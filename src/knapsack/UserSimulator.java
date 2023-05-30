package knapsack;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.variables.BoolVar;

public class UserSimulator {
    private static int iterationCount = 0;
    Map<Integer, Integer> sumValues = new HashMap<>();
    List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>();
    int ksol;
    
    

    public UserSimulator(int ksol) {
    	this.ksol=ksol;
    }

	    
    public void getvalue(BoolVar[] selected, int[] values) {
        iterationCount++;

        int sum = 0;

        for (int i = 0; i < selected.length; i++) {
            if (selected[i].getValue() == 1) {
                sum += values[selected[i].getId() - 1];
                System.out.print("sum of selected item  : "+sum);

            }
            
        }
    	System.out.println();

        sumValues.put(iterationCount, sum);


        
    }

	    

	   

    public Map<Integer, Integer> getSumValuesMap() {
        return sumValues;
    }


	    
	    
	    
	  
    
    public void displaySortedEntries() {
        System.out.println("sumValues : " +sumValues);
    }
    
    
    public void displaysortedsolutions(){
        System.out.println("Solution ordeddddd" );

               List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(sumValues.entrySet());
               sortedEntries.sort(Map.Entry.comparingByValue());

               for (Map.Entry<Integer, Integer> entry : sortedEntries) {
                   System.out.println("solkey " + entry.getKey() + ": " + entry.getValue());
               }
           
       }
    
}


