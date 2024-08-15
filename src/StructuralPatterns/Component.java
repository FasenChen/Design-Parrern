package StructuralPatterns;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Component {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String companyName = scanner.nextLine();
        Department company = new Department(companyName);
        int num = Integer.parseInt(scanner.nextLine());
        while(num-->0){
            String[] str=scanner.nextLine().split(" "); 
            if("D".equals(str[0])){
                company.add(new Department(str[1]));
            }else{
                Department tmp = (Department) company.getEmployees().get(company.getEmployees().size()-1);
                tmp.add(new Employee(str[1]));
            }
        }
        System.out.println("Company Structure");
        company.operation(0);
    }   
}


interface  Organization {
    void operation(int index);
}

class Department implements Organization {
    private String name;
    LinkedList<Organization> Employees;
    public Department(String name){
        this.name=name;
        this.Employees=new LinkedList<Organization>();
    }
    public void operation(int index){
        for(int i=0;i<index;i++){
            System.out.print("  ");
        }
        System.out.println(name);
        for(Organization  c:Employees){
            c.operation(index+1);
        }
    }
    public void add(Organization  c){
        Employees.add(c);
    }

    public void remove(Organization  c){
        Employees.remove(c);
    }

    public List<Organization > getEmployees(){
        return Employees;
    }
}

class Employee implements Organization {
    private String name;
    public Employee(String name){
        this.name=name;
    }
    public void operation(int index){
        for(int i=0;i<index;i++){
            System.out.print("  ");
        }
        System.out.println(name);
    }
}