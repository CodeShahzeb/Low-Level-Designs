public interface JobProcessingSystem {
    void run(Job job, long futureExecutionTimeInMillis);
}
