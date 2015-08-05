package com.erhsh.prj.distrmgmtsys.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;

public class DBImporterUtil {

	public static List<CarInfoVO> parse() throws DocumentException {
		List<CarInfoVO> allData = new ArrayList<CarInfoVO>();
		List<File> files = FileUtils.listSub("d:\\cars");

		for (File file : files) {
			if (file.isDirectory()) {
				continue;
			}
			List<CarInfoVO> partData = parse(file);
			allData.addAll(partData);
		}

		return allData;

	}

	private static List<CarInfoVO> parse(File file) throws DocumentException {
		List<CarInfoVO> ret = new ArrayList<CarInfoVO>();
		if (!file.getName().endsWith(".xml")) {
			return ret;
		}

		SAXReader sax = new SAXReader();

		Document doc = sax.read(file);

		Element root = doc.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> elements = root.elements();

		for (Element e : elements) {
			CarInfoVO carInfo = CarInfoMapper.mapper(e);
			ret.add(carInfo);
		}

		return ret;
	}

	public static void main(String[] args) throws DocumentException {
		DBImporterUtil.parse();
	}
}
