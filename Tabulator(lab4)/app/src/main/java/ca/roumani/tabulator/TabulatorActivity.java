package ca.roumani.tabulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TabulatorActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabulator);
    }

    public void tabClicked(View v)
    {
        //Define TableLayout

        TableLayout table = ((TableLayout)findViewById(R.id.tableLayout));
        table.removeAllViews();

        //Define TableRow
        TableRow tr = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(lp);

        try
        {
            //Define EditText Box
            String from = ((EditText)findViewById(R.id.from)).getText().toString();
            String upTo = ((EditText)findViewById(R.id.upTo)).getText().toString();
            String increase = ((EditText)findViewById(R.id.inc)).getText().toString();

            if (from.length()==0 || upTo.length()==0 || increase.length()==0)
            {
                throw new Exception();
            }

            // Add title to the first row.
            TextView incomeLabel = new TextView(this);
            incomeLabel.setText("INCOME");
            tr.addView(incomeLabel);

            TextView taxLabel = new TextView(this);
            taxLabel.setText("TAX");
            tr.addView(taxLabel);

            TextView avgLabel = new TextView(this);
            avgLabel.setText("Avg");
            tr.addView(avgLabel);

            TextView mgnLabel = new TextView(this);
            mgnLabel.setText("Mgn");
            tr.addView(mgnLabel);

            TextView cppLabel = new TextView(this);
            cppLabel.setText("CPP");
            tr.addView(cppLabel);

            TextView eiLabel = new TextView(this);
            eiLabel.setText("EI");
            tr.addView(eiLabel);

            table.addView(tr);

            TaxModel model = new TaxModel();

            for (double i = Double.parseDouble(from); i <= Double.parseDouble(upTo); i += Double.parseDouble(increase))
            {

                model.setIncome(i);
                String n = Double.toString(i);

                tr = new TableRow(this);
                lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                tr.setLayoutParams(lp);

                TextView income = new TextView(this);
                income.setText(n);
                tr.addView(income);

                TextView tax = new TextView(this);
                tax.setText(model.getTax());
                tr.addView(tax);

                TextView avg = new TextView(this);
                avg.setText(model.getAverageRate());
                tr.addView(avg);

                TextView mgn = new TextView(this);
                mgn.setText(model.getMarginalRate());
                tr.addView(mgn);

                TextView cpp = new TextView(this);
                cpp.setText(model.getCPP());
                tr.addView(cpp);

                TextView ei = new TextView(this);
                ei.setText(model.getEI());
                tr.addView(ei);

                table.addView(tr);
            }
        }
        catch (Exception e)
        {
            TextView msgError = new TextView(this);
            msgError.setText("Please fill out all the fields!");
            tr.addView(msgError);

            table.addView(tr);
        }


    }

 }




