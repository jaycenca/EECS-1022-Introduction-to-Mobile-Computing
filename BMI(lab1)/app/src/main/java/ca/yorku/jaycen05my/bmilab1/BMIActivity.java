package ca.yorku.jaycen05my.bmilab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
 *@author Jay Cen
 *@description: The function of this class is to act as a controller of the "view" and the "Model". The purpose is to "display" an result
 * that satisfy the "Model" class according to users' "values"
 */
public class BMIActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }

    public void buttonClicked(View v)
    {
        //declare and initalize type View
        //to get the values entered by users
        View weightView = findViewById(R.id.weightBox);

        //declare and initalize type EditText
        //to cast it to EditText type such that
        //it can call the toString method in the EditText class
        EditText weightEdit = (EditText) weightView;
        String weight = weightEdit.getText().toString();

        String height = ((EditText) findViewById(R.id.heightBox)).getText().toString();

        //instantiate a class and use the getBMI access method
        BMIModel model = new BMIModel(weight, height);
        String answer = model.getBMI();

        //using the getPound access method
        String pound = model.getPound();

        //using the values of answer and pound variables to view it
        ((TextView) findViewById(R.id.answer)).setText(answer);
        ((TextView) findViewById(R.id.pound)).setText(pound);
    }
}
