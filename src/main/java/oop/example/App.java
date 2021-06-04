package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */

public class App 
{
    public static void main( String[] args )
    {
        CompoundInterest userAccount = new CompoundInterest();
        userAccount.setPrincipal();
        userAccount.setIR();
        userAccount.setYears();
        userAccount.setCompounded();

        System.out.println(
                userAccount.getPrincipal() +
                        " invested at " + userAccount.getInputIR() +
                        "% for " + userAccount.getYears() +
                        " years compounded " + userAccount.getInputCompounded() +
                        " times per year is " + userAccount.calcInterest() +"."
        );


    }
}
