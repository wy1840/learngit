package cn.zaw.tsys.common.service;

import javax.servlet.http.HttpSession;

public interface LoginService {
	int login(String username, String password, Integer role, HttpSession session);
}
