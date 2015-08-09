package com.erhsh.prj.distrmgmtsys.dao.impl.dms;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erhsh.prj.distrmgmtsys.dao.impl.GenericDao;
import com.erhsh.prj.distrmgmtsys.dao.po.dms.DmsCarInfo;

@Repository
public class ProductDao extends GenericDao<DmsCarInfo> {
	public List<DmsCarInfo> getTop(int topSize) {
		return this.find("from DmsCarInfo c where c.carId < ?",
				new Object[] { topSize });
	}
}
