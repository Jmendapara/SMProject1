/**
 * This class creates a TeamMember object and compares TeamMember objects with each other. 
 @author  Raina Gupta & Jay Mendapara
 */
public class TeamMember 
{
	private String name;
	private Date   startDate;

	public TeamMember(String nm, Date date)
	{
		this.name = nm;
		this.startDate = date;

	}

	public Date getStartDate()
	{
		return this.startDate;
	}

	public boolean equals(Object obj)
	{
		//name and startDate must be the same

		if(obj instanceof TeamMember){	

			//obj.getClass() == (new TeamMember(name, startDate).getClass())
			//obj = TeamMember.class.cast(obj);

			TeamMember temp = (TeamMember)obj;

			if (this.name.equals(temp.name) && (this.startDate == temp.startDate)) {

				return true;

			}

		}
		
		//if obj is not of type Team Member or does not match the current name/startDate
		return false;


	}  

	public String toString()
	{
		return this.name + " " + this.startDate.toString();
		//name + " " + startDate;
	}

	public static void main(String [] args)
	{
		//testbed main; you must include test cases that exercise 
		//the constructor and all methods in this class.
		
		
	}

}