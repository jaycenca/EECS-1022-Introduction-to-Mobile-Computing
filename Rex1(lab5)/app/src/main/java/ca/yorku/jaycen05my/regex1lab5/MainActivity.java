package ca.yorku.jaycen05my.regex1lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private RexModel rm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rm = new RexModel();
    }

    //button that generate random regex
    public void generateClicked(View v)
    {
        /**
         * two ways to write the codes:
         *
         * 1) do a ton of if-statement to check the state of the check boxes
         * 2) use a while loop to determine the state of the check boxes
         */

        /**
         * //first way: lacking effiency and structure method
         *
         *
         */


    }

    //button that produce a result to show whether the string entered
    //matches the regex
    public void checkClicked(View v)
    {

    }


}
