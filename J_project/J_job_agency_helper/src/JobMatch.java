import java.util.*;
import java.io.*;
public class JobMatch {
    public static void JobMatcher() throws IOException{
        List<Job> jobs = Job_Type.loadJobs();
        List<JobDetails> jobseeker = JobSeeker.loadSeekers();
        for(Job j: jobs){
            for(JobDetails js: jobseeker){
                if(js.getSkill().equalsIgnoreCase(j.getPrimary()) || js.getSkill().equalsIgnoreCase(j.getSecondary())){
                    System.out.println("Match Found!...details given below");
                    System.out.println(js.toString());
                    System.out.println("Above candidate is suitable for:\n");
                    System.out.println(j.toString());
                }
            }
        }
    }
}
