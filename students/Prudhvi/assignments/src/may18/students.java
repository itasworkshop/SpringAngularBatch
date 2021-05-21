package may18;

public class students implements Comparable<students> {
	int id;
	String name;

	students(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
	@Override
	public int compareTo(students o) {
		String a = "" + this.id;
		a= a+ this.name;
		String b = "" + o.id;
		b = b+o.name;
		return a.compareTo(b);
	}
}
