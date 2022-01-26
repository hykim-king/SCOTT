package kr.scott.ngg.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import kr.scott.ngg.cmn.StringUtil;
import kr.scott.ngg.file.domain.FileVO;

@Controller
@RequestMapping("file")
public class FileController {
	final Logger LOG = LogManager.getLogger(getClass());
	final String IMG_PATH = "";
	final String FILE_PATH = "";

	@Resource
	View download;

	public FileController() {
	}

	@RequestMapping(value = "/download.do")
	public ModelAndView download(FileVO fileVO, ModelAndView modelAndView) throws IllegalStateException, IOException {

		File downFile = new File(fileVO.getFileSName(), fileVO.getFilePath());

		modelAndView.addObject("fileOName", fileVO.getFileOName());

		modelAndView.addObject("downFile", downFile);

		return modelAndView;
	}

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest mReg, ModelAndView modelAndView)
			throws IllegalStateException, IOException {

		File imgRootDir = new File(IMG_PATH);
		if (imgRootDir.isDirectory() == false) {
			imgRootDir.mkdir();
		}

		File fileRootdir = new File(FILE_PATH);

		if (fileRootdir.isDirectory() == false) {
			fileRootdir.mkdir();
		}

		String title = StringUtil.nvl(mReg.getParameter("title"));
		String fileDiv = mReg.getParameter("file_div");

		LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");
		LOG.debug("title: " + title);
		LOG.debug("fileDiv: " + fileDiv);
		LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");

		List<FileVO> list = new ArrayList<>();

		Iterator<String> files = mReg.getFileNames();
		while (files.hasNext()) {
			FileVO fileVO = new FileVO();
			String upFilNm = files.next();

			LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");
			LOG.debug("upFilNm: " + upFilNm);
			LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");

			// 원본파일명
			MultipartFile mFile = mReg.getFile(upFilNm);
			String orgFileNm = mFile.getOriginalFilename();
			LOG.debug("orgFileNm: " + orgFileNm);

			// 파일이 없는 경우
			if (null == orgFileNm || "".equals(orgFileNm)) {
				continue;
			}

			// 저장파일명 -> yyyyMMddHH24mmss+UUID
			String saveFileNm = StringUtil.getRenameFile("yyyyMMddHH24mmss");

			// 확장자 꺼내기 : 제일 뒤에서 .을 기준으로 잘라냄
			String ext = "";

			if (orgFileNm.lastIndexOf(".") > -1) {
				ext = orgFileNm.substring(orgFileNm.lastIndexOf(".") + 1);
				saveFileNm += "." + ext;
			}
			LOG.debug("saveFileNm: " + saveFileNm);

			// 파일 사이즈: byte단위임

			long fileSize = mFile.getSize();
			String savePath = "";
			if ("20".equals(fileDiv)) {// 이미지
				savePath = this.IMG_PATH;
			} else {

				savePath = this.FILE_PATH;
			}

			fileVO.setFileOName(orgFileNm);
			fileVO.setFileSName(saveFileNm);
			fileVO.setFilePath(savePath);
			LOG.debug("fileVO: " + fileVO);
			list.add(fileVO);
			
			File renameFile = new File(savePath,fileVO.getFileSName());
			mFile.transferTo(renameFile);

		}
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
}
