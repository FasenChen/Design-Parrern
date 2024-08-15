package StructuralPatterns;

import java.util.Scanner;


public class Decorator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" ");
            abstractCoffee coffee = "1".equals(arr[1])?new CoffeeAddMilk():new CoffeeAddSugar();
            coffee.setCoffee("1".equals(arr[0])?new BlackCoffee():new Latte());
            coffee.brew();
        }
    }
}

interface Coffee{
    void brew();
}

class BlackCoffee implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing Black Coffee");
    }
}
class Latte implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing Latte");
    }
}

abstract class abstractCoffee implements Coffee{
    Coffee coffee;

    public void setCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public void brew(){
       coffee.brew();
    }
} 

class CoffeeAddMilk extends abstractCoffee{
    @Override
    public void brew(){
        super.brew();
        System.out.println("Adding Milk");
    }
}

class CoffeeAddSugar extends abstractCoffee{
    @Override
    public void brew(){
        super.brew();
        System.out.println("Adding Sugar");
    }
}