package ca.roumani.rex1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
        this.rm.setDigit((((CheckBox)findViewById(R.id.digit)).isChecked()));

        this.rm.setLetter(((CheckBox)findViewById(R.id.letter)).isChecked());

        this.rm.setAnchor(((CheckBox)findViewById(R.id.anchor)).isChecked());

        this.rm.generate(2);

        ((TextView)findViewById(R.id.regex)).setBackgroundColor(Color.TRANSPARENT);
        ((TextView)findViewById(R.id.regex)).setText(this.rm.getRex());


    }

    //button that produce a result to show whether the string entered
    //matches the regex
    public void checkClicked(View v)
    {
        String input = ((EditText)findViewById(R.id.string)).getText().toString();
        boolean output = this.rm.doesMatch(input);
        String text = "regex = "+ this.rm.getRex()+ ", String = "+input+"  ----> "+output;
        TextView log = (TextView) findViewById(R.id.log);
        log.append("\n"+text);
    }


}
