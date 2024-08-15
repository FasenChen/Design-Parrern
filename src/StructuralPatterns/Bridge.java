package StructuralPatterns;

import java.util.Scanner;

public class Bridge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        while (num-->0) { 
            String[] arr= scanner.nextLine().split(" ");
            TV tv = "0".equals(arr[0])?new Sony():new TCL();
            Controler c = arr[1].equals("2")?new OnControler():arr[1].equals("3")?new OffControler():new ChangechannelControler();
            c.setTv(tv);
            c.operation();
        }
        scanner.close();
    }
}
interface TV{
    void On();
    void Off();
    void changechannel();
}
class Sony implements TV{
    
    @Override
    public void On(){
        System.out.println("Sony TV is ON");
    }

    @Override
    public void Off(){
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void changechannel(){
        System.out.println("Switching Sony TV channel");
    }
}


class TCL implements TV{
    
    @Override
    public void On(){
        System.out.println("TCL TV is ON");
    }

    @Override
    public void Off(){
        System.out.println("TCL TV is OFF");
    }

    @Override
    public void changechannel(){
        System.out.println("Switching TCL TV channel");
    }
}

abstract class Controler{
    protected  TV tv;
    public void setTv(TV tv){
        this.tv = tv;
    }

    public abstract void operation();
}


class OnControler extends Controler{
    public void setTv(TV tv){
        super.setTv(tv);
    }

    @Override
    public void operation(){
        super.tv.On();
    }
}

class OffControler extends Controler{
    public void setTv(TV tv){
        super.setTv(tv);
    }

    @Override
    public void operation(){
        super.tv.Off();
    }
}

class ChangechannelControler extends Controler{
    public void setTv(TV tv){
        super.setTv(tv);
    }

    @Override
    public void operation(){
        super.tv.changechannel();
    }
}

// +----------------+       +----------------+       +----------------+
// |      TV        |       |     Sony       |       |      TCL       |
// |+---------------+       |+---------------+       |+---------------+
// || - On()        |       || - On()        |       || - On()        |
// || - Off()       |       || - Off()       |       || - Off()       |
// || - changechannel() |   || - changechannel() |   || - changechannel() |
// +----------------+       +----------------+       +----------------+

//          / \                          / \
// +----------------+  /  +----------------+  /  +----------------+
// |  Controler     | /   | OnControler    | /   | OffControler    |
// |+---------------+|    |+---------------+|    |+---------------+|
// || - tv: TV      | |   || - tv: TV      | |   || - tv: TV      | |
// || - setTv(TV)   | |   || - setTv(TV)   | |   || - setTv(TV)   | |
// || - operation() | |   || - operation() | |   || - operation() | |
// +----------------+|    +----------------+|    +----------------+|
//                   |                     |                     |
//                   |                     |                     |
// +----------------+                     +----------------+     +----------------+
// |ChangechannelControler|                 |Abstract Class|     | Concrete Class|
// |+---------------------+                 |+--------------+     |+---------------+
// || - tv: TV          |                  || - tv: TV     |     || - tv: TV      | 
// || - setTv(TV)       |                  || - setTv(TV)  |     || - setTv(TV)   |
// || - operation()     |                  || - operation()|     || - operation() |
// +---------------------+                 +--------------+     +---------------+