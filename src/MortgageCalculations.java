public class MortgageCalculations {
    public final static byte MONTHS_IN_A_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculations(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    //formulas source: https://www.mortgageprofessor.com/formulas.htm
    public double calculateBalance(short numberOfPaymentsMade) {
        float rate = annualInterestRate / (PERCENT * MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years * MONTHS_IN_A_YEAR;

        double balance = principal *
                ((Math.pow((1 + rate), totalMonthlyPayments)) - (Math.pow((1 + rate), numberOfPaymentsMade)))
                / ((Math.pow((1 + rate), totalMonthlyPayments)) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float rate = annualInterestRate / (PERCENT * MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years * MONTHS_IN_A_YEAR;
        double expPart = Math.pow((1 + rate), totalMonthlyPayments);
        double mortgage = principal * ((rate * expPart) / (expPart - 1));

        return mortgage;
    }

    public byte getYears() {
        return years;
    }
}
