package java1012_collection;

public class UserList {
	Object sale[] = new Object[3];
	int point = 0;
	
	public void add(Object data) { // Vector의 add 함수 구현
		if(point == sale.length) {
			Object[] arr = new Object[sale.length*2];
			System.arraycopy(sale, 0, arr, 0, sale.length); // 배열 복사 메소드.. System에서 제공
			sale = arr;
		}
			sale[point++] = data;
	}
	
	public int size() {
		return point;
	}
	
	public Object get(int index) {
		return sale[index];
	}
	
	public Object remove(int index) { // Vector의 remove 함수 구현
		if(index >= point)
			throw new ArrayIndexOutOfBoundsException();
		
		Object removeIndex = sale[index];
		
		for(int i = index; i < point; i++) {
			sale[i] = sale[i+1];
		}		
		point--;
		
		return removeIndex;
	}
} // end UserList
