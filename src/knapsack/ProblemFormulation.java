package knapsack;

import java.util.List;
import java.util.ArrayList;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.nary.cnf.LogOp;
import org.chocosolver.solver.variables.BoolVar;

public class ProblemFormulation {
	int[] values = {4, 2, 7, 1, 5}; // Values of the items
    int[] weights = {2, 1, 3, 2, 4}; // Weights of the items
    int capacity = 7; // Knapsack capacity

    private int numItems;
    private Model model;
    private BoolVar[] selected;

    private List<BoolVar[]> previousSolutions=new ArrayList<>();



	public  ProblemFormulation(int[] values, int[] weights, int capacity) {
        this.values = values;
        this.weights = weights;
        this.capacity = capacity;
        this.numItems = values.length;
        
        this.previousSolutions = new ArrayList<>(); // Initialize the list
        // Create a model
        this.model = new Model("Knapsack Problem");

        // Create decision variables: 0/1 variables indicating whether an item is selected or not
        this.selected = model.boolVarArray(numItems);

        // Constraint: total weight should be less than or equal to the capacity
        model.scalar(selected, weights, "<=", capacity).post();
        
    }

    

    public BoolVar[] getSelected() {
        return selected;
    }
    public void solve() {
    	BoolVar[] solution = selected.clone();

        forbiddenSolutions(solution);
    	// Create a solver
        Solver solver = model.getSolver();
      //  forbiddenSolutions();

        // Solve the model
        solver.solve();

        // Store the current solution
       
        // Call the method displaySol
       displaySol(solver);
    	
    }
    
    private void forbiddenSolutions(BoolVar[] solution) {
        for (BoolVar[] prevSolution : previousSolutions) {
            BoolVar[] negatedSolution = new BoolVar[prevSolution.length];
            for (int i = 0; i < prevSolution.length; i++) {
                negatedSolution[i] = prevSolution[i].not();
            }
            model.addClauses(LogOp.or(negatedSolution));
        }
    }

    


	//dispaly one solution found
    public void displaySol(Solver solver) {
    	if(solver.solve()) {
    	for( int i=0;i<selected.length;i++) {
    	
    	
            System.out.println("item "+(i+1)+"  is " +selected[i].getValue());

    	}
    }
}
    
    public void custumzedstrategy() {
    	
    	
    	
    	
    }
    
}
