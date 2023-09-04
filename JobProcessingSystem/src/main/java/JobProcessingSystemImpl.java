import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JobProcessingSystemImpl implements JobProcessingSystem {
    private final ScheduledExecutorService executorService;
    private final AtomicInteger jobCounter = new AtomicInteger(0);

    public JobProcessingSystemImpl(int numThreads) {
        executorService = Executors.newScheduledThreadPool(numThreads);
    }

    @Override
    public void run(Job job, long futureExecutionTimeInMillis) {
        long currentTimeInMillis = System.currentTimeMillis();
        long delayInMillis = futureExecutionTimeInMillis - currentTimeInMillis;

        if (delayInMillis < 0) {
            // If the specified time has already passed, execute immediately
            executeJob(job);
        } else {
            // Schedule the job for future execution
            executorService.schedule(() -> executeJob(job), delayInMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void executeJob(Job job) {
        try {
            job.run();
        } catch (Exception e) {
            System.err.println("Error executing job " + job.getId() + ": " + e.getMessage());
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        JobProcessingSystem jobProcessingSystem = new JobProcessingSystemImpl(2);

        // Submitting jobs for future execution
        jobProcessingSystem.run(new SimpleJob("1"), System.currentTimeMillis() + 2000);
        jobProcessingSystem.run(new SimpleJob("2"), System.currentTimeMillis() + 1000);
        jobProcessingSystem.run(new SimpleJob("3"), System.currentTimeMillis() + 3000);

        // Shutdown the system when done
        ((JobProcessingSystemImpl) jobProcessingSystem).shutdown();
    }
}
