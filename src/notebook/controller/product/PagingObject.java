package notebook.controller.product;

public class PagingObject {
	private int allRecord;
	private int pageRecord = 12;
	private int totalPage;
	
	public PagingObject() {
		super();
	}

	public int getAllRecord() {
		return allRecord;
	}
	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
	}
	public int getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
