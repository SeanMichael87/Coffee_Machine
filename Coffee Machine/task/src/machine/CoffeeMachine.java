package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = false;
        Coffee coffee = new Coffee();
        State state = State.ACTION;

        while (!flag) {

            switch (state) {
                case ACTION:
                    System.out.println("Write action (buy, fill, take, remaining, exit)");
                    String action = scan.next();
                    state = coffee.action(action);
                    break;
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menu:");
                    String choice = scan.next();

                    if (choice.equals("back")) {
                        state = State.ACTION;
                        break;
                    } else {
                        coffee.subtractBuy(Integer.parseInt(choice));
                    }

                    state = State.ACTION;
                    break;
                case FILL:
                    System.out.println("Write how many ml of water you want to add:");
                    int addWater = scan.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int addMilk = scan.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int addBeans = scan.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    int addCups = scan.nextInt();

                    coffee.fillAdd(addWater, addMilk, addBeans, addCups);
                    state = State.ACTION;
                    break;
                case TAKE:
                    int money = coffee.takeCash();
                    System.out.printf("I gave you %d", money);
                    state = State.ACTION;
                    break;
                case REMAIN:
                    System.out.println("The coffee machine has:");
                    System.out.printf("%d ml of water\n", coffee.getAvailWater());
                    System.out.printf("%d ml of milk\n", coffee.getAvailMilk());
                    System.out.printf("%d g of coffee beans\n", coffee.getAvailBeans());
                    System.out.printf("%d disposable cups\n", coffee.getDisposableCups());
                    System.out.printf("%d of money\n", coffee.getCash());
                    state = State.ACTION;
                    break;
                default:
                    state = State.SHUT_DOWN;
                    flag = true;
                    break;
            }
        }
    }

}
