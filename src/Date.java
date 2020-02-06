/**
  
 @author  Jay Mendapara    poochie  yeld==e                      and RAINA
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
	   StringTokenizer a = new StringTokenizer();
      //use StringTokenizer to parse the String and create a Date object     
   }
   
   public Date(Date d)
   {
      //this is a constructor
   }      
   
   public boolean isValid()
   {
       
   }
   
   @Override
   public String toString()
   {
	   //use the format "month/day/year"
       return this.month + "/" + this.day + "/" + this.year;
   }
   
   @Override
   public boolean equals(Object obj)
   {
       
   }  
}


