package machine;

import java.util.Scanner;

enum State {
    ACTION,
    BUY,
    FILL,
    TAKE,
    REMAIN,
    SHUT_DOWN;
}

public class Coffee {
    Scanner scan = new Scanner(System.in);
    private int availWater = 400;
    private int availMilk = 540;
    private int availBeans = 120;
    private int disposableCups = 9;
    private int cash = 550;

    public Coffee() {

    }

    public int getAvailWater() {
        return availWater;
    }

    public int getAvailMilk() {
        return availMilk;
    }

    public int getAvailBeans() {
        return availBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getCash() {
        return cash;
    }

    public void fillAdd(int water, int milk, int beans, int cups){
        this.availWater += water;
        this.availMilk += milk;
        this.availBeans += beans;
        this.disposableCups += cups;
    }

    public void subtractBuy(int choice){
        //Expresso
        if (choice == 1) {
            if (availWater < 250) {
                System.out.println("Sorry, not enough water!");
            } else if (availBeans < 16) {
                System.out.println("Sorry, not enough coffee beans");
            } else if (disposableCups == 0) {
                System.out.println("Sorry, not enough disposable cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                this.availWater -= 250;
                this.availBeans -= 16;
                this.disposableCups -= 1;
                this.cash += 4;
            }
        }
        //Latte
        if (choice == 2) {
            if (availWater < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (availMilk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else if (availBeans < 20) {
                System.out.println("Sorry, not enough coffee beans");
            } else if (disposableCups == 0) {
                System.out.println("Sorry, not enough disposable cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                this.availWater -= 350;
                this.availMilk -= 75;
                this.availBeans -= 20;
                this.disposableCups -= 1;
                this.cash += 7;
            }
        }
        //Cappucino
        if (choice == 3) {
            if (availWater < 200) {
                System.out.println("Sorry, not enough water!");
            } else if (availMilk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else if (availBeans < 12) {
                System.out.println("Sorry, not enough coffee beans");
            } else if (disposableCups == 0) {
                System.out.println("Sorry, not enough disposable cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                this.availWater -= 200;
                this.availMilk -= 100;
                this.availBeans -= 12;
                this.disposableCups -= 1;
                this.cash += 6;
            }
        }
    }
    public int takeCash(){
        int cash1 = this.cash;
        this.cash = 0;
        return cash1;
    }

    //Enums manipulation for determinein machine state
    public State action(String choice) {
        switch (choice) {
            case "fill":
                return State.FILL;
            case "buy":
                return State.BUY;
            case "take":
                return State.TAKE;
            case "remaining":
                return State.REMAIN;
            default:
                return State.SHUT_DOWN;
        }
    }
}
