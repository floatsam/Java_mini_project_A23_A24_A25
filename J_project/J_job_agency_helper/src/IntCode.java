import java.io.*;
import java.util.*;
public class IntCode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = 4;
        do{
            x = 4;
            System.out.println("\n\nWelcome to Job Help Interface, here; \n1)you can add a job");
            System.out.println("2)you can add details of someone who wants a job");
            System.out.println("3)Match a job with preferred candidate");
            System.out.println("4)Exit out of Job Help Interface");
            System.out.println("Now, what will you choose:\n");
            //sc.next();
            //System.out.println("Press again to confirm");
            //if(sc.hasNextInt()){
                x = sc.nextInt();
            //    sc.nextLine();
            //}
            //else{
            //    sc.close();
            //    sc = new Scanner(System.in);
            //}
            //sc.nextLine();
            switch(x){
                case 1:{
                    try{
                        Job_Type.JobCreationInterface();
                        //sc.nextLine();
                    }
                    catch(IOException e){
                        System.out.println("File cannot be opened, erroneous execution of bytestream");
                    }
                    finally{
                        System.out.println("Concluding....");
                    }
                    break;
                }
                case 2:{
                    try{
                        JobSeeker.JobSeekerInterface();
                        //sc.nextLine();
                    }
                    catch(IOException e){
                        System.out.println("File cannot be opened, erroneous execution of bytestream");
                    }
                    finally{
                        System.out.println("Concluding....");
                    }
                    break;
                }
                case 3:{
                    try{
                        Job_Type.clrscr();
                        JobMatch.JobMatcher();
                    }
                    catch(IOException e){
                        System.out.println("Failed to open or create files on local storage!!");
                    }
                    finally{
                        System.out.println("Exiting...");
                    }
                    break;
                }
                case 4:{
                    Job_Type.clrscr();
                    System.out.println("Exiting and freeing resources...");
                    break;
                }
                default:{
                    System.out.println("\nWrong option selected, please try again !!");
                    break;
                }
            }
        }while(x != 4);
        sc.close();
    }
}
