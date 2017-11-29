package cn.zaw.tsys.teacher.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zaw.tsys.common.exception.ServiceException;
import cn.zaw.tsys.teacher.dao.TeacherDAO;
import cn.zaw.tsys.teacher.entity.Teacher;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherDAO teacherDAO;

	@Override
	public Teacher checkTeacherRole(String teacherId, String password) {
		System.out.println("teacherId:" + teacherId + ", password:" + password);
		Teacher teacher = teacherDAO.findById(teacherId);
		if (teacher == null || !teacher.getPassword().equals(password)) throw new ServiceException("用户名或密码错误");
		return teacher;
	}
}
