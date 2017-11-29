package cn.zaw.tsys.studentquestions.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zaw.tsys.questions.entity.Questions;

public interface StuQuestionsDao {

	/**获取全部随机试题*/
	public List<Questions> findRandomQuestions();
	/**获取考生姓名*/
	public String findStudentName(@Param("studentID")String studentID,@Param("password")String password);
}
