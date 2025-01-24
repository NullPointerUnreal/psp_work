package MultiThreadsInOne;

public class professor_isTeaching extends Thread{
	private String name, subject;
	private int students;
	
	public professor_isTeaching(String name, String subject, int students) {
		this.name = name;
		this.subject = subject;
		this.students = students;
	}
	@Override
	public void run() {
        // Simulate the professor teaching a subject
        System.out.println(name + " is teaching " + subject + " to " + students + " students.");
        
        // Simulate the teaching process with periodic updates
        try {
            for (int i = 0; i < 5; i++) { // This will loop 5 times, for 5 seconds
                System.out.println(name + " is still teaching " + subject + " (second " + (i + 1) + ")");
                Thread.sleep(1000); // Simulate time taken for each second of teaching (1 second)
            }
        } catch (InterruptedException e) {
            System.out.println("The teaching session was interrupted.");
        }
        
        System.out.println(name + " has finished teaching " + subject + ".");
    }
	public static class Execute {
        public static void main(String[] args) {
            // Create a professor who is teaching a subject
            professor_isTeaching professor = new professor_isTeaching("Dr. Dani", "PSP", 30);
            
            // Start the professor's teaching thread
            professor.start();
            
            // You can also create another professor or perform other actions if needed
            professor_isTeaching professor2 = new professor_isTeaching("Dr. Pablo", "AADD", 25);
            professor2.start();
        }
    }
}
