package zda1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Proszę napisać prosty program konsolowy, wyliczający pole powierzchni prostokąta
 */

public class zad1 {
    public class Square {
        private int sideLenght;
        private int area;

        public int getArea() {
            return this.area;
        }

        public int getSideLenght() {
            return this.sideLenght;
        }

        Square(int sideLenght) {
            this.sideLenght = sideLenght;
            this.area = sideLenght * sideLenght;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        zad1 zd = new zad1();

        try {
            System.out.println("Specify the length side of the square.");
            Square sq = zd.new Square(input.nextInt());
            System.out.printf("Surface for %d area is: %d\n", sq.getSideLenght(), sq.getArea());

        }
        catch (InputMismatchException ex) {
            System.out.println("Entered the length of the side is not an integer!");
        }
        finally {
            input.close();
        }

    }
}
