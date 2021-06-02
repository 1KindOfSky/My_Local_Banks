package sg.edu.rp.c346.id20029443.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText1;
    TextView tvTranslatedText2;
    TextView tvTranslatedText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText1 = findViewById(R.id.DBS);
        tvTranslatedText2 = findViewById(R.id.OCBC);
        tvTranslatedText3 = findViewById(R.id.UOB);

        registerForContextMenu(tvTranslatedText1);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);
    }
    String wordClicked = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");

        if (v == tvTranslatedText1) {
            wordClicked = "dbs";
        }
        else if (v == tvTranslatedText2) {
            wordClicked = "ocbc";
        }
        else if (v == tvTranslatedText3) {
            wordClicked = "uob";
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu. menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText1.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvTranslatedText1.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText3.setText("大华银行");
            return true;
        } else {
            tvTranslatedText1.setText("Error translation");
            tvTranslatedText2.setText("Error translation");
            tvTranslatedText3.setText("Error translation");
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) {
            if (wordClicked == "dbs") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com/default.page"));
                startActivity(intentWeb);
            }
            else if (wordClicked == "ocbc") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking"));
                startActivity(intentWeb);
            }
            else if (wordClicked == "uob") {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intentWeb);
            }

        }

        else if(item.getItemId() == 1) {
            if (wordClicked == "dbs") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 111 1111"));
                startActivity(intentCall);
            }

            else if (wordClicked == "ocbc") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 363 3333"));
                startActivity(intentCall);
            }

            else if (wordClicked == "uob") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 222 2121"));
                startActivity(intentCall);
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}