package java0914_array.answ;

/*
 * [출력결과]
	data[0]=1
	data[1]=1
	data[2]=3
	data[3]=5
	data[4]=9
	data[5]=15
	data[6]=25
	data[7]=41
	data[8]=67
	data[9]=109
 */
public class Prob_06 {

	public static void main(String[] args) {
		int[] data=new int[10];
		data[0]=1;
		data[1]=1;
		
		// 여기에 구현하세요.///////////////////////
		for(int i=2; i<data.length; i++) {
			data[i]=data[i-1]+data[i-2]+1;
		}		
		///////////////////////////////////////
		

		for(int i=0; i<data.length; i++)
			System.out.printf("data[%d]=%d\n", i,data[i]);
	}//end main()

}//end class
