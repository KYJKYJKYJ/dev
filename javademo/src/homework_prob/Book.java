package homework_prob;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Book {
	public static void main(String[] args) {
	HashMap<String, Book> map = new HashMap<String, Book>();
	
	Book b = new Book();
	
	map.put(b.toString(), b);
	
	Iterator<Book> v_iterator = map.values().iterator();
	Iterator<String> k_iterator = map.keySet().iterator();
	
	while(k_iterator.hasNext() && v_iterator.hasNext()) {
		System.out.println(k_iterator.next() + " = " + v_iterator.next());
	}
	
	
 }
}
