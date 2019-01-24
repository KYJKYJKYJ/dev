package homework_prob;

import java.io.*;

public class Streams {

	public void fileOpen(String fileName) {
		File file = new File(fileName);
		
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}

}
