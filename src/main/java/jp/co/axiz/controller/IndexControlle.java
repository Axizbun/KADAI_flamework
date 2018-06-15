package jp.co.axiz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.entity.Admin;
import jp.co.axiz.entity.UserInfoForm;

@Controller
public class IndexControlle {

	@Autowired
	HttpSession session;

	@RequestMapping("/start")
	public String start(Model model) {
		return "index";
	}


	@RequestMapping("/index")
	public String index(@ModelAttribute("login") Admin form, Model model) {
		return "index";
	}


	@RequestMapping({ "/menu"})
	public String returnMenu(UserInfoForm form, Model model) {
		return "menu";
	}
}
