package cn.zaw.tsys.studentquestions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zaw.tsys.common.web.JsonResult;
import cn.zaw.tsys.student.service.StudentService;
import cn.zaw.tsys.studentquestions.service.StuQuestionsService;

@RequestMapping("/stuQuestions/")
@Controller
public class StuQuestionsController {
	
	@Resource
	private StuQuestionsService stuQuestionsService;
	@Resource
	private StudentService studentService;
	/**
	 * 返回随机20道试题给客户端
	 */
	@RequestMapping("doFindRandomQuestions")
	@ResponseBody
	public JsonResult doFindRandomQuestions(){
		
		return new JsonResult(stuQuestionsService.findRandomQuestions());
	}
	
	/**
	 * 将考生姓名返回给客户端
	 */
	@RequestMapping("studentName")
	@ResponseBody
	public JsonResult doFindStudentName(){
		
		return new JsonResult(stuQuestionsService.findStudentName());
	}
	
	@RequestMapping("updateResult")
	@ResponseBody
	public JsonResult doUpdateResult(Integer result) {
		studentService.updateResult(result);
		return new JsonResult();
	}
	
	@RequestMapping("listUI")
	public String loginUI(){
		return "student/index";
	}
	
	@RequestMapping("stuSubObject")
	public String stuSub(){
		return "student/examResult";
	}
}
