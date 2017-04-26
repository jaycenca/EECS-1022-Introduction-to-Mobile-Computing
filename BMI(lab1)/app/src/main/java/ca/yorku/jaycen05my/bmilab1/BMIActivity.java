package ca.yorku.jaycen05my.bmilab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        //using the getPound access method
        String pound = model.getWeightInPound();


        //using the values of answer and pound variables to view it
        String answer = "Your weight in pound is "+pound+" and your BMI is "+ model.getBMI();
        ((TextView) findViewById(R.id.answer)).setText(answer);
    }

    //reset
    public void Clear(View v)
    {
        View weightView = findViewById(R.id.weightBox);
        ((EditText) weightView).setText("");

        View height = ((EditText) findViewById(R.id.heightBox));
        ((EditText) height).setText("");

        ((TextView) findViewById(R.id.answer)).setText("Answer");

    }
}
