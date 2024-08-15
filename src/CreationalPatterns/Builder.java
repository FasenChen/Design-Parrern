package CreationalPatterns;

import java.util.Scanner;
/*
【设计模式专题之建造者模式】4. 自行车加工
题目描述
小明家新开了一家自行车工厂，用于使用自行车配件（车架 frame 和车轮 tires ）进行组装定制不同的自行车，包括山地车和公路车。

山地车使用的是Aluminum Frame（铝制车架）和 Knobby Tires（可抓地轮胎），公路车使用的是 Carbon Frame （碳车架）和 Slim Tries。

现在它收到了一笔订单，要求定制一批自行车，请你使用【建造者模式】告诉小明这笔订单需要使用那些自行车配置吧。


输入描述
输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示订单的数量。 

接下来的 N 行，每行输入一个字符串，字符串表示客户的自行车需求。

字符串可以包含关键词 "mountain" 或 "road"，表示客户需要山地自行车或公路自行车。

输出描述
对于每笔订单，输出该订单定制的自行车配置。
输入示例
3
mountain
road
mountain
输出示例
Aluminum Frame Knobby Tires
Carbon Frame Slim Tires
Aluminum Frame Knobby Tires
提示信息
在本例中：产品为自行车，可以有两个建造者：山地车建造者和公路车建造者。
 */
public class Builder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        n=0;
        while(scanner.hasNext()){
            arr[n++] = scanner.nextLine();
        }

        for(String s : arr){
            BikeBuilder bikeBuilder = "road".equals(s)?new roadBikeBuilder():new mountainBikeBuilder();
            Directer directer = new Directer(bikeBuilder);
            directer.construct();
            bikeBuilder.createBike().show();
        }
    }
}

class Bike{
    private String Frame;
    private String Tires;
    public Bike(){};

    public void setFrame(String Frame){
        this.Frame = Frame;
    }
    
    public void setTires(String Tires){
        this.Tires = Tires;
    }

    public void show(){
        System.out.println(Frame+" "+Tires);
    }

}

interface BikeBuilder{
    void buildFrame();
    void buildTires();
    Bike createBike();
}

class mountainBikeBuilder implements BikeBuilder{
    private Bike bike;

    public mountainBikeBuilder(){
        bike = new Bike();
    }

    @Override
    public void buildFrame(){
        this.bike.setFrame("Aluminum Frame");
    }

    @Override
    public void buildTires(){
        this.bike.setTires("Knobby Tires");
    }

    @Override
    public Bike createBike(){
        return bike;
    }
}

class roadBikeBuilder implements BikeBuilder{
    private Bike bike;

    public roadBikeBuilder(){
        bike = new Bike();
    }

    @Override
    public void buildFrame(){
        this.bike.setFrame("Carbon Frame");
    }

    @Override
    public void buildTires(){
        this.bike.setTires("Slim Tires");
    }

    @Override
    public Bike createBike(){
        return bike;
    }
}

class Directer{
    private BikeBuilder bikeBuilder;
    public Directer(BikeBuilder bikeBuilder){
        this.bikeBuilder = bikeBuilder;
    }
    public void construct(){
        bikeBuilder.buildFrame();
        bikeBuilder.buildTires();
    }

}