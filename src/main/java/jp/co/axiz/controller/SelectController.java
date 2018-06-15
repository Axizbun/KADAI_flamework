package jp.co.axiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.entity.UserInfo;
import jp.co.axiz.entity.UserInfoForm;
import jp.co.axiz.service.impl.SearchServiceImpl;

@Controller
public class SelectController {

	@Autowired
	private SearchServiceImpl uIS;


	@RequestMapping("/selectIn")
	public String select (@ModelAttribute("command") UserInfoForm form, Model model) {
		return "select";
	}

	@RequestMapping("/selectResult")
	public String selectResult (@Validated @ModelAttribute("command") UserInfoForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "エラー");
			return "select";
		}


		List<UserInfo> list = uIS.search(form.getId(), form.getName(), form.getTel());
		if (list == null || list.size() == 0) {
			model.addAttribute("msg", "入力されたデータはありませんでした");
			return "select";
		} else {
			model.addAttribute("user_info", list);
			return "selectResult";
		}
	}
}
