package jp.co.axiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.dao.impl.SearchDao;
import jp.co.axiz.entity.UserInfo;

@Service
public class SearchServiceImpl {

	@Autowired
	SearchDao sDao;

	//数字判定
	public boolean isNumber(String id) {
	    try {
	        Integer.parseInt(id);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}


	//検索結果を取得
	public List<UserInfo> search (String id, String name, String tel) {
		if(id != "" && !isNumber(id)) {
			return null;
		}
		return sDao.search(id, name, tel);

	}

	public Integer latestId () {
		return sDao.latestId();
	}

	//IDを元にデータ取得
	public UserInfo findById (String id) {
		return sDao.findById(Integer.parseInt(id));
	}
}