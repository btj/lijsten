package lijsten;

import java.util.Iterator;

public abstract class Lijst implements Iterable<Integer> {
	
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
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			Lijst lijst = Lijst.this;
			@Override
			public boolean hasNext() {
				return lijst instanceof NietLegeLijst;
			}
			@Override
			public Integer next() {
				NietLegeLijst nll = (NietLegeLijst)lijst;
				lijst = nll.getStaart();
				return nll.getKop();
			}
		};
	}

}
