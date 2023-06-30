package knapsack;
<<<<<<< HEAD
import java.util.Scanner;


public class UserSimulator {

	    private int[] preferences;

	    public UserSimulator(int numItems) {
	        this.preferences = new int[numItems];
	    }

	    public void setPreferences() {
	        Scanner scanner = new Scanner(System.in);

	        for (int i = 0; i < preferences.length; i++) {
	            System.out.print("Enter preference for item " + i + ": ");
	            preferences[i] = scanner.nextInt();
	        }
	    }

	    public int[] getPreferences() {
	        return preferences;
	    }
	}
=======
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.variables.IntVar;

public class UserSimulator {
    private static int iterationCount = 0;
    Map<Integer, Integer> sumValues = new HashMap<>();
    List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>();
    int ksol;
    
    

    public UserSimulator() {
    }

	    
    public void getvalue(IntVar[] selected, int[] values) {
        iterationCount++;

        int sum = 0;

        for (int i = 0; i < selected.length; i++) {
            if (selected[i].getValue() == 1) {
                sum += values[selected[i].getId() - 1];

            }
            sumValues.put(iterationCount, sum);

            
        }
    	System.out.println();


    	//System.out.println("sumvalue"+sumValues);

        
    }

	    

	   

    public Map<Integer, Integer> getSumValuesMap() {
        return sumValues;
    }


	    
	    
	    
	  
    
    public void displaySortedEntries() {
        //System.out.println("sumValues : " +sumValues);
    }
    
    
    public void displaysortedsolutions( ){
        System.out.println("Solution orded" );
               List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(sumValues.entrySet());
               sortedEntries.sort(Map.Entry.comparingByValue());

               for (Map.Entry<Integer, Integer> entry : sortedEntries) {
                   System.out.println("solkey " + entry.getKey() + ": " + entry.getValue());
               }
           
       }
    
}

>>>>>>> origin/master

