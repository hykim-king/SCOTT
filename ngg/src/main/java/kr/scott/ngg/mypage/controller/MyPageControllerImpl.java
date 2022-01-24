package kr.scott.ngg.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.scott.ngg.mypage.service.MyPageService;
import kr.scott.ngg.user.vo.UserVO;

@Controller("myPageController")
@RequestMapping(value="/mypage")
public class MyPageControllerImpl implements MyPageController{
	
	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private UserVO userVO;
		
	@Override
	@RequestMapping(value="/myInfo.do" ,method = RequestMethod.GET)
	public ModelAndView myDetailInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String myInfo=(String)request.getAttribute("myInfo");
		ModelAndView mav = new ModelAndView(myInfo);               //check
		return mav;
	}	
	
	@Override
	@RequestMapping(value="/modifyMyInfo.do" ,method = RequestMethod.POST)
	public ResponseEntity modifyMyInfo(@RequestParam("attribute")  String attribute,
			                 @RequestParam("value")  String value,
			               HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		HttpSession session=request.getSession();
		Map<String,String> userMap=new HashMap<String,String>();
		String val[]=null;
		userVO=(UserVO)session.getAttribute("userInfo");
		String userId=userVO.getUserId();
		
		if(attribute.equals("userEmail")){
			val=value.split(",");
			userMap.put("email1",val[0]);
			userMap.put("email2",val[1]);
		}else if(attribute.equals("userHeight")){
			userMap.put("userHeight",value);
		}else if(attribute.equals("userWeight")){
			userMap.put("userWeight",value);
		}else if(attribute.equals("userGoal")){
			userMap.put("userGoal",value);
		}	
		
		userMap.put("userId", userId);
		userVO=(UserVO)myPageService.modifyMyInfo(userMap);
		session.removeAttribute("userInfo");
		session.setAttribute("userInfo", userVO);
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		message  = "mod_success";
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}
