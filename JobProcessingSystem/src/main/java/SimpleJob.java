public class SimpleJob implements Job {
    private String id;

    public SimpleJob(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        // Simulate job execution, replace with actual job logic
        System.out.println("Job " + id + " is running.");
    }

    @Override
    public String getId() {
        return id;
    }
}
