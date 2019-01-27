package java1015_collection;

import java.util.ArrayList;

public class Java183_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add(new String("java"));
		aList.add(new String("jsp"));
		aList.add(new String("spring"));
		prnDisplay(aList);
	}
	
	public static void prnDisplay(ArrayList<String> aList) {
		//aList 매개변수의 요소에서 'j'가 포함되어 있는 요소만 출력하는 프로그램 구현
		System.out.println("contains 사용");
		for(String sn : aList) {
			if(sn.contains("j")) {
				System.out.println(sn);
			}
		}
		
		System.out.println("=======================");
		
		System.out.println("charAt 사용");
		for(String sn : aList) {
			//sn="java"
			for(int i = 0; i < sn.length(); i++) {
				if(sn.charAt(i) == 'j') {
					System.out.println(sn.toString());
					break;
				}
			}
		}
		
		System.out.println("=======================");
		
		System.out.println("toCharArray 사용");
		for(String sn : aList) {
			char[] data = sn.toCharArray();
			for(int i = 0; i < data.length; i++) {
				if(data[i]=='j') {
					System.out.println(data);
					break;
				}
			}
		}
	}	
}
