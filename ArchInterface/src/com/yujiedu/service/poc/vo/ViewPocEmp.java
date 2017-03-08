package com.yujiedu.service.poc.vo;

import java.util.Date;

import com.yujiedu.orm.poc.PocDep;

public class ViewPocEmp implements java.io.Serializable {
	private String empUuid;
	private PocDep pocDep;
	private String empNo;
	private String firstName;
	private String lastName;
	private Date recUpdDt;

	public String getEmpUuid() {
		return empUuid;
	}

	public void setEmpUuid(String empUuid) {
		this.empUuid = empUuid;
	}

	public PocDep getPocDep() {
		return pocDep;
	}

	public void setPocDep(PocDep pocDep) {
		this.pocDep = pocDep;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRecUpdDt() {
		return recUpdDt;
	}

	public void setRecUpdDt(Date recUpdDt) {
		this.recUpdDt = recUpdDt;
	}

	@Override
	public String toString() {
		return "ViewPocEmp [empUuid=" + empUuid + ", empNo=" + empNo + ", firstName=" + firstName + ", lastName="
				+ lastName + ", recUpdDt=" + recUpdDt + "]";
	}

}
