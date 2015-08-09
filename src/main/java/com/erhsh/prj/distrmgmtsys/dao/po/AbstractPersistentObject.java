package com.erhsh.prj.distrmgmtsys.dao.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@MappedSuperclass
public class AbstractPersistentObject implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301246659630978433L;

	@Column(name = "ACTIVE_FLAG")
	private BigDecimal activeFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUT_DATE")
	protected Date inputDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	protected Date updateDate;

	public BigDecimal getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(BigDecimal activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
