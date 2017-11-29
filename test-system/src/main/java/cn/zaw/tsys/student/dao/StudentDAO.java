package cn.zaw.tsys.student.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zaw.tsys.student.entity.Student;

public interface StudentDAO {
	
	//根据姓名查询学生
	Student findNameStudent(String StudentName);
	
	
	//根据班级查询学生
	List<Student> findClassStudent(@Param("sclass") String sclass,
							       @Param("startIndex")int startIndex,
								   @Param("pageSize") int pageSize);
	
	//根据学生ID查成绩
	Student findStudentById(String studentID);
	int getRowCount(@Param("sclass")String sclass);
	//修改学生成绩
	int updateResult(@Param("result")Integer result, @Param("studentID")String studentID);
}
