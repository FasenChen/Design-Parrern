package StructuralPatterns;

import java.util.HashMap;
import java.util.Scanner;

public class Flyweight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory shapeFactory = new ShapeFactory();

        while(scanner.hasNext()){
            String[] str = scanner.nextLine().split(" ");
            Shape shape = shapeFactory.getShape(ShapeType.valueOf(str[0]));
            shape.draw(new Position(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            ((ConcreteShape)shape).setIsFirstTime(false);
        }
        scanner.close();
    }
}

enum ShapeType{
    CIRCLE,RECTANGLE,TRIANGLE;
}

class Position{

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


interface Shape{
    void draw(Position position);
}

class ConcreteShape implements Shape {

    private ShapeType shapeType;
    boolean isFirstTime = true;

    public ConcreteShape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public void draw(Position position) {
        System.out.println(shapeType + (isFirstTime ? " drawn" : " shared") + " at (" + position.getX() + ", " + position.getY() + ")");
    }

    public void setIsFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }
}

class ShapeFactory{
    HashMap<ShapeType, Shape> map  = new HashMap<>();
    public Shape getShape(ShapeType shapeType){
        if(map.containsKey(shapeType)){
            return map.get(shapeType);
        }else{
            Shape shape = new ConcreteShape(shapeType);
            map.put(shapeType, shape);
            return shape;
        }
    }
}