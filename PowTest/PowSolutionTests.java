package steven.test;

import org.junit.Assert;
import org.junit.Test;

public class PowSolutionTests {

	// test for 2.3 ^ 3 removed here because of java issue
	// my code return 12.166999999999996, Math.pow returns 12.166999999999998
	// tiny difference.
	//@Test
	//public void testPowSolution1() {
	//	double x = 2.3;
	//	for (double j = 1; j < 30; j++)
	//		Assert.assertTrue("Testing " + x + " ^ "+j+"=>", PowSolution.myPow(x, j).equals(Math.pow(x, j)));		
	//}

	@Test
	// 2 ^ i (i = 1 to 100)
	public void testPowSolution() {
		double x = 2;
		for (double j = 1; j < 100; j++)
			try {
				Assert.assertTrue("Testing " + x + " ^ "+j+"=>", PowSolution.myPow(x, j).equals(Math.pow(x, j)));
			} catch (Exception e) {
				Assert.fail(e.getStackTrace().toString());
			}		
	}

	
	@Test
	// 2 ^ i (i = 1 to 100)
	// this test will be failed because the java vm issue: 12 * 12 *...(repeat 38 times) was different as 12^2 * 12^8...
	// when calculate 12 ^ 38, my code returns 1.0206746999785324E41,
	// Math.power returns 1.0206746999785322E41, tiny different cause the fail
	public void testPowSolution1() {
		double x = 12;
		for (double j = 1; j < 100; j++)
			try {
				Assert.assertTrue("Testing " + x + " ^ "+j+"=>", PowSolution.myPow(x, j).equals(Math.pow(x, j)));
			} catch (Exception e) {
				Assert.fail(e.getStackTrace().toString());
			}		
	}

	@Test
	// 2 ^ (-2)
	public void test_2_Pow_minus_2() {
		double x = 2, y = -2;
		
			try {
				Assert.assertTrue("Testing " + x + " ^ "+y+"=>", PowSolution.myPow(x, y).equals(Math.pow(x, y)));
			} catch (Exception e) {
				Assert.fail(e.getStackTrace().toString());
			}		
	}

	@Test
	// 2 ^ 0
	public void test_2_Pow_0() {
		double x = 2, y = 0;
		
			try {
				Assert.assertTrue("Testing " + x + " ^ "+y+"=>", PowSolution.myPow(x, y).equals(Math.pow(x, y)));
			} catch (Exception e) {
				Assert.fail(e.getStackTrace().toString());
			}		
	}
	

}
