
public class IntegrationMethods {

	// Aproximates integral from b to a of f(x)
	public static double trapezoidalRule(SingleVarEq f, double a, double b){
		double h = b - a;
		return h * (f.at(a) + f.at(b) ) / 2.0;
	}
	
	// A better aproximation than trapezoidal rule giving
	// more weight to the midpoint between a and b. 
	public static double simpsonsRule(SingleVarEq f, double a, double b){
		double h = b - a;
		double midPt = (a + b) / 2.0;
		return (h / 6.0) * (f.at(a) + 4 * f.at(midPt) + f.at(b));
	}
	
	public static double compositeSimpsonsRule(SingleVarEq f, double a, double b, int steps){
		// N must be positive and even
		if(steps < 0 || steps % 2 != 0){
			throw new IllegalArgumentException("Steps must be positive and even");
		}
		double h = (b - a) / steps;
		double endSum = f.at(a) + f.at(b); 	// sum the end points
		double oddSum = 0;					// Temporary variables to hold the partial sums
		double evenSum = 0;
		
		for(int i = 0; i < steps; i++){
			double x = a + (i * h);
			if(i % 2 == 0){	// i is even
				evenSum += f.at(x);
			}else{
				oddSum += f.at(x);
			}
			
		}
		double sum = h * (endSum + 2 * evenSum + 4 * oddSum) / 3;
		return sum;
	}
	
	
	// Pg 218
	public static double romberg(SingleVarEq f, double a, double b, int steps){
		// TODO: Fix this to start at index 0 rather than 1;
		// It works as is, but allocates one dimension of extra array space than necessary.  
		// since the 0th row and column is never used. 
		double[][] R = new double[3][steps + 1];
		double h = (b - a);
		
		
		R[1][1] = (h / 2.0) * (f.at(a) + f.at(b));
		System.out.println("R1,1 = "+R[1][1]);
		for(int i = 2; i <= steps; i++){
			double tempSum = 0;
			int loopSteps = (int) Math.pow(2, i - 2);
			for(int k = 1; k <= loopSteps; k++){
				tempSum += f.at(a + (k - 0.5)*h);
			}
			// Aproximation from trapezoidal method
			R[2][1] = 0.5 * (R[1][1] + h * tempSum);
			
			for(int j = 2; j <= i; j++){
				// Extrapolation				
				R[2][j] = R[2][j-1] + ( (R[2][j-1] - R[1][j-1]) / (Math.pow(4, j-1) -1) );
			}
			
			for(int j = 1; j <= i; j++){
				System.out.print("R" + i +","+j+" = " +R[2][j]+ " \t");
			}
			System.out.println();
			
			h = h/ 2;
			// Update row 1
			for(int j = 1; j <= i; j++){
				R[1][j] = R[2][j];
			}
		}
		return R[1][steps];
	}	
	
	
}
