import java.util.StringTokenizer;

/**

 @author  Jay Mendapara & Raina Gupta
 */
public class Date 
{
<<<<<<< HEAD
	private int  day;
	private int  month;
	private int  year;


	/**
	 * 
	 * @param d
	 */
	public Date(String d)
	{
		//use StringTokenizer to parse the String and create a Date object

		StringTokenizer st = new StringTokenizer(d, "/");

		int counter = 0;

		while (st.hasMoreTokens()) {

			switch (counter) {

			case (0):
				this.month = Integer.parseInt(st.nextToken("/"));

			case (1):
				this.day = Integer.parseInt(st.nextToken("/"));

			case (2):
				this.year = Integer.parseInt(st.nextToken("/"));

			case (3):
				//correct error statement? who knows
				System.out.println("Invalid date");

			}

		}
	}

	/**
	 * 
	 * @param d
	 */

	public Date(Date d)
	{
		//this is a constructor
		this.day = d.day;
		this.month = d.month;
		this.year = d.year;
	}      



	/**
	 * 
	 * @return
	 */
	public boolean isValid()
	{

		boolean leapYear = false;

		leapYear = isLeapYear();

		if (this.validateMonth()) {

			if (!this.validateDay(leapYear)) {
				System.out.println(this.day + "is not a valid day.");
				return false;
			}

		}

		else {
			System.out.println(this.month + "is not a valid month.");
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean validateMonth() {

		if (this.month >= 1 && this.month <= 12) {

			return true;

		}

		return false;

	}


	/**
	 * 
	 * @param leapYear
	 * @return
	 */
	private boolean validateDay(boolean leapYear) {

		if (this.month == Month.JAN || this.month == Month.MAR || this.month == Month.MAY 
				|| this.month == Month.JUL || this.month == Month.AUG || this.month == Month.OCT
				|| this.month == Month.DEC) {

			if (this.day >= 1 && this.day <= Month.DAYS_ODD)
				return true;

		}

		else if (this.month == Month.FEB) {

			if (leapYear) {

				if (this.day >= 1 && this.day <= Month.DAYS_FEB+1)
					return true;

			}
			else {

				if (this.day >= 1 && this.day <= Month.DAYS_FEB)
					return true;


			}

		}

		else {

			if (this.day >= 1 && this.day <= Month.DAYS_EVEN)
				return true;

		}


		return false;

	}

	/**
	 * 
	 * @return
	 */
	private boolean isLeapYear() {

		boolean leapYear = false;

		//checks if year is a leapYear, and sets flag leapYear accordingly

		if (this.year % Month.QUADRENNIAL == 0) {
			if (this.year % Month.CENTENNIAL == 0) {
				if (this.year % Month.QUATERCENTENNIAL == 0)
					leapYear = true;
				else
					leapYear = false;
			}
			else
				leapYear = true;
		}
		else
			leapYear = false;

		return leapYear;


	}

	@Override
	public String toString()
	{
		//use the format "month/day/year"

		return (this.month + "/" + this.day + "/" + this.year);
	}

	@Override
	public boolean equals(Object obj)
	{
=======
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
	   StringTokenizer tempDate = new StringTokenizer(d);
      //use StringTokenizer to parse the String and create a Date object    
	   
      //use StringTokenizer to parse the String and create a Date object
	   
	   StringTokenizer st = new StringTokenizer(d, "/");
	   
	   int counter = 0;
	   
	   while (st.hasMoreTokens()) {
		   
		   switch (counter) {
		   
		   case (0):
			   this.month = Integer.parseInt(st.nextToken("/"));
		   
		   case (1):
			   this.day = Integer.parseInt(st.nextToken("/"));
		  
		   case (2):
			   this.year = Integer.parseInt(st.nextToken("/"));
		   
		   case (3):
			   //correct error statement? who knows
			   System.out.println("Invalid date");
		   
		   }
		   
	   }
   }
   /**
    * 
    * @param d
    */
   
   public Date(Date d)
   {
      //this is a constructor
	   this.day = d.day;
	   this.month = d.month;
	   this.year = d.year;
   }      
   
   public boolean isValid()
   {
       
   }
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
	   
	   return (this.month + "/" + this.day + "/" + this.year);
   }
   
   @Override
   public boolean equals(Object obj)
   {
>>>>>>> branch 'master' of https://github.com/Jmendapara/SMProject1.git
		if(obj instanceof Date){	

			//obj.getClass() == (new TeamMember(name, startDate).getClass())
			//obj = TeamMember.class.cast(obj);

			Date temp = (Date)obj;

			if ((this.month == temp.month) && (this.day == temp.day) && (this.year == temp.year)) {

				return true;

			}

		}

		//if obj is not of type Team Date or does not match the current month/date/year
		return false;

	}  
}


