package knapsack;

import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.variables.IntVar;

<<<<<<< HEAD
=======



>>>>>>> origin/master
public class CustomValueSelector implements IntValueSelector {

	 @Override
	    public int selectValue(IntVar variable) {
<<<<<<< HEAD
	        return 1;
=======
	        int minValue = variable.getLB();
	        int maxValue = variable.getUB();

	        for (int value = minValue; value <= maxValue; value++) {
	            if (variable.contains(value)) {
	                return value;
	            }
	        }

	        return minValue;
>>>>>>> origin/master
	    }
	}