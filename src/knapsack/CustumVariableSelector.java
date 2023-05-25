package knapsack;

import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.variables.IntVar;

public class CustumVariableSelector implements VariableSelector<IntVar>   {
	private int[] values;
    private int[] weights;
    private int[] preferences;

    public CustumVariableSelector(int[] values, int[] weights, int[] preferences) {
        this.values = values;
        this.weights = weights;
        this.preferences = preferences;
    }

    @Override
    public IntVar getVariable(IntVar[] variables) {
    	double maxRatio = Double.MIN_VALUE;
        int maxPreference = Integer.MIN_VALUE;
        IntVar selectedVar = null;

        for (IntVar variable : variables) {
            int varIndex = variable.getId();
            double ratio = (double) values[varIndex] / weights[varIndex];

            if (ratio > maxRatio && preferences[varIndex] > maxPreference) {
                maxRatio = ratio;
                maxPreference = preferences[varIndex];
                selectedVar = variable;
            }
        }

        return selectedVar;
    }
}
