package ca.jaycen05myyorku.rex2lab6;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 3/5/17.
 */
public class ScoreModel
{
    //attributes
    private int attempt,successes;
    private long elapsed_time, start;

    //default constructor
    public ScoreModel()
    {
        this.attempt = 0;
        this.successes = 0;
        this.start = new Date().getTime();
    }

    //accessor methods
    public int getAttempts()
    {
        return this.attempt;
    }

    public int getSuccess()
    {
        return this.successes;
    }

    public long getStart()
    {
        return this.start;
    }

    public long getElapsedTime()
    {
        this.elapsed_time = (new Date().getTime() - this.start)/1000;
        return this.elapsed_time;
    }

    public void record(boolean success)
    {
        if(success == true)
        {
            this.successes++;
        }
        (this.attempt)++;
    }

    public double getAverageScore()
    {
        return ((double)this.successes / (double)this.attempt) * 100;
    }

    public void resetTimer()
    {
        this.start = new Date().getTime();
        this.attempt = 0;
        this.successes = 0;
    }

    public static void main(String[] args)
    {
        ScoreModel model = new ScoreModel();
        long s = model.getStart();
        System.out.println("The starting time is "+s);
        long e = model.getElapsedTime();
        System.out.println("The elapsed time is "+e);

        System.out.println("The first attempt is "+model.getAttempts());

        System.out.println("After the record method");
        model.record(false);
        System.out.println("The second attempt is "+model.getAttempts());

        System.out.println("After another record method");
        model.record(true);
        System.out.println("The Third attempt is "+model.getAttempts());

    }
}
