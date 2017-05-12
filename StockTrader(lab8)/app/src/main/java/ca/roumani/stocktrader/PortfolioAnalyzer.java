package ca.roumani.stocktrader;

import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jba.roumani.lib.Stock;

/**
 * Created by user on 3/23/17.
 */
public class PortfolioAnalyzer
{
    private String title;
    private String[] rows;
    private List<Equity> equities;
    private double portfolioMarketValue;
    private List<String> date;

    //constructor
    public PortfolioAnalyzer(String title, String[] rows)
    {
        this.title = title;
        this.rows = rows;

        this.equities = new ArrayList<>();

        this.date = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String row : rows)
        {
            String[] items = row.split(",[ ]*");
            try
            {
                String symbol = items[0];
                int quantity = Integer.valueOf(items[1]);
                double bookValue = Double.valueOf(items[2]);

                this.date.add(items[3]);
                Date acquired = simpleDateFormat.parse(items[3]); //There's a potential exception throwing
                double marketValue = getInvestmentMarketValue(symbol);
                this.portfolioMarketValue += quantity * marketValue; //recording the portfolio market value
                double yield = getInvestmentYield(bookValue, marketValue, acquired);
                Equity equity = new Equity(symbol, quantity, bookValue, acquired, marketValue, yield);
                equities.add(equity);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
    }


    public double getInvestmentMarketValue(String symbol) {
        return new Stock(symbol).getPrice();
    }

    public double getInvestmentYield(double bookValue, double marketValue, Date acquired)
    {
        double dayDiff = (new Date().getTime() - acquired.getTime()) / (24 * 3600* 1000);
        return ((marketValue - bookValue) / bookValue) * (365.0 / dayDiff)*100;
    }

    public List<String> getDate()
    {
        return this.date;
    }
    public List<Equity> getPortfolio()
    {
        return this.equities;
    }

    public double getPortfolioMarketValue()
    {
        return this.portfolioMarketValue;
    }

    public int getPortfolioSize()
    {
        return this.equities.size();
    }

    public double getPortfolioYielid()
    {
        double wholeShare = 0;
        double sumPortfolio = 0;

        for (int i = 0; i < this.equities.size(); i++)
        {
            int quantity = this.equities.get(i).getQty();
            double bookValue = this.equities.get(i).getBookValue();
            double yield = this.equities.get(i).getYield();
            wholeShare += quantity * bookValue * yield;
            sumPortfolio += quantity * bookValue;
        }
        return (wholeShare/ sumPortfolio)*100;
    }


    public String toString()
    {
        return "The "+ this.title + "portfolio consists of "+ getPortfolioSize() +" equities\n It has a market value of $"+
                getPortfolioMarketValue() + " and a yield of " + getPortfolioYielid() + "(annualized).";
    }

    public static void main(String[] args)
    {
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = simpleDateFormat.parse("22/06/1989");
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/



    }
}
