import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
  
 @author  
 */
 
public class ProjectManager
{
	
   Scanner stdin = new Scanner(System.in);
   Team cs213;
   
   private TeamMember currMem;
   private Queue<String> tokens = new LinkedList<String>();
   
   public void run(){
	   
      boolean done = false;
      
      System.out.println("Welcome!");
      
      while (!done)
      {
    	  
         String command = stdin.next();
         
         switch (command.charAt(0))  
         {   
            case 'A':
            	
            	instantiateTeamMember(command);
            	
            	//add();
            	break;
            	
            case 'R':
            	
            	instantiateTeamMember(command);
            	
            	remove();
            	break;
            	
            case 'P':
            	print();
            	break;
            	
            case 'Q':
            	done = true;
            	break;
            	
            default: 
            	System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
            	
            	//deal with bad command here 
         }  
      }
      
      print();
      System.out.println("The team is ready to go!");
      
   } //run()
   
   /**
    * 
    * @param command
    */
   private void instantiateTeamMember(String command) {
	   
	   StringTokenizer st = new StringTokenizer(command);
	   String name;
	   Date date;
	   
	   //skips through first command token (A, R, P, Q)
	   if (st.hasMoreTokens()) {
      	 st.nextToken();
       }
       
       while (st.hasMoreTokens()) {
      	 tokens.add(st.nextToken());
       }
	   
       if (tokens.isEmpty()) {
    	   System.out.println("hey hey you you i dont like your girlfriend");
    	   return;
       }
       
       name = tokens.element();
       tokens.remove();
       
       date = new Date(tokens.element());
       tokens.remove();

       
       currMem = new TeamMember(name, date);
       
       System.out.println(currMem.toString());
	   
	   
   }
   
   
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
