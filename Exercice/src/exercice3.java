import java.util.Scanner;

public class exercice3 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int max_number = 0;
        int counter = 0;
        int number = 0;

        while(number < 1 || number > 127) {
            System.out.print("Enter a number between 1 and 127: ");
            number = reader.nextInt();

            if (number > max_number) {
                max_number = number;
                counter = 0;
            }
        }
    }
}
