package com.erhsh.prj.distrmgmtsys.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public interface PersistentObject extends Serializable {

	/**
	 * active
	 */
	BigDecimal getActiveFlag();

	void setActiveFlag(BigDecimal activeFlag);

	/**
	 * input date
	 */
	Date getInputDate();

	void setInputDate(Date date);

	/**
	 * update date
	 */
	Date getUpdateDate();

	void setUpdateDate(Date date);

}
