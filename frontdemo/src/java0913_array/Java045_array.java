package java0913_array;

public class Java045_array {

	public static void main(String[] args) {
		int[] data1 = new int[3]; // 기본값 0 
		long[] data2 = new long[3]; // 기본값 0L
		float[] data3 = new float[3]; // 기본값 0.0F
		double[] data4 = new double[3]; // 기본값 0.0
		char[] data5 = new char[3]; // 기본값 \u0000
		boolean[] data6 = new boolean[3]; // 기본값 false
		String[] data7 = new String[3]; // 기본값 null
		
		for(int i = 0; i < data1.length; i++) {
			System.out.println(data7[i]);
		}
		
		System.out.println("===========================================");
		
		char a = ' '; // String a = ""; 선언 가능
		char b = '\u0020'; // 공백
		char c = '\u0000';
		
		System.out.println(a==b);
		System.out.println(a==c);
	}

}
