package ca.roumani.piglatin;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class PigLatinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{

    //declaring an object
    private PigLatinModel model;

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_latin);

        //initializing an object
        this.model = new PigLatinModel();
        this.tts = new TextToSpeech(this, this);

    }
    public void convertClick(View v)
    {
        String input = ((EditText)findViewById(R.id.inputText)).getText().toString();
        model.setEnglish(input);
        say(input);
        model.translate();
        ((TextView)findViewById(R.id.convertedText)).setText(model.getPig());
    }

    public void clearClick(View v)
    {
        ((EditText)findViewById(R.id.inputText)).setText("");

        ((TextView)findViewById(R.id.convertedText)).setText("");

        model.setPig("");
    }

    public void speakClick(View v)
    {
        say( ((TextView)findViewById(R.id.convertedText)).getText().toString());
    }

    @Override
    public void onInit(int initStatus)
    {
        if (initStatus != TextToSpeech.ERROR)
        {
            if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
            {
                tts.setLanguage(Locale.US);
            }
        } else
        {
            Toast.makeText(this, "Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

    public void say(String s)
    {
        if (tts != null)
        {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

}
