package eecs.test;

import hr.YumI;

/**
 * Created by user on 2/17/17.
 */
public class Model
{
    //field
    private int population;
    private  double gdp;
    public static final int MIN_POPULATION = 2500000;

    //constructors
    public Model()
    {
        population = 0;
        gdp = 0;
    }

    public Model(double g)
    {
        population = MIN_POPULATION;
        gdp = g;
    }

    public Model(double g, int p)
    {
        population = p;
        gdp = g;
    }

    //accessor methods
    public java.lang.String getGdp(char currencySymbol)
    {
        return String.format(currencySymbol+"%,d", (int)(gdp));
    }

    public int getPopulationInMillions()
    {
        int output = (int)(Math.floor(population/1000000));
        if(population < 500000 && output > 0 )
            output = 0;
        return output;
    }


    //CompareTo method
    public int compareTo(Model other)
    {
        if(this.population > other.getPopulationInMillions())
            return 1;
        else if(this.population < other.getPopulationInMillions())
            return -1;
        else
            return 0;
    }

    //equals method
    public boolean equals(Model other)
    {
        return this.getPopulationInMillions() == other.getPopulationInMillions() && this.getGdp('$').equals(other.getGdp('$'));
    }

    //setPopulation
    public boolean setPopulation(int p)
    {
        if(p > 0)
            population = p;
        System.out.println("The Population is Now "+population);
        return p > 0;
    }

    //computeYUM
    public int computeYum()
    {
        return new YumI().getDensity(population);
    }

    //in the main
    public static void main(String[] args)
    {
        Model test1 = new Model(80000000,2);
        Model test2 = new Model(3,2);

        //testing compareTo method
        int method1 = test1.compareTo(test2);
        System.out.println("Model(8,2) compares to Model(3,9) is "+method1);

        //testing computeYum method
        int method2 = test2.computeYum();
        System.out.println("The Yum Density of Model(3,9) is "+method2);

        //testing equals method
        boolean method3 = test1.equals(test2);
        System.out.println("The Comparision of the two is "+method3);

        //testing getGdp method
        String method4 = test1.getGdp('$');
        System.out.println("The GDP for Model(8,2) is "+method4);

        //testing getPopulationInMiilions method
        int method5 = test1.getPopulationInMillions();
        System.out.println("Population of Model(8,2) is "+method5);

        //testing setPopulation method
        boolean method6 = test1.setPopulation(0);
        System.out.println("The truth value of setting population of Model(8,2) is "+method6);


    }
}
