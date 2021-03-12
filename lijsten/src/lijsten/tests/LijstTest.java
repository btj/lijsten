package lijsten.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lijsten.LegeLijst;
import lijsten.Lijst;
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
	}

}
