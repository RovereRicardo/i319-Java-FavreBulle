import java.util.Scanner;

public class exercice2 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 127");
        int number = reader.nextInt();

        int result = number;
        for (int i = number; i >= 0; i--) {
            result = result + i;
        }
        System.out.println("The sum is : " + result);
    }
}
