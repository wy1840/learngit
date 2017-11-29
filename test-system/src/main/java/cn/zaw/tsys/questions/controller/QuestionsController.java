package cn.zaw.tsys.questions.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zaw.tsys.common.web.JsonResult;
import cn.zaw.tsys.questions.entity.Questions;
import cn.zaw.tsys.questions.service.QuestionsService;
/**
 * 
 * @author uid
 *
 */
@RequestMapping("/questions/")
@Controller
public class QuestionsController {
	@Resource
	private QuestionsService questionsService;
	
	@RequestMapping("listUI")
	public String listUI() {
		return "teacher/question_list";
	}
	
	@RequestMapping("editUI")
	public String editUI() {
		return "teacher/question_edit";
	}
	
	/**
	 * 将试题插入数据库
	 * @param questions
	 * @return
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doAddQuestions(Questions questions){
		questionsService.addQuestions(questions);
		return new JsonResult();
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Questions questions) {
		questionsService.updateQuestions(questions);
		return new JsonResult();
	}
	/**
	 * 从数据库删除试题
	 */
	@RequestMapping("doDeleteQuestions")
	@ResponseBody
	public JsonResult doDeleteQuestions(Integer subjectID){
		questionsService.deleteQuestions(subjectID);
		
		return new JsonResult();
	}
	
	/**
	 * 将所有试题返回给客户端
	 * @return
	 */
	@RequestMapping("doFindQuestions")
	@ResponseBody
	public JsonResult doFindQuestions(String subjectTitle,Integer pageCurrent){
		Map<String,Object> map = questionsService.findQuestions(subjectTitle, pageCurrent);
		return new JsonResult(map);
	}
	
	/**
	 * 返回随机20道试题给客户端
	 */
	@RequestMapping("doFindRandomQuestions")
	@ResponseBody
	public JsonResult doFindRandomQuestions(){
		
		return new JsonResult(questionsService.findRandomQuestions());
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(questionsService.findObjectById(id));
	}
}
