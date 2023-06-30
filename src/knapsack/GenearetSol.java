package knapsack;

public class GenearetSol {
	int k;
         public GenearetSol(int k) {
           this.k=k;	
           }

         public void generateSolutions() {
             
           //  UserSimulator userSimulator = new UserSimulator(k);

            for (int i=0;i<k;i++) {
            	 System.out.println("Solution : "+(i+1));
             //problem.solve();
         
		    // userSimulator.getvalue(problem.getSelected(),values);

             }
             
            //userSimulator.getSortedSumValues();
		    //userSimulator.displaySortedEntries();
            
         }
         
         
             
           
             
             
         
		   //  userSimulator.getvalue(problem.getSelected(),values);

             
         
}
