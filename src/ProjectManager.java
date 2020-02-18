import java.util.Scanner;

/**
 ProjectManager class scans the user's input and parses through it- reads command and validates date.
 Additionally, it adds and removes TeamMember objects from a team.
 @author Jay Mendapara
 @author Raina Gupta 
 */
public class ProjectManager {

	Scanner stdin = new Scanner(System.in);
	Team cs213;

	private TeamMember currMem;

	/**
	 * Starts the project manager.
	 * Scans user input for commands and key information about a team member.
	 */
	public void run() {

		boolean done = false;

		cs213 = new Team();
		
		System.out.println("Welcome!");
		System.out.println("Your entry must be of the following format: Command ('A', 'R', 'P', 'Q') Name Date (Month/Day/Year).");

		while (!done) {

			String command = stdin.next();

			switch (command.charAt(0)) {

			case 'A':

				readTeamMember();
				add();
				break;

			case 'R':

				readTeamMember();
				remove();
				break;

			case 'P':
				
				print();
				break;

			case 'Q':
				done = true;
				break;

			//deal with bad command here 
			default: 
				
				if(command.charAt(0) == 'q' || command.charAt(0) == 'p') {
					System.out.println("Command '" + command.charAt(0) + "' is not supported!");
				}

				else {
					stdin.next();
					stdin.next();
					System.out.println("Command '" + command.charAt(0) + "' is not supported!");
				}

			}  
		}

		print();
		System.out.println("The team is ready to go!");

	} //run()

	/**
	 * Captures the name and start date from what the user entered. 
	 * Uses the values entered by the user to create a TeamMember object.
	 */
	private void readTeamMember() {

		//reading in date and name
		String name = stdin.next();
		Date date = new Date(stdin.next());

		//creating new TeamMember object with console inputs
		currMem = new TeamMember(name, date);
	}

	/**
	 * Adds the TeamMember object to the team.
	 * Validates date of the TeamMember and verifies TeamMember is not in the team before adding.
	 */
	private void add() {

		if(currMem.getStartDate().isValid()) {

			if(cs213.contains(currMem)) {
				System.out.println("Team member already exists!");
			}
			else{
				cs213.add(currMem);
			}
		}

		else {
			System.out.println(currMem.getStartDate().toString() + " is not a valid date!");
		}
	}

	/**
	 * Removes the TeamMember object from the team.
	 * Validates date of the TeamMember before removing.
	 */
	private void remove() {

		if(currMem.getStartDate().isValid()) {
			cs213.remove(currMem);
		}

		else {
			System.out.println(currMem.getStartDate().toString() + " is not a valid date!");
		}
	}

	/**
	 * Prints the list of TeamMembers currently on the team.
	 */
	private void print() {

		if(cs213.isEmpty()) {
			System.out.println("We have 0 team members!");
		}

		else {
			cs213.print();
		}
	}
} //ProjectManager