package java1023_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

// 두 컴퓨터를 네트워크 연결하여 대화하기 위한 socket 

// 접속할 서버 소켓에서 열어둔 포트 번호를 사용해서 접근해야함

public class Java231_ClientSocket {

	public static void main(String[] args) {
		Socket socket = null;
	
		try {
			// 1. 열어둔 포트번호로 서버에 접속
			socket = new Socket("127.0.0.1", 7777); // 로컬호스트 주소와 열어둔 포트번호로 접근
			
			// 2. 입출력 스트림 연결
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			
			// 3. 서버에 정보 전송
			osw.write("클라이언트 정보를 보냄");
			osw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}


// 이제 동기화 처리를 해서 서로서로 작동되게 만들어야 함 (따로 작동되는 것이 아닌)