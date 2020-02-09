/**
  
 @author  
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team()
   {
      //this is the default constructor
   }
   
   private int find(TeamMember m)
   {
       for (int i = 0; i < team.length; i++) {
    	   
    	   if (team[i] == m) {
    		   return i;
    	   }
    	   
       }

	          
       return -1;
   }
   
   private void grow()
   {
       
   }
   
   public boolean isEmpty()
   {
       
   }
   
   public void add(TeamMember m)
   {     
            for(int i = team.length-1; i >= 0; i --) {
            	
            	if(team[i] != null) {
            		if (i == team.length-1) {
            			System.out.println("You have reached the maximum number of team members");
            			return;
            		}
            		team[i+1] = m;
            		return;
            	}
            	
            }
   }
   
   public boolean remove(TeamMember m)
   {
       
   } 
   
   public boolean contains(TeamMember m)
   {
      
   } 
   
   public void print()
   {
      //set up a for loop and call the toString() method
   } 
}
