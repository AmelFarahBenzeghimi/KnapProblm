package knapsack;

import java.util.List;
import java.util.ArrayList;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.extension.Tuples;
import org.chocosolver.solver.variables.IntVar;

 
public class ProblemFormulation {
	

    private int numItems;
    private Model model;
    private IntVar[] selected;
    private int []values;
    private static List<List<Integer>> previousSolutions = new ArrayList<>();	
	
    UserSimulator userSimulator= new UserSimulator();
    
    static {
        previousSolutions.clear(); 
    }

	public  ProblemFormulation(int[] values, int[] weights, int capacity) {
     
        this.numItems = values.length;
        this.values=values;
        
      // this.previousSolutions = new ArrayList<>(); // Initialize the list
        // Create a model
        this.model = new Model("Knapsack Problem");

        this.selected = new IntVar[numItems];
        for (int i = 0; i < numItems; i++) {
            selected[i] = model.intVar("item_" + (i+1), 0, 1); 
            
        }


        // Constraint: total weight should be less than or equal to the capacity
        model.scalar(selected, weights, "<=", capacity).post();
       
        
    }

    

    public IntVar[] getSelected() {
        return selected;
    }
    
    public void solve() {
    	Model upModel =updateModel(model,getSelected(),previousSolutions);
    	

    	CustumStrategy strat=new CustumStrategy();
    	
    	
     // Solve the model
      Solver solver=upModel.getSolver();
      
       solver.setSearch(strat.CustumStrategy(selected));

        
		solver.limitSolution(5);

		

   	while(solver.solve()) {
   		recordSol(solver,selected);
   		System.out.println("Solution found solvermethod");
   		for(int i=0;i<selected.length;i++) {

   		System.out.print(" "+selected[i].getValue());

   	}
   	}
        
       



     
    }
    
    
    
    private static Tuples forbiddenSolutions(List<List<Integer>> selected2) {
    	Tuples tuple=new Tuples(false);

        System.out.print("selected2 "+selected2);
    	int i=0;
        for (List<Integer> currentSolution2 : selected2) {
            int []t1=new int[currentSolution2.size()] ;

            for (int  value : currentSolution2) {
            	if(i<currentSolution2.size()) {
                System.out.print("i "+i);

        	 t1[i]=value;
        	i=i+1;
            	}
                
                
                
                
            }
        tuple.add(t1);
        
        }
    		
	        

    		
	    	
    	
    	
    	
    	        return tuple;
    }

    
    
    public Model updateModel(Model model, IntVar [] selected, List<List<Integer>> previousSolutions)
    {
    	if(previousSolutions.size()!=0) {
	        System.out.println("updatemodel");

    	Constraint tableConstraint = model.table(selected, forbiddenSolutions(previousSolutions));
    	model.post(tableConstraint);
    	
    	}
    	
    	return model;
    	
    	
    }
    
    
    public void solvermethod(Model model) {
		System.out.println("inside solvermethod");


    	Solver solve=model.getSolver();
 		solve.limitSolution(5);

		

    	while(solve.solve()) {
    		System.out.println("Solution found solvermethod");
    		for(int i=0;i<selected.length;i++) {

    		System.out.print(" "+selected[i].getValue());

    	}
    	}
    }
    
    
    
    
    


    public void displaySol(Solver solver, IntVar []selected) {
		System.out.println(" :");
    	
    	

    	for( int i=0;i<selected.length;i++) {

    	
    		System.out.printf(" "+selected[i].getValue()," ");
    		
    	}
    	System.out.println();
    
}
    public void recordSol(Solver solver, IntVar[] solution) {
    	

			userSimulator.getvalue(getSelected(), values);


    		List<Integer> currentSolution = new ArrayList<>();
    		currentSolution.clear();
        	for( int i=0;i<solution.length;i++) {
        		currentSolution.add(solution[i].getValue());
        		

        	}
        	previousSolutions.add(currentSolution);

             System.out.println("previousSolutions "+previousSolutions);

             System.out.println("previousSolutions "+previousSolutions.size());

    	
    	
    	
        }
    
    
    public void displayoredreuser() {
    	
    	userSimulator.displaysortedsolutions();
    	
    	
    }
    	
    	
    
    
}
