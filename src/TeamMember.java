/**
 This class is a template for a TeamMember object.
 Has the ability to compares TeamMember objects with each other. 
 @author Jay Mendapara
 @author Raina Gupta
 */
public class TeamMember 
{
	private String name;
	private Date   startDate;

	
	/**
	 * Constructor for TeamMember class.
	 * @param nm  name of the team member
	 * @param date  start date of the team member
	 */
	public TeamMember(String nm, Date date)
	{
		this.name = nm;
		this.startDate = date;

	}

	/**
	 * Obtains the date that the team member started working.
	 * @return  a Date object containing the start date of the team member
	 */
	public Date getStartDate()
	{
		return this.startDate;
	}

	/**
	 * Compares two TeamMember objects to check if they have the same name and start date. 
	 * @param obj  TeamMember object being compared
	 * @return  true if both TeamMembers are equal, false otherwise
	 */
	public boolean equals(Object obj)
	{
		if(obj instanceof TeamMember){	

			TeamMember temp = (TeamMember)obj;
			
			if (this.name.equals(temp.name) && (this.startDate.equals(temp.startDate))) {
				return true;
			}
		}

		//if obj is not of type Team Member or does not match the current name/startDate
		return false;
	}  

	/**
	 * Formats the TeamMember information into a String. 
	 * @return  String format of the TeamMember that includes name and start date
	 */
	public String toString()
	{
		return this.name + " " + this.startDate.toString();
	}

	/**
	 * Main method that includes various testing scenarios for the TeamMember class.
	 * @param args  default main method argument
	 */
	public static void main(String [] args)
	{
		
		System.out.println("--------TESTING Date CLASS--------");

		Date testDate1 = new Date("05/32/1999");
		Date testDate2 = new Date("05/09/1999");
		Date testDate3 = new Date("02/29/2012");
		Date testDate4 = new Date("02/29/2013");


		boolean valid;

		// TEST - false case for Date isValid()
		valid = testDate1.isValid();
		System.out.println("Date : " + testDate1.toString() + " isValid() = " + valid);

		// TEST - true case for Date isValid()
		valid = testDate2.isValid();
		System.out.println("Date : " + testDate2.toString() + " isValid() = " + valid);

		// TEST - true case for Date isValid() on a leap year
		valid = testDate3.isValid();
		System.out.println("Date : " + testDate3.toString() + " isValid() = " + valid);
		
		// TEST - false case for Date isValid() on a not leap year
		valid = testDate4.isValid();
		System.out.println("Date : " + testDate4.toString() + " isValid() = " + valid);


		System.out.println("Date toString : " + testDate2.toString()); //TEST - Date toString

		
		System.out.println("--------END TESTING Date CLASS--------\n");
		System.out.println("--------TESTING TeamMember CLASS--------");

		TeamMember test = new TeamMember("Raina", testDate2); //TEST - TeamMember constructor

		Date compareDate1 = new Date("08/13/13");
		Date compareDate2 = new Date("05/09/1999");
		boolean result;

		// TEST - equals 
		TeamMember compare1 = new TeamMember("Raina", compareDate1);
		result = test.equals(compare1);
		System.out.println("TEST - this.equals(Object obj) where this = " + test.toString() + " and obj = " + compare1.toString());
		System.out.println("Result = " + result + "\n");

		TeamMember compare2 = new TeamMember("Raina", compareDate2);
		result = test.equals(compare2);
		System.out.println("TEST - this.equals(Object obj) where this = " + test.toString() + " and obj = " + compare2.toString());
		System.out.println("Result = " + result);
		
		
		TeamMember jay = new TeamMember("Jay", new Date("12/1/2014"));
		System.out.println(jay.getStartDate().toString()); //TEST - getStartDate();

		System.out.println("--------END TESTING TeamMember CLASS--------\n");
		System.out.println("--------TESTING Team CLASS--------");

		// creating instances of TeamMember
		TeamMember bob = new TeamMember("Bob", new Date("9/31/2016")); // Last date (31th) of odd month
		TeamMember al = new TeamMember("Al", new Date("2/29/2012")); // Leap year date
		TeamMember jenny = new TeamMember("Jenny", new Date("6/30/2005")); // Last date (30th) of even month

		Team testTeam = new Team();


		testTeam.add(jay);
		

		System.out.println("Adding a team member that already exists:");
		testTeam.add(bob);
		testTeam.add(bob); // case - adding a TeamMember twice

		System.out.println("Removing a TeamMember that does not exist:");
		testTeam.remove(al); // case - removing a TeamMember that is not in Team
		testTeam.add(al);
		System.out.println("Removing a TeamMember that does exist:");
		testTeam.remove(al); // case - removing a TeamMember successfully

		testTeam.contains(al); // case - does not exist

		System.out.println("Checking if team member 'jay' is contained: ");

		System.out.println(testTeam.contains(jay)); // case - returns true;

		testTeam.add(jenny);
		testTeam.add(test);

		testTeam.add(compare1); // case - have to call grow() on array
		testTeam.add(compare2); // case - adding with the same name, different date
		
		System.out.println("-------- END TESTING Team CLASS--------\n");
	}

}