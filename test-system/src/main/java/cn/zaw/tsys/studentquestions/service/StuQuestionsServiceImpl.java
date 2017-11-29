package cn.zaw.tsys.studentquestions.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.zaw.tsys.questions.entity.Questions;
import cn.zaw.tsys.student.entity.Student;
import cn.zaw.tsys.studentquestions.dao.StuQuestionsDao;

@Service
public class StuQuestionsServiceImpl implements StuQuestionsService{
	@Resource
	private StuQuestionsDao stuQuestionsDao;
	
	@Resource
	private HttpSession session;
	
	/**
	 * 获取随机试题
	 */
	@Override
	public List<Questions> findRandomQuestions() {
		List<Questions> list = stuQuestionsDao.findRandomQuestions();
		return list;
	}

	/**
	 * 获取考生的名字
	 */
	@Override
	public String findStudentName() {
		Student student = (Student)session.getAttribute("user");
		System.out.println("StuQuestionsService.findStudentName() -> " + student);
		String studentID = student.getStudentID();
		String password = student.getPassword();
		return stuQuestionsDao.findStudentName(studentID, password);
	}
}
