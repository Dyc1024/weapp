package test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Conplidate {
	

	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="conplidate")
    private Set<Orders> orders = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	@Column
	private String cname;
	
	@Column
	private String cphone;
	
	@Column
	private String cemail;
	
	@Column
	private String cresum;
	
	@Column
	private String ccollege;
	
	@Column
	private String czhuanye;
	
	@Column
	private String ccardnum;
	
	@Column
	private String cworktype;
	
	@Column
	private Long uid;
	
	
	@JsonProperty("rows")
	public Set<Orders> getordres() {
		return orders;
	}
	
	public Long getWid() {
		return cid;
	}
	
	public void setWid(Long cid) {
		this.cid = cid;
	}
	
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}
	
	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	
	public void setCzhuanye(String czhuanye) {
		this.czhuanye = czhuanye;
	}

	public String getCzhuanye() {
		return czhuanye;
	}
	
	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	public String getCresum() {
		return cresum;
	}

	public void setCresum(String cresum) {
		this.cresum = cresum;
	}
	
	public String getCcollege() {
		return ccollege;
	}

	public void setCcollege(String ccollege) {
		this.ccollege = ccollege;
	}
	
	public String getCcardnum() {
		return ccardnum;
	}

	public void setCcardnum(String ccardnum) {
		this.ccardnum = ccardnum;
	}
	
	public String getCworktype() {
		return cworktype;
	}

	public void setCworktype(String cworktype) {
		this.cworktype = cworktype;
	}
	
	
	public Integer getTotal() {
		return orders.size();
	}
	/**
	 * 获取选择该工作的应聘者信息。 该方法不会被JSON序列化。
	 * @return  选择该工作的应聘者信息
	 */
	@JsonIgnore
	public Set<Orders> getOrders() {
		return orders;
	}
	
}
