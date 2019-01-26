package part12_exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class ServiceImp implements Service{
	private List<String> list;
	
	public ServiceImp() {
	
	}

	public ServiceImp(List<String> list) {
		this.list = list;
	}
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public void process() {
		/*
		 * //중복허용은 HashSet 하면 중복이 알아서 제거 되므로 알아두자... 
		 * HashSet<String> set = new HashSet<String>(list);
		 * List<String> list = new ArrayList<String>(set);
		 * Collections.sort(list);
		 * 
		 * for(String str : list) System.out.println(str);
		 */
		
		TreeSet<String> tSet = new TreeSet<String>(list);
		while(!tSet.isEmpty())
			System.out.println(tSet.pollFirst());
	}

}// end class






