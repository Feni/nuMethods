package feni.school.m348;

public class Bisection extends SingleVarEqSolver {
	double startPt, endPt;
	// Pre:
	// f must be defined on the interval [a, b]
	// f(a) and f(b) are of opposite signs, non zero.
	public Bisection(SingleVarEq eq, double a, double b){
		f = eq;
		startPt = a;
		endPt = b;
		
		if(f.sign(startPt) == 0){
			status = SUCCESS;
			solution = startPt;
		}
		else if(f.sign(endPt) == 0){
			status = SUCCESS;
			solution = endPt;
		}
		else if( f.sign(startPt) != -1 * f.sign(endPt)){
			status = FAIL_PRE;
			throw new IllegalArgumentException("Signs of f(a) and f(b) should be opposites");
		}
		
	}
	
	
	public String solve(){
		if(status != NOT_SOLVED){
			return status;
		}
		double a = startPt;
		double b = endPt;
		double p = (a + b) / 2;
		double p1 = Double.MAX_VALUE;
		for(int i = 0; i < MAX_ITER; i++){ 
			double eval = f.at(p);
			// Check both condition 2.3 and 2.2
			// First checks if we've reached zero
			// Second checks if we've converged to some point
			if( Math.abs(eval) < TOLERANCE || Math.abs( (p - p1) / p ) < (TOLERANCE ) ){ // we're done
				solution = p;
				iterations = i;
				solutionEval = eval;
				status = SUCCESS;
				return SUCCESS;	
			}else{
				// Then p has the same sign as either a or b
				// since a and b are opposite signs and non-zero
				if(f.sign(p) == f.sign(a)){
					// Then p is in (p, b)
					// So find the midpoint of that sub-set
					a = p;
					//b = b;
				}else if(f.sign(p) == f.sign(b)){
					// a = a;
					b = p;
				}else{
					throw new IllegalStateException("Iteration Condition fails. f(p) doesn't have the same sign as either a or b");  
				}
			}
			p1 = p;
			p = (a + b) / 2;
			
		}
		System.out.println("Finished computaiton in MAX iterations");
		solution = p;
		iterations = MAX_ITER;
		solutionEval = f.at(p);
		status = FAIL_MAX_ITER;
		return status;
	}
	
	public String toString(){
		return "Interval ["+startPt +","+endPt+"]; \n " + super.toString();
	}
	
}