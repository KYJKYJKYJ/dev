package java1016_collection;

class Box<T>  { // 제네릭을 명시하는 자리 < > 임의의로 T로 할당 
	private T data;
	
	public Box() {
		
	}
	
	public Box(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
} // end class

public class Java199_User {

	public static void main(String[] args) {
		Box<Integer> box = new Box<Integer>();
		box.setData(new Integer(10));
		System.out.println(box.getData());
		
		Box<String> box2 = new Box<String>("java");
		System.out.println(box2.getData());

	} // end main()

} // end class
