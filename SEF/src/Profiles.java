import java.util.Scanner;

public class Profiles extends Users {
	public void searchProfiles() {
		//method to search profile on program
		Scanner object = new Scanner(System.in);
		int profileIndex;
		
		System.out.println("Please enter profile index");
		profileIndex = object.nextInt();
		System.out.println(profiles.get(profileIndex));
		
	}
	
	public void viewProfiles() {

	}
}
