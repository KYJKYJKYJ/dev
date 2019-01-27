package exam;

class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Human() { }	
	public Human(String name, int age, int height, int weight) {
		this.name = name; this.age = age; this.height = height; this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + "\t" + age + "\t"+ height + "\t"+ weight + "\t";
	}
}

class Student extends Human {
	private String number;
	private String major;
	
	public Student() { }
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + number + "\t" + major + "\t";
	}
}

public class JavaTest3_07 {

	public static void main(String[] args) {
		Student[] students = new Student[3];
		
		Student stu1 = new Student("홍길순", 25, 171, 81, "201401", "영어영문학");
		students[0] = stu1;
		Student stu2 = new Student("한사랑", 23, 183, 72, "201402", "건축학");	
		students[1] = stu2;
		Student stu3 = new Student("임꺽정", 26, 175, 65, "201403", "체육학");
		students[2] = stu3;
		
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}

	}

}
