package corbet.info.iutnc.fr.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void computeAge(View view){
        String nom = ((EditText)findViewById(R.id.nomRemplir)).getText().toString();
        int sex = ((RadioGroup)findViewById(R.id.sexe)).getCheckedRadioButtonId();
        String messSexe ="";
        switch(sex) {
            case R.id.homme: {
                messSexe = "Monsieur";
                break;
            }
            case R.id.femme: {
                messSexe = "Madame";
                break;
            }
        }
        DatePicker dp = (DatePicker) findViewById(R.id.datePicker4);
        int anNaiss = dp.getYear();
        int moiNaiss = dp.getMonth();
        int jourNaiss = dp.getDayOfMonth();


        Calendar auj = Calendar.getInstance();
        int auj_j = auj.get(Calendar.DAY_OF_MONTH);
        int auj_m = auj.get(Calendar.MONTH);
        int auj_a = auj.get(Calendar.YEAR);

        int age = auj_a-anNaiss;
        if(moiNaiss < auj_m)
            age--;
        else
            if(jourNaiss < auj_j)
                age--;
        String an="";
        if(age==1 || age==0)
            an = "an";
        else
            an = "ans";
        String message =messSexe+" "+nom+", vous avez : "+age +"an";

        Intent i = new Intent (this , Activity2.class );
        startActivity(i) ;


        /* Question SNACKBAR
        Snackbar sb = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        sb.show();
        */

       /* QUestion TOAST
            Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
       toast.show();*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
