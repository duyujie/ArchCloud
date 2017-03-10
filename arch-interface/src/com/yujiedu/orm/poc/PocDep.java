package com.yujiedu.orm.poc;
// Generated Jan 22, 2015 4:57:48 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;


/**
 * PocDep generated by hbm2java
 */
@Entity
@Table(name = "POC_DEP", uniqueConstraints = @UniqueConstraint(columnNames = "DEP_NAME"))
public class PocDep implements java.io.Serializable {

	private String depUuid;
	private String depName;
	private Date recCrtDt;
	private Date recUpdDt;
	private String orgId;
	private Set<PocEmp> pocEmps = new HashSet<PocEmp>(0);

	public PocDep() {
	}

	public PocDep(String depUuid, String depName, Date recCrtDt, Date recUpdDt) {
		this.depUuid = depUuid;
		this.depName = depName;
		this.recCrtDt = recCrtDt;
		this.recUpdDt = recUpdDt;
	}

	public PocDep(String depUuid, String depName, Date recCrtDt, Date recUpdDt, Set<PocEmp> pocEmps) {
		this.depUuid = depUuid;
		this.depName = depName;
		this.recCrtDt = recCrtDt;
		this.recUpdDt = recUpdDt;
		this.pocEmps = pocEmps;
	}

	@Column(name = "DEP_NAME", unique = true, nullable = false, length = 50)
	public String getDepName() {
		return this.depName;
	}

	@Id

	@Column(name = "DEP_UUID", unique = true, nullable = false, length = 32)
	public String getDepUuid() {
		return this.depUuid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocDep")
	public Set<PocEmp> getPocEmps() {
		return this.pocEmps;
	}

	@Column(name = "REC_CRT_DT", nullable = false, length = 26)
	public Date getRecCrtDt() {
		return this.recCrtDt;
	}

	@Version
	@Column(name = "REC_UPD_DT", nullable = false, length = 26)
	public Date getRecUpdDt() {
		return this.recUpdDt;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setDepUuid(String depUuid) {
		this.depUuid = depUuid;
	}

	public void setPocEmps(Set<PocEmp> pocEmps) {
		this.pocEmps = pocEmps;
	}

	public void setRecCrtDt(Date recCrtDt) {
		this.recCrtDt = recCrtDt;
	}

	public void setRecUpdDt(Date recUpdDt) {
		this.recUpdDt = recUpdDt;
	}

	@Column(name = "ORG_UUID", length = 32)
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}