package jp.co.axiz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.entity.UserInfo;
import jp.co.axiz.entity.UserInfoForm;
import jp.co.axiz.service.impl.UserInfoServiceImpl;

@Controller
public class UpdateController {

	@Autowired
	private UserInfoServiceImpl uIS;

	@Autowired
	HttpSession session;

	@RequestMapping({ "/update"})
	public String returnUpdate(@ModelAttribute("command") UserInfoForm form, Model model) {
		return "update";
	}

	@RequestMapping("/updateInput")
	public String update(@Validated @ModelAttribute("command") UserInfoForm fm, BindingResult bindingResult, Model model) {

		try {
			Integer.parseInt(fm.getId());
		}catch(Exception e){
				model.addAttribute("msg", "無効です。");
			return "update";
		}
		Integer id  = Integer.parseInt(fm.getId());
		UserInfo user = uIS.findById(id);
		session.setAttribute("beforeUser", user);


		if(user == null) {
			model.addAttribute("msg", "入力されたデータはありませんでした");
			return "update";
		}
		return "updateInput";
	}

	@RequestMapping(value = "/updateInput", method = RequestMethod.GET)
	public String updateback(@Validated @ModelAttribute("command") UserInfoForm fm, BindingResult bindingResult, Model model) {
		return "updateInput";
	}

	@RequestMapping("/updateConfirm")
	public String updateConfirm(@Validated @ModelAttribute("command") UserInfoForm fm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "updateInput";
		}
		String newName = fm.getNewName();
		String newTel = fm.getNewTel();
		String newPass = fm.getNewPass();

		UserInfo beforeUser = (UserInfo)session.getAttribute("beforeUser");

		Integer id = beforeUser.getUser_id();

		UserInfo newUser = new UserInfo(id, newName, newTel, newPass);

		session.setAttribute("NewUser", newUser);
		session.setAttribute("defo_id", id);

		if(beforeUser.getPassword().equals(newUser.getPassword())) {
			session.setAttribute("Pass", beforeUser.getPassword());

		}else {
			session.setAttribute("Pass", "");
		}

		if(newName.equals(beforeUser.getUser_name()) && newTel.equals(beforeUser.getTelephone()) && newPass.equals(beforeUser.getPassword())) {
			model.addAttribute("error", "1項目以上変更してください。");

			return "updateInput";
		}

		return "updateConfirm";
	}

	@RequestMapping("/updateResult")
	public String updateResult(@ModelAttribute("command") UserInfoForm fm, Model model) {
		String rePass = fm.getRePass();
		UserInfo beforeUser = (UserInfo)session.getAttribute("beforeUser");
		UserInfo newUser = (UserInfo)session.getAttribute("NewUser");

		String newName =newUser.getUser_name();
		String newTel = newUser.getTelephone();
		String newPass = newUser.getPassword();

		if(newName != null && newTel != null && newPass != null){
			if(!(newName.equals(beforeUser.getUser_name())) && !(newName.equals(""))) {
				uIS.updateName(newUser);
			}

			if(!(newTel.equals(beforeUser.getTelephone())) && !(newTel.equals(""))){
				uIS.updateTel(newUser);
			}

			if(!(newPass.equals(beforeUser.getPassword())) && !(newPass.equals(""))){
				if(newPass.equals(rePass)) {
					uIS.updatePass(newUser);
				}else {
					model.addAttribute("error", "前画面で入力したパスワードと一致しません。");

					return "updateConfirm";
				}
			}
		}

		return "updateResult";
	}
}
