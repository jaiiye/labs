package javaee.pw.zda.hw;

/**
 * Created by blepa on 2015-12-02.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Proszę napisać prosty program konsolowy, wyliczający pole powierzchni prostokąta
 */

public class zad1 {
    private class Square {
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

        try {
            System.out.println("Specify the length side of the square.");
            Square sq = new Square(input.nextInt());
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
