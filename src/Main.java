//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHS_IN_A_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal($1k - $1M): ", 1000, 1_000_000);
        float interestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period(Years): ", 1, 30);

        MortgageReport.printMortgage(principal, interestRate, years);
        MortgageReport.printBalance(years, principal, interestRate);

    }
}