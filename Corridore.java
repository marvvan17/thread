import java.util.Random;

public class Corridore extends Thread {
    private String nome;
    private Random random;

    public Corridore(String nome) {
        this.nome = nome;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int passo = 1; passo <= 5; passo++) {
            System.out.println(nome + " ha fatto il passo " + passo);

            try {
                // Pausa casuale tra 200 e 800 millisecondi
                int pausa = random.nextInt(601) + 200;
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.println(nome + " è stato interrotto.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(nome + " ha raggiunto il traguardo!");
    }
}