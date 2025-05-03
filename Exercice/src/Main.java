import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 127");
        int number = reader.nextInt();

        if(number > 1 && number < 127) {
            System.out.println("You typed number : " + number);
            if (number % 2 == 0) {
                System.out.println("The number is pair");
            } else if (number % 2 != 0) {
                System.out.println("The number is odd");
            } else {
                number = reader.nextInt();
            }
        }
        reader.close();
    }
}
