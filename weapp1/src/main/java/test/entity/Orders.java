package test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Work works;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Conplidate conplidate;
	
	@Column
	private Integer isover=0;
	
	public Long getOid() {
		return oid;
	}


	public void setOid(Long oid) {
		this.oid = oid;
	}


	@JsonIgnore
	public Work getWorks() {
		return works;
	}


	public void setWorks(Work work) {
		this.works = work;
	}

	public Conplidate getConplidate() {
		return conplidate;
	}


	public void setConplidate(Conplidate conplidate) {
		this.conplidate = conplidate;
	}
}
