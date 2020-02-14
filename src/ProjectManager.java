import java.util.Scanner;

/**
 * ProjectManager class scans the user's input and parses through it- reads command and validates date.
 * Additionally, it adds and removes a TeamMember from a team.


 @author Jay Mendapara & Raina Gupta
 */

public class ProjectManager
{

	Scanner stdin = new Scanner(System.in);
	Team cs213;

	private TeamMember currMem;
	//private Queue<String> tokens = new LinkedList<String>();

	public void run(){

		boolean done = false;
		
		cs213 = new Team();

		System.out.println("Welcome!");
		System.out.println("Your entry must be of the following format: Command (A, R, P, Q) Name Month/Day/Year.");


		while (!done)
		{

			String command = stdin.next();

			System.out.println("command is " + command);

			switch (command.charAt(0))  
			{   
			case 'A':

				String nameAdd = stdin.next();
				Date dateAdd = new Date(stdin.next());
				
				currMem = new TeamMember(nameAdd, dateAdd);
				
				add();
				
				/*if (instantiateTeamMember(command)) {
				
					add();
					System.out.println("Team Member added succesfully");
					print();
				}*/
				
				//break;

			case 'R':

				String nameRemove = stdin.next();
				Date dateRemove = new Date(stdin.next());
				
				currMem = new TeamMember(nameRemove, dateRemove);
				
				remove();
				break;

			case 'P':
				print();
				break;

			case 'Q':
				done = true;
				break;

			default: 
				System.out.println("Command '"+ command.charAt(0) +"' is not supported!");

				//deal with bad command here 
			}  
		}

		print();
		System.out.println("The team is ready to go!");

	} //run()

	/**
	 * 
	 * @param command
	 */
	private boolean instantiateTeamMember(String command) {

		String name;
		Date date;
		boolean valid;
		
		/*
		if(!stdin.hasNext()) {
			System.out.println("Your entry must be of the following format: Command Name Month/Day/Year.");
			return;
		}
		*/
		
		//reads in name token
		String token = stdin.next();
		System.out.println(token);
		name = token;
		
		//CASE: the user did not enter enough tokens
		boolean temp = stdin.hasNext("raina");
		System.out.println(temp);

	/*
		if(!stdin.hasNext()) {
			System.out.println("Your entry must be of the following format: Command (A, R, P, Q) Name Month/Day/Year.");
			return;
		}
	*/	
		
		//reads in date token
		token = stdin.next();
		System.out.println(token);
		

		//CASE: the user did not enter enough tokens

		/*
		if (token == null) {
			System.out.println("Your entry must be of the following format: Command Name Month/Day/Year.");
			return;
		}
		*/

		date = new Date(token);

		valid = date.isValid();
		
		if(valid) {	
			
			currMem = new TeamMember(name, date);

			System.out.println(currMem.toString());
			
			return true;
		}

		return false;

	}


	private void add()
	{
		
		//must check if the date is valid
		//must call the contains() method to check if a given 
		//team member is in the team already
		
		if(currMem.getStartDate().isValid()) {
			
			if(cs213.contains(currMem)) {
				System.out.println("Team member already exists!");
			}
			else{
				cs213.add(currMem);
			}
			
		}
		
		else {
			System.out.println("Date is invalid");
		}
		
		
	}

	private void remove()
	{
		//must check if the date is valid
		if(currMem.getStartDate().isValid()) {

			cs213.remove(currMem);
		
		}

		else {
			
			System.out.println("Date is invalid");
			
		}

	}

	private void print()
	{

		//must check if the team has 0 members. 
		if(cs213.isEmpty()) {
			System.out.println("We have 0 team members!");
		}

		else {
			cs213.print();
		}

	}   
} //ProjectManager