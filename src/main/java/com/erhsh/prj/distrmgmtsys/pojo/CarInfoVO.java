package com.erhsh.prj.distrmgmtsys.pojo;

public class CarInfoVO {
	private String id;
	private String systemId;
	private String brand;
	private String factory;
	private String system;
	private String type;
	private String title;
	private String engine;
	private String guidePrice;
	private String size;
	private String struct;
	private String gearBox;
	private String speed;
	private String acceleration;
	private String oilConsumption;
	private String webLink;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getStruct() {
		return struct;
	}

	public void setStruct(String struct) {
		this.struct = struct;
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
		return "CarInfo [id=" + id + ", systemId=" + systemId + ", brand="
				+ brand + ", factory=" + factory + ", system=" + system
				+ ", type=" + type + ", title=" + title + ", engine=" + engine
				+ ", guidePrice=" + guidePrice + ", size=" + size + ", struct="
				+ struct + ", gearBox=" + gearBox + ", speed=" + speed
				+ ", acceleration=" + acceleration + ", oilConsumption="
				+ oilConsumption + ", webLink=" + webLink + "]";
	}

}
