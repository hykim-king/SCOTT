package kr.scott.ngg.work.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.scott.ngg.cmn.MessageVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.cmn.StringUtil;
import kr.scott.ngg.work.domain.WorkVO;
import kr.scott.ngg.work.service.WorkService;



@Controller("workController")
@RequestMapping("work")
public class WorkController {
	final Logger LOG = LogManager.getLogger(getClass());
	final String VIEW_NAME = "work/work_view";
	
	@Autowired
	WorkService workService;
	
	public WorkController() {}
	
	
	@RequestMapping(value = "/moveToReg.do")
	public String moveToReg()throws SQLException{
	    LOG.debug("========================");

		return "work/work_reg";
	}
	
	
	@RequestMapping(value = "/doRetrieve.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(SearchVO inVO) throws SQLException {
		
		if (0 == inVO.getPageSize()) {
			inVO.setPageSize(10);
		}

		// pageNum ==1
		if (0 == inVO.getPageNum()) {
			inVO.setPageNum(1);
		}
		
	    inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
	    inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		
	    LOG.debug("========================");
		LOG.debug("inVO: " + inVO);
		LOG.debug("========================");
		
		List<WorkVO> list = workService.doRetrieve(inVO);
		
		return new Gson().toJson(list);
	}
	
	
	
	@RequestMapping(value = "/doUpdate.do", method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	
	public String doUpdate(WorkVO inVO) throws SQLException {
		LOG.debug("========================");
		LOG.debug("inVO: "+inVO);
		LOG.debug("========================");
		String resultMsg = "";
		
		int flag = workService.doUpdate(inVO);
		if(1==flag) {
			resultMsg = "수정되었습니다";
		}else {
			resultMsg = "등록 실패";
		}
		
		MessageVO message = new MessageVO(flag+"",resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("jsonString: "+jsonString);

		return jsonString;
	}
	
	
	@RequestMapping(value = "/doDelete.do", method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(WorkVO inVO) throws SQLException {
		LOG.debug("========================");
		LOG.debug("inVO: "+inVO);
		LOG.debug("========================");
		String resultMsg = "";
		
		int flag = workService.doDelete(inVO);
		if(1==flag) {
			resultMsg = "삭제되었습니다";
		}else {
			resultMsg = "삭제 실패";
		}
		
		MessageVO message = new MessageVO(flag+"",resultMsg);
		LOG.debug("message: "+message);

		return new Gson().toJson(message);
	}
	
	
	
	@RequestMapping(value = "/doInsert.do", method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(WorkVO inVO) throws SQLException {
		LOG.debug("========================");
		LOG.debug("inVO: "+inVO);
		LOG.debug("========================");
		String resultMsg = "";
		
		int flag = workService.doInsert(inVO);
		if(1==flag) {
			resultMsg = inVO.getWorkTitle()+"가 등록되었습니다";
		}else {
			resultMsg = "등록 실패";
		}
		
		MessageVO message = new MessageVO(flag+"",resultMsg);
		String jsonString = new Gson().toJson(message);
		LOG.debug("jsonString: "+jsonString);

		return jsonString;
	}
	@RequestMapping(value = "/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(WorkVO inVO,Model model)throws SQLException {
		LOG.debug("========================");
		LOG.debug("inVO: "+inVO);
		LOG.debug("========================");
		
		WorkVO outVO = this.workService.doSelectOne(inVO);
		LOG.debug("outVO: "+outVO);
		model.addAttribute("vo",outVO);
		return "work/work_mng";
	}
	
	
	
	@RequestMapping(value = "/work_view.do", method = RequestMethod.GET)
	public String workView(Model model, SearchVO inVO) throws SQLException {
		LOG.debug("========================");
		LOG.debug("workView: ");
		LOG.debug("========================");
		
		if (0 == inVO.getPageSize()) {
			inVO.setPageSize(10);
		}

		// pageNum ==1
		if (0 == inVO.getPageNum()) {
			inVO.setPageNum(1);
		}

		if (null == inVO.getSearchDiv()) {
			inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv()));
		}

		if (null == inVO.getSearchWord()) {
			inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord()));
		}
		
		List<WorkVO> list = workService.doRetrieve(inVO);
		
		double totalPage = 0;
		if (null != list && list.size() > 0) {
			totalPage = Math.ceil(list.get(0).getTotalNum() / (inVO.getPageSize() * 1.0));
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		
		return "work/work";
	}
	@RequestMapping(value = "/work_reg.do", method = RequestMethod.GET)
	public String workReg() throws SQLException {
		LOG.debug("========================");
		LOG.debug("workView: ");
		LOG.debug("========================");
		return "work/work";
	}
}
