import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		// Build Plant Objects and store into ArrayList
		ArrayList<Plant> plantList = new ArrayList<Plant>();

		// Declare + initialize variables for file input
		Scanner fileScanner = null;
		FileInputStream fileStream = null;
		
		// Connect input stream to file
		try {
			fileStream = new FileInputStream("Forage.csv");
			fileScanner = new Scanner(fileStream);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not find file");
		}

		// loop to read through whole file
		while (fileScanner != null && fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Plant newPlant = new Plant(line);
			plantList.add(newPlant);
		}

		// Close the input stream
		if (fileScanner != null) {
			fileScanner.close();
		}

		// Print contents of ArrayList
		System.out.println("Plants!");
		System.out.println("=======");
		for (Plant p : plantList) {
			System.out.println(p);
			System.out.println();
		}
	}
}
