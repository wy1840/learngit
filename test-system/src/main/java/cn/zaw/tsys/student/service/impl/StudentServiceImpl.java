package cn.zaw.tsys.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.zaw.tsys.common.exception.ServiceException;
import cn.zaw.tsys.common.web.PageObject;
import cn.zaw.tsys.student.dao.StudentDAO;
import cn.zaw.tsys.student.entity.Student;
import cn.zaw.tsys.student.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDAO studendao;
	@Resource
	private HttpSession session;
	//通过名字查询学生信息
	@Override
	public Student findNameStudent(String StudentName) {
		if(StudentName==null||StudentName==""){
			throw new ServiceException("不能为空");
		}
		return studendao.findNameStudent(StudentName);
	}
	//通过班级查询学生信息

	@Override
	public Map<String,Object> findClassStudent(String sclass, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1){
			throw new ServiceException("参数无效,pageCurrent:"+pageCurrent);
		}
		if(sclass==null||sclass==""){
			throw new ServiceException("不能为空");
		}
		int pageSize = 2;
		int startIndex =(pageCurrent-1)*pageSize;
		List<Student> list = studendao.findClassStudent(sclass, startIndex, pageSize);
		PageObject pageObject =new PageObject();
		int rowCount = studendao.getRowCount(sclass);
		System.out.println("rowCount="+rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setStartIndex(startIndex);
		pageObject.setPageCurrent(pageCurrent);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	@Override
	public Student checkStudentRole(String studentID, String password) {
		Student student = studendao.findStudentById(studentID);
		System.out.println("student : " + student);
		if (student == null || !student.getPassword().equals(password)) throw new ServiceException("用户名或密码错误");
		return student;
	}

	@Override
	public int updateResult(Integer result) {
		Student student = (Student)session.getAttribute("user");
		String studentID = student.getStudentID();
		studendao.updateResult(result, studentID);
		return 0;
	}
}
