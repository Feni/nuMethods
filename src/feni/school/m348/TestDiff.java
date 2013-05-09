package feni.school.m348;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.junit.Test;


public class TestDiff {

	@Test
	public void testDiffSin() {
		// 4.1 Q1
		ArrayList<Point2D.Double> f = new ArrayList<Point2D.Double>();
		f.add(new Point2D.Double(0.5, 0.4794));
		f.add(new Point2D.Double(0.6, 0.5646));
		f.add(new Point2D.Double(0.7, 0.6442));
			
		ArrayList<Point2D.Double> fP = DifferenceMethods.derivative(f, 0.1);
		System.out.println("Final aproximation : " + fP);
		//assertTrue(Math.abs(aprox - 0.5118277) <= 0.001);
	}

	
}
