package cn.zaw.tsys.common.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorUtils {
	public static boolean checkRole(HttpServletRequest request, HttpServletResponse response, String role) throws IOException {
		System.out.println("验证" + role + "登录身份...");
		// 获取Session属性User对应的字符串（teacher:student）
		String user = request.getSession().getAttribute("user").getClass().getName();
		if (role.equals(user.substring(user.lastIndexOf(".") + 1))) {
			System.out.println(role + "身份验证通过");
			return true;
		}
		System.out.println(role + "身份验证不通过");
		response.sendRedirect("loginMsg.do");
		return false;
	}
}
