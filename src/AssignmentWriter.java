import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/*this class uses an ArrayList of assignments,
 * and OccupationManager, and a fileName to
 * print out the jobs of each individual*/

public class AssignmentWriter {
	private BufferedWriter bw;
	private ArrayList<Assignment> assignments;
	OccupationManager om;
	public AssignmentWriter(ArrayList<Assignment> assignments, String fileName, OccupationManager om) throws IOException{
		FileWriter fw = new FileWriter(new File(fileName));
		bw = new BufferedWriter (fw);
		this.assignments=assignments;
		this.om=om;
	}
	public void writeAssignments() throws IOException{
		for (Assignment a: assignments){
			bw.write(a.getName()+" "+om.getTitle(a.getAssignment()));
			bw.newLine();
		}
		bw.close();
	}

}
