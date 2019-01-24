package java0912_statement;

public class Java024_if {

	public static void main(String[] args) {
		
		//방송채널
		/*
		 * KBS channel 7 => 닥터포스터
		 * KBS channel 9 => 국수의 신
		 * MBC => 몬스터
		 * EBS => 한국기행
		 */
		
		int channel = 9;
		String station = "KBS";

		if (station == "MBC") {
			System.out.println("현재 방영 중인 프로그램은 몬스터");
		} else if (station == "EBS") {
			System.out.println("현재 방영 중인 프로그램은 한국기행");
		} else if (station == "KBS") {
			if (channel == 7) {
				System.out.println("현재 방영 중인 프로그램은 닥터포스터");
			} else if (channel == 9) {
				System.out.println("현재 방영 중인 프로그램은 국수의 신");
			} else { 
				System.out.println("방송이 존재하지 않습니다");
				}
		} else {
			System.out.println("방송이 존재하지 않습니다");
			}
		
	}

}
