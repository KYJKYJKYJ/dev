package java1011_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Java174_stream {

   public static void main(String[] args) {
      File file = new File("src/java1011_stream/phone.dat"); // 객체를 저장할때는 .txt 말고 .dat 확장자 사용
      FileOutputStream fs = null;
      ObjectOutputStream os = null;
      FileInputStream fi = null;
      ObjectInputStream oi = null;
      
      try {
         fs = new FileOutputStream(file);
         os = new ObjectOutputStream(fs);
         Phone p = new Phone("android", 5000);
         os.writeObject(p);
         os.writeObject(new String("java"));   
         os.flush();
         System.out.println("객체 저장");
         //객체를 저장하려면 직렬화 되어있어야한다.   
      } catch (FileNotFoundException e) { 
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      try {
         fi = new FileInputStream(file);
         oi = new ObjectInputStream(fi);
         Phone p = (Phone)oi.readObject();
         System.out.println(p.toString());
         String st = (String)oi.readObject();
         System.out.println(st.toString());
      } catch (FileNotFoundException e) {     
         e.printStackTrace();
      } catch (IOException e) {      
         e.printStackTrace();
      } catch (ClassNotFoundException e) {   
         e.printStackTrace();
      }
      
   }//end main()

}//end class