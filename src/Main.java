//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal($1k - $1M): ", 1000, 1_000_000);
        float interestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period(Years): ", 1, 30);

        var calculator = new MortgageCalculations(principal, interestRate, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printBalance();

    }
}