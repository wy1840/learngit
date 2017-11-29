package cn.zaw.tsys.teacher.dao;

import cn.zaw.tsys.teacher.entity.Teacher;

public interface TeacherDAO {
	Teacher findById(String teacherId);
}
