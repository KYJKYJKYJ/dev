package dto;

public class DrinkDTO {
	private String name;
	private int price, num, alcohol;
	
	public DrinkDTO() {
		
	}
	
	public DrinkDTO(String name, int price, int alcohol) {
		this.name = name;
		this.price = price;
		this.alcohol = alcohol;	
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
