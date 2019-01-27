package java1011_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Java172_stream {

	public static void main(String[] args) {
		DataOutputStream dos = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		FileInputStream fis = null;

		try {
			fos = new FileOutputStream("src/java1011_stream/sample.txt");
			dos = new DataOutputStream(fos);

			fis = new FileInputStream("src/java1011_stream/sample.txt");
			dis = new DataInputStream(fis);

			dos.writeInt(65); // A
			dos.write(65);// A
			dos.writeDouble(10.5);
			dos.writeChar('a');
			dos.writeUTF("java");

			System.out.println(dis.readInt());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
