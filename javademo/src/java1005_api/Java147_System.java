package java1005_api;

import java.text.SimpleDateFormat;

public class Java147_System {

	public static void main(String[] args) {
		/*
		 * currentTimeMillis() : 1970. 1. 1 부터 초단위로 눡한 값을 밀리세컨드로 리턴
		 * 하루는 86400초, 1초는 1000밀리세컨드
		 */
		long curr = System.currentTimeMillis();
		System.out.println(curr);
		
		//currentTimeMillis를 이용하여 현재 시간을 출력함
		String pattern = "yyyy-MM-dd HH:mm:ss a EEEE"; //MM은 월, mm은 분, hh는 12시간 단위, HH는 24시간 단위

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String data = sdf.format(curr);
		System.out.println(data);
		
	}

}
