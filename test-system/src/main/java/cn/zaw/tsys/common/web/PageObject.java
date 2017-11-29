package cn.zaw.tsys.common.web;

public class PageObject {
	private int pageCurrent = 1;
	private int pageSize = 10;
	private int rowCount;
	private int startIndex;
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageCount() {
		int pages = rowCount/pageSize;
		if (0 != rowCount % pageSize) {
			pages++;
		}
		return pages;
	}
}
