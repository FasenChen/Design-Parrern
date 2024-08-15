package CreationalPatterns;

import java.util.Scanner;
/*
【设计模式专题之抽象工厂模式】3. 家具工厂
题目描述
小明家新开了两个工厂用来生产家具，一个生产现代风格的沙发和椅子，一个生产古典风格的沙发和椅子，现在工厂收到了一笔订单，请你帮他设计一个系统，描述订单需要生产家具的信息。
输入描述
输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示订单的数量。 

接下来的 N 行，每行输入一个字符串，字符串表示家具的类型。家具类型分为 "modern" 和 "classical" 两种。

输出描述
对于每笔订单，输出字符串表示该订单需要生产家具的信息。 

modern订单会输出下面两行字符串 

modern chair 

modern sofa

classical订单会输出下面两行字符串 

classical chair 

classical soft

输入示例
3
modern
classical
modern
输出示例
modern chair
modern sofa
classical chair
classical sofa
modern chair
modern sofa
提示信息
在示例中，工厂收到了3笔订单，其中有2笔要求生产modern风格，1笔要求生产classical风格。根据输入的类型，每次订单生产的家具信息被输出到控制台上。
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        AbractFactory modernFactory = new modernFactory();
        AbractFactory classicalFactory = new classicalFactory();
        n=0;
        while(scanner.hasNext()){
            arr[n++] = scanner.nextLine();
        }
        scanner.close();

        for(String s : arr){
            createProduct("modern".equals(s)?modernFactory:classicalFactory);
        }
    }
    public static void createProduct(AbractFactory factory){
        factory.createChair().show();
        factory.createSofa().show();
    }
}


interface chair{
    void show();
}
interface sofa{
    void show();
}
interface AbractFactory {
    chair createChair();
    sofa createSofa();
}

class modernChair implements chair{
    @Override
    public void show(){
        System.out.println("modern chair");
    }
}

class classicalChair implements chair{
    @Override
    public void show(){
        System.out.println("classical chair");
    }
}


class modernSofa implements sofa{
    @Override
    public void show(){
        System.out.println("modern sofa");
    }
}

class classicalSofa implements sofa{
    @Override
    public void show(){
        System.out.println("classical sofa");
    }
}

class modernFactory implements AbractFactory {
    @Override
    public chair createChair(){
        return new modernChair();
    }
    
    @Override
    public sofa createSofa(){
        return new modernSofa();
    }
}


class classicalFactory implements AbractFactory {
    @Override
    public chair createChair(){
        return new classicalChair();
    }
    
    @Override
    public sofa createSofa(){
        return new classicalSofa();
    }
}