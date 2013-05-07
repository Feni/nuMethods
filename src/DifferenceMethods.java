import java.awt.geom.Point2D;
import java.util.ArrayList;


// Ways to calculate the derivative of a function. 
public class DifferenceMethods {

	// Use a negative h for backward difference
	// h should be small for accurate results
	public static double forwardDifference(SingleVarEq f, double h, double pt){
		return (f.at(pt + h) - f.at(pt) ) / h; 
	}
	
	public static double threePtEndPtForumla(SingleVarEq f, double h, double pt){
		return (f.at(pt - 2*h) - 4 * f.at(pt - h) + 3 * f.at(pt)  ) / (2 * h);
	}
	
	public static double threePtMidPtFormula(SingleVarEq f, double h, double pt){
		return (f.at(pt + h) - f.at(pt - h) ) / (2 * h);
	}

	
	// fPt = f(pt), fPt1 = f(pt + h)
	public static double forwardDifference(double fPt, double fPtph, double h){
		return (fPtph - fPt ) / h; 
	}

	// fPtm2h = f.at(pt - 2h)
	// fPtmh = f.at(pt - h)
	// fPt = f.at(pt)
	public static double threePtEndPtForumla(double fPtm2h, double fPtmh, double fPt, double h){
		return (fPtm2h - 4 * fPtmh + 3 * fPt  ) / (2 * h);
	}
	
	public static double threePtMidPtFormula(double fPtph, double fPtmh, double h){
		return (fPtph - fPtmh ) / (2 * h);
	}
	
	
	public static ArrayList<Point2D.Double> derivative(ArrayList<Point2D.Double> f, double h){
		ArrayList<Point2D.Double> fPrime = new ArrayList<Point2D.Double>();
		assert fPrime.size() >= 3;
		// Use endPt formula for the first point
		double x0 = f.get(0).x;
		double yP0 = threePtEndPtForumla( f.get(2).y, f.get(1).y, f.get(0).y, -1 * h);
		fPrime.add(new Point2D.Double(x0, yP0 ));
		
		// Do all the midPoints. Exclude the last end point
		for(int i = 1; i < f.size() - 1; i++){
			double fPtph = f.get(i + 1).y;
			double fPtmh = f.get(i - 1).y;
			double yPi = threePtMidPtFormula(fPtph, fPtmh, h);
			fPrime.add(new Point2D.Double(f.get(i).x, yPi));
		}
		
		int lastI = f.size() - 1;
		double xi = f.get(lastI).x;
		double yPi = threePtEndPtForumla( f.get(lastI - 2).y, f.get(lastI - 1).y, f.get(lastI).y, h);
		fPrime.add(new Point2D.Double(xi, yPi));
		
		return fPrime;
	}
}
