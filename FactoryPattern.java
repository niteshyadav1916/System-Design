
// Factory Pattern

interface Shape{
    void shape();
}

class Circle implements Shape{
    public void shape(){
         System.out.println("Hello World this is a circle");
    }
}

class Rectangle implements Shape{
    public void shape(){
         System.out.println("Hello World this is a rectangle");
    }
}

class ShapeFactory{
    
    public Shape getShapeInstance(String shape){
       switch(shape){
           case "Circle": {
               return new Circle();
           }
           case "Rectangle": {
               return new Rectangle();
           }
           default: return null;
       }
    }
}

public class Main
{
	public static void main(String[] args) {
	    Shape circle = new ShapeFactory().getShapeInstance("Circle");
		
		Shape rectangle = new ShapeFactory().getShapeInstance("Rectangle");
		
		circle.shape();
		rectangle.shape();
	}
}
