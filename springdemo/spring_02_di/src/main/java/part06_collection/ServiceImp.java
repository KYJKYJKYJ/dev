package part06_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ServiceImp implements Service {
	private List<Integer> list;
	private Map<String, Integer> map;
	private Set<String> set;
	private Properties prop;

	public ServiceImp() {
		
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public void prn1() {
		for(Integer it : list)
			System.out.println(it);
		
	}

	@Override
	public void prn2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prn3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prn4() {
		// TODO Auto-generated method stub
		
	}
	
} // end class
