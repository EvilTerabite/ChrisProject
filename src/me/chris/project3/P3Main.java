package me.chris.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P3Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> acceptableCharacters = new ArrayList<>(Arrays.asList("c","m","s"));
        while(true) {
            insSpace(5);
            System.out.println("Are you (s)ingle, (m)arried, or (c)ohabiting?");
            System.out.print("Enter s,m, or c: ");
            String filingStatus = scanner.next();
            if(!acceptableCharacters.contains(filingStatus.toLowerCase())) {
                System.out.println("Invalid Character.");
                continue;
            }
            System.out.print("Gross Income: ");
            double grossIncome = scanner.nextDouble();
            System.out.print("Exemptions: ");
            int exemptions = scanner.nextInt();
            double taxableIncome = grossIncome - 1000 * exemptions;
            if(taxableIncome < 0) {
                taxableIncome = 0;
            }
            double taxRate = getTaxRate(filingStatus, taxableIncome);
            double taxesOwed = taxableIncome * taxRate;
            insSpace(2);
            System.out.println("Tax Rate = " + taxRate*100 + "%");
            System.out.println("Taxable Income = " + taxableIncome);
            System.out.println("Taxes Owed = " + taxesOwed);
            insSpace(2);
            System.out.print("Process another Customer? (y/n)");
            String another = scanner.next();
            if(another.equalsIgnoreCase("n")) {
                break;
            }
        }
    }


    private static double getTaxRate(String filingStatus, double taxableIncome) {
        switch (filingStatus) {
            case "s":
            case "S":
                return 0.20;
            case "m":
            case "M":
                return 0.25;
            case "c":
            case "C":
                if (taxableIncome < 20000) {
                    return 0.10;
                }
                if (taxableIncome >= 20000 && taxableIncome <= 50000) {
                    return 0.15;
                }
                if (taxableIncome > 50000) {
                    return 0.30;
                }
            default:
                return 404;
        }
    }


    private static void insSpace(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println();
        }
    }
}
