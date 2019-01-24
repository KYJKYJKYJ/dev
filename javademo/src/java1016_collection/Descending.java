package java1016_collection;

import java.util.Comparator;

//내림차순
public class Descending implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
	

}
