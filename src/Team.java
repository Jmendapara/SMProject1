/**
 Represents a list of TeamMembers.
 The list automatically grows if it is full and another TeamMember is added. 
 @author Jay Mendapara
 @author Raina Gupta
 */
public class Team {
	
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; //initial and grow size
	private TeamMember [] team;
	private int numMembers;

	/**
	 * Creates a new Team of size GROW_SIZE.
	 * Sets the numMembers to 0.
	 */
	public Team() {
		team = new TeamMember[GROW_SIZE];
		numMembers = 0;
	}

	/**
	 * Checks to see the position of a team member in the team.
	 * If the team member is not in the team, then a -1 will be returned. 
	 * @param m  a team member that will be searched for
	 * @return  the index at which the TeamMember is or -1 if team member is not found
	 */
	private int find(TeamMember m) {

		for (int i = 0; i < numMembers; i ++) {

			if (team[i].equals(m)) {
				return i;
			}

		}

		return NOT_FOUND;
	}

	/**
	 * Grows the size of the team to fit more TeamMember objects.
	 * Method automatically called when the team is full and another TeamMember needs to be added.
	 */
	private void grow() {
		
		int currentTeamSize = team.length;
		TeamMember [] newTeam =  new TeamMember[currentTeamSize + GROW_SIZE];

		for(int i = 0; i < team.length; i ++) {
			newTeam[i] = team[i];
		}

		team = newTeam;
	}

	/**
	 * Checks to see if the team has any members.
	 * @return  true if there are no TeamMember objects in the team, false otherwise
	 */
	public boolean isEmpty() {
		
		if(numMembers == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Adds a TeamMember object to the end of the team array.
	 * If the array is full, then the grow() method will be called before adding. 
	 * @param m  TeamMember object being added to the team
	 */
	public void add(TeamMember m) {

		if(contains(m)) {
			System.out.println("This member already exists!");
			return;
		}

		for(int i = team.length-1; i >= 0; i --) {

			if(team[i] != null) {

				if (i == team.length-1) {
					grow();
					team[i+1] = m;
					System.out.println(m.toString() + " has joined the team!");
					numMembers ++;
					return;
				}

				team[i+1] = m;
				System.out.println(m.toString() + " has joined the team!");
				numMembers ++;
				return;

			}

			else if(i == 0) {

				team[i] = m;
				numMembers ++;
				System.out.println(m.toString() + " has joined the team!");
				return;

			}

		}
	}

	/**
	 * Removes a Team Member object from the team array.
	 * The last TeamMember in the array replaces the removed TeamMember. 
	 * @param m  TeamMember object being removed from the team array
	 * @return  true if TeamMember was successfully removed, false otherwise 
	 */
	public boolean remove(TeamMember m){
		
		if(contains(m) == true) {

			int index = find(m);

			// case - team member to be removed is the last element in the array
			if(index == team.length-1) {
				team[index] = null;
				System.out.println(m.toString() + " has left the team!");
				numMembers --;
				return true;
			}

			else {
				
				// check for the last open index starting from the end of array
				for(int i = team.length-1; i > index; i --) {

					if(team[i]!= null) {
						team[index] = team[i];
						team[i] = null;
						System.out.println(m.toString() + " has left the team!");
						numMembers --;
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
			System.out.println(m.toString() + " is not a team member.");
			return false;
		}
	} 

	/**
	 * Checks to see if the team array contains a TeamMember object.
	 * @param m  TeamMember object being searched for
	 * @return  true if the team contains the TeamMember, false otherwise
	 */
	public boolean contains(TeamMember m) {
		
		for (int i = 0; i < numMembers; i ++) {

			if (team[i].equals(m)) {
				return true;
			}
		}
		
		return false;
	} 

	/**
	 * Prints the list of TeamMembers currently on the team.
	 */
	public void print() {
		
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
	
} //Team