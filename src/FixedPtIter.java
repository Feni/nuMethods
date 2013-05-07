
public class FixedPtIter extends SingleVarEqSolver {
	double initAprox;		// Initial aproximation
	
	// Pre:
	// eq is the fixed point equation
	// p0 is the intial guess
	public FixedPtIter(SingleVarEq eq, double p0){
		f = eq;
		initAprox = p0;
	}
	
	// We'll call it g even though the variable is f just to stick with the book's
	// convention. 
	public double g(double pt){
		return f.at(pt);
	}
	
	public String solve(){
		if(status != NOT_SOLVED){
			return status;
		}
		double p0 = initAprox;
		double p = g(p0);
		for(int i = 0; i < MAX_ITER; i++){ 
			p = g(p0);
			if( Math.abs(p - p0) < TOLERANCE){ // we're done
				solution = p;
				iterations = i;
				solutionEval = g(p);
				status = SUCCESS;
				return SUCCESS;	
			}
			p0 = p;
		}
		System.out.println("Finished computaiton in MAX iterations");
		solution = p;
		iterations = MAX_ITER;
		solutionEval = g(p);
		status = FAIL_MAX_ITER;
		return status;
	}
	
}