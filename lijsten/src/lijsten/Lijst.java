package lijsten;

public abstract class Lijst implements Iterable {
	
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
	public Iterator iterator() {
		return new Iterator() {
			Lijst lijst = Lijst.this;
			@Override
			public boolean hasNext() {
				return lijst instanceof NietLegeLijst;
			}
			@Override
			public Object next() {
				NietLegeLijst nll = (NietLegeLijst)lijst;
				lijst = nll.getStaart();
				return nll.getKop();
			}
		};
	}
	
	@Override
	public void forEach(Consumer consumer) {
		for (Lijst lijst = this; lijst instanceof NietLegeLijst; ) {
			NietLegeLijst nll = (NietLegeLijst)lijst;
			consumer.accept(nll.getKop());
			lijst = nll.getStaart();
		}
	}

}
