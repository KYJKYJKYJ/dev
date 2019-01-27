package java1023_network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class Java234_ChatHandler implements Runnable {
	Socket socket;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private static Vector<Java234_ChatHandler> userVec = new Vector<Java234_ChatHandler>(); // 접속할 유저 정보를 저장할 벡터
	InputStream is;
	Thread th;
	
	public Java234_ChatHandler() {
		
	} 
	
	public Java234_ChatHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void initStart() {
		try {
			is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			dataIn = new DataInputStream(new BufferedInputStream(is));
			dataOut = new DataOutputStream(new BufferedOutputStream(os));
			
			th = new Thread(this);
			th.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		userVec.addElement(this); // 스태틱으로 선언된 벡터가 쓰레드의 공유자원이 됨
								  // 벡터는 동기화가 되어 있다.
		
		while(!Thread.interrupted()) {
			try {
				String message = dataIn.readUTF();
				System.out.println(message);
				broadcast(message);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println(socket.getInetAddress().getHostAddress() + "님이 나가셨습니다.");
				return;
			}
		}
	}
	
	synchronized public void broadcast(String message) {
		Enumeration<Java234_ChatHandler> enu = userVec.elements(); // 공유자원인 벡터를 가져와서 열거함
		while(enu.hasMoreElements()) {
			Java234_ChatHandler handler = enu.nextElement();
			try {
				handler.dataOut.writeUTF(message);
				handler.dataOut.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				handler.stop();
			}
		}
	}
	
	synchronized public void stop() {
		if(th != null) {
			if(th != Thread.currentThread()) {
				th.interrupt();
				th = null;
				try {
					dataIn.close();
					dataOut.close();
				} catch (IOException e) {
					//e.printStackTrace(); // th가 Null이면 NullPointerException이 뜸
				}
				
			}
		}
	}
}
