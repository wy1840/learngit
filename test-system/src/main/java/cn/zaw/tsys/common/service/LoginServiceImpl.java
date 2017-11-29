package cn.zaw.tsys.common.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.zaw.tsys.common.exception.ServiceException;
import cn.zaw.tsys.student.entity.Student;
import cn.zaw.tsys.student.service.StudentService;
import cn.zaw.tsys.teacher.entity.Teacher;
import cn.zaw.tsys.teacher.service.TeacherService;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private StudentService studentService;
	@Resource
	private TeacherService teacherService;
	@Override
	public int login(String username, String password, Integer role, HttpSession session) {
		System.out.println(username + "/" + password + "/" + role);
		System.out.println("session : " + session);
		// 根据登录选择，发起不同登录验证
		switch (role) {
		case 1 : Teacher teacher = teacherService.checkTeacherRole(username, password);
					System.out.println("teacher登录");
					session.setAttribute("user", teacher);
					return 1;
		case 2 : Student student = studentService.checkStudentRole(username, password);
					System.out.println("student登录");
					session.setAttribute("user", student);
					return 2;
		default : throw new ServiceException("Service Error");
		}
	}
	
}
