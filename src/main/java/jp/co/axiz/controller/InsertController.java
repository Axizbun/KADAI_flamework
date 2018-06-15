package jp.co.axiz.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.entity.UserInfo;
import jp.co.axiz.entity.UserInfoForm;
import jp.co.axiz.service.impl.UserInfoServiceImpl;

@Controller
public class InsertController {

	@Autowired
	private UserInfoServiceImpl uIS;

	@Autowired
	HttpSession session;

	@RequestMapping("/insertIn")
	public String insertIn(@ModelAttribute("command") UserInfoForm form,Model model) {		//メニューで登録押したらそのページに飛ばすよ
		return "insert";
	}

	@RequestMapping("/insertBack")
	public String insertBack(@ModelAttribute("command") UserInfoForm form,Model model) {		//メニューで登録押したらそのページに飛ばすよ
		return "insert";
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insert(@ModelAttribute("command") UserInfoForm form,Model model) {		//登録画面で入力後の処理だよ
		if((form.getName()==null || form.getTel()==null ||form.getPass()==null)||"".equals(form.getName())||"".equals(form.getTel())||"".equals(form.getPass())){
			model.addAttribute("msg", "必須項目が未入力です！！");
			return "insert";
		}
		session.setAttribute("insertname", form.getName());
		session.setAttribute("inserttel", form.getTel());
		session.setAttribute("insertpass", form.getPass());		//確認画面で使うからセッションいれるよ
		return "insertConfirm";
	}

	@RequestMapping(value="/insertConfirm",method=RequestMethod.POST)
	public String insertResult(@ModelAttribute("command") UserInfoForm form,Model model) {
		if(form.getRePass().equals(session.getAttribute("insertpass"))) {//パスあってたら
			uIS.register((String)session.getAttribute("insertname"),(String)session.getAttribute("inserttel"),(String)session.getAttribute("insertpass"));	//登録するよ
			List<UserInfo> user = uIS.findMaxId();
			UserInfo uI = user.get(0);
			Integer maxId = uI.getUser_id();

			session.setAttribute("defo_id", maxId);		//検索時に初期表示させるために入れる
			return "insertResult";
		}else {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "insertConfirm";
		}
	}






}