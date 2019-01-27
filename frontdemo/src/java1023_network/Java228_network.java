package java1023_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Java228_network {

	public static void main(String[] args) {
		try {
			//InetAddress : ip주소를 다루기 위한 클래스
			InetAddress ip = InetAddress.getByName("daum.net");
			System.out.println(ip.getHostName()); // 도메인 네임을 가져옴
			System.out.println(ip.getHostAddress()); // 아이피 주소를 가져옴
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
