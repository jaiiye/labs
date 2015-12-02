package zda1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Created by blepa on 2015-12-02.
 */

/**
 * Proszę na podstawie powyższego przykładu zrobić program wypisujący kolejne liczby pierwsze dokładnie przez 5 sekund
 * Wskazówki:
 * zdarzenia należy użyć do dokładnego odmierzenia czasu. W metodzie actionPerformed umieszczamy wywołanie funkcji System.exit(0) kończące program
 * zamiast metody sleep należy użyć pętli sprawdzającej kolejne liczby pierwsze
 * dobrze jest napisać metodę: boolean isPrimeNumber(int number) { ... } sprawdzającą, czy przekazana liczba jest liczbą pierwszą
 */
public class zad2 implements ActionListener {
    private static int genNextPrimeNumber(int initalNumber) {
        int testNumber = initalNumber + 1;

        while (!isPrimeNumber(testNumber)) {
            testNumber++;
        }

        return testNumber;
    }

    private static boolean isPrimeNumber(int number) {
        int divisor = 2;

        while (divisor < number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }

        return true;
    }


    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }


    public static void main(String[] args) throws InterruptedException {
        int primeNumber = 1;

        ActionListener listener = new zad2();


        Timer t = new Timer(5000, listener);
        t.start();

        while (true) {

            primeNumber = genNextPrimeNumber(primeNumber);
            System.out.printf("Next prime number is: [%d]%n", primeNumber);

        }

    }

}
