package ca.roumani.stocktrader;
import java.util.Date;
/**
 * Created by Jay C on 3/23/2017.
 */

public class Equity
{
    /**
     * Attributes
     * Description: Each instance has a stock symbol (a String),
     *              a quantity or number of shared (int),
     *              book and market value (double),
     *              a yield (double),
     *              and the date on which it was acquired (Date).
     */
    private String symbol;
    private int qty;
    private double bookValue, marketValue, yield;
    private static Date acquired;

    //parameterized constructor
    public Equity(java.lang.String symbol, int qty, double bookValue, java.util.Date acquired, double marketValue, double yield)
    {
        this.acquired = acquired;
        this.bookValue = bookValue;
        this.marketValue = marketValue;
        this.qty = qty;
        this.symbol = symbol;
        this.yield = yield;
    }

    //accessors

    public String getSymbol()
    {
        return symbol;
    }

    public int getQty()
    {
        return qty;
    }

    public double getBookValue()
    {
        return bookValue;
    }

    public double getMarketValue()
    {
        return marketValue;
    }

    public double getYield()
    {
        return yield;
    }

    public static Date getAcquired()
    {
        return acquired;
    }

    @Override
    public String toString()
    {
        return "";
    }

    public static void main(String[] args)
    {
        System.out.println(getAcquired().getDate());
    }
}
