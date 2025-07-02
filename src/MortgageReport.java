import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(int principal, float interestRate, byte years) {
        double mortgage = MortgageCalculations.calculateMortgage(principal, interestRate, years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Monthly Mortgage");
        System.out.println("----------------");
        System.out.println("Monthly amount due will be: " + formattedMortgage);
    }

    public static void printBalance(byte years, int principal, float interestRate) {
        System.out.println();
        System.out.println("Remaining Balance after each payment");
        System.out.println("------------------------------------");
        for(short month = 1; month <= years * Main.MONTHS_IN_A_YEAR; month++){
            double balance = MortgageCalculations.calculateBalance(principal, interestRate, years, month);
            String remainingBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(month +") "+remainingBalance);
        }
    }
}
