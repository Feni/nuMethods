import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.Callable;



public abstract class Equation {
	public Equation(){	}	
}


abstract class SingleVarEq extends Equation{

	public abstract double at(double pt);
	
	// Returns 1 if positive, -1 if negative
	public int sign(double pt){		
		if(this.at(pt) < 0){
			return -1;
		}else if(this.at(pt) > 0){ 
			return 1;
		}else{
			return 0;
		}
	}
}
