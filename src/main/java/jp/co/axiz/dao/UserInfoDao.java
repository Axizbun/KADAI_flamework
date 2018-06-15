package jp.co.axiz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.axiz.entity.UserInfo;

@Repository
public class UserInfoDao {
	@Autowired
	private NamedParameterJdbcTemplate nPJT;


	public List<UserInfo> findById(Integer id) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("id",id);
		try {
			return nPJT.query(
					"SELECT * FROM user_info WHERE user_id = :id",
					param,
					new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<UserInfo> findByName(String name) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("name",name);

		try {
			return nPJT.query(
					"SELECT * FROM user_info WHERE user_name = :name",
					param,
					new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}


	public void deleteById(Integer id) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("id",id);

		try {
			nPJT.update(
					"DELETE FROM user_info WHERE user_id = :id",
					param);

		}catch(EmptyResultDataAccessException e) {
		}
	}

	public List<UserInfo> search(String id, String name, String tel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void register(String name, String tel, String pass) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public List<UserInfo> findMax() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public int updateName(UserInfo user) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	public int updateTel(UserInfo user) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	public int updatePass(UserInfo user) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
