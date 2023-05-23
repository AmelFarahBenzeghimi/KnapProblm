package knapsack;
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

