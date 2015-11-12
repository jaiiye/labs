package javaee.pw.obj.ArrayListTest;

public class TestClass {
	
	private int value;
	
	TestClass() {
		this.value = randomGenerator(); 
	}
	
	TestClass(int value){
		this.value = value;
	}

	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	private static int randomGenerator(){
		return (int) (Math.random() * 50 + 1);
	}

}
