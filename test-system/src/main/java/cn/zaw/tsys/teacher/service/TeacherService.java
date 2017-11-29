package cn.zaw.tsys.teacher.service;

import cn.zaw.tsys.teacher.entity.Teacher;

public interface TeacherService {
	Teacher checkTeacherRole(String teacherId, String password);
}
