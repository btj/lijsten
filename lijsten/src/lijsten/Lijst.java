package lijsten;

public abstract class Lijst {
	
	public abstract int getLength();
	
	public String toString() {
		String result = "[";
		boolean first = true;
		Lijst lijst = this;
		while (lijst instanceof NietLegeLijst) {
			NietLegeLijst nll = (NietLegeLijst)lijst;
			if (first)
				first = false;
			else
				result += ", ";
			result += nll.getKop();
			lijst = nll.getStaart();
		}
		result += "]";
		return result;
	}

}
