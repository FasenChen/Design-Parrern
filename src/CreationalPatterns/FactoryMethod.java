package CreationalPatterns;

import java.util.Scanner;
/** 
【设计模式专题之工厂方法模式】2.积木工厂
题目描述
小明家有两个工厂，一个用于生产圆形积木，一个用于生产方形积木，请你帮他设计一个积木工厂系统，记录积木生产的信息。
输入描述
输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示生产的次数。 

接下来的 N 行，每行输入一个字符串和一个整数，字符串表示积木的类型。积木类型分为 "Circle" 和 "Square" 两种。整数表示该积木生产的数量

输出描述
对于每个积木，输出一行字符串表示该积木的信息。
输入示例
3
Circle 1
Square 2
Circle 1
输出示例
Circle Block
Square Block
Square Block
Circle Block
提示信息
在示例中，积木工厂生产了4块积木，其中有2块是圆形积木，2块是方形积木。根据输入的类型，每块积木的信息被输出到控制台。
**/
public class FactoryMethod {
    public static void createShapeByFactory(Factory factory, int num){
        for(int i=0;i<num;i++){
            factory.createShape().show();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        Factory circleFactory = new CircleFactory();
        Factory squareFactory = new SquareFactory();
        n = 0;
        while(scanner.hasNext()){
            arr[n++] = scanner.nextLine();
        }
        scanner.close();

        for(String s : arr){
            String[] tmp = s.split(" ");
            createShapeByFactory("Circle".equals(tmp[0])?circleFactory:squareFactory, Integer.parseInt(tmp[1]));
        }
    }
}

interface Shape{
    void show();
}
interface Factory{
    Shape createShape();
}

class CircleShape implements Shape {
    @Override
    public void show(){
        System.out.println("Circle Block");
    }
}

class SquareShape implements Shape {
    @Override
    public void show(){
        System.out.println("Square Block");
    }
}

class CircleFactory implements Factory {
    @Override
    public Shape createShape() {
        return new CircleShape();
    }
}

class SquareFactory implements Factory {
    @Override
    public Shape createShape() {
        return new SquareShape();
    }
}