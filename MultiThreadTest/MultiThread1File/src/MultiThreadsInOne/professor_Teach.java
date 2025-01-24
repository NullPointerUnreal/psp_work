package MultiThreadsInOne;

public class professor_Teach implements Runnable {
    private String name, subject;
    private int students;
    
    // Constructor to initialize the professor's name, subject, and number of students
    public professor_Teach(String name, String subject, int students) {
        this.name = name;
        this.subject = subject;
        this.students = students;
    }

    @Override
    public void run() {
        // Simulate the professor teaching a subject
        System.out.println(name + " is teaching " + subject + " to " + students + " students.");
        
        // Simulate the teaching process with a pause (sleep)
        try {
            Thread.sleep(2000); // Simulate time taken for the lecture (2 seconds)
        } catch (InterruptedException e) {
            System.out.println("The teaching session was interrupted.");
        }
        
        System.out.println(name + " has finished teaching " + subject + ".");
    }
    
    public static class Run {
        public static void main(String[] args) {
            // Create Runnable instance (ProfessorTeach)
        	professor_Teach professor1 = new professor_Teach("Dr. Smith", "Mathematics", 30);
        	professor_Teach professor2 = new professor_Teach("Dr. Johnson", "Physics", 25);
            
            // Create Thread objects and pass the Runnable to them
            Thread thread1 = new Thread(professor1);
            Thread thread2 = new Thread(professor2);
            
            // Start the threads to simulate the professors teaching
            thread1.start();
            thread2.start();
        }
    }
}
