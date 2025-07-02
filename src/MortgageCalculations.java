public class MortgageCalculations {

    //formulas source: https://www.mortgageprofessor.com/formulas.htm
    public static double calculateBalance(int principal, float annualInterestRate, byte years, short numberOfPaymentsMade) {
        float rate = annualInterestRate / (Main.PERCENT * Main.MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years * Main.MONTHS_IN_A_YEAR;

        double balance = principal *
                ((Math.pow((1 + rate), totalMonthlyPayments)) - (Math.pow((1 + rate), numberOfPaymentsMade)))
                / ((Math.pow((1 + rate), totalMonthlyPayments)) - 1);

        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, byte years) {
        float rate = annualInterestRate / (Main.PERCENT * Main.MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years * Main.MONTHS_IN_A_YEAR;
        double expPart = Math.pow((1 + rate), totalMonthlyPayments);
        double mortgage = principal * ((rate * expPart) / (expPart - 1));

        return mortgage;
    }
}
