import java.util.StringTokenizer;

/**
 This class defines a Date.
 @author Jay Mendapara
 @author Raina Gupta
 */
public class Date {
	
	private int  day;
	private int  month;
	private int  year;

	private StringTokenizer st;
	
	/**
	 * Constructor for Date class.
	 * Uses StringTokenizer to parse the date and create a Date object.
	 * @param d  is a String that contains a date
	 */
	public Date(String d) {
		
		st = new StringTokenizer(d, "/");
		int counter = 0;
		
		while (st.hasMoreTokens()) {

			switch (counter) {

			case (0):
				this.month = Integer.parseInt(st.nextToken());
				counter ++;

			case (1):
				this.day = Integer.parseInt(st.nextToken());
				counter ++;

			case (2):
				this.year = Integer.parseInt(st.nextToken());
				break;
			}

		}

	}

	/**
	 * Constructor for Date class.
	 * @param d  Date object
	 */
	public Date(Date d) {
		
		this.day = d.day;
		this.month = d.month;
		this.year = d.year;
		
	}      

	/**
	 * Checks to see if the day, month, and year form a valid date.
	 * @return  true if the Date object is valid, false otherwise
	 */
	public boolean isValid() {
		
		if (st.hasMoreTokens()) {
			return false;
		}

		boolean leapYear = false;
		leapYear = isLeapYear();
		
		if (this.validateMonth()) {
			
			if (!this.validateDay(leapYear)) {
				return false;
			}

		}

		else {
			return false;
		}

		return true;
	}

	/**
	 * Checks if user entered a valid month.
	 * @return  true if month is valid, false otherwise
	 */
	private boolean validateMonth() {

		if (this.month >= 1 && this.month <= 12) {
			return true;
		}
		
		return false;
	}

	/**
	 * Checks if user entered a valid day depending on the leap year.
	 * @param leapYear  used to verify if the date is valid
	 * @return  true if day is valid, false otherwise
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
	 * Checks to see if the year entered by the user is a leap year or not
	 * @return  true if the year is a leap year, false otherwise
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

	/**
	 * Formats the Date information into a String. 
	 * @return  String format of the Date that includes month, day, and year
	 */
	@Override
	public String toString() {

		return (this.month + "/" + this.day + "/" + this.year);
	}

	/**
	 * Compares two Date objects to check if they have the same day, month, and year. 
	 * @param obj  Date object being compared
	 * @return  true if both Dates are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Date){	
			
			Date temp = (Date)obj;

			if ((this.month == temp.month) && (this.day == temp.day) && (this.year == temp.year)) {
				return true;
			}

		}
		
		//if obj is not of type Team Date or does not match the current month/date/year
		return false;
	}  
	
	/**
	 * Main method that includes various testing scenarios for the Date class.
	 * @param args  default main method argument
	 */
	public static void main(String [] args) {

		System.out.println("--------TESTING Date CLASS--------");

		Date test = new Date("12/13/2017");
		Date test2 = new Date(test);
		System.out.println(test2.toString());
		
		
		Date testDate1 = new Date("05/32/1999");
		Date testDate2 = new Date("05/09/1999");
		Date testDate3 = new Date("02/29/2012");
		Date testDate4 = new Date("02/29/2013");
		Date testDate5 = new Date("15/29/2013");

		testDate5.validateMonth(); //TEST - invalid month
		
		System.out.println(testDate3.isLeapYear()); //TEST - is leap year
		System.out.println(testDate4.isLeapYear()); //TEST - is not leap year
		
		boolean leapYr = testDate2.isLeapYear();
		System.out.println(testDate2.validateDay(leapYr)); //TEST - valid day
		
		leapYr = testDate1.isLeapYear();
		System.out.println(testDate1.validateDay(leapYr)); //TEST - invalid day

		System.out.println(testDate4.validateMonth()); //TEST - valid month
		System.out.println(testDate5.validateMonth()); //TEST - invalid month


		
		
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
		
		
	}
	
} //Date


