package feni.school.m348;
abstract class MultiVarEq{
	public abstract double at(double t, double y);
}


public class EulersMethod {
	MultiVarEq yP;	// y' = f(t, y)
	double a, b;	// boundaries for t. 
	double initVal;	// alpha. = y(a)
	
	public EulersMethod(MultiVarEq yPrime, double startBound, double endBound, double iVal){ 
		yP = yPrime;
		a = startBound;
		b = endBound;
		initVal = iVal;
	}
	
	// outputs aproximation w to y at the (N+1) values of t
	public double solve(int n){
		double h = (b - a) / n;
		double t = a;
		double w = initVal;
		System.out.println("(t,w) = ("+t+","+w+")");
		
		for(int i = 1; i <= n; i++){
			w = w + h * yP.at(t, w);
			t = a + i * h;
			System.out.println("(t,w) = ("+t+","+w+")");
		}
		return w;
	}
}
