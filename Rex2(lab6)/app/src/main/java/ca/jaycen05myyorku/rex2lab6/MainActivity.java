package ca.jaycen05myyorku.rex2lab6;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{

    private RexModel rm;
    private ToneGenerator tg;
    private ScoreModel sm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        this.rm = new RexModel();
        this.sm = new ScoreModel();
        this.tg = new ToneGenerator(ToneGenerator.TONE_CDMA_ABBR_ALERT,100);
        newRegex();
    }

    public void checkClicked(View v)
    {
        String input = ((EditText)findViewById(R.id.string)).getText().toString();
        boolean truth = this.rm.doesMatch(input);
        String output = "";
        String text = "regex = "+ this.rm.getRex()+ ", String = "+input+"  ----> "+output;
        sm.record(truth==false);

        long time = 0;
        while(truth == false)
        {
            output = "Score = "+sm.getAverageScore()+" (" + sm.getAttempts()+ " attempts in "+ time + "sec)";
            ((TextView) findViewById(R.id.result)).setText(output);
        }

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
    public void onSensorChanged(SensorEvent event)
    {
        double sum = Math.pow(event.values[0],2) + Math.pow(event.values[1],2) + Math.pow(event.values[2],2);
        if(sum > 14)
        {
            ((EditText) findViewById(R.id.string)).setText("");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}
