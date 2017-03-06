package ca.jaycen05myyorku.rex2lab6;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{

    private RexModel rm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rm = new RexModel();
    }

    public void checkClicked(View v)
    {
        String input = ((EditText)findViewById(R.id.string)).getText().toString();
        boolean output = this.rm.doesMatch(input);
        String text = "regex = "+ this.rm.getRex()+ ", String = "+input+"  ----> "+output;
        TextView log = (TextView) findViewById(R.id.log);
        log.append("\n"+text);
    }

    //generate a new regex once the string entered is correct
    private void newRegex()
    {
        this.rm.setDigit((((CheckBox)findViewById(R.id.digit)).isChecked()));

        this.rm.setLetter(((CheckBox)findViewById(R.id.letter)).isChecked());

        this.rm.setAnchor(((CheckBox)findViewById(R.id.anchor)).isChecked());

        this.rm.generate(2);

        ((TextView)findViewById(R.id.regex)).setText(this.rm.getRex());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}
