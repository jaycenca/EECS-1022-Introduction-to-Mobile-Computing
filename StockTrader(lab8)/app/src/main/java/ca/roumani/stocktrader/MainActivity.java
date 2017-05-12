package ca.roumani.stocktrader;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void analyzeButton(View v)
    {
        //Define TableLayout

        TableLayout table = ((TableLayout)findViewById(R.id.myTableLayout));
        table.removeAllViews();

        //Define TableRow
        TableRow tr = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(lp);

        EditText input = (EditText) findViewById(R.id.porfolioName);

        TextView symbolLabel = new TextView(this);
        symbolLabel.setText("Symbol ");
        tr.addView(symbolLabel);

        TextView quantityLabel = new TextView(this);
        quantityLabel.setText("Quantity ");
        tr.addView(quantityLabel);

        TextView bookvalueLabel = new TextView(this);
        bookvalueLabel.setText("BookValue ");
        tr.addView(bookvalueLabel);

        TextView acquired = new TextView(this);
        acquired.setText("Acquired ");
        tr.addView(acquired);

        TextView marketvalueLabel = new TextView(this);
        marketvalueLabel.setText("MarketValue ");
        tr.addView(marketvalueLabel);

        TextView yieldLabel = new TextView(this);
        yieldLabel.setText("Yield ");
        tr.addView(yieldLabel);

        table.addView(tr);

        if(input.getText().toString().equals("?"))
        {
            Intent intent = new Intent(this, ListActivity.class);
            this.startActivity(intent);
        }
        else
        {

            Resources res = getResources();//â€¨
            String[] data = res.getStringArray(res.getIdentifier(input.getText().toString(), "array", this.getPackageName()));

            PortfolioAnalyzer pa = new PortfolioAnalyzer(input.getText().toString(),data);


            for(int i = 0; i < pa.getPortfolio().size(); i++ )
            {
                tr = new TableRow(this);
                lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                tr.setLayoutParams(lp);

                Equity e = pa.getPortfolio().get(i);

                TextView x = new TextView(this);
                //x.setText("Hello");
                //tr.addView(x);
                symbolLabel = new TextView(this);
                symbolLabel.setText(e.getSymbol());
                tr.addView(symbolLabel);

                quantityLabel = new TextView(this);
                quantityLabel.setText(e.getQty()+"");
                tr.addView(quantityLabel);

                bookvalueLabel = new TextView(this);
                bookvalueLabel.setText(e.getBookValue() + "");
                tr.addView(bookvalueLabel);

                acquired = new TextView(this);
                acquired.setText(pa.getDate().get(i));
                tr.addView(acquired);

                marketvalueLabel = new TextView(this);
                marketvalueLabel.setText(e.getMarketValue() + "");
                tr.addView(marketvalueLabel);

                yieldLabel = new TextView(this);
                yieldLabel.setText(String.format("%.2f%%",e.getYield()));

                tr.addView(yieldLabel);

                table.addView(tr);
            }

            ((TextView)findViewById(R.id.summary)).setText(pa.toString());
        }

    }

}
