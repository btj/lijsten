package lijsten;

public class LegeLijst extends Lijst {

	public int getLength() { return 0; }
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof LegeLijst))
			return false;
		return true;
	}
	
}
