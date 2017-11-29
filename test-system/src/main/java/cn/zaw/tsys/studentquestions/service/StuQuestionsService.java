package cn.zaw.tsys.studentquestions.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.zaw.tsys.questions.entity.Questions;

public interface StuQuestionsService {
	//随机的试题
		public List<Questions> findRandomQuestions();
	//考生姓名
		public String findStudentName();
}
