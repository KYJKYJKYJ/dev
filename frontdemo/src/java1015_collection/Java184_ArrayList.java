package java1015_collection;

import java.util.ArrayList;

public class Java184_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("oracle");
		aList.add("mysql");
		aList.add("mssql");

		String[] arr = display(aList);
		for (String data : arr)
			System.out.println(data);
	} // end main
	
	public static String[] display(ArrayList<String> aList) {
		/*String[] stn = new String[aList.size()];
		for(int i = 0; i < aList.size(); i++)
			stn[i]=aList.get(i);
		return stn;*/
		
		//aList.toArray(a) -> T[] a 임의의 형식의 배열을 넣어준다 
		/*Object[] obj = aList.toArray();
		String[] stn = new String[obj.length];
		for(int i = 0; i < stn.length; i++) {
			stn[i] = (String) obj[i];
		}
		return stn;*/
		
		/*String[] stn = new String[aList.size()];
		return aList.toArray(stn); -> 이 때 toArray 리턴 타입은 String
		
		만약에 Integer[] stn로 선언해서 넣어주면 리턴 타입은 Integer*/
		
		 return aList.toArray(new String[aList.size()]); //한번에도 가능
	} // end display

} // end class
