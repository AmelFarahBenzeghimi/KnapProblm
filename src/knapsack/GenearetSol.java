package knapsack;

public class GenearetSol {
	int k;
         public GenearetSol(int k) {
           this.k=k;	
           }

         public void generateSolutions() {
             int[] values = {4, 2, 7, 1, 5}; // Values of the items
             int[] weights = {2, 1, 3, 2, 4}; // Weights of the items
             int capacity = 7; // Knapsack capacity
             UserSimulator userSimulator = new UserSimulator(k);

             ProblemFormulation problem = new ProblemFormulation(values, weights, capacity);
            for (int i=0;i<k;i++) {
            	 System.out.println("Solution : "+(i+1));
             problem.solve();
         
		     userSimulator.getvalue(problem.getSelected(),values);

             }
             
            //userSimulator.getSortedSumValues();
		    //userSimulator.displaySortedEntries();
            
         }
         
         
         public void generateSolutions(UserSimulator userSimulator) {
             int[] values = {4, 2, 7, 1, 5}; // Values of the items
             int[] weights = {2, 1, 3, 2, 4}; // Weights of the items
             int capacity = 7; // Knapsack capacity

             ProblemFormulation problem = new ProblemFormulation(values, weights, capacity);
           
             
             for (int i=0;i<k;i++) {
            	 System.out.println("Solution : "+(i+1));
             problem.solve();
         
		     userSimulator.getvalue(problem.getSelected(),values);

             }
         }
}
