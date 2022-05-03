public class Coffee {
    private int availWater = 400;
    private int availMilk = 540;
    private int availBeans = 120;
    private int disposableCups = 9;
    private int cash = 550;

    public Coffee() {
        this.availWater = availWater;
        this.availMilk = availMilk;
        this.availBeans = availBeans;
        this.disposableCups = disposableCups;
        this.cash = cash;
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
            this.water -= 250;
            this.availBeans -= 16;
            this.disposableCups -= cups;
            this.cash += (cups * 4);
        }
        //Latte
        if (choice == 2) {
            this.water -= 200;
            this.milk -= 100;
            this.availBeans -= 12;
            this.disposableCups -= cups;
            this.cash += (cups * 6);
        }
        //Cappucino
        if (choice == 3) {
            this.water -= 350;
            this.milk -= 75;
            this.availBeans -= 20;
            this.disposableCups -= cups;
            this.cash += (cups * 7);
        }
    }
    
    public int takeCash(){
        int money == this.cash;
        this.cash = 0;
        return money;
    }

}