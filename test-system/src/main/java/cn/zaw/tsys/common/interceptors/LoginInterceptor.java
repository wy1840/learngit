package cn.zaw.tsys.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("开始Session认证...");
		// 获得Session对象
		HttpSession session = request.getSession();
		// 通过Session对象获得数据
		Object obj = session.getAttribute("user");
		if (obj == null) {
			System.out.println("没有登录，重定向到登录页面");
			// 没有登录，重定向到登录页面
			response.sendRedirect("loginUI.do");
			return false;
		}
		// 登录过了，允许访问
		System.out.println("登录过了，允许访问");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
