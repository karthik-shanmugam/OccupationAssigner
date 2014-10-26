import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/*This class reads the file detailing how many of each
 * occupation is available, and allows other classes
 * to request to occupy a specific occupation, 
 * or the simply request the first available occupation*/

public class OccupationManager {
	private int[] occupations;
	private ArrayList<String> occupationTitles;
	public OccupationManager(File filename) throws IOException{
		occupationTitles = new ArrayList<String>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Scanner file = new Scanner (filename);
			while (file.hasNext()){
				StringTokenizer st = new StringTokenizer (file.nextLine());
				st.nextToken();
				occupationTitles.add(st.nextToken());
				temp.add(Integer.valueOf(st.nextToken()));
			}
			occupations = new int[temp.size()];
			for (int i=0;i<temp.size();i++){
				occupations[i]=temp.get(i);
			}
		}
	public boolean makeRequest (int i){
		if (occupations[i]>0){
			occupations[i]--;
			return true;
		}
		return false;
	}
	public int getAvailable(){
		for (int i=0;i<occupations.length;i++){
			if (occupations[i]>0){
				occupations[i]--;
				return i;
			}
		}
		return -1;
	}
	public String getTitle(int i){
		if (i==-1)return "unemployed";
		return occupationTitles.get(i);
	}
}

