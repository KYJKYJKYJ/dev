package exam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.Current;

public class JavaTest3_13 {

	public static void main(String[] args) {
		Map<String, Inventory> map = new HashMap<String, Inventory>();
		Calendar cal = Calendar.getInstance();
		
		cal.set(2016, 2, 15);
		Inventory iv1 = new Inventory("삼성 갤럭시 S7", cal.getTime(), 30);
		map.put(iv1.getProductName(), iv1);
		
		cal.set(2016, 1, 25);
		Inventory iv2 = new Inventory("LG G5", cal.getTime(), 20);
		map.put(iv2.getProductName(), iv2);
		
		cal.set(2016, 0, 23);
		Inventory iv3 = new Inventory("애플 아이패드 Pro", cal.getTime(), 15);
		map.put(iv3.getProductName(), iv3);
		
		for(Map.Entry<String, Inventory> entry : map.entrySet()) {
			Inventory value = entry.getValue();
			
			System.out.println(value);
		}
		
		Inventory[] invenArray = new Inventory[map.size()];
		invenArray[0] = map.get(iv1.getProductName());
		invenArray[1] = map.get(iv2.getProductName());
		invenArray[2] = map.get(iv3.getProductName());
		
		invenArray[0].setGetDate(new Date());
		invenArray[0].setGetAmount(10);
		
		invenArray[1].setGetDate(new Date());
		invenArray[1].setGetAmount(10);
		
		invenArray[2].setGetDate(new Date());
		invenArray[2].setGetAmount(10);
		
		System.out.println("출고 수량 10 적용 ----------------------------------------------");
		System.out.println(invenArray[0].toString());
		System.out.println(invenArray[1].toString());
		System.out.println(invenArray[2].toString());
		
		System.out.println("출고 수량  부족시 -----------------------------------------------");
		invenArray[0].setGetAmount(110);
	}

}

class Inventory {
	private String productName;
	private Date putDate; // 입고날짜
	private Date getDate; // 출고날짜
	private int putAmount; // 입고재고
	private int getAmount; // 출고재고
	private int inventoryAmount;
	
	public Inventory() { }	
	public Inventory(String productName, Date putDate, int putAmount) {
		this.productName = productName; this.putDate = putDate; this.putAmount = putAmount;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd");
		if(getDate == null) {
			return productName + ",\t" + sdf.format(putDate) + ",\t" + getDate + ",\t" + putAmount + "개" +
					",\t" + getAmount + "개";
		} else {
			return productName + ",\t" + sdf.format(putDate) + ",\t" + sdf.format(getDate) + ",\t" + putAmount + "개" +
					",\t" + getAmount + "개";
		}
	}
	
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
	
	public void setGetAmount(int getAmount) {
		if(putAmount < getAmount) {
			try {
				throw new AmountNotEnough("현재 재고가 부족합니다. 재고수량 확인하시기 바랍니다.");
			} catch (AmountNotEnough e) {
				System.out.println(e.getMessage());
			}
		} else {
			this.getAmount = (putAmount - getAmount);
		}
	}

	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName;}
	public Date getPutDate() { return putDate; }
	public void setPutDate(Date putDate) { this.putDate = putDate; }
	public int getPutAmount() { return putAmount; }
	public void setPutAmount(int putAmount) { this.putAmount = putAmount; }
	public int getInventoryAmount() { return inventoryAmount; }
	public void setInventoryAmount(int inventoryAmount) { this.inventoryAmount = inventoryAmount; }
	public Date getGetDate() { return getDate; }
	public int getGetAmount() { return getAmount; }
		
}

class AmountNotEnough extends Exception {
	public AmountNotEnough(String message) {
		super(message);
	}
}