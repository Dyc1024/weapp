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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="works")
    private Set<Orders> orders = new HashSet<>();
	
	@Column
	private String wordertype;
	
	@Column
	private String wphone;
	
	@Column
	private String wemail;
	
	@Column
	private String wtype;
	
	@Column
	private String wresum;
	
	@Column 
	private String wcompany;
	
	@Column
	private String wlicence;

	
	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public void setWordertype(String wordertype) {
		this.wordertype = wordertype;
	}

	public String getWordertype() {
		return wordertype;
	}
	
	public String getWphone() {
		return wphone;
	}

	public void setWphone(String wphone) {
		this.wphone = wphone;
	}
	
	public String getWemail() {
		return wemail;
	}

	public void setWemail(String wemail) {
		this.wemail = wemail;
	}
	
	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	
	public String getWresum() {
		return wresum;
	}

	public void setWresum(String wresum) {
		this.wresum = wresum;
	}
	
	public String getWcompany() {
		return wcompany;
	}

	public void setWcompany(String wcompany) {
		this.wcompany = wcompany;
	}
	
	public String getWlicence() {
		return wlicence;
	}

	public void setWlicence(String wlicence) {
		this.wlicence = wlicence;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return user;
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
