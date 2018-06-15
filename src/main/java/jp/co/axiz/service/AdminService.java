package jp.co.axiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.dao.AdminDao;
import jp.co.axiz.entity.Admin;
@Service
public class AdminService {
	@Autowired
private AdminDao adminDao;
	public Admin findByID(String id,String pass) {
		try{
			List<Admin> log = adminDao.findByIdAndPass(id,pass);
			Admin login=log.get(0);
			return login;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public Admin authentication(String id, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Admin findById(String id, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
