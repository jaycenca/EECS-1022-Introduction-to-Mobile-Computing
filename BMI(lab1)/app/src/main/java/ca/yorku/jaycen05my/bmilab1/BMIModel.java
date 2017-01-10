package ca.yorku.jaycen05my.bmilab1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by user on 1/10/17.
 */

public class BMIModel
{
    private double weight;
    private double height;

    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    public String getBMI()
    {
        double index = this.weight / (this.height * this.height);
        String result = String.format("%.1f", index);
        return result;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        BMIModel model = new BMIModel("100", "1.8");
        output.println(model.getBMI());

        model = new BMIModel("45", "1.35");
        output.println(model.getBMI());

        model = new BMIModel("80", "1.2");
        output.println(model.getBMI());

        model = new BMIModel("65", "1.6");
        output.println(model.getBMI());
    }
}