/**
 
 @author  
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
   }  
   
   public String toString()
   {
       //name + " " + startDate;
	   return this.name + " " + this.startDate;
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
   }
}