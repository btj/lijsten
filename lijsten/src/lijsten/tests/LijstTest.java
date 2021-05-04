package lijsten.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import lijsten.LegeLijst;
import lijsten.NietLegeLijst;

class LijstTest {

	@Test
	void test() {
		LegeLijst l1 = new LegeLijst();
		NietLegeLijst l2 = new NietLegeLijst(30, l1);
		NietLegeLijst l3 = new NietLegeLijst(20, l2);
		NietLegeLijst l4 = new NietLegeLijst(10, l3);
		assertEquals(10, l4.getKop());
		assertEquals(l3, l4.getStaart());
		assertEquals(3, l4.getLength());
		assertEquals("[10, 20, 30]", l4.toString());
		assertEquals(new NietLegeLijst(10, new NietLegeLijst(20, new NietLegeLijst(30, new LegeLijst()))), l4);
		
		Iterator<Integer> i = l4.iterator();
		assertTrue(i.hasNext());
		assertEquals(10, i.next());
		assertTrue(i.hasNext());
		assertEquals(20, i.next());
		assertTrue(i.hasNext());
		assertEquals(30, i.next());
		assertFalse(i.hasNext());
		
		ArrayList<Integer> elements0 = new ArrayList<>();
		for (Integer e : l4) {
			elements0.add(e);
		}
		assertEquals(List.of(10, 20, 30), elements0);
		
		ArrayList<Integer> elements = new ArrayList<>();
		l4.forEach(element -> {
			elements.add(element);
		});
		assertEquals(List.of(10, 20, 30), elements);
	}

}
