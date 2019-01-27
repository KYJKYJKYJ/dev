package java1012_collection;

public class Sawon {
	private String name;
	private int one;
	private int two;
	private int three;

	public Sawon() {

	}

	public Sawon(String name, int one, int two, int three) {
		super();
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	private int jumsuTotal() {
		return one+two+three;
	}
	
	@Override
	public String toString() {
	  return name+" "+one+" "+two+" "+three+" "+jumsuTotal();
	}
}// end Sawon






