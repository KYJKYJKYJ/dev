package exam;

class Product {
	public String name;
	public int price;
	public int quantity;
	
	public Product() { }
	public Product(String name, int price, int quantity) {
		setName(name); setPrice(price); setQuantity(quantity);
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }	
	
	public String information() {
		return "상품명 : " + getName() + "\n" +
			   "가격 : " + getPrice() + "\n" +
			   "수량 : " + getQuantity();  
	}
}

public class JavaTest3_04 {

	public static void main(String[] args) {
		Product p = new Product("갤럭시 s7", 563500, 3);
		System.out.println(p.information());
		
		System.out.printf("총 구매 가격 : %d원\n", (p.getPrice()*p.getQuantity()));
	}

}
