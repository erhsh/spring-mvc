package com.erhsh.prj.distrmgmtsys.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Element;

import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;

public class CarInfoMapper {
	private static final Map<String, String> mapper = new HashMap<String, String>();

	static {
		mapper.put("SystemID", "systemId");
		mapper.put("Brand", "brand");
		mapper.put("Factory", "factory");
		mapper.put("System", "system");
		mapper.put("ID", "id");
		mapper.put("Class", "type");
		mapper.put("Title", "title");
		mapper.put("Engine", "engine");
		mapper.put("GuidedPrice", "guidePrice");
		mapper.put("Size", "size");
		mapper.put("Struct", "struct");
		mapper.put("GearBox", "gearBox");
		mapper.put("Speed", "speed");
		mapper.put("Acceleration", "acceleration");
		mapper.put("OilConsumption", "oilConsumption");
		mapper.put("WebLink", "webLink");

	}

	public static CarInfoVO mapper(Element element) {
		CarInfoVO carInfoVO = null;

		Class<CarInfoVO> clazz = CarInfoVO.class;
		try {
			carInfoVO = clazz.newInstance();
			for (Entry<String, String> entry : mapper.entrySet()) {
				String attrXml = entry.getKey();
				String attrBean = entry.getValue();

				String attr = element.attributeValue(attrXml);
				Method m = clazz.getMethod(BeanUtils.setter(attrBean),
						String.class);
				m.invoke(carInfoVO, attr);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return carInfoVO;
	}

}
