/*Each instance of this class represents
 * a student and the integer corresponding to his job*/
public class Assignment {
	private String name;
	private int assignment;
	public Assignment (String name, int i){
		this.name = name;
		assignment=i;
	}
	public String getName(){return name;}
	public int getAssignment(){return assignment;}

}
