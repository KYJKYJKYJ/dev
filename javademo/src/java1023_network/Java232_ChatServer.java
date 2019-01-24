package java1023_network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Java232_ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7779);
			System.out.print("대기 : ");
			
			while(true) {
				Socket client = server.accept(); //무한루프로 여러 클라이언트의 접속이 가능하도록 계속 대기
				System.out.printf("Client 가  %s로 접속함\n", client.getInetAddress().getHostAddress());
				
				Java234_ChatHandler handler = new Java234_ChatHandler(client);
				handler.initStart();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
