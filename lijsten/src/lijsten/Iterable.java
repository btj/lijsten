package lijsten;

public interface Iterable {
	
	Iterator iterator();

	void forEach(Consumer consumer);

}
