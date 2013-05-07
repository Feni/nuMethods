import java.awt.geom.Point2D;
import java.util.ArrayList;


public class NevillsMethod {
	double pt;
	
	// Defines a pair of known points interpolating the function
	ArrayList<Point2D.Double> f;
	
	public NevillsMethod(ArrayList<Point2D.Double> table, double interpolatingPoint){	
		f = table;
		pt = interpolatingPoint;
	}
	
	// Aproximate the value of f(pt) given table
	public double aprox(){
		// We have p0 
		// Q1,1 = (x-x0)Q1,0 - (x-x1)Q0,0   / x1 - x0
		// Row, Column
		double[][] Q = new double[f.size()][f.size() + 1];
		
		for(int i = 0; i < f.size(); i++){
			Q[i][0] = f.get(i).y;
		}
		
//		Q[1][1] = ( ((pt - f.get(0).x) * Q[1][0]) - ((pt - f.get(1).x) * Q[0][0]) ) / (f.get(1).x - f.get(0).x);
//		Q[2][1] = ( ((pt - f.get(1).x) * Q[0][2]) - ((pt - f.get(2).x) * Q[0][1]) ) / (f.get(2).x - f.get(1).x);
		
		for(int column = 1; column < f.size(); column++){

			for(int row = column; row < f.size(); row++){
				double numeratorLeft = ((pt - f.get(row - column).x) * Q[row][column-1]);
				double numeratorRight = ((pt - f.get(row).x) * Q[row - 1][column-1]);
				double denom = f.get(row).x - f.get(row-column).x;
			//	System.out.println("NumLeft " + numeratorLeft + " - " + numeratorRight);
				//System.out.println("Denom " + denom);
				
				Q[row][column] = (numeratorLeft - numeratorRight) / denom;
				
				System.out.println("Q"+row+","+column+" = " +Q[row][column]);
			}
		}
		
		return 0;
	}
}

