package ca.yorku.jaycenmy.mcalc;

import hr.YumModel;

/**
 * Created by user on 1/23/17.
 */
public class EntryForm
{
    /**
     * 3 private attributes to hold the principle (a double), the amortization (an int) and
     * annual interest(double)\
     *
     * where p is the principle, r is the monthly interest
     * and n is the number of months in the amortization
     */
    private static double P , R;
    private static int n;

    /**
     * Description: parameterized constructor accept three parameter n, p r, all strings
     * and convert and stored them accordingly
     * Method: Using the parseDouble and parseInt in Double and Integer classes to convert
     *        them to the correct states ACCORDINGLY.
     */
    public EntryForm(String a , String b, String c)
    {
        P = Double.parseDouble(a);
        R = Double.parseDouble(c);
        n = Integer.parseInt(b);
    }

    /**
     * Description: ComputePament() method that returns the monthly payments as a string
     * Formula:
     *      (rP)
     *   ___________________________
     *     1 -  _______1__________
     *          1 + nr + n(n-1)r^2/2
     *
     * Method:
     *  1)change the r, the monthly interest rate to right decimal places
     *  2)declare a few variables (double) to represent nominator and denominator, so that
     *   it is more organize
     */

    public String computePayment()
    {
        R = (R / 12) / 100;
        n*= 12;
        double result = 1;
        double nom = R * P;
        double denom1 = (1)/((1 + (n * R) + (( n * (n - 1) * (Math.pow(R,2))/2))));
        double denom2 = 1 - denom1;
        //System.out.println("The Rate value , R is "+R );
        //System.out.println("The Principle value, P is "+P);
        //System.out.println("The Interest  value , n is "+n);

        result =  (nom) / (denom2);
        //System.out.println("The Result is "+result);
        return String.format("%.2f", result);
    }

    /**
     *                  Optional Part of the lab
     *  Description: an method called computeExactPayment() is created to compute the monthly payment
     *              using the exact formula:
     *                            rP
     *           __________________________________
     *                        1- (1 + r)^-n
     */

    public String computeExactPayment()
    {
        R = (R / 12) / 100;
        n*= 12;
        double result = 1;
        double nom = R * P;
        double denom = 1 - (Math.pow( 1 + R , -n ));

        result = (nom) / (denom);

        return String.format("%.2f", result);
    }

    /**
     * Testing in the main
     */
    public static void main(String[]args)
    {
        //instantiate a new class using the parameterized constructor
        EntryForm test1 = new EntryForm("700000","25","2.75");

        //testing the computePayment() method
        System.out.println("The Approximate value of EntryForm(\"700000\",\"25\",\"2.75\") is "+test1.computePayment());

        //testing the computeExactPayment() method
        System.out.println("The Exact value of EntryForm(\"700000\",\"25\",\"2.75\") is "+test1.computeExactPayment());

        //testing the YUM class in the YUM jar
        YumModel test2 = new YumModel();
        test2.setPrinciple("700000");
        test2.setAmortization("25");
        test2.setInterest("2.75");

        System.out.println("The Approximate value for YUM is "+test2.computePayment());
    }
}
