package ca.roumani.stocktrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // find out what string arrays are present in the resources.
        Field[] fields = R.array.class.getFields();
        LinearLayout area = (LinearLayout) findViewById(R.id.area);

        for(int i = 1; i < fields.length; i++)
        {
            TextView text = new TextView(this);
            text.setText(fields[i].getName());
            area.addView(text);
        }
    }

    public void doneButton(View v)
    {
        this.finish();
    }
}
