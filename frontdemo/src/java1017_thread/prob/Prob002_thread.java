package java1017_thread.prob;

public class Prob002_thread {

	public static void main(String[] args) {
		String[] el = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
				, "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		String[] eu = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
				"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] kr = new String[] { "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ",
				"ㅍ", "ㅎ" };
		
		EnglishLowerThread t1=new EnglishLowerThread(el);
		EnglishUpperThread t2=new EnglishUpperThread(eu);
		KoreanThread t3=new KoreanThread(kr);
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end main()

}//end class
