import java.io.*;
import java.util.*;

class AppendableObjectOutputStream extends ObjectOutputStream {

    private boolean append;
    private boolean initialized;
    private DataOutputStream dout;

    protected AppendableObjectOutputStream(boolean append) throws IOException, SecurityException {
        super();
        this.append = append;
        this.initialized = true;
    }

    public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dout = new DataOutputStream(out);
        this.writeStreamHeader();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }

}

@SuppressWarnings("unchecked")
public class Job_Type {
    public static List<Job> jobs;
    private static final String FILENAME = "C://Users//anird//OneDrive//Desktop//Uni Books//Semester IV//CSE310//J_project//J_job_agency_helper//src//jobs.txt";
    
    public Job_Type() {
        jobs = new ArrayList<>();
        loadJobs();
    }
    
    public static void addJob(Job job) {
        //System.out.println(job.getName());
        jobs = new ArrayList<Job>();
        jobs.add(job);
        saveJobs();
    }
    
    public static void removeJob(Job job) {
        jobs.remove(job);
        saveJobs();
    }
    
    public static void displayJobs() {
        System.out.println("Jobs:");
        jobs = new ArrayList<Job>();
        for (Job job : jobs) {
            System.out.println(job.toString());
        }
    }
    
    private static void saveJobs() {
        try {
            File f1 = new File(FILENAME);
            if(f1.length() == 0){
                jobs = new ArrayList<Job>();
            }
            else{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
                try {
                    jobs.addAll((List<Job>)ois.readObject());
                } catch (ClassNotFoundException e) {
                    System.out.println("Object creation failed, please contact the developer for troubleshooting");
                    e.printStackTrace();
                }
                ois.close();
            }

            FileOutputStream fos = new FileOutputStream(new File(FILENAME));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jobs);
            oos.close();
        } catch (IOException e) {
            System.out.println("File not found or corrupted!");
            e.printStackTrace();
        }
    }
    
    public static List<Job> loadJobs() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
            jobs = new ArrayList<Job>();

            jobs = (List<Job>)ois.readObject();

            ois.close();
            //for(Job job : jobs){
            //    System.out.println(job.toString());
            //}
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found or corrupted!");
            e.printStackTrace();
        }
        return jobs;
    }

    public static void clrscr(){

        //Clears Screen in java
    
        try {
    
            if (System.getProperty("os.name").contains("Windows"))
    
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    
            else
    
                Runtime.getRuntime().exec("clear");
    
        } catch (IOException | InterruptedException ex) {
            System.out.println("Failed to clear screen, exiting...");
        }
    
    }

    public static void JobCreationInterface() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWelcome to job creation interface");
        System.out.println("To create a job, follow the instructions as they are given");
        System.out.println("Enter job name");
        String job_name = sc.nextLine();
        System.out.println("Enter primary skills required for the job");
        String job_prim = sc.nextLine();
        System.out.println("Enter secondary skills required for the job");
        String job_sec = sc.nextLine();
        System.out.println("Enter job description");
        String job_desc = sc.nextLine();
        Job job1 = new Job(job_name, job_prim, job_sec, job_desc);
        clrscr();
        addJob(job1);
        System.out.println("Job successfully created and saved...");
        //loadJobs();
        //displayJobs();
        //sc.nextLine();
        //sc.close();
    }
}

class Job implements Serializable {
    private String name;
    private String primary;
    private String secondary;
    private String description;
    
    public Job(String name,String prim, String sec, String description) {
        this.name = name;
        this.primary = prim;
        this.secondary = sec;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }

    public String getPrimary() {
        return this.primary;
    }

    public String getSecondary() {
        return this.secondary;
    }
    
    public String toString() {
        return "Name :" + name + "\nPrimary skills :" + primary + "\nSecondary Skills :" + secondary +  "\ndescription :" + description + "\n";
    }
}