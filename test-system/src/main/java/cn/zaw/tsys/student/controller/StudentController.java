package cn.zaw.tsys.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zaw.tsys.common.web.JsonResult;
import cn.zaw.tsys.student.service.StudentService;

@RequestMapping("/student/")
@Controller
public class StudentController {
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	@RequestMapping("listUI")
	public String listUI(){
		return "teacher/team_list";
		
	}
	
	
	
	@RequestMapping("doFindName")
	@ResponseBody
	public JsonResult doFindName(String StudentName){
		System.out.println(StudentName);
		return new JsonResult(studentService.findNameStudent(StudentName));
		
	}
	@RequestMapping("doFindClass")
	@ResponseBody
	public JsonResult doFindClass(String sclass,Integer pageCurrent){
		Map<String,Object> map = studentService.findClassStudent(sclass, pageCurrent);
		
		return new JsonResult(map);
		
	}

	
}
