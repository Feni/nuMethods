
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
}
