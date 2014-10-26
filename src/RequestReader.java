import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
/*this class reads a file detailing each student's name
 * and the jobs he wants it then returns this information
 * as an ArrayList of requests*/

public class RequestReader {
	private ArrayList<Request> requests;
	public RequestReader(File filename) throws IOException{
			requests = new ArrayList<Request>();
			Scanner file = new Scanner (filename);
			while (file.hasNext()){
				StringTokenizer temp = new StringTokenizer(file.nextLine());
				String tempName = temp.nextToken();
				ArrayList<Integer> tempOccupations = new ArrayList<Integer>();
				while (temp.hasMoreTokens()){
					tempOccupations.add(Integer.valueOf(temp.nextToken()));
				}
				requests.add(new Request(tempName, tempOccupations));
			}
		}
	public ArrayList<Request> getRequests(){
		return requests;
		}
}
