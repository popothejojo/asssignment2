import java.io.*;
import java.util.*;

public class Assignment2 {

	public static void main(String[] args) throws FileNotFoundException {
		int row = 18, col = 5;
		String[] files = new String[2];
		files[0] = "week1txt.txt";
		files[1] = "week2txt.txt";

		String[][] array1 = populatearray(files[0]); // populates first array with first file
		printArray(array1, row, col, "File 1");

		String[][] array2 = populatearray(files[1]); // populates second array with second file
		printArray(array2, row, col, "File 2");

		System.out.println("------------------------------ Combined Songs Sorted Alpabetically ---------------------------");

		ArrayList<String> songNames = combineSongs(array1, array2, row, col);
		Collections.sort(songNames); // sorting combined files

		for (int i = 0; i < songNames.size(); i++) 			// printing combined files
			System.out.println(songNames.get(i));

		listenToSong(songNames);	//listening to songs through playlist

	}

	public static String[][] populatearray(String file) throws FileNotFoundException {
		int col = 5, row = 18;

		String[][] week = new String[row + 1][col + 1];
		Scanner in = new Scanner(new File(file));

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				week[i][j] = in.next();
			}
		}
		in.close();
		return week;
	}

	public static void printArray(String[][] week, int row, int col, String filename) {
		System.out.println(
				"------------------------" + filename + "---------------------------------------------------------");
		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int j = 0; j < col; j++) {
				System.out.print(week[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static ArrayList<String> combineSongs(String[][] array1, String[][] array2, int row, int col) {
		ArrayList<String> songNames = new ArrayList<>();

		for (int i = 0; i < row; i++) { // adds first file
			songNames.add(array1[i][1]);
		}
		for (int i = 0; i < row; i++) // adds second file
			songNames.add(array2[i][1]);

		Set<String> noDupes = new LinkedHashSet<String>(songNames); /// Removes Dupes from array list
		songNames.clear();
		songNames.addAll(noDupes);

		return songNames;

	}

	public static void listenToSong(ArrayList<String> songNames) {
		Scanner keyboard = new Scanner(System.in);
		int cont = 0;
		ArrayList<String> history = new ArrayList<>();
		
		for(int i = 0; i< songNames.size(); i++){
		System.out.println("Type N to listen to a new song, or H to view history.");
		String selection = keyboard.next();
		
		if(selection.equalsIgnoreCase("N")) {
			System.out.println("Now listening to " + songNames.get(cont) + "....");
			history.add(songNames.get(cont));
			cont++;
		
			
			if(selection.equalsIgnoreCase("H")){
			for(int j=0; j<history.size();j++)		
				System.out.println(history.get(i));
			}
		}
		else
			System.out.println("Wrong Command!!, Try again....");
	
	
		
	}

}
}
