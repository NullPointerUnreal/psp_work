package MultiThreadTest;

public class player_scores {
	public static void main(String[] args) {
		footballplayer player1 = new footballplayer("Cristiano Ronaldo", 1, 70);
		footballplayer player2 = new footballplayer("Leonel Messi", 1, 60);
		
		Thread thread1 = new Thread(player1);
		Thread thread2 = new Thread(player2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("The two top players has score a goal on their previous match!!");
	}
}
