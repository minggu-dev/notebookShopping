package notebook.domain;

import java.util.List;

public class Product {
	private String serialNum;//	일련번호
	private String modelName;//	모델명
	private String company;//	회사
	private int price;//	가격
	private int ram;//		램
	private String cpu;//	cpu
	private int noteSize;//	화면크기
	private double noteWeight;//	무게
	private String launchDate;//	출시일
	private int stock;//	재고
	private double grade;//	평점
	private String descriptionImgName;//	상품상세사진
	private String imgName;
	public Product() {
		super();
	}
	public Product(String serialNum, String modelName, String company, int price, int ram, String cpu, int noteSize,
			double noteWeight, String launchDate, int stock, double grade, String descriptionImgName, String imgName) {
		super();
		this.serialNum = serialNum;
		this.modelName = modelName;
		this.company = company;
		this.price = price;
		this.ram = ram;
		this.cpu = cpu;
		this.noteSize = noteSize;
		this.noteWeight = noteWeight;
		this.launchDate = launchDate;
		this.stock = stock;
		this.grade = grade;
		this.descriptionImgName = descriptionImgName;
		this.imgName = imgName;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getNoteSize() {
		return noteSize;
	}
	public void setNoteSize(int noteSize) {
		this.noteSize = noteSize;
	}
	public double getNoteWeight() {
		return noteWeight;
	}
	public void setNoteWeight(double noteWeight) {
		this.noteWeight = noteWeight;
	}
	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getDescriptionImgName() {
		return descriptionImgName;
	}
	public void setDescriptionImgName(String descriptionImgName) {
		this.descriptionImgName = descriptionImgName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	
	
}
