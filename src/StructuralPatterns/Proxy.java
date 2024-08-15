package StructuralPatterns;

import java.util.Scanner;
/*
【设计模式专题之代理模式】7-小明买房子
题目描述
小明想要购买一套房子，他决定寻求一家房屋中介来帮助他找到一个面积超过100平方米的房子，只有符合条件的房子才会被传递给小明查看。
输入描述
第一行是一个整数 N（1 ≤ N ≤ 100），表示可供查看的房子的数量。

接下来的 N 行，每行包含一个整数，表示对应房子的房屋面积。

输出描述
对于每个房子，输出一行，表示是否符合购房条件。如果房屋面积超过100平方米，输出 "YES"；否则输出 "NO"。
输入示例
3
120
80
110
输出示例
YES
NO
YES
 */
public class Proxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HouseAgent houseAgent = new HouseAgent();
        while(n-->0){
            houseAgent.sizeJudge(scanner.nextInt());
        }
    }
}
interface HouseScreening{
    void sizeJudge(int size);
}

class HouseScreeningTool implements HouseScreening{

    @Override
    public void sizeJudge(int size){
        String s = size>100?"YES":"NO";
        System.out.println(s);
    }
}

class HouseAgent implements HouseScreening{
    private HouseScreeningTool houseScreeningTool;

    public HouseAgent(){
        houseScreeningTool = new HouseScreeningTool();
    }
    @Override
    public void sizeJudge(int size){
        houseScreeningTool.sizeJudge(size);
    }
}
