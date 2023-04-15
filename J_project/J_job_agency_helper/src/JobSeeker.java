import java.io.*;
import java.util.*;

@SuppressWarnings("closed")
class JobDetails implements Serializable{
    
    // Fields
    private String name;
    private String email;
    private String phno;
    private String skill;
    
    // Constructor
    public JobDetails(String name, String email, String phone, String skills) {
        this.name = name;
        this.email = email;
        this.phno = phone;
        this.skill = skills;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    
    public String getSkill() {
        return skill;
    }

    public String getphno() {
        return phno;
    }

    public String toString() {
        return "Name :" + name + "\nE-mail :" + email + "\nSkill :" + skill +  "\nPhone Number :" + phno + "\n";
    }
}
@SuppressWarnings("unchecked")
public class JobSeeker{

    public static List<JobDetails> seekers;
    private static final String FILEN = "C://Users//anird//OneDrive//Desktop//Uni Books//Semester IV//CSE310//J_project//J_job_agency_helper//src//seeker.txt";

    public static void addSeekers(JobDetails job) {
        //System.out.println(job.getName());
        seekers = new ArrayList<JobDetails>();
        seekers.add(job);
        saveSeekers();
    }
    
    public static void removeSeekers(JobDetails sek) {
        seekers.remove(sek);
        saveSeekers();
    }
    
    public static void displaySeekers() {
        System.out.println("Jobs:");
        seekers = new ArrayList<JobDetails>();
        for (JobDetails sek : seekers) {
            System.out.println(sek.toString());
        }
    }
    
    private static void saveSeekers() {
        try {
            File f1 = new File(FILEN);
            if(f1.length() == 0){
                seekers = new ArrayList<JobDetails>();
            }
            else{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
                try {
                    seekers.addAll((List<JobDetails>)ois.readObject());
                } catch (ClassNotFoundException e) {
                    System.out.println("Object creation failed, please contact the developer for troubleshooting");
                    e.printStackTrace();
                }
                ois.close();
            }

            FileOutputStream fos = new FileOutputStream(new File(FILEN));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(seekers);
            oos.close();
        } catch (IOException e) {
            System.out.println("File not found or corrupted!");
            e.printStackTrace();
        }
    }
    
    public static List<JobDetails> loadSeekers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FILEN)));
            seekers = new ArrayList<JobDetails>();

            seekers = (List<JobDetails>)ois.readObject();

            ois.close();

            //for(JobDetails job : seekers){
            //    System.out.println(job.toString());
            //}
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found or corrupted!");
            e.printStackTrace();
        }
        return seekers;
    }

    public static void JobSeekerInterface() throws IOException, FileNotFoundException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("\n\nLooking for jobs, this interface is for you!");
        System.out.println("Enter your name");
        String nm = sc1.nextLine();
        System.out.println("Enter your email");
        String gt = sc1.nextLine();
        System.out.println("Enter phone no.:");
        String phno = sc1.nextLine();
        System.out.println("Enter job specific skill, for better visibility of skills and talent");
        String skill = sc1.nextLine();
        JobDetails j1 = new JobDetails(nm, gt, phno, skill);
        addSeekers(j1);
        //loadSeekers();
        Job_Type.clrscr();
        System.out.println("Job Seeker details have been entered into the database successfully!");
        //sc1.close();
    }
}