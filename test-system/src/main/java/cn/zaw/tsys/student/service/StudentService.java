package cn.zaw.tsys.student.service;


import java.util.Map;

import cn.zaw.tsys.student.entity.Student;

public interface StudentService {
	Student findNameStudent(String StudentName);
	Student checkStudentRole(String studentID, String password);
	
	
	Map<String, Object> findClassStudent(String sclass,Integer pageCurrent);
	int updateResult(Integer result);
	
}
