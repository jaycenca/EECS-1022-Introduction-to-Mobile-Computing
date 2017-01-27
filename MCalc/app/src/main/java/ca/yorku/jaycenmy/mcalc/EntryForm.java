package ca.roumani.mcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import hr.YumModel;

public class EntryForm extends AppCompatActivity
{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void buttonClicked(View v)
    {

        String p = ((EditText) findViewById(R.id.principleBox)).getText().toString();
        String n = ((EditText) findViewById(R.id.amortBox)).getText().toString();
        String r = ((EditText) findViewById(R.id.interestBox)).getText().toString();


        MortgageModel model = new MortgageModel(p, n, r);
        String answer = "$"+model.getPayment();

        ((TextView) findViewById(R.id.answer)).setText(answer);

    }

    public void YumbuttonCicked(View v)
    {
        System.out.println("start");
        String p = ((EditText) findViewById(R.id.principleBox)).getText().toString();
        String n = ((EditText) findViewById(R.id.amortBox)).getText().toString();
        String r = ((EditText) findViewById(R.id.interestBox)).getText().toString();

        YumModel model = new YumModel();

        model.setPrinciple(p);
        model.setAmortization(n);
        model.setInterest(r);

        /*System.out.println("principle is "+model.);
        System.out.println("amort is "+n);
        System.out.println("interest is "+r);*/

        String answer = model.computePayment();
        ((TextView) findViewById(R.id.yumans)).setText(answer);
    }

}
