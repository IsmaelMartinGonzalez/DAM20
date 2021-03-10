package Cine;


/**
 * Project name: DAM20/Cine
 * Filename: Este archivo sirve como generador de personas con una edad y cartera aleatorias.
 * Created:  18/01/2021 / 19:17
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Person {
    //Attriubutes
    private int age;
    private int balance;
    private String name;

    //Builder
    public Person(int age, int balance,String name){
        this.age=age;
        this.balance=balance;
        this.name=name;
    }

    //Getters/Setters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Methods
    public void pay(int price){
        balance-=price;
    }
    public boolean haveMoney(int price){
        return balance>=price;
    }
    public boolean haveAge(int minAge){
        return age>=minAge;
    }

}
