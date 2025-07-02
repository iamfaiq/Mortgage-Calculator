import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max){
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
