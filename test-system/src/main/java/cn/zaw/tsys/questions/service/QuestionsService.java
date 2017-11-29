package cn.zaw.tsys.questions.service;


import java.util.List;
import java.util.Map;

import cn.zaw.tsys.questions.entity.Questions;

/**
 * 试题 业务层
 * @author uid
 *
 */
public interface QuestionsService {
	//根据id查询
	public Questions findObjectById(Integer id);
	//增加试题
	public void addQuestions(Questions questions);
	//修改试题
	public void updateQuestions(Questions questions);
	//删除试题
	public void deleteQuestions(Integer subjectID);
	//查询所有试题
	public Map<String,Object> findQuestions(String subjectTitle,Integer pageCurrent);
	//随机的试题
	public List<Questions> findRandomQuestions();
	
}	
