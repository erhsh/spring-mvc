package com.erhsh.prj.distrmgmtsys.model;

// Generated 2015-8-5 23:30:11 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contracts generated by hbm2java
 */
@Entity
@Table(name = "contracts", catalog = "distrmgmtsys")
public class Contracts implements java.io.Serializable {

	private long contractId;
	private String seqNum;
	private String title;
	private String template;

	public Contracts() {
	}

	public Contracts(long contractId) {
		this.contractId = contractId;
	}

	public Contracts(long contractId, String seqNum, String title,
			String template) {
		this.contractId = contractId;
		this.seqNum = seqNum;
		this.title = title;
		this.template = template;
	}

	@Id
	@Column(name = "CONTRACT_ID", unique = true, nullable = false)
	public long getContractId() {
		return this.contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	@Column(name = "SEQ_NUM")
	public String getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TEMPLATE")
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
