package java0917_method;

public class Java063_method {

	public static char[] reverse(char[] data) {
		int index;
		int index2;
		char[] revData = new char[data.length];
		
		for(index = 0; index < revData.length; index++) {
			revData[index] = data[data.length-index-1];
		}
		
		/*for(index=0, index2=data.length-1; index < data.length; index++, index2--) {
			revData[index] = data[index2];
		}*/
		
		return revData;
	}
	
	public static void main(String[] args) {
		char[] arr = { 'j', 'a', 'v', 'a', ' ', 't', 'e', 's', 't' };
		
		System.out.println(arr);
		System.out.println(reverse(arr));
		System.out.println(arr);

	}

}
