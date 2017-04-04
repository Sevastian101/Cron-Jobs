package CronJobs;

import Entity.Employees;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sodobescu on 4/4/2017.
 */
public class AddEmployee implements Job
{
	static int id = 0;

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println("An entity of employee has been added: " + LocalDateTime.now());

		int randomNum = ThreadLocalRandom.current().nextInt(18, 51);
		Employees.Employees.add(new Employees(id, getRandomName(), randomNum));
		id++;
	}

	public String getRandomName() {
		final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final java.util.Random rand = new java.util.Random();

		final Set<String> identifiers = new HashSet<String>();
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
}
