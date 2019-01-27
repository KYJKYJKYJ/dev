package java1012_collection;

public class Person {
	private String name;
	private int age;
	
	public Person() { }
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "\t" + age;
	}
}
