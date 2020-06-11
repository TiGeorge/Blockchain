import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Command buyCommand;
        Command sellCommand;
        int[] amountList = new int[3];
        Broker broker = new Broker();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            amountList[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            Option option = new Option(amountList[i]);
            if (amountList[i] > 0) {
                buyCommand = new BuyCommand(option);
                /* write your code here */
                broker.setCommand(buyCommand);
                broker.executeCommand();

            } else {
                sellCommand = new SellCommand(option);
                /* write your code here */
                broker.setCommand(sellCommand);
                broker.executeCommand();
            }
        }
    }
}

class Option {
    private int amount;

    Option(int amount) {
        this.amount = amount;
    }

    void buy() {
        System.out.println(amount + " was bought");
    }

    void sell() {
        /* write your code here */
        System.out.println(amount + " was sold");
    }
}

interface Command {
    /* write your code here */
    void execute();
}

class BuyCommand implements Command {
    private Option option;

    BuyCommand(Option option) {
        this.option = option;
    }

    /* write your code here */
    @Override
    public void execute() {
        option.buy();
    }
}

class SellCommand implements Command {
    private Option option;

    SellCommand(Option option) {
        this.option = option;
    }

    /* write your code here */
    @Override
    public void execute() {
        option.sell();
    }
}

class Broker {
    private Command command;

    void setCommand(Command command) {
        /* write your code here */
        this.command = command;
    }

    void executeCommand() {
        /* write your code here */
        command.execute();
    }
}