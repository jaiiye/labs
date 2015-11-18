package javaee.pw.zda.ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeNumbersTimer implements ActionListener {
	private static int genNextPrimeNumber(int initalNumber) {
		int testNumber = initalNumber + 1;
		
		while (!isPrimeNumber(testNumber)) {
			testNumber++;
		}
		
		System.exit(0);;
		return testNumber;
	}
	
	private static boolean isPrimeNumber(int number) {
		int divisor = 2;
		
		while (divisor < number ) {
			if (number % divisor == 0) {
				return false;
			}			
			divisor++;
		}
		
		return true;	
	}
	
	public void actionPerformed(ActionEvent event){	
		long startTime;
		long stopTime = 0;
		
		int primeNumber = 1;
		
		startTime = System.currentTimeMillis();
		
		while ( (stopTime - startTime) < 5000) {
			System.out.printf("Elapsed time: %d [ms]\n", -(stopTime - startTime));
			
			/*
			while (!isPrimeNumber(primeNumber)) {
				System.out.println("while (!isPrimeNumber(this.primeNumber))");				
				primeNumber = genNextPrimeNumber(primeNumber + 1);						
			}
			
			if (isPrimeNumber(primeNumber)) {
				System.out.printf("Next Prime Number is: %d\n", primeNumber);
			}
			primeNumber++;*/
			stopTime = System.currentTimeMillis();
		}
		
		System.exit(0);
	}

	
	
	public static void main(String[] args) {
	
		ActionListener action = new PrimeNumbersTimer();
		
		action.actionPerformed(null);
	}
	
}
