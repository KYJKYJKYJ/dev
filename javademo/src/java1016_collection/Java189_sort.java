package java1016_collection;

import java.util.ArrayList;

public class Java189_sort {

	public static void main(String[] args) {
		ArrayList<Person> ts = new ArrayList<Person>() ;
		ts.add(new Person("홍길동", 40));
		ts.add(new Person("가비", 30));
		ts.add(new Person("가비", 20));
		ts.add(new Person("나비", 15));
		
		ts.sort(new Person());
		for(Person ps : ts)
			System.out.printf("%s %d\n", ps.getName(), ps.getAge());
	} // end main()

} // end class
