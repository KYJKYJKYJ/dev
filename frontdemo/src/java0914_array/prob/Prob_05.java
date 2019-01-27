package java0914_array.prob;

/*순위를 구하기
 [출력결과]
  
score      rank
===============
75          4
100         1
85          3
60          5
95          2
*/
public class Prob_05 
{
	public static void main(String[] args) 
	{
		int[] sc={75,100,85,60,95};
		int[] rank={1,1,1,1,1};
		//여기에 구현하세요./////////////////////
		for(int row = 0; row < sc.length; row++) {
			for(int col = 0; col < sc.length; col++) {
				if(sc[row] < sc[col]) {
					rank[row]++;
				}
			}
		}
		
		///////////////////////////////////
		System.out.println("score  rank");
		System.out.println("===========");
		for(int i=0; i<sc.length; i++)
		{
			System.out.println(sc[i]+"\t"+rank[i]);
		}
	}//end main()
}//end class
