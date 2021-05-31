package oop.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class CompoundInterest {

    double inputPrincipal;
    double inputIR;
    double inputYears;
    int inputCompounded;
    BigDecimal principal;
    BigDecimal ir;
    BigDecimal years;
    BigDecimal accountValue;
    BigDecimal compounded;

    public void setPrincipal() {
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Enter the principal: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid amount.");
                System.out.println("Enter the principal: ");
            }
            inputPrincipal = input.nextDouble();
            if (inputPrincipal < 0) {
                System.out.println("Principal cannot be a negative value.");
            }
        } while (inputPrincipal < 0);
        principal = BigDecimal.valueOf(inputPrincipal);
    }

    public void setIR() {
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Enter the annual interest rate percentage: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid rate.");
                System.out.println("Enter the annual interest rate percentage: ");
            }
            inputIR = input.nextDouble();
            if (inputIR < 0) {
                System.out.println("Interest rate cannot be a negative value.");
            }
        } while (inputIR < 0);
        ir = BigDecimal.valueOf((inputIR / 100));
    }

    public void setYears() {
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Enter the number of years: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid amount.");
                System.out.println("Enter the number of years: ");
            }
            inputYears = input.nextDouble();
            if (inputYears < 0) {
                System.out.println("Years cannot be a negative value.");
            }
        } while (inputYears < 0);
        years = BigDecimal.valueOf(inputYears);
    }

    public void setCompounded() {
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Enter the number of times the interest is compounded per year:  ");
            while (!input.hasNextInt()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid amount.");
                System.out.println("Enter the number of times the interest is compounded per year:  ");
            }
            inputCompounded = input.nextInt();
            if (inputCompounded < 0) {
                System.out.println("This amount cannot be a negative value.");
            }
        } while (inputCompounded < 0);
        compounded = BigDecimal.valueOf(inputCompounded);
    }

    public String calcInterest() {
        BigDecimal step1 = ir.divide(compounded, 6, RoundingMode.UP);

        BigDecimal step2 = step1.add(BigDecimal.ONE);

        BigDecimal step3 = compounded.multiply(years);

        //need an integer for BigDecimal pow
       step3 = step3.setScale(0, RoundingMode.HALF_UP);
        int powStep3 = step3.intValueExact();

        BigDecimal step4 = step2.pow(powStep3);

        accountValue = principal.multiply(step4);

        accountValue = accountValue.setScale(2,RoundingMode.UP);

        return NumberFormat.getCurrencyInstance().format(accountValue);
    }

    public double getInputIR() {
        return inputIR;
    }

    public int getInputCompounded(){
        return inputCompounded;
    }

    public String getPrincipal() {
        principal = principal.setScale(2, RoundingMode.UP);
        return NumberFormat.getCurrencyInstance().format(principal);
    }

    public BigDecimal getYears() {
        years = years.setScale(1, RoundingMode.HALF_UP);
        return years;
    }

}
