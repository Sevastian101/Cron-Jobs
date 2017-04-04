package CronJobs;
import Entity.Employees;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.time.LocalDateTime;

public class CronJob implements Job
{
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("Cron job prints employees: " + LocalDateTime.now());
		for (Employees item : Employees.Employees) {
			System.out.println(item);
		}
	}
}