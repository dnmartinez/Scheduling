class Car {
private String color;
	public Car(String c) {  //constructor
		color=c;
	}
	public void setColor(String newColor) {  //a function taking an argument and returning nothing
		color=newColor;
	}
	public String getColor() {  //a function not taking any argument, but returning a String
		return color;
	}
	public void honk() {  //a function neither taking any argument, nor returning anything
		System.out.println("Beep Beep!!!");
	}
	  
	public String toString() {
		return color;
	}
}