package knapsack;

import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.variables.IntVar;

public class CustomValueSelector implements IntValueSelector {

	 @Override
	    public int selectValue(IntVar variable) {
	        return 1;
	        //add comment
	    }
	}