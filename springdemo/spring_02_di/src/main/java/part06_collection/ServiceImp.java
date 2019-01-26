package part06_collection;

import java.util.Iterator;
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

	public ServiceImp(List<Integer> list) {
		this.list = list;
	}

	public ServiceImp(Map<String, Integer> map) {
		this.map = map;
	}

	public ServiceImp(Set<String> set) {
		this.set = set;
	}

	public ServiceImp(Properties prop) {
		this.prop = prop;
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
		for (Integer it : list)
			System.out.println(it);

	}

	@Override
	public void prn2() {
		/*
		 * for (String key : map.keySet()) { System.out.printf("%s %d\n", key,
		 * map.get(key)); }
		 */
		
		Set<String> set = map.keySet();
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			String key = ite.next();
			Integer value = map.get(key);
			System.out.printf("%s %d\n", key, value);
		}
	}

	@Override
	public void prn3() {
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			System.out.printf("%s\n", ite.next());
		}
	}

	@Override
	public void prn4() {
		Set<Object> set = prop.keySet();
		Iterator<Object> ite = set.iterator();
		while(ite.hasNext()) {
			Object key = ite.next();
			Object value = prop.get(key);
			System.out.printf("%s %s\n", key, value);
		}

	}

} // end class
