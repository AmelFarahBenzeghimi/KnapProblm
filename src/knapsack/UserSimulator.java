package knapsack;
import java.util.HashMap;
import java.util.Map;

import org.chocosolver.solver.variables.BoolVar;

public class UserSimulator {
    private static int iterationCount = 0;
    Map<Integer, Integer> sumValues = new HashMap<>();

    
    
    

    public UserSimulator() {
        // Empty constructor
    }

	    
	    public void getvalue(BoolVar[] selected, int[] values) {
	        iterationCount++;

	        int sum = 0;

	        for (int i = 0; i < selected.length; i++) {
	            if (selected[i].getValue() == 1) {
	                sum += values[selected[i].getId() - 1];

	            }
	            
	        }
            sumValues.put(iterationCount, sum);


	        
	    }

	    

	    public Map<Integer, Integer> getSumValuesMap() {
	        return sumValues;
	    }

	        
	    
	}
