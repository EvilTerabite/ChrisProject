package me.chris.project2;

import java.util.Scanner;

public class P2Main {

    public static void main(String[] args) {
        System.out.print("Enter a radius value: ");
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double diameter = getDiameter(radius);
        double circumference = getCircumference(diameter);
        double area = getArea(radius);
        System.out.println("Diameter = " + diameter);
        System.out.println("Circumference = " + circumference);
        System.out.println("Area = " + area);
    }

    private static double getDiameter(double radius) {
        return radius*2;
    }

    private static double getCircumference(double diameter) {
        return Math.PI*diameter;
    }

    private static double getArea(double radius) {
        return Math.PI*Math.pow(radius, 2);
    }
}
