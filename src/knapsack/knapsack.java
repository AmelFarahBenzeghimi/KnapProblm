package knapsack;

<<<<<<< HEAD
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
        
        
     // Create a user simulator to set preferences
        UserSimulator userSimulator = new UserSimulator(numItems);
        userSimulator.setPreferences();
        int[] preferences = userSimulator.getPreferences();

        
        CustumVariableSelector variableSelector = new CustumVariableSelector(values, weights, preferences);
        CustomValueSelector valueSelector = new CustomValueSelector();

        IntStrategy    strategy = new IntStrategy(selected, variableSelector, valueSelector);
        
        // Create a solver
        Solver solver = model.getSolver();
        System.out.println(numItems);

        // Solve the problem
        while (solver.solve()) {
           System.out.println("Solution found!");
            for (int i = 0; i < numItems; i++) {
                if (selected[i].getValue() == 1) {
                    System.out.println("Item " + i + " is selected.");
                }
            }
        }
    }
}
=======



public class knapsack {
	
	
    public static void main(String[] args) {
    	int k =3;
        int maxSol=18;
        int num_iteration=0;
        
        int[] values = {4, 2, 7, 1, 5,2,8,7,11,22,3,17,8}; // Values of the items
        int[] weights = {2, 1, 6, 2, 4,1,8,6,5,4,3,11,10}; // Weights of the items
        int capacity = 20; // Knapsack capacity
        

        ProblemFormulation problem = new ProblemFormulation(values, weights, capacity);
        
          UserSimulator userSimulator= new UserSimulator();
           
        
        problem.solve();
        problem.displayoredreuser();

       
        userSimulator.getSumValuesMap();
        num_iteration=k;
        int iter=0;

        while(num_iteration<maxSol) {
        	iter++;
        	num_iteration+=k;
            System.out.println("ietartion solve number   "+iter);
            
            ProblemFormulation problem2 = new ProblemFormulation(values, weights, capacity);


        problem2.solve();

           problem2.displayoredreuser();
        }

        
	   
       
       
    	 
           
           
           
 	   
        
        
    	   
    	   
    	   
    } 
       
//	IterationHandler hd=new IterationHandler(maxSol);
	
	//    hd.handleIterations();
	
	
       
	
        
	

	
}
       
        
       // CustumVariableSelector variableSelector = new CustumVariableSelector(values, weights, preferences);
       // CustomValueSelector valueSelector = new CustomValueSelector();

        //IntStrategy    strategy = new IntStrategy(selected, variableSelector, valueSelector);
        
        
        
        
        
        
          
          

        
        
       
        
      
    
    


>>>>>>> origin/master
