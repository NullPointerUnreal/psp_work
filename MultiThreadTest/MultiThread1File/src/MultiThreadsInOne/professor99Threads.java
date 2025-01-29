package MultiThreadsInOne;

import java.util.concurrent.atomic.AtomicInteger;

public class professor99Threads extends Thread {
    private String name, subject;
    private int students;
    private static AtomicInteger sharedCounter = new AtomicInteger(0); // Variable compartida

    public professor99Threads(String name, String subject, int students) {
        this.name = name;
        this.subject = subject;
        this.students = students;
    }

    @Override
    public void run() {
        // Incrementa la variable compartida y sincroniza la impresión
        int currentCount = sharedCounter.incrementAndGet();

        synchronized (System.out) {
            System.out.println(name + " is teaching " + subject + " to " + students + " students. [Shared Counter: " + currentCount + "]");
            System.out.flush(); // Forzar la salida inmediata a la consola
        }

        // Simulación de enseñanza
        try {
            for (int i = 0; i < 10; i++) { // Simula 10 segundos
                System.out.println("Omg, It is taking so long - " + name + " is still teaching " + subject + "...");
                Thread.sleep(1000); // Pausa de 1 segundo
            }
        } catch (InterruptedException e) {
            System.out.println("The teaching session was interrupted.");
        }

        System.out.println(name + " has finished teaching " + subject + ".");
    }

    public static class Execute {
        public static void main(String[] args) {
            for (int i = 1; i <= 99; i++) {
                professor99Threads professor = new professor99Threads(
                    "Dani " + i, "PSP " + i, 30
                );
                professor.start();
            }
        }
    }
}
