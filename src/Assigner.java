import java.util.ArrayList;
import java.util.Collections;

/*
 * This class takes an ArrayList of requests and
 * and OccupationManager object to generate a list
 * of final assignments*/
public class Assigner {
	ArrayList<Request> requests;
	OccupationManager om;
	ArrayList<Assignment> assignments;
	
	public Assigner(ArrayList<Request> requests, OccupationManager om){
		this.requests=requests;
		this.om=om;
		assignments = new ArrayList<Assignment>();
		Collections.shuffle(requests);
		assignOccupations(requests);
	}
	
	private void assignOccupations(ArrayList<Request> requests){
		ArrayList<Request> pending = new ArrayList<Request>();
		for (Request r: requests)assignOccupation(r,pending);
	    randomlyAssign(pending);
		
		
		

		
	}
	private void randomlyAssign(ArrayList<Request> requests){
		for (Request r:requests){
			assignments.add(new Assignment(r.getName(),om.getAvailable()));
		}
	}
	
	private void assignOccupation(Request r, ArrayList<Request> pending){
		ArrayList<Integer> preferences = r.getPreferences();
		for (int i:preferences){
			if (om.makeRequest(i)){
				assignments.add(new Assignment(r.getName(),i));
				return;
			}
		}
		pending.add(r);
	}
	public ArrayList<Assignment> getAssignments(){return assignments;}


}
