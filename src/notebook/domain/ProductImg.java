package notebook.domain;

public class ProductImg {
	private String imgName;//	상품사진파일
	private String descriptionImgName;//	상품 상세설명 파일
	public ProductImg(String imgName, String descriptionImgName) {
		super();
		this.imgName = imgName;
		this.descriptionImgName = descriptionImgName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getDescriptionImgName() {
		return descriptionImgName;
	}
	public void setDescriptionImgName(String descriptionImgName) {
		this.descriptionImgName = descriptionImgName;
	}
	
	
}
