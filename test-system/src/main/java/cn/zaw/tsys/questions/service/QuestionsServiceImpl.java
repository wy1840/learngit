package cn.zaw.tsys.questions.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zaw.tsys.common.exception.ServiceException;
import cn.zaw.tsys.common.web.PageObject;
import cn.zaw.tsys.questions.dao.QuestionsDao;
import cn.zaw.tsys.questions.entity.Questions;
/**
 * 试题 业务层实现类
 * @author uid
 *
 */
@Service
public class QuestionsServiceImpl implements QuestionsService{
	//将dao层注入进来
	@Resource
	private QuestionsDao questionsDao;
	
	@Override
	public void addQuestions(Questions questions) {
		//将试题插入数据库
		//验证参数有效性
		if(questions==null){
			throw new ServiceException("插入试题不能为空");
		}
		int rows = questionsDao.addQuestions(questions);
		if(rows<=0){
			throw new ServiceException("系统繁忙");
		}
	}

	@Override
	public void updateQuestions(Questions questions) {
		//修改试题
		//验证参数有效性
		if(questions==null){
			throw new ServiceException("修改试题不能为空");
		}
		
		int rows = questionsDao.updateQuestions(questions);
		if(rows<=0){
			throw new ServiceException("系统繁忙");
		}
	}

	@Override
	public void deleteQuestions(Integer subjectID) {
		//验证参数有效性
		if(subjectID==null||subjectID<0){
			throw new ServiceException("试题ID不能为空或不能小于1");
		}
		
		//删除试题
		int rows = questionsDao.deleteQuestions(subjectID);
		if(rows<=0){
			throw new ServiceException("系统繁忙");
		}
	}
	
	//查询分页试题
	@Override
	public Map<String, Object> findQuestions(String subjectTitle,Integer pageCurrent) {
		System.out.println(pageCurrent);
		//验证参数有效性
		if(pageCurrent==null||pageCurrent<1){
			throw new ServiceException("参数无效,pageCurrent="+pageCurrent);
		}
		//获取当前页数据
		int pageSize = 10;
		int startIndex = (pageCurrent-1)*pageSize;
		List<Questions> list= questionsDao.findQuestions(subjectTitle,startIndex, pageSize);
		//3获取总记录数（根据此值计算总页数）
		int rowCount = questionsDao.getRowCount(subjectTitle);
		PageObject pageObject = new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);//可选
		
		//4。封装查询和计算结果到map对象
		//1)HashMap底层结构?(数组+链表+红黑树)-->JDK1.8
		//2)HashMap是否线程安全?(不安全，多线程并发访问)
		//3)HashMap是否能保证添加元素的有序性?(不能，假如希望保证有序性可以选择LinkedHashMap)
		//4)HashMap在并发场景下如何使用？（将其转换为同步集合）
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);//list:分页查询出来的数据
		map.put("pageObject", pageObject);//pageObject:分页总页数
		return map;
		
	}

	@Override
	public List<Questions> findRandomQuestions() {
		List<Questions> list = questionsDao.findRandomQuestions();
		return list;
	}

	@Override
	public Questions findObjectById(Integer id) {
		if (id == null || id < 1) throw new ServiceException("id值无效");
		Questions questions = questionsDao.findObjectById(id);
		if (questions == null) throw new ServiceException("此记录已经不存在");
		return questions;
	}



}
