package java1012_collection;

public class Java176_list {

	public static void main(String[] args) {
		UserList uList = new UserList();
		uList.add(new Integer(10));
		uList.add(new Integer(20));
		uList.add(new Integer(30));
		uList.add(new Integer(40));
		
		for(int i = 0; i < uList.size(); i++) {
			Integer it = (Integer)uList.get(i);
			System.out.println(it);
		}

		System.out.println();
		
		System.out.println(uList.remove(3) + " 제거됨\n");
		for(int i = 0; i < uList.size(); i++) {
			Integer it = (Integer)uList.get(i);
			System.out.println(it);
		}
		
	}

}
