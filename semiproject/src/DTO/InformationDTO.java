package DTO;

public class InformationDTO {
	private int info_num;
	private String info_upload, info_text;

	public int getInfo_num() {
		return info_num;
	}

	public String getInfo_text() {
		return info_text;
	}

	public void setInfo_text(String info_text) {
		this.info_text = info_text;
	}

	public void setInfo_num(int info_num) {
		this.info_num = info_num;
	}

	public String getInfo_upload() {
		return info_upload;
	}

	public void setInfo_upload(String info_upload) {
		this.info_upload = info_upload;
	}

}