package kr.scott.ngg.cmn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


public class DownloadView extends AbstractView {
	final Logger LOG = LogManager.getLogger(getClass());

	public DownloadView() {
		setContentType("application/download;charset=utf-8");
		
	}
	
	public void setDownloadFileName(String orgFileNm, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		String userAgent = request.getHeader("User-Agent");//브라우져 정보를 가져옴	
		LOG.debug("orgFileNm: "+orgFileNm);
		LOG.debug("userAgent: "+userAgent);
		
		orgFileNm = URLEncoder.encode(orgFileNm,"utf-8");
		LOG.debug("encode orgFileNm: "+orgFileNm);
		
		//header에 원본파일명을 넣어주면 됨
		response.setHeader("Content-Disposition", "attachment; fileName=\""+orgFileNm+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		

	}
	
	public void downloadFile(File downloadFile,HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		FileInputStream in = new FileInputStream(downloadFile);
		
		OutputStream out =response.getOutputStream();
		try {
			int bytes = FileCopyUtils.copy(in, out);
			LOG.debug("=+=+=+=+=+=+=+=+=+=");
			LOG.debug("bytes: "+bytes);
			LOG.debug("=+=+=+=+=+=+=+=+=+=");
		}catch(IOException e) {
			throw e;
		}finally{
			if(null != in) {
				try{in.close();} catch(IOException e) {}
			}
			if(null!= out) {
				try {out.close();}catch(IOException e) {}
			}
		}
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		setResponseContentType(request, response);
		String orgFileNm  =  (String) model.get("orgFileNm");
		File downloadFile =  (File) model.get("downloadFile");
		
		LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");
		LOG.debug("orgFileNm: "+orgFileNm);
		LOG.debug("downloadFile: "+downloadFile);
		LOG.debug("=-=-=-=-=-=-=-=-=-=-=-=");
		
		//다운로드 파일을 원본파일명으로 변환
		setDownloadFileName(orgFileNm, request, response);
		
		//stream으로 파일 다운로드
		downloadFile(downloadFile,request, response);
	}

}
