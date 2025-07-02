import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHS_IN_A_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal($1k - $1M): ", 1000, 1_000_000);
        float interestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period(Years): ", 1, 30);

        printMortgage(principal, interestRate, years);

        printBalance(years, principal, interestRate);

    }

    private static void printMortgage(int principal, float interestRate, byte years) {
        double mortgage = calculateMortgage(principal, interestRate, years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Monthly Mortgage");
        System.out.println("----------------");
        System.out.println("Monthly amount due will be: "+formattedMortgage);
    }

    private static void printBalance(byte years, int principal, float interestRate) {
        System.out.println();
        System.out.println("Remaining Balance after each payment");
        System.out.println("------------------------------------");
        for(short month = 1; month <= years *MONTHS_IN_A_YEAR; month++){
            double balance = calculateBalance(principal, interestRate, years, month);
            String remainingBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(month +") "+remainingBalance);
        }
    }

    //formulas source: https://www.mortgageprofessor.com/formulas.htm
    public static double calculateBalance(int principal, float annualInterestRate, byte years, short numberOfPaymentsMade){
        float rate = annualInterestRate/(PERCENT*MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years*MONTHS_IN_A_YEAR;

        double balance = principal*
                ((Math.pow((1+rate), totalMonthlyPayments))-(Math.pow((1+rate), numberOfPaymentsMade)))
                /((Math.pow((1+rate), totalMonthlyPayments))-1);

        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, byte years){
        float rate = annualInterestRate/(PERCENT*MONTHS_IN_A_YEAR);
        int totalMonthlyPayments = years*MONTHS_IN_A_YEAR;
        double expPart = Math.pow((1+rate), totalMonthlyPayments);
        double mortgage = principal*((rate*expPart)/(expPart-1));

        return mortgage;
    }

}