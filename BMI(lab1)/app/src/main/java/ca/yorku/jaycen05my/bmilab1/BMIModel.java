package ca.yorku.jaycen05my.bmilab1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by user on 1/10/17.
 * @author Jay Cen
 * @description The purpose of this class to act as an model such that it can be operated to achieve a goal using the ambiguous numbers
 * @goal: To Find the Body Mass Index(BMI) of a human using the weight and height
 */

public class BMIModel
{
    //two private double
    private double weight;
    private double height;

    //a parameterized constructor that stored two string paramters: w represent weight and h represent height
    //stored them into the private variables
    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    //an access method that compute the BMI
    // using the formula : BMI = (weight)/(height)^2)
    public String getBMI()
    {
        //professor's method of computing by multiplying by itself
        //double index = this.weight / (this.height * this.height);

        //my own way of computing by using the Math class
        double index1 = this.weight / Math.pow(this.height, 2);

        //format method inside the String
        //****Very Interesting Used
        //format(Locale x,Format y, Object z)
        //Format can be null
        String result = String.format("%.1f", index1);
        return result;
    }

    //convert kg to Pound
    public String getWeightInPound()
    {
        double Pound = Math.floor(this.weight*2.20462);
        return String.valueOf((int)(Pound));
        /*
         *Using the format method from the String class,
         * Object cant be int or string because they are primitive
         */

    }

    public static void main(String[] args)
    {
        /*
         *Testing diffferent scenarios
         ***An Important Note: declare once and change the values for very scenarios
         */

        //storing printing class in a variable to look fancy
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        BMIModel model = new BMIModel("100", "1.8");
        output.println("BMIModel(\"100\", \"1.8\") is "+model.getBMI());
        output.println("Your Pound is "+model.getWeightInPound());

        model = new BMIModel("45.6", "1.35");
        output.println("BMIModel(\"45\", \"1.35\") is "+model.getBMI());
        output.println("Your Pound is "+model.getWeightInPound());

        model = new BMIModel("80", "1.2");
        output.println("BMIModel(\"80\", \"1.2\") is "+model.getBMI());
        output.println("Your Pound is "+model.getWeightInPound());

        model = new BMIModel("65", "1.6");
        output.println("BMIModel(\"65\", \"1.6\") is "+model.getBMI());
        output.println("Your Pound is "+model.getWeightInPound());

    }
}
