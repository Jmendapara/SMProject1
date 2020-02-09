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
       return this.month + "/" + this.day + "/" + this.year;
   }
   
   @Override
   public boolean equals(Object obj)
   {
	   
   }  
}


