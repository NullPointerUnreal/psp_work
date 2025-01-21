package MultiThreadTest;

public class footballplayer extends Thread {
	private String player_name;
	private int score;
	private int team_passes;

	/**
	 * Constructor to the football player
	 * 
	 * @param player_name References the player's name
	 * @param score       References the number of points
	 * @param team_passes References how much metters the player has run
	 */
	public footballplayer(String player_name, int score, int team_passes) {
		this.player_name = player_name;
		this.score = score;
		this.team_passes = team_passes;
	}

	@Override
	public void run() {
		 // Record the start time
        long startTime = System.currentTimeMillis();

        // Begins the process of shooting
        System.out.println(this.player_name + " shoots after " + this.team_passes + " passes");

        /**
         * Simulates the time taken for the player to shoot by calculating elapsed time.
         */
        try {
            // Simulate some operation (e.g., running with the ball)
            Thread.sleep(2000); // Simulates a 2-second delay (optional, adjust as needed)
        } catch (InterruptedException e) {
            System.out.println("The player " + this.player_name + " has been interrupted by the defender");
            Thread.currentThread().interrupt();
        }
        
        // Record the end time
        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000; // Convert milliseconds to seconds

		// The player achives to score the goal.
		System.out.println("The player " + this.player_name + " has score " + this.score + " goal" + " after "
				+ this.team_passes + " passes!!");
		System.out.println("Time taken for " + this.player_name + "'s to take the shoot: " + elapsedTime + " seconds.");
	}
}
