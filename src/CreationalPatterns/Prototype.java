package CreationalPatterns;

import java.util.Scanner;
/*
【设计模式专题之原型模式】5. 矩形原型
题目描述
公司正在开发一个图形设计软件，其中有一个常用的图形元素是矩形。设计师在工作时可能需要频繁地创建相似的矩形，而这些矩形的基本属性是相同的（颜色、宽度、高度），为了提高设计师的工作效率，请你使用原型模式设计一个矩形对象的原型。使用该原型可以快速克隆生成新的矩形对象。

输入描述
首先输入一个字符串，表示矩形的基本属性信息，包括颜色、长度和宽度，用空格分隔，例如 "Red 10 5"。

然后输入一个整数 N（1 ≤ N ≤ 100），表示使用原型创建的矩形数量。

输出描述
对于每个矩形，输出一行字符串表示矩形的详细信息，如 "Color: Red, Width: 10,Height: 5"。
输入示例
Red 10 5
3
输出示例
Color: Red, Width: 10, Height: 5
Color: Red, Width: 10, Height: 5
Color: Red, Width: 10, Height: 5
提示信息
使用原型模式中的克隆方法实现矩形对象的创建。
 */
public class Prototype {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int num = scanner.nextInt();
        RectangleShape rectangleShape = new RectangleShape(arr[0],Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        for(int i=0;i<num;i++){
            // rectangleShape.clone().show();
        }
    }
}

abstract class AbstractShape implements Cloneable {
    public abstract void show();

    public AbstractShape clone(){
        try {
            return (AbstractShape)super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}

class RectangleShape extends AbstractShape {
    String Color;
    int Height;
    int Width;

    public RectangleShape(String color,int width,int height){
        this.Color = color;
        this.Height = height;
        this.Width = width;
    }
    public void show(){
        System.out.println("Color: "+Color+", Width: "+Width+", Height: "+Height);
    }
}