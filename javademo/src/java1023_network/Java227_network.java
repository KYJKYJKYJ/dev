package java1023_network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

// 네트워크 : 데이터 통신이라는 공통의 목적을 위하여 두개 이상의 장치들이 연결되어 있는 통신구조
// (두 개 이상의 컴퓨터를 케이블 등으로 연결해 서로 데이터를 교환할 수 있도록 만든 시스템)

// 서버(Server) : 정보를 제공하는 컴퓨터
// 클라이언트(Client) : 정보를 제공받는 컴퓨터

// 프로토콜(Protocol) : 통신을 위해 지켜야 할 규약

public class Java227_network {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net");
			URLConnection conn = url.openConnection(); // 네트워크 연결을 위한 URLConnection
			Scanner sc = new Scanner(conn.getInputStream()); // 스트림과 연결하여 출력
			
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end main

} // end class
