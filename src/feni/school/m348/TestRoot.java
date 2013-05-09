package feni.school.m348;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestRoot {
	static final double POINT_TOLERANCE = 0.001;

	@Test
	public void testBisectionSingleRoot() {
		SingleVarEq testEq = new SingleVarEq(){
			public double at(double x){
				return 4 * (x - 3); 
			}
			public String toString(){
				return "4(x - 3)";
			}			
		};
		Bisection solver = new Bisection(testEq, -100, 100);
		solver.solve();
		System.out.println(solver);
		assertEquals(solver.status, Bisection.SUCCESS);
		assertTrue(Math.abs(solver.solution - 3.0) <= POINT_TOLERANCE);
	}
	
	@Test
	public void testBisectionMultiRoot() {
		SingleVarEq testEq = new SingleVarEq(){
			public double at(double x){
				return (x * x) - 2 * x - 4;  
			}
			public String toString(){
				return "x^2 -2x -4";
			}
		};
		// Solutions = -1.2361, 3.2361 = 1 +/- sqrt(5)		
		Bisection root1 = new Bisection(testEq, -100, 0);
		root1.solve();
		System.out.println(root1);		
		assertEquals(root1.status, Bisection.SUCCESS);
		assertTrue(Math.abs(root1.solution - (-1.2361)) <= 0.002);

		Bisection root2 = new Bisection(testEq, 0, 100);
		root2.solve();
		System.out.println(root2);
		assertEquals(root2.status, Bisection.SUCCESS);
		assertTrue(Math.abs(root2.solution - (3.2361)) <= 0.002);
	}

	
	@Test
	public void testNewtonSingleRoot() {
		SingleVarEq function = new SingleVarEq(){
			public double at(double x){
				return 4 * (x - 3); 
			}
			public String toString(){
				return "4(x - 3)";
			}			
		};
		SingleVarEq derivative = new SingleVarEq(){
			public double at(double x){
				return 4; 
			}
			public String toString(){
				return "4";
			}
		};		
		
		NewtonsMethod solver = new NewtonsMethod(function, derivative, 21);
		solver.solve();
		System.out.println(solver);
		assertEquals(solver.status, Bisection.SUCCESS);
		assertTrue(Math.abs(solver.solution - 3.0) <= POINT_TOLERANCE);
	}	

	
	

	@Test
	public void testNewtonMultiRoot() {
		SingleVarEq testEq = new SingleVarEq(){
			public double at(double x){
				return (x * x) - 2 * x - 4;  
			}
			public String toString(){
				return "x^2 -2x -4";
			}
		};
		
		SingleVarEq testEqDeriv = new SingleVarEq(){
			public double at(double x){
				return 2*x - 2;  
			}
			public String toString(){
				return "2x - 2";
			}
		};		
		
		// Solutions = -1.2361, 3.2361 = 1 +/- sqrt(5)		
		NewtonsMethod root1 = new NewtonsMethod(testEq, testEqDeriv, -4);
		root1.solve();
		System.out.println(root1);		
		assertEquals(root1.status, Bisection.SUCCESS);
		assertTrue(Math.abs(root1.solution - (-1.2361)) <= POINT_TOLERANCE);

		// It seems that different guesses still give you the same root back. 
		NewtonsMethod root2 = new NewtonsMethod(testEq, testEqDeriv, 100);
		root2.solve();
		System.out.println(root2);
		assertEquals(root2.status, Bisection.SUCCESS);
		assertTrue(Math.abs(root2.solution - (3.2361)) <= POINT_TOLERANCE);
	}
	
	@Test
	public void testFixedPtIter() {
		// Pg 61, Illustration example. equation d. 
		SingleVarEq fixedPtFunct = new SingleVarEq(){
			public double at(double x){
				return Math.sqrt( 10 / (4 + x)  ); 
			}
			public String toString(){
				return "(10 / (4 + x))^(1/2)";
			}			
		};
		FixedPtIter solver = new FixedPtIter(fixedPtFunct, 1.5);
		solver.solve();
		System.out.println(solver);
		assertEquals(solver.status, Bisection.SUCCESS);
		assertTrue(Math.abs(solver.solution - 1.362523) <= 0.01);
	}	

	
}

// TODO : Hermite Interpolation
// TODO : Cubic spline interpolation after tridiagonal matrix stuff
