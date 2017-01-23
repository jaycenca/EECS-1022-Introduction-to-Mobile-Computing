package ca.yorku.jaycenmy.mcalc;

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
        R = R / 100;
        double result = 1;
        double nom = R * P;
        double denom1 = (1)/(1 + (n * R) + ( n * (n - 1) * Math.pow(R,2))/2);
        double denom2 = 1 - denom1;

        result =  nom / denom2;

        return String.format("%.2f", result);
    }

    //optional
    //will discussed later 

}
