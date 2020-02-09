import java.util.StringTokenizer;

/**
  
 @author  Jay Mendapara & Raina Gupta
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
	   StringTokenizer tempDate = new StringTokenizer(d);
      //use StringTokenizer to parse the String and create a Date object    
	   
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


