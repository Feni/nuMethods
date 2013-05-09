package feni.school.m348;

// Solves the problem of finding the roots to equations
public abstract class EqSolver {
	int MAX_ITER = 1000;
	double TOLERANCE = 0.001;
	double CONVERGENCE_TOLERANCE = 1/TOLERANCE;
}

abstract class SingleVarEqSolver extends EqSolver{
	static final String NOT_SOLVED = "Function has not been solved yet.";
	static final String SUCCESS = "Success!";
	static final String FAIL_MAX_ITER = "Fail: Could not solve within max iterations";
	static final String FAIL_PRE = "Fail: Pre-conditions were not met";
	
	
	SingleVarEq f;
	double solution;
	String status = NOT_SOLVED;
	int iterations = 0;
	
	// f(solution) for easy comparison 
	double solutionEval = 0;
	
	// Helper method to call f a little more clealy. f(pt) rather than f.at(pt)
	public double f(double pt){
		return f.at(pt);
	}

	
	public abstract String solve();	

	public String toString(){
		String rtrn = "Equation " + f + "; \n";
		rtrn+="Status: "+status +"\n";
		rtrn+="Solution: "+solution+"\n";
		rtrn+="Iterations: "+iterations+"\n";
		rtrn+="f(solution): "+solutionEval+"\n";
		return rtrn;
	}
	
}



// TODO : 2.2 Pg 60. Fixed point iteration

