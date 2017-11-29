package cn.zaw.tsys.questions.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zaw.tsys.questions.entity.Questions;

/**
 * 试题 持久层
 * @author uid
 *
 */
public interface QuestionsDao {
	/**根据id查询*/
	public Questions findObjectById(Integer id);
	/**增加试题*/
	public int addQuestions(Questions questions);
	
	/**修改试题*/
	public int updateQuestions(Questions questions);
	
	/**删除试题*/
	public int deleteQuestions(Integer subjectID);
	
	/**查询试题*/
	public List<Questions> findQuestions( @Param("subjectTitle")String subjectTitle,
											@Param("startIndex")int startIndex,
			  							  @Param("pageSize")int pageSize);
	/**获取全部试题*/
	public List<Questions> findRandomQuestions();

	public int getRowCount(@Param("subjectTitle")String subjectTitle);

}
