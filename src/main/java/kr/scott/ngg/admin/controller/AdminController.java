package kr.scott.ngg.admin.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.scott.ngg.cmn.PieVO;
import kr.scott.ngg.cmn.SearchVO;
import kr.scott.ngg.food.service.FoodService;
import kr.scott.ngg.meal.service.MealService;
import kr.scott.ngg.report.service.ReportService;
import kr.scott.ngg.status.service.StatusService;
import kr.scott.ngg.user.service.UserService;

@Controller("adminController")
@RequestMapping("admin")
public class AdminController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService userService;
	@Autowired
	FoodService foodService;
//	@Autowired
//	WorkService workService;
//	@Autowired
//	CommuService commuService;
//	@Autowired
//	CommtService commtService;
	@Autowired
	ReportService reportService;
	@Autowired
	MealService mealService;
	@Autowired
	StatusService statusService;
	
	
	/* ---------------------------- VIEW ---------------------------- */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainView(Model model) throws SQLException {
		LOG.debug("---------- mainView()");
		
		List<PieVO> dList = userService.getDailyRegCnt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		List<PieVO> wList = userService.getWeeklyRegCnt(new SimpleDateFormat("yyyyMM").format(new Date()));
		
		model.addAttribute("dailyData", dList);
		model.addAttribute("weeklyData", wList);
		
		return "admin/contents/main";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userView(Model model) throws SQLException {
		LOG.debug("---------- userView()");
		
		model.addAttribute("list", userService.doRetrieve(new SearchVO("99", "0", 10, 1)));
		
		return "admin/contents/user";
	}
	
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public String foodView(Model model) throws SQLException {
		LOG.debug("---------- foodView()");
		
		model.addAttribute("list", foodService.doRetrieve(new SearchVO("", "", 10, 1)));
		
		return "admin/contents/food";
	}
	
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String workView(Model model) throws SQLException {
		LOG.debug("---------- workView()");
		
//		model.addAttribute("list", workService.doRetrieve(new SearchVO("", "", 10, 1)));

		return "admin/contents/work";
	}
	
	@RequestMapping(value = "/commu", method = RequestMethod.GET)
	public String commuView(Model model) throws SQLException {
		LOG.debug("---------- commuView()");
		
//		model.addAttribute("list", commuService.doRetrieve(new SearchVO("", "", 10, 1)));

		return "admin/contents/commu";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String reportView(Model model) throws SQLException {
		LOG.debug("---------- reportView()");
		
		model.addAttribute("list", reportService.doRetrieve(new SearchVO("", "", 10, 1)));

		return "cadmin/ontents/report";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminView(Model model) throws SQLException {
		LOG.debug("---------- adminView()");

		model.addAttribute("list", userService.doRetrieve(new SearchVO("99", "1", 10, 1)));
		
		return "admin/contents/admin";
	}
	
	/* ---------------------------- END VIEW ---------------------------- */
	
	
	
}
