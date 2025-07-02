import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculations calculator;

    public MortgageReport(MortgageCalculations calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Monthly Mortgage");
        System.out.println("----------------");
        System.out.println("Monthly amount due will be: " + formattedMortgage);
    }

    public void printBalance() {
        System.out.println();
        System.out.println("Remaining Balance after each payment");
        System.out.println("------------------------------------");
        for(short month = 1; month <= calculator.getYears() * MortgageCalculations.MONTHS_IN_A_YEAR; month++){
            double balance = calculator.calculateBalance(month);
            String remainingBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(month +") "+remainingBalance);
        }
    }
}
