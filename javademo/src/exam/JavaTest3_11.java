package exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.List;

public class JavaTest3_11 { // 문제상 클래스명 ListTest
	
	public static void display(List<Integer> list) {
		System.out.print("정렬 전 : ");
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
		
		System.out.print("정렬 후 : ");
		list.sort(new Descending());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			list.add(new Integer(random.nextInt(99) + 1));
		}
		
		display(list);
	}	
}

class Descending implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}