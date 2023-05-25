package knapsack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.Model;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.search.strategy.strategy.*;


public class knapsack {
    public static void main(String[] args) {
        // Knapsack problem parameters
        int[] values = {4, 2, 7, 1, 5}; // Values of the items
        int[] weights = {2, 1, 3, 2, 4}; // Weights of the items
        int capacity = 7; // Knapsack capacity

        int numItems = values.length;

        // Create a model
        Model model = new Model("Knapsack Problem");

        // Create decision variables: 0/1 variables indicating whether an item is selected or not
        BoolVar[] selected = model.boolVarArray(numItems);

        // Constraint: total weight should be less than or equal to the capacity
        model.scalar(selected, weights, "<=", capacity).post();

        // Objective function: maximize the total value
       // model.setObjective(Model.MAXIMIZE, model.scalar(selected, values));
        
        
        
            
        
       // CustumVariableSelector variableSelector = new CustumVariableSelector(values, weights, preferences);
       // CustomValueSelector valueSelector = new CustomValueSelector();

        //IntStrategy    strategy = new IntStrategy(selected, variableSelector, valueSelector);
        
        // Create a solver
        Solver solver = model.getSolver();
        solver.limitSolution(6);
        int counter=0;
        
        ArrayList<ArrayList<Integer>> arrayvalue1 = new ArrayList<>();

        // Solve the problem
        UserSimulator userSimulator = new UserSimulator();

        while (solver.solve()) {
        	counter++;
            userSimulator.getvalue(selected, values);        

           userSimulator.getSumValuesMap();

           
           
        }
        
        Map<Integer, Integer> sumValuesMap = userSimulator.getSumValuesMap();

        // Sort the map entries in decreasing order of sum values
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(sumValuesMap.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        // Display the sorted map entries
        System.out.println("the decreasing order set by the user is : ");
        for (int i = 0; i < sortedEntries.size(); i++) {
            Map.Entry<Integer, Integer> entry = sortedEntries.get(i);

            int iteration = entry.getKey();
            int sum = entry.getValue();
            System.out.print("solution " + iteration   );
            if (i < sortedEntries.size() - 1) {
                System.out.print(" > ");
            }
        }

    }
}

