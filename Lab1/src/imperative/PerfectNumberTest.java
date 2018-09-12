package imperative;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static imperative.PerfectNumber.STATE.ABUNDANT;
import static imperative.PerfectNumber.STATE.DEFICIENT;
import static imperative.PerfectNumber.STATE.PERFECT;

import org.junit.Test;

public class PerfectNumberTest {

	@Test
	public void test6Perfect() {
		assertEquals(PERFECT, PerfectNumber.process(6));
	}

	@Test
	public void test8Deficient() {
		assertEquals(DEFICIENT, PerfectNumber.process(8));
	}

	@Test
	public void test20Abundant() {
		assertEquals(ABUNDANT, PerfectNumber.process(20));
	}

	@Test
	public void test16DeficientWithIntSqrt() {
		assertEquals(DEFICIENT, PerfectNumber.process(16));
	}

	@Test
	public void test1Deficient() {
		assertEquals(DEFICIENT, PerfectNumber.process(1));
	}

	@Test
	public void testDivisors1() {
		Object[] expected = new Integer[] { 1 };
		int n = 1;
		assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
	}

	@Test
	public void testDivisors6() {
		Object[] expected = new Integer[] { 1, 2, 3, 6 };
		int n = 6;
		assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
	}

	@Test
	public void testDivisors8() {
		Object[] expected = new Integer[] { 1, 2, 4, 8 };
		int n = 8;
		assertArrayEquals(expected, PerfectNumber.divisors(n).toArray());
	}


	
	
}
