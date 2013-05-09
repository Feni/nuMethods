import org.junit.Test;


public class TestIVP {


	@Test
	public void testEuler() {
		MultiVarEq ex1 = new MultiVarEq(){
			public double at(double t, double y){
				return y - (t * t) + 1;
			}
		};
		// Example 1. pg 268
		// y' = y - t^2 + 1. 
		// 0 <= t <= 2. 
		// y(0) = 0.5
		EulersMethod method = new EulersMethod(ex1, 0, 2, 0.5);
		System.out.println("Eulers method : " + method.solve(10));
	}	
		
	
}
