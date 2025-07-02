import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculations calculator;

    public MortgageReport(MortgageCalculations calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println();
        System.out.println("Monthly Mortgage");
        System.out.println("----------------");
        System.out.println("Monthly amount due will be: " + formattedMortgage);
    }

    public void printBalance() {
        System.out.println();
        System.out.println("Remaining Balance after each payment");
        System.out.println("------------------------------------");

        int month = 1;
        for (double balance : calculator.getRemainingBalances()){
            String remainingBalance = currency.format(balance);
            System.out.println(month +") "+remainingBalance);
            month++;
        }
    }

}
