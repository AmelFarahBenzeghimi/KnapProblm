package knapsack;

 public class    IterationHandler {
	 private int maxSol =18;
	    private int k = 6;
	    private int solCounter = 1;

	    private GenearetSol generator = new GenearetSol(k);
	    private UserSimulator userSimulator = new UserSimulator(k);
	    
	    public IterationHandler(int maxSol){
	    	
	    	
	    	this.maxSol=maxSol;
	    	
	    	
	    	
	    }
	    
	    
	    

	    public void handleIterations( ) {
	    	int iteCounter=0;
	        while (solCounter <= maxSol) {
	        	iteCounter++;
	            solCounter += k;

			       System.out.println("iteration iteration iteration  "+iteCounter);
	    	        System.out.println("calling display k iteartion"+solCounter);


	            generator.generateSolutions();

    	      //  userSimulator.getSortedSumValues();

			      //userSimulator.displaySortedEntries();
	            
	        }
	    }
 }
           

	    

 

	


	
	
	


