/**
  
 @author  
 */
 
public class ProjectManager
{
	
   Scanner stdin;
   Team cs213;
   
   public void run(){
	   
      boolean done = false;
      
      while (!done)
      {
         String command = stdin.next();
         switch (command.charAt(0))  
         {   
            case 'A': 
            	add();
            	break;
            	
            case 'R':
            	remove();
            	break;
            	
            case 'P':
            	print();
            	break;
            	
            case 'Q':
            	done = true;
            	break;
            	
            default: 
            	System.out.println("Command '"+ command.charAt(0) +"' is not supported!"); //deal with bad command here 
         }  
      }
      
      print();
      System.out.println("The team is ready to go!");
      
   } //run()
   
   private void add()
   {
      	//must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
   }
   
   private void remove()
   {
      //must check if the date is valid
	   
   }
   
   private void print()
   {
	   
	   //must check if the team has 0 members. 
	   if(cs213.isEmpty()) {
		   System.out.println("We have 0 team members!");
	   }
	   
	   else {
		   cs213.print();
	   }
	   
   }   
} //ProjectManager
