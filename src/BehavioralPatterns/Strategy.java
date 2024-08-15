package BehavioralPatterns;

import java.util.Scanner;

public class Strategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        while (num-- >0) { 
            String[] arr = scanner.nextLine().split(" ");
            Context context = new Context(Integer.parseInt(arr[1]));
            context.getFinalPrice(Integer.parseInt(arr[0]));
        }
        scanner.close();
    }
}
interface Discount{
    int getPrice(int price);
}

class discountA implements Discount{
    public int getPrice(int price)
    {
        return (int) ((int) price*0.9);
    }
}

class discountB implements Discount{
    public int getPrice(int price)
    {
        if(price>=100 && price<150){
            return price-5;
        }
        else if(price>=150 && price <200){
            return price-15;
        }
        else if(price>=200 && price <300){
            return price-25;
        }else if (price >= 300){
            return  price - 40;
        }
        else{
            return price;
        }
    }
}

class Context {
    private Discount discount;
    public Context(int i){
        if(i==1){
            discount = new discountA();
        }
        else if(i==2){
            discount = new discountB();
        }
    }

    public void getFinalPrice(int price){
        System.out.println(discount.getPrice(price));
    }
}