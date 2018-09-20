package recursive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveTest {
	@Test
	public void testSuperDigit9875() {
		assertEquals(29, Recursive.superDigit(9875));
	}
	@Test
	public void testSuperDigit29() {
		assertEquals(11, Recursive.superDigit(29));
	}
	@Test
	public void testSuperDigit11() {
		assertEquals(2, Recursive.superDigit(11));
	}
	@Test
	public void testSuperDigit2() {
		assertEquals(2, Recursive.superDigit(2));
	}
	@Test
	public void testPowerSum13() {
		assertEquals(1, (int)Recursive.powerSum(13,2,1));
	}
	@Test
	public void testPowerSum5() {
		assertEquals(1, (int)Recursive.powerSum(5,2,1));
	}
	@Test
	public void testPowerSum1() {
		assertEquals(1, (int)Recursive.powerSum(1,3,1));
	}
	@Test
	public void testPowerSum100() {
		assertEquals(3, (int)Recursive.powerSum(100,2,1));
	}
}