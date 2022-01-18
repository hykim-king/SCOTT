package kr.scott.ngg.admin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class ViewController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainView(Model model) {
		LOG.debug("---------- mainView()");
		
		return "admin/contents/main";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userView(Model model) {
		LOG.debug("---------- userView()");
		
		return "admin/contents/user";
	}
	
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public String foodView(Model model) {
		LOG.debug("---------- foodView()");
		
		return "admin/contents/food";
	}
	
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String workView(Model model) {
		LOG.debug("---------- workView()");
		
		return "admin/contents/work";
	}
	
	@RequestMapping(value = "/commu", method = RequestMethod.GET)
	public String commuView(Model model) {
		LOG.debug("---------- commuView()");
		
		return "admin/contents/commu";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String reportView(Model model) {
		LOG.debug("---------- reportView()");
		
		return "cadmin/ontents/report";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminView(Model model) {
		LOG.debug("---------- adminView()");
		
		return "admin/contents/admin";
	}
	
	
	
}
