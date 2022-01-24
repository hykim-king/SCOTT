package kr.scott.ngg.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.scott.ngg.user.service.UserService;
import kr.scott.ngg.user.vo.UserVO;

public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserVO userVO;
	
	
	@Override
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
			                  HttpServletRequest request, 
			                  HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		userVO=userService.login(loginMap);
		if(userVO!= null && userVO.getUserId()!=null){
			HttpSession session=request.getSession();
			session=request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("userInfo", userVO);
			
			String action = (String)session.getAttribute("action");
			if(action!=null && action.equals("/user/mypage.do")){       
				mav.setViewName("forward:"+action);
			}else{
				mav.setViewName("redirect:/main/main.do");	
			}
			
		}else{
			String message="아이디 또는 비밀번호가 틀립니다. 다시 로그인 해 주세요.";
			mav.addObject("message", message);
			mav.setViewName("/user/login");
		}
		return mav;
	
	}
	
	
	@Override
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, 
							   HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("userInfo");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	
	}
	
	
	@Override
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public ResponseEntity register(@ModelAttribute("userVO") UserVO _userVO,
			                	  HttpServletRequest request, 
			                	  HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
		    userService.register(_userVO);
		    message  = "<script>";
		    message += " alert('회원 가입을 마쳤습니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/user/login.do';";
		    message += "</script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message += " alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요.');";
		    message += " location.href='"+request.getContextPath()+"/user/register.do';";
		    message += "</script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity (message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value="/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("userId") String userId,
									HttpServletRequest request, 
									HttpServletResponse response) throws Exception{
	
		ResponseEntity resEntity = null;
		String result = userService.overlapped(userId);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
}


