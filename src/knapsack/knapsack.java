package knapsack;




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
        
        
        
        
        
        
          
          

        
        
       
        
      
    
    


