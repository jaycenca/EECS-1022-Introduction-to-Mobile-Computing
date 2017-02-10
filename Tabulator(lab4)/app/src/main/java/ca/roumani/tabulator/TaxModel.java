package ca.roumani.tabulator;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by user on 1/27/17.
 *
 *
 */
public class TaxModel
{

    /**  This is provided by the outline of this lab without modification
     *
     * We have input variable "income"
     */
    private double income;
    private double tax, average, marginal, cpp, ei;
    private double maxTax1,maxTax2,maxTax3;
    private double maxTax;

    public static final double BRACKET_0 = 11475.0;
    public static final double BRACKET_1 = 33808.0;
    public static final double BRACKET_2 = 40895.0;
    public static final double BRACKET_3 = 63823.0;
    public static final double RATE_1 = 22.79 / 100.0;
    public static final double RATE_2 = 33.23 / 100.0;
    public static final double RATE_3 = 45.93 / 100.0;
    public static final double RATE_4 = 52.75 / 100.0;

    public static final double EI_RATE = 1.63/100.0;
    public static final double EI_MAX = 836.19;

    public static final double CPP_RATE = 4.95/100.0;
    public static final double CPP_MAX = 2564.10;
    public static final double CPP_EXEMPT = 3500.0;




    public void setIncome(double inc)
    {
        this.income = inc;
    }


    //default constructor
    public TaxModel()
    {
        this.income = 0;
    }
    /** Setup parameters according to the provided label as per private double
     *
     *
     */

    public TaxModel(String a, String b, String c, String d, String e, String f)
    {
        income = Double.parseDouble(a);

        tax = Double.parseDouble(b);
        average = Double.parseDouble(c);
        marginal = Double.parseDouble(d);
        cpp = Double.parseDouble(e);
        ei = Double.parseDouble(f);
    }

    /** Setup methods according to the psvm testing requirement for
     * getTax,
     * getAverageTax
     * getMarginalRate
     * getCPP
     * getEI
     *
     * These method will be return as result to Activity.
     */


    /** getTax method manual:
     *
     * taxAmount is used to indicate which bracket the income falls into.
     *
     * maxTax is parameter that if the income fulfilled more than 1 bracket, the tax amount would be max out for particular bracket.
     *
     * Example:
     *
     * income as $52500
     *
     * IF statement will test which bracket the income falls into
     * test 1 taxAmount4  = 52500 - 11475 - 33808 - 40895 - 63823 = (-96501)
     * hence, taxAmount is less than 0 and failed the test and goes to the next ELSE IF.
     *
     * The test that actually passed is taxAmount 2 > 0 of which
     * taxAmount2 = 52500 - 11475 - 33808 = 7217 , which is > 0.
     * and it processed with the follow calculation:
     *
     * taxAmount2 * Rate2 = 7217 * .3323 = 2398.2091 (the income falls into next bracket)
     * maxTax1 = 33808 * .2279 = 7704.8432  (The income that falls into previous bracket of which fully taxable)
     *
     * result = 2398.2091 + 7704.8432 = 10103.0523.
     *
     *  maxTax1 (because 33808 got fully taxed at Rate1)
     *
     *
     */

    public String getTax()
    {
        double result = 0;

        double taxAmount1 = (income - BRACKET_0);

        double taxAmount2 = (income - BRACKET_0 - BRACKET_1);

        double taxAmount3 = (income - BRACKET_0 - BRACKET_1 - BRACKET_2);

        double taxAmount4 = (income - BRACKET_0 - BRACKET_1 - BRACKET_2 - BRACKET_3);

        maxTax1 = BRACKET_1*RATE_1;
        maxTax2 = BRACKET_2*RATE_2;
        maxTax3 = BRACKET_3*RATE_3;

        if(taxAmount4 > 0)
        {
            result = (taxAmount4 * RATE_4) + maxTax1 + maxTax2 + maxTax3;
            maxTax = ( RATE_4);
        }
        else if(taxAmount3 > 0)
        {
            result = (taxAmount3 * RATE_3) + maxTax1 + maxTax2;
            maxTax = ( RATE_3);
        }
        else if(taxAmount2 > 0)
        {
            result = (taxAmount2 * RATE_2) + maxTax1;
            maxTax = ( RATE_2);
        }
        else if(taxAmount1 > 0)
        {
            result = taxAmount1* RATE_1;
            maxTax = ( RATE_1);
        }
        else
        {
            result = 0;
            maxTax *= 0;
        }

        average = result /  this.income;
        return String.format("%,.2f",result);
    }


    /** Average Rate is equal to income / tax
     *
     *
     */
    public String getAverageRate()
    {
        double result = average;

        if(Double.isNaN(average))
        {
            result = 0;
        }
        return String.format("%.0f%%", result * 100);

    }

    /** Marginal Rate means the highest tax bracket that the income falls into.
     *
     * ex. 52500 the highest tax bracket would be 33%.
     */
    public String getMarginalRate()
    {
        return String.format("%.0f%%",maxTax*100);
    }

    /**CPP, this calculation only considered CPP rate vs MAX CPP contribution without the exemption
     *
     * we need to see what we should do about it.
     *
     */
    public String getCPP()
    {

        double computeCPP = (income -CPP_EXEMPT) * CPP_RATE;

        double result = 0;


        if (computeCPP > CPP_MAX)
        {
            result = CPP_MAX;
        }
        else if (income <= CPP_EXEMPT)
        {
            result = 0;
        }
        else
        {
            result = computeCPP;
        }

        return String.format("%,.2f", result);


    }

    /** EI , This calculation considered EI rate vs MAX EI contribution. this should be okay.
     *
     *
     */

    public String getEI()
    {
        double computeEI = (income) * EI_RATE ;

        double result = 0;


        if (computeEI > EI_MAX)
        {
            result = EI_MAX;
        }
        else
        {
            result = computeEI;
        }

        return String.format("%,.2f", result);


    }


    /** this is directly copied from the lab doc.
     *
     * this is a model.setIncome where we need to build a method for it i guess.
     *
     */

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        TaxModel model = new TaxModel();
        model.setIncome(52500);
        System.out.println(model.getTax());
        System.out.println(model.getAverageRate());
        System.out.println(model.getMarginalRate());
        System.out.println(model.getCPP());
        System.out.println(model.getEI());
    }





}
