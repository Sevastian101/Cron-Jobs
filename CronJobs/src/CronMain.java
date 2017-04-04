import CronJobs.AddEmployee;
import CronJobs.CronJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by sodobescu on 4/4/2017.
 */
public class CronMain

{
	public static Trigger getATrigger(String mycron,String group) {
		return TriggerBuilder.newTrigger().withIdentity("cronTrigger", group).withSchedule(CronScheduleBuilder.cronSchedule(mycron)).build();
	}
	public static void main(String args[]) throws Exception {


		JobDetail job1 = JobBuilder.newJob(AddEmployee.class).withIdentity("job1", "group1").build();
		JobDetail job2 = JobBuilder.newJob(CronJob.class).withIdentity("job2", "group2").build();

		Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
		scheduler1.start();

		scheduler1.scheduleJob(job1, getATrigger("0/30 * * * * ?","group1"));
		scheduler1.scheduleJob(job2, getATrigger("0 * * * * ?","group2"));


		Thread.sleep(9999999);
		scheduler1.shutdown();
	}
}
