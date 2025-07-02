public class MortgageCalculations {
    private final static byte MONTHS_IN_A_YEAR = 12;
    private final static byte PERCENT = 100;

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
        float rate = getMonthlyInterestRate();
        int totalMonthlyPayments = getNumberOfPayments();

        double balance = principal *
                ((Math.pow((1 + rate), totalMonthlyPayments)) - (Math.pow((1 + rate), numberOfPaymentsMade)))
                / ((Math.pow((1 + rate), totalMonthlyPayments)) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float rate = getMonthlyInterestRate();
        int totalMonthlyPayments = getNumberOfPayments();
        double expPart = Math.pow((1 + rate), totalMonthlyPayments);
        double mortgage = principal * ((rate * expPart) / (expPart - 1));

        return mortgage;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);

        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_A_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / (PERCENT * MONTHS_IN_A_YEAR);
    }

}
