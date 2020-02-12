import java.util.Scanner;

/**

 @author  Jay Mendapara and Raina Gupta  
 */

public class ProjectManager
{

	Scanner stdin = new Scanner(System.in);
	Team cs213;

	private TeamMember currMem;
	//private Queue<String> tokens = new LinkedList<String>();

	public void run(){

		boolean done = false;

		System.out.println("Welcome!");
		System.out.println("Your entry must be of the following format: Command (A, R, P, Q) Name Month/Day/Year.");


		while (!done)
		{

			String command = stdin.next();

			System.out.println("command is " + command);

			switch (command.charAt(0))  
			{   
			case 'A':

				instantiateTeamMember(command);

				//add();
				break;

			case 'R':

				instantiateTeamMember(command);

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
	private void instantiateTeamMember(String command) {

		String name;
		Date date;

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


		currMem = new TeamMember(name, date);

		System.out.println(currMem.toString());


	}


	private void add()
	{
		//must check if the date is valid
		//must call the contains() method to check if a given 
		//team member is in the team already
	}

	private void remove()
	{
		//must check if the date is valid

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