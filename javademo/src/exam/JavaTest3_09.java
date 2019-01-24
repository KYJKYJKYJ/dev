package exam;

abstract class Plane {
	private String planeName;
	private int fuelSize;
	
	public Plane() { }
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel) {
		this.fuelSize = this.fuelSize + fuel;
	}
	
	abstract public void flight(int distance);
	
	public String getPlaneName() { return planeName; }
	public void setPlaneName(String planeName) { this.planeName = planeName; }
	public int getFuelSize() { return fuelSize; }
	public void setFuelSize(int fuelSize) { this.fuelSize = fuelSize; }
	
}

class Airplane extends Plane {
	public Airplane() { }
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - ((distance / 10) * 30));
	}
}

class Cargoplane extends Plane {
	public Cargoplane() { }
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - ((distance / 10) * 50));
	}
}

public class JavaTest3_09 {

	public static void main(String[] args) {
		Airplane ap = new Airplane("L747", 1000);
		Cargoplane cp = new Cargoplane("C40", 1000);

		System.out.println("Plane\t\tfuelSize");
		System.out.println("--------------------------");
		System.out.println(ap.getPlaneName()+"\t\t"+ap.getFuelSize());
		System.out.println(cp.getPlaneName()+"\t\t"+cp.getFuelSize());
		
		System.out.println("100 운항");
		ap.flight(100); cp.flight(100);
		
		System.out.println("Plane\t\tfuelSize");
		System.out.println("--------------------------");
		System.out.println(ap.getPlaneName()+"\t\t"+ap.getFuelSize());
		System.out.println(cp.getPlaneName()+"\t\t"+cp.getFuelSize());
		
		System.out.println("200 주유");
		ap.refuel(200); cp.refuel(200);
		
		System.out.println("Plane\t\tfuelSize");
		System.out.println("---------------------------");
		System.out.println(ap.getPlaneName()+"\t\t"+ap.getFuelSize());
		System.out.println(cp.getPlaneName()+"\t\t"+cp.getFuelSize());
	}

}
