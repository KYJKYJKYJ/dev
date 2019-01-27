package java1023_network;

import java.net.MalformedURLException;
import java.net.URL;

public class Java229_network {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://realestate.daum.net/?nil_profile=mini&nil_src=realestat");
			System.out.println("getHost() : " + url.getHost() + "\n");
			System.out.println("getPort() : " + url.getPort() + "\n"); // 서버에 접근하기 위한 출입문
			System.out.println("getProtocol() : " + url.getProtocol() + "\n");
			System.out.println("getPath() : " + url.getPath() + "\n");
			System.out.println("getQuery() : " + url.getQuery() + "\n"); // 데베 관리를 위한 키
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	} // end main()

} // end class
