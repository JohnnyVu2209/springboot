package com.example.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="employee")
public class Employee {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "sur_name")
	private String sur_name;

	@Column(name = "last_name")
	private String last_name;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday",nullable = true)
	private Date birthday;

	@Column(name = "address",nullable = true)
	private String address;

	public Employee() {
	}

	public Employee(int id, String first_name, String sur_name, String last_name, Date birthday, String address) {
		this.id = id;
		this.first_name = first_name;
		this.sur_name = sur_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSur_name() {
		return sur_name;
	}

	public void setSur_name(String sur_name) {
		this.sur_name = sur_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", sur_name=" + sur_name + ", last_name="
				+ last_name + ", birthday=" + birthday + ", address=" + address  + "]";
	}

}
