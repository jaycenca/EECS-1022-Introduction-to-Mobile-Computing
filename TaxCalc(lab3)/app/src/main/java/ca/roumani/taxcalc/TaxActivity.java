package ca.roumani.taxcalc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.CompletionException;

public class TaxActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
    }

    public void computeClicked(View v)
    {
        LinearLayout output = (LinearLayout)(findViewById(R.id.output));
        try
        {
            String income = ((EditText) findViewById(R.id.incomeBox)).getText().toString();

            if(income.length()==0)
            {
                throw new Exception();
            }
            TaxModel model = new TaxModel();
            model.setIncome(Double.parseDouble(income));
            //LinearLayout output = (LinearLayout)(findViewById(R.id.output));

            output.removeAllViews();

            /**
             * Description: Creating an array with all the elements inside the array and create,
             * set and add texts inside a loop
             * Process:
             *    1) declare and instantiate an array of length 10
             *    2) initalize all elements in the array with values
             *    3) create a loop
             *    4) use the concept of create a new TextView, set it to a value and add it to the TextView
             *       in the loop
             */
            String[] arr = new String[10];
            arr[0] = "Income Tax:";
            arr[1] = model.getTax();
            arr[2] = "Average Rate:";
            arr[3] = model.getAverageRate();
            arr[4] = "Marginal Rate:";
            arr[5] = model.getMarginalRate();
            arr[6] = "CPP:";
            arr[7] = model.getCPP();
            arr[8] = "EI:";
            arr[9] = model.getEI();

            for(int i = 0; i < arr.length;i++)
            {
                TextView taxLabel = new TextView(this);
                taxLabel.setText(arr[i]);
                output.addView(taxLabel);
            }
        }
        catch (Exception e)
        {
            output.removeAllViews();
            TextView taxLabel = new TextView(this);
            taxLabel.setText("YOU ENTER NOTHING?!!! \n Please Enter A number!!!!!");
            output.addView(taxLabel);

        }

    }
}



