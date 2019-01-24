package DTO;

public class QBoardDTO {
	private int q_num, q_ref, q_re_step, q_re_level;
	private String q_writer, q_subject, q_content, q_ip, q_upload;
	private String q_reg_date;
	
	public QBoardDTO() {
		
	}//end QBoardDTO()

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public int getQ_ref() {
		return q_ref;
	}

	public void setQ_ref(int q_ref) {
		this.q_ref = q_ref;
	}

	public int getQ_re_step() {
		return q_re_step;
	}

	public void setQ_re_step(int q_re_step) {
		this.q_re_step = q_re_step;
	}

	public int getQ_re_level() {
		return q_re_level;
	}

	public void setQ_re_level(int q_re_level) {
		this.q_re_level = q_re_level;
	}

	public String getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public void setQ_subject(String qsubject) {
		this.q_subject = qsubject;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_ip() {
		return q_ip;
	}

	public void setQ_ip(String q_ip) {
		this.q_ip = q_ip;
	}

	public String getQ_upload() {
		return q_upload;
	}

	public void setQ_upload(String q_upload) {
		this.q_upload = q_upload;
	}

	public String getQ_reg_date() {
		return q_reg_date;
	}

	public void setQ_reg_date(String q_reg_date) {
		this.q_reg_date = q_reg_date;
	}
	
	

	
}//end class