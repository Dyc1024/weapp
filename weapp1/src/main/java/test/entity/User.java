package test.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}
	
	public String getPwd() {
		return password;
	}

	public void setPwd(String password) {
		this.password = password;
	}
	

}
