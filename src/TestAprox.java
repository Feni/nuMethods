import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.junit.Test;


public class TestAprox {

	@Test
	public void testNevillsMethod() { 
		// Bessel function of the first kind of order zero
		// See Ch. 3.2 example
		ArrayList<Point2D.Double> f = new ArrayList<Point2D.Double>();
		f.add(new Point2D.Double(1.0, 0.7651977));
		f.add(new Point2D.Double(1.3, 0.6200860));
		f.add(new Point2D.Double(1.6, 0.4554022));
		f.add(new Point2D.Double(1.9, 0.2818186));
		f.add(new Point2D.Double(2.2, 0.1103623));
			
		NevillsMethod aproximator = new NevillsMethod(f, 1.5);
		double aprox = aproximator.aprox();
		System.out.println("Final aproximation : " + aprox);
		assertTrue(Math.abs(aprox - 0.5118277) <= 0.001);
	}
	
}
