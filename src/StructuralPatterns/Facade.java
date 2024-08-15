package StructuralPatterns;

import java.util.Scanner;
/*
【设计模式专题之外观模式】9-电源开关
题目描述
小明家的电源总开关控制了家里的三个设备：空调、台灯和电视机。每个设备都有独立的开关密码，分别用数字1、2和3表示。即输入1时，空调关闭，输入2时，台灯关闭，输入3时，电视机关闭，当输入为4时，表示要关闭所有设备。请你使用外观模式编写程序来描述电源总开关的操作。

输入描述
第一行是一个整数 N（1 <= N <= 100），表示后面有 N 行输入。

 接下来的 N 行，每行包含一个数字，表示对应设备的开关操作（1表示关闭空调，2表示关闭台灯，3表示关闭电视机，4表示关闭所有设备）。

输出描述
输出关闭所有设备后的状态，当输入的数字不在1-4范围内时，输出Invalid device code.
输入示例
4
1
2
3
4
输出示例
Air Conditioner is turned off.
Desk Lamp is turned off.
Television is turned off.
All devices are off.
 */

public class Facade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PowerSwitch powerSwitch = new PowerSwitch();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0) {
            powerSwitch.turnoff(Integer.parseInt(scanner.nextLine()));
        }
    }
}

interface Switch {

    void turnoff();
}

class AirConditioner implements Switch {

    @Override
    public void turnoff() {
        System.out.println("Air Conditioner is turned off.");
    }
}

class DeskLamp implements Switch {

    @Override
    public void turnoff() {
        System.out.println("Desk Lamp is turned off.");
    }
}

class Television implements Switch {

    @Override
    public void turnoff() {
        System.out.println("Television is turned off.");
    }
}

class PowerSwitch {

    private Switch[] switchs;

    public PowerSwitch() {
        switchs = new Switch[3];
        switchs[0] = new AirConditioner();
        switchs[1] = new DeskLamp();
        switchs[2] = new Television();
    }

    public void turnoff(int i) {
        switch (i) {
            case 1:
            switchs[0].turnoff();                
                break;
            case 2:
            switchs[1].turnoff();    
                break;
            case 3:
            switchs[2].turnoff();    
                break;
            default:
                System.out.println("All devices are off.");
        }
    }
}
