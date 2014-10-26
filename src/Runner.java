/*This class implements the other classes*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("use default files? (Y/N)");
		Scanner userInput = new Scanner(System.in);
		boolean useDefault=true;
		if (userInput.next()=="N")useDefault=false;
		File file;
		if (useDefault)  file = new File(args[0]);
		else  file = new File(userInput.next());
		RequestReader fileReader = new RequestReader(file);
		ArrayList<Request> requests = fileReader.getRequests();
		File file2 = new File(args[1]);
		OccupationManager om = new OccupationManager (file2);
		Assigner assigner = new Assigner(requests,om);
		ArrayList<Assignment>assignments = assigner.getAssignments();
		AssignmentWriter aw = new AssignmentWriter(assignments,args[2],om);
		aw.writeAssignments();
		System.out.println("done.");
	}

}
