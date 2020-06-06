import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String shape = null;
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                shape = "square";
                break;
            case 2:
                shape = "circle";
                break;
            case 3:
                shape = "triangle";
                break;
            case 4:
                shape = "rhombus";
                break;
            default:
        }

        System.out.println(shape == null ? "There is no such shape!" : "You have chosen a " + shape);
    }
}
