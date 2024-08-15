package BehavioralPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Observer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Clock clock = new Clock(0);
        while(num-- > 0){
            String name = scanner.next();
            clock.registerObserver(new Student(name));
        }
        int time = scanner.nextInt();
        scanner.close();
        while(time-- > 0){
            clock.addOneHour();
        }
    }
}
interface observer{
    void update(int hour);
}

class Student implements observer{
    private String name;
    
    private int hour=0;

    public Student(String name){
        this.name = name;
    }
    @Override
    public void update(int hour) {
        this.hour = hour;
        System.out.println(name+" "+hour);
    }
}
interface Subject{
    void registerObserver(observer o);
    void removeObserver(observer o);
    void notifyObservers();
}

class Clock implements Subject{
    private int hour;

    List<observer> observers;

    public Clock(int hour){
        this.hour = hour;
        observers = new ArrayList<>();
    }
    
    public void addOneHour(){
        hour++;
        notifyObservers();
    }

    @Override
    public void registerObserver(observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(observer o : observers){
            o.update(hour);
        }
    }
}