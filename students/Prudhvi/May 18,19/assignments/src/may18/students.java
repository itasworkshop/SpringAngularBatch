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
		if(this.id==o.id)
		return this.name.compareTo(o.name);
		return this.id-o.id;
	}
}
