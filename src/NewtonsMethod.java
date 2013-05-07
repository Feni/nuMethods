
public class NewtonsMethod extends SingleVarEqSolver {
	double initAprox;		// Initial aproximation
	SingleVarEq fp;
	
	// Pre:
	public NewtonsMethod(SingleVarEq eq, SingleVarEq deriv, double p0){
		f = eq;
		fp = deriv;
		initAprox = p0;
	}
	
	
	public String solve(){
		if(status != NOT_SOLVED){
			return status;
		}
		double p0 = initAprox;
		double p = p0;
		for(int i = 0; i < MAX_ITER; i++){ 
			p = p0 - (f.at(p0) / fp.at(p0));
			if( Math.abs(p - p0) < TOLERANCE){ // we're done
				solution = p;
				iterations = i;
				solutionEval = f.at(p);
				status = SUCCESS;
				return SUCCESS;	
			}
			p0 = p;
		}
		System.out.println("Finished computaiton in MAX iterations");
		solution = p;
		iterations = MAX_ITER;
		solutionEval = f.at(p);
		status = FAIL_MAX_ITER;
		return status;
	}
	
	public String toString(){
		String rtrn = "Equation " + f + "; Initial guess ["+initAprox+"] \n";
		rtrn+="Status: "+status +"\n";
		rtrn+="Solution: "+solution+"\n";
		rtrn+="Iterations: "+iterations+"\n";
		rtrn+="f(solution): "+solutionEval+"\n";
		return rtrn;
	}
}