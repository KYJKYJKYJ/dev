package DTO;

public class ReviewReplyDTO {
	private int re_col;
	private int review_num;
	private String re_content, user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getRe_col() {
		return re_col;
	}

	public void setRe_col(int re_col) {
		this.re_col = re_col;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

}
