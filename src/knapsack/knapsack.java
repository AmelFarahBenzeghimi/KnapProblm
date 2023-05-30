package knapsack;




public class knapsack {
	
	
    public static void main(String[] args) {
    	int k =6;
        int maxSol=18;
        int counter=0;
        GenearetSol generator = new GenearetSol(k);
        //generator.generateSolutions();
        UserSimulator userSimulator= new UserSimulator(k);

        // for the first k solutions 
        
        generator.generateSolutions(userSimulator);
        
        
        
        
	      userSimulator.displaySortedEntries();

       userSimulator.displaysortedsolutions();
       
       
       
       while(counter<=maxSol) {
    	   counter=counter+k;
    	   generator.generateSolutions(userSimulator);
           
           
           
           
 	   // userSimulator.displaySortedEntries();

        userSimulator.displaysortedsolutions();
        
        
    	   
    	   
    	   
       }
       
//	IterationHandler hd=new IterationHandler(maxSol);
	
	//    hd.handleIterations();
	
	
       
	
        
	

	
}
       
        
       // CustumVariableSelector variableSelector = new CustumVariableSelector(values, weights, preferences);
       // CustomValueSelector valueSelector = new CustomValueSelector();

        //IntStrategy    strategy = new IntStrategy(selected, variableSelector, valueSelector);
        
        
        
        
        
        
          
          

        
        
       
        
      
    }
    


