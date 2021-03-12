package lijsten;

public class NietLegeLijst extends Lijst {
	
	/**
	 * @invar | staart != null
	 */
	private final int kop;
	private final Lijst staart;
	
	public int getKop() { return kop; }
	public Lijst getStaart() { return staart; }
	
	public NietLegeLijst(int kop, Lijst staart) {
		if (staart == null)
			throw new IllegalArgumentException("`staart` is null");
		
		this.kop = kop;
		this.staart = staart;
	}
	
	@Override
	public int getLength() {
		return 1 + staart.getLength();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NietLegeLijst))
			return false;
		NietLegeLijst otherLijst = (NietLegeLijst)other;
		return kop == otherLijst.kop && staart.equals(otherLijst.staart);
	}

}
