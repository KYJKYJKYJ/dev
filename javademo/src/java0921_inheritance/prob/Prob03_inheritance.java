package java0921_inheritance.prob;

/*
 * 
 * Movie클래스를 상속받아 MovieWork클래스를 구현하세요.
 * MovieWork클래스에서 display( )메소드를 오버라이딩해서
 * 아래와 같이 구현하세요.
 * [출력결과]
 * 영화제목:추격자
* 감독 : 7, 배우 : 5
* 영화총점 :12
* 영화평점 : ☆☆☆☆
* ***********************************
* 영화제목:사도세자
* 감독:9, 배우:10, 작품성:10, 대중성:8, 대본:9
* 영화총점 : 46
* 영화평점 : ☆☆☆☆☆
 */

class Movie {
	String title; // 영화제목 - 멤버변수	
	int director; // 감독점수 - 멤버변수
	int acter; // 배우점수 - 멤버변수
	
	
	
	public Movie(String title,  int director, int acter) {		
		this.title = title;		
		this.director = director;
		this.acter = acter;
	}
	
	void display() {
		
		int total = director+ acter; 		
		String result="";
		System.out.printf("영화제목:%s\n",title);
		System.out.printf("감독 : %d, 배우 : %d\n",director,acter);
		System.out.printf("영화총점 :%d\n",total);
		if (total >= 15)
			result = "☆☆☆☆☆";
		else if(total>=12)
			result = "☆☆☆☆";
		else if(total>=10)
			result = "☆☆☆";
		else
			result = "☆☆";
		System.out.println("영화평점 : " + result);
	}
	
}

class MovieWork extends Movie{
	private int cinematic; //작품성
	private int popular; //대중성
	private int scenario; //시나리오
	public MovieWork(String title,  int director, int acter, int cinematic, int popular, int scenario) {
		super(title,director, acter);
		this.cinematic = cinematic;
		this.popular = popular;
		this.scenario = scenario;
	}
	
	@Override
	void display() {
		//여기를 구현하세요.
		int total = director+ acter + cinematic + popular + scenario; 		
		String result="";
		System.out.printf("영화제목:%s\n",title);
		System.out.printf("감독 : %d, 배우 : %d, 작품성 : %d, 대중성 : %d, 대본 : %d\n", director, acter, cinematic, popular, scenario);
		System.out.printf("영화총점 : %d\n",total);
		if (total >= 15)
			result = "☆☆☆☆☆";
		else if(total>=12)
			result = "☆☆☆☆";
		else if(total>=10)
			result = "☆☆☆";
		else
			result = "☆☆";
		System.out.println("영화평점 : " + result);
	}
}

public class Prob03_inheritance {

	public static void main(String[] args) {
		Movie mv=new Movie("추격자",7,5);
		mv.display();
		
		System.out.println("***********************************");
		
		// 매개변수 4개인 생성자로 객체 생성
		MovieWork mk = new MovieWork("사도세자", 9, 10, 10,8,9);
		mk.display();
	}

}
