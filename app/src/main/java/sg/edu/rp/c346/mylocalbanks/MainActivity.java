package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tv1);
        tvOCBC = findViewById(R.id.tv2);
        tvUOB = findViewById(R.id.tv3);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);


        int id = v.getId();
        if (id == R.id.tv1) {
            type = "DBS";
        } else if (id == R.id.tv2) {
            type = "OCBC";
        } else {
            type = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.webSelection) {
            webSelection(type);
        } else {
            phoneSelection(type);
        }
        return super.onContextItemSelected(item);
    }

    public void webSelection(String type) {
        String url = "";

        if (type.equals("DBS")) {
            url = "https://www.dbs.com.sg";
        } else if (type.equals("OCBC")) {
            url = "https://www.ocbc.com";
        } else {
            url = "https://www.uob.com.sg";
        }

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);

    }

    public void phoneSelection(String type) {
        String phone = "tel:";

        if (type.equals("DBS")) {
            phone += "18001111111";
        } else if (type.equals("OCBC")) {
            phone += "18003633333";
        } else {
            phone += "18002222121";
        }

        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
        startActivity(i);

    }

}
