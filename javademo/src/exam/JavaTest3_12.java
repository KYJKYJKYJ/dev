package exam; // 문제상 ncs.test12

import java.io.*;
import java.util.*;

public class JavaTest3_12 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(1, new Fruit("apple", 1200, 3));
		prop.put(2, new Fruit("banana", 2500, 2));
		prop.put(3, new Fruit("grape", 4500, 5));
		prop.put(4, new Fruit("orange", 800, 10));
		prop.put(5, new Fruit("melon", 5000, 2));
		
		fileSave(prop);
		fileOpen(prop);
	}
	
	public static void fileSave(Properties p) {
		File file = new File("src/exam/data.xml");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			p.storeToXML(fos, p.toString(), "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOpen(Properties p) {
		File file = new File("src/exam/data.xml");
		Fruit[] fr = new Fruit[p.size()];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			p.loadFromXML(fis);
			
			class AscendingSort implements Comparator<Integer> {
				@Override
				public int compare(Integer o1, Integer o2) {
					return (o1).compareTo(o2);
				}
			}
			
			Integer[] keys = p.keySet().toArray(new Integer[0]);
			Arrays.sort(keys, new AscendingSort());
			
			for(int i = 0; i < p.size(); i++) {
				fr[i] = (Fruit) p.get(i+1);
				
				System.out.println(keys[i] + " = " + fr[i].toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Fruit {
	private String name;
	private int price;
	private int quantity;
	
	public Fruit() { }
	public Fruit(String name, int price, int quantity) {
		this.name = name; this.price = price; this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return name + ", " + price + "원, " + quantity + "개";
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
		
}