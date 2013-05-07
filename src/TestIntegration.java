import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.junit.Test;

public class TestIntegration {

	@Test
	public void testTrapRule() {
		SingleVarEq cosX = new SingleVarEq(){
			public double at(double pt){
				return Math.cos(pt);
			}
		};
		// integrate cos(x) from 0 to pi / 2 = 1
		double area = IntegrationMethods.trapezoidalRule(cosX, 0.0, Math.PI / 2.0);
		// Trapezoidal rule returns 0.7853981633974483
		System.out.println("Integral of cos(x) from 0 to Pi using trapezoidalRule: " + area);
	}


	@Test
	public void testSimpsonsRule() {
		SingleVarEq cosX = new SingleVarEq(){
			public double at(double pt){
				return Math.cos(pt);
			}
		};
		// integrate cos(x) from 0 to pi / 2 = 1
		double area = IntegrationMethods.simpsonsRule(cosX, 0.0, Math.PI / 2.0);
		// Returns the much better aproximation of 1.0022798774922104
		System.out.println("Integral of cos(x) from 0 to Pi using Simpsons Rule : " + area);
	}	
	
	
}
