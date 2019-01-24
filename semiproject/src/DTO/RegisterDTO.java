package DTO;

import java.util.Date;

public class RegisterDTO {
	//user_id sports register_date register_time
	private Integer register_num;
	private String user_id;
	private String sports;
	private Date register_date;
	private String register_time;
	
	public RegisterDTO() {
		
	}
	

	public Integer getRegister_num() {
		return register_num;
	}


	public void setRegister_num(Integer register_num) {
		this.register_num = register_num;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

}
