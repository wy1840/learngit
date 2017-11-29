package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zaw.tsys.common.service.LoginService;
import cn.zaw.tsys.student.entity.Student;
import cn.zaw.tsys.student.service.StudentService;

public class TestCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
	}
	
	
	
	@After
	public void destroy() {
		ctx.close();
	}
}
