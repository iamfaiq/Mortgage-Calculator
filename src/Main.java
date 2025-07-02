import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int principal = (int)readNumber("Principal($1k - $1M): ", scanner, 1000, 1_000_000);
        float interestRate = (float)readNumber("Annual Interest Rate: ", scanner, 1, 30);
        byte years = (byte)readNumber("Period(Years): ", scanner, 1, 30);

        System.out.println();
        System.out.println("You've entered----- ");
        System.out.println("Principal: "+principal);
        System.out.println("Annural Interest Rate: "+interestRate);
        System.out.println("Amortization Period: "+years);

    }

    public static double readNumber(String prompt, Scanner scanner, int min, int max){
        double numberRead = 0.0;
        while (true) {
            System.out.print(prompt);
            numberRead = (double) scanner.nextDouble();
            if ((numberRead >= min) && (numberRead <= max))
                break;
            System.out.println("Enter a number between "+min+" and "+max);
        }
        return numberRead;
    }
}