package javaee.pw.zda.ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Toolkit;

import java.util.Timer;
import java.util.TimerTask;

public class PrimeNumbersTimer implements ActionListener {	
	
	private static int genNextPrimeNumber(int initalNumber) {
		int testNumber = initalNumber + 1;
		
		while (!isPrimeNumber(testNumber)) {
			testNumber++;
		}	
		
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
	
	private static void printPrimeNumber() {		
		int primeNumber = 1;
		while(true) {			
			primeNumber = genNextPrimeNumber(primeNumber);
			System.out.printf("Next prime number is: [%d]\n", primeNumber);
		}
	}
	
	
	public void actionPerformed(ActionEvent event){	
		Timer timer = new Timer();
		TimerTask task = new PrintPrimeNumber();
		
		System.out.printf("[%d]\n", task.scheduledExecutionTime());
		
		System.out.println("Start!");
		timer.schedule(task, 0, 100);	
		System.out.println("End!");		
	}
	
		
	class PrintPrimeNumber extends TimerTask {
		int primeNumber = 1;
		long scheduledExecutionTime = 0;
		long systemTime = System.currentTimeMillis();
		
		public void run() {
			
			while ( (this.scheduledExecutionTime - this.systemTime) < 5000 ) {
				this.scheduledExecutionTime = System.currentTimeMillis();
				this.primeNumber = genNextPrimeNumber(this.primeNumber);				
				System.out.printf("Next prime number is: [%d], scheduledTime: [%d], systemTime: [%d], executionTime: [%d]\n", this.primeNumber, this.scheduledExecutionTime, this.systemTime, (this.scheduledExecutionTime - this.systemTime));
			}
			System.exit(0);
			
		}
	}
	
	
	
	public static void main(String[] args) {		
		
		ActionListener action = new PrimeNumbersTimer();
		
		action.actionPerformed(null);		
	}
	
}
