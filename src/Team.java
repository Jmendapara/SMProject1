
/**
  
 @author  
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   
   //this is Team class
   public Team()
   {
	  team = new TeamMember[GROW_SIZE];
	  numMembers = GROW_SIZE;
   }
   
   private int find(TeamMember m)
   {
       
	   for (int i = 0; i < team.length; i++) {
    	   
    	   if (team[i] == m) {
    		   return i;
    	   }
    	   
       }
	          
       return NOT_FOUND;
       
   }
   
   private void grow()
   {
	   int currentTeamSize = team.length;
	   
	   TeamMember [] newTeam =  new TeamMember[currentTeamSize + GROW_SIZE];
	   
	   for(int i = 0; i < team.length; i++) {
		   newTeam[i] = team[i];
	   }
	   
	   team = newTeam;
	   
   }
   
   public boolean isEmpty()
   {
       if(numMembers == 0) {
    	   return true;
       }
       
       return false;
       
   }
   
   public void add(TeamMember m)
   {     
	   for(int i = team.length-1; i >= 0; i --) {

		   if(team[i] != null) {

			   if (i == team.length-1) {
				   grow();
				   team[i+1] = m;
				   numMembers++;
				   return;
			   }
			  
			   team[i+1] = m;
			   numMembers++;
			   return;

		   }
		   
		   else if(i == 0) {
			   
			   team[i] = m;
			   numMembers++;
			   return;
			   
		   }

	   }
   }

   public boolean remove(TeamMember m)
   {
       if(contains(m) == true) {
    	   
    	   int index = find(m);
    	   
    	   if(index == team.length) {
        	   team[index] = null;
        	   numMembers--;
        	   return true;
    	   }
    	   
    	   else {
    		   
    		   for(int i = team.length-1; i >= index; i --) {
    			   
    			   if(team[i]!= null) {
    				   team[index] = team[i];
    				   team[i] = null;
    	        	   numMembers--;
    				   return true;
    			   }
    			   
    		   }
    		   
    		   numMembers--;
			   team[index] = null;
			   return true;
    		  
    	   }
    	   
    	   
       }
    	   
       else {
    	   System.out.println("USER NOT FOUND");
    	   return false;
       }
       
   } 
   
   public boolean contains(TeamMember m)
   {
	   for (int i = 0; i < team.length; i++) {
    	   
    	   if (team[i] == m) {
    		   
    		   return true;
    		   
    	   }
    	   
       }
	   
	   return false;
   } 
   
   public void print()
   {
 	  //set up a for loop and call the toString() method
      for(int i = 0; i < team.length; i ++) {
    	  
    	  System.out.println(team[i].toString());
    	  
      }
   }
   
}
