package com.erhsh.prj.distrmgmtsys.dao.po.dms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.erhsh.prj.distrmgmtsys.dao.po.AbstractPersistentObject;

@Entity
@Table(name = "DMS_CAR_INFO")
public class DmsCarInfo extends AbstractPersistentObject {

	//
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CAR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;

	@Column(name = "ID")
	private String id;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "FACTORY")
	private String factory;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "SYSTEM")
	private String system;

	@Column(name = "SYSTEM_ID")
	private String systemId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ENGINE")
	private String engine;

	@Column(name = "GUIDE_PRICE")
	private String guidePrice;

	@Column(name = "SIZE")
	private String size;

	@Column(name = "STRUCTURE")
	private String structure;

	@Column(name = "GEAR_BOX")
	private String gearBox;

	@Column(name = "SPEED")
	private String speed;

	@Column(name = "ACCELERATION")
	private String acceleration;

	@Column(name = "OIL_CONSUMPTION")
	private String oilConsumption;

	@Column(name = "WEB_LINK")
	private String webLink;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(String guidePrice) {
		this.guidePrice = guidePrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(String acceleration) {
		this.acceleration = acceleration;
	}

	public String getOilConsumption() {
		return oilConsumption;
	}

	public void setOilConsumption(String oilConsumption) {
		this.oilConsumption = oilConsumption;
	}

	public String getWebLink() {
		return webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
