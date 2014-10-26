import java.util.ArrayList;
/*Each instance of this object contains a student's names and 
 * an ArrayList of integers corresponding with his 
 * preferred jobs in order
 * */

public class Request {
	private String name;
	private ArrayList<Integer> preferences;
	public Request(String s, ArrayList<Integer> preferences){
		name=s;
		this.preferences=preferences;
	}
	public String getName(){return name;}
	public ArrayList<Integer> getPreferences(){return preferences;}

}
