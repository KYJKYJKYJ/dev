package part05;

public class MemDTO {
	private int num; //0
	private String name; //null
	private int age; //0
	private String loc; //null
	
	public MemDTO() {

	}
	
	public MemDTO(int num, String name, int age, String loc) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.loc = loc;
	}

	public MemDTO(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}

	public MemDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/*public MemDTO(String name, String loc) {
		this.name = name;
		this.loc = loc;
	}*/

	public MemDTO(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public MemDTO(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
