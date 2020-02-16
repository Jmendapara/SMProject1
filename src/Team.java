/**
 * Represents a list of TeamMembers
 * Can be of any size
 * 
 @author  Jay Mendapara and Raina Gupta
 */
public class Team 
{
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; //initial and grow size
	private TeamMember [] team;
	private int numMembers;

	/**
	 * Creates a new Team of size GROW_SIZE
	 */
	//this is Team class
	public Team()
	{
		team = new TeamMember[GROW_SIZE];
		numMembers = 0;
	}

	private int find(TeamMember m)
	{

		for (int i = 0; i < numMembers; i++) {

			if (team[i].equals(m)) {
				return i;
			}

		}

		return NOT_FOUND;

	}

	private void grow()
	{
		int currentTeamSize = team.length;

		TeamMember [] newTeam =  new TeamMember[currentTeamSize + GROW_SIZE];

		for(int i = 0; i < team.length; i++) {
			newTeam[i] = team[i];
		}

		team = newTeam;

	}

	public boolean isEmpty()
	{
		if(numMembers == 0) {
			return true;
		}

		return false;

	}

	public void add(TeamMember m)
	{     

		if(contains(m)) {
			System.out.println("This member already exists!");
			return;
		}

		for(int i = team.length-1; i >= 0; i --) {

			if(team[i] != null) {

				if (i == team.length-1) {
					grow();
					team[i+1] = m;
					System.out.println(m.toString()+ " has joined the team!");
					numMembers++;
					return;
				}

				team[i+1] = m;
				System.out.println(m.toString()+ " has joined the team!");
				numMembers++;
				return;

			}

			else if(i == 0) {

				team[i] = m;
				numMembers++;
				System.out.println(m.toString()+ " has joined the team!");
				return;

			}

		}
	}

	public boolean remove(TeamMember m)
	{
		if(contains(m) == true) {

			int index = find(m);

			// case - team member to be removed is the last element in the array
			if(index == team.length-1) {
				team[index] = null;
				System.out.println(m.toString()+ " has left the team!");
				numMembers--;
				return true;
			}

			else {
				/*
    		   case - team member to be removed is in the middle of the array
    		   and needs to be swapped with the last team member in the list
				 * 
				 */
				for(int i = team.length-1; i > index; i --) {

					if(team[i]!= null) {
						team[index] = team[i];
						team[i] = null;
						System.out.println(m.toString()+ " has left the team!");
						numMembers--;
						return true;
					}

				}

				// case - team member to be removed is the last member of the list, but list is not full
				numMembers--;
				team[index] = null;
				System.out.println(m.toString() + " has left the team!");
				return true;

			}


		}

		else {
			System.out.println(m.toString()+" is not a team member.");
			return false;
		}

	} 

	public boolean contains(TeamMember m)
	{
		for (int i = 0; i < numMembers; i++) {

			if (team[i].equals(m)) {

				return true;

			}

		}

		return false;
	} 

	public void print()
	{
		//set up a for loop and call the toString() method

		if(isEmpty()) {
			System.out.println("We have 0 team members!");
			return;
		}

		System.out.println("We have the following team members: ");
		for(int i = 0; i < team.length && team[i] != null ; i ++) {

			System.out.println(team[i].toString());

		}

		System.out.println("-- end of the list --");
	}

}