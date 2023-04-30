import java.util.ArrayList;
import java.util.Scanner;

import drama.DramaSchedule;
import drama.HistoricalDramaSchedule;

public class DramaManager {
   ArrayList<DramaSchedule> dramaSchedules = new ArrayList<DramaSchedule>();
   Scanner input;
   DramaManager(Scanner input) {
      this.input = input;
   }
   
   public void addDramaSchedule() {
	   int kind=0;
	   DramaSchedule dramaSchedule;
	   while (kind !=1&kind!=2) {
		   System.out.print("1 for Romance Drama"); 
		   System.out.print("2 for Historical Drama");
		   System.out.print("Select num for drama kind between 1 and 2:"); 
		   kind = input.nextInt();
		   if (kind==1) {
			   dramaSchedule = new DramaSchedule();
			   dramaSchedule.getUserInput(input);
			   dramaSchedules.add(dramaSchedule);
			   break;
		   }
		   else if(kind ==2) {
			   dramaSchedule = new HistoricalDramaSchedule();
			   dramaSchedule.getUserInput(input);
			   dramaSchedules.add(dramaSchedule);
			   break;
		   }
		   else {
			   System.out.print("Select num for drama kind:"); 
		   }
	   }
   }

   public void deletDramaSchedule() {
      System.out.print("drama name:");
      String dramaname = input.next();
      int index = -1;
      for(int i=0; i<dramaSchedules.size();i++) {
    	  if(dramaSchedules.get(i).getDramaname().equals(dramaname)) {
    		  index = i;
    		  break;
    	  }
      }
      
      if(index>=0) {
    	  dramaSchedules.remove(index);
    	  System.out.println("the schedule " + dramaname + " is deleted.");   	  
      }
      
      else {
    	  System.out.println("the schedule has not been registered.");
          return;
      }
   }
   
   
   public void editDramaSchedule() {
      System.out.print("drama name:");
      String dramaname = input.next();
      for(int i=0; i<dramaSchedules.size();i++) {
    	  DramaSchedule dramaschedule = dramaSchedules.get(i);
    	  if(dramaschedule.getDramaname().equals(dramaname)) {
    		  int num = -1;

    		  while(num != 5) {
    			  System.out.println("** Drama Schedule Edit Menu **");
    			  System.out.println("1. Edit Dramaname");
    			  System.out.println("2. Edit Dramachannel");
    			  System.out.println("3. Edit runningtime");
    			  System.out.println("4. View episodes");
    			  System.out.println("5. Exit");
    			  System.out.println("Select one number betwen 1 - 5:");
    			  num = input.nextInt();

    			  if (num == 1) {
    				  System.out.print("dramaname: ");
    				  String dramaname1 = input.next();
    				  dramaschedule.setDramaname(dramaname1);
    			  }

    			  else if (num == 2) {
    				  System.out.print("dramachannel: ");
    				  String dramachannel = input.next();
    				  dramaschedule.setDramachannel(dramachannel);
    			  }

    			  else if (num == 3) {
    				  System.out.print("runningtime: ");
    				  int runningtime = input.nextInt();
    				  dramaschedule.setRunningtime(runningtime);
    			  }

    			  else if (num == 4) {
    				  System.out.print("episodes: ");
    				  int episodes = input.nextInt();
    				  dramaschedule.setEpisodes(episodes);
    			  }

    			  else {
    				  continue;
    			  }
    		  }
    		  break;
    	  }
      }
   }

    	  
   
   public void viewDramaSchedule() {
//      System.out.print("drama name:");
//	  String dramaname1 = input.next();
	  System.out.println("#of registered students: " + dramaSchedules.size());
	  for(int i=0; i<dramaSchedules.size();i++) {
		  dramaSchedules.get(i).printInfo();
	  }
   }
}

