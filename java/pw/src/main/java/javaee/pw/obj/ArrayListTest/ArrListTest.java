package javaee.pw.obj.ArrayListTest;

import java.util.ArrayList;

public class ArrListTest {
	public static void main(String args[]) {
		int elementCount = 10000;
		
		long startTime;
		long endTime;
		long listNotSpecifiedTime;
		long listSpecifiedTime;		
		
		startTime = System.nanoTime();
		ArrayList<TestClass> ArrListNotSpecified = new ArrayList<TestClass>();
		endTime = System.nanoTime();
		System.out.printf("Init -  ArrListNotSpecified - duration: %d [%s]\n", (endTime-startTime), "ns");
		
		
		startTime = System.nanoTime();
		ArrayList<TestClass> ArrListSpecified = new ArrayList<TestClass>(elementCount);
		endTime = System.nanoTime();
		System.out.printf("Init -  ArrListSpecified -    duration: %d [%s]\n", (endTime-startTime), "ns");
		
		System.out.println("Start - ArrListSpecified");
		startTime = System.nanoTime();
		for (int i=0; i<elementCount; i++)
		{
			TestClass test = new TestClass();
			
			ArrListSpecified.add(test);
		}
		endTime = System.nanoTime();
		listSpecifiedTime = endTime-startTime;
		System.out.printf("Stop -  ArrListSpecified - duration:    %d [%s]\n", (endTime-startTime),"ns");	
		
		
		System.out.println("Start - ArrListNotSpecified");
		startTime = System.nanoTime();
		for (int i=0; i<elementCount; i++)
		{
			TestClass test = new TestClass();
			
			ArrListNotSpecified.add(test);
		}
		endTime = System.nanoTime();
		listNotSpecifiedTime = endTime-startTime;
		System.out.printf("Stop -  ArrListNotSpecified - duration: %d [%s]\n", (endTime-startTime), "ns");
		
		
				
		System.out.printf("Nanosec diff at %d element: %d [ns]\n", elementCount, listNotSpecifiedTime-listSpecifiedTime);
		System.out.printf("Procent diff at %d element: %f [prc]\n", elementCount, ((double)(((double)listNotSpecifiedTime-(double)listSpecifiedTime)/(double)listSpecifiedTime))*100);
		
	}
}
