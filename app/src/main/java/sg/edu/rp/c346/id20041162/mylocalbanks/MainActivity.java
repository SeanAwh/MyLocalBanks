package sg.edu.rp.c346.id20041162.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btnDbs, btnOcbc, btnUob;
    TextView tvDBS, tvOCBC, tvUOB;

    String bankSelected = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.btnDbs);
        btnOcbc = findViewById(R.id.btnOcbc);
        btnUob = findViewById(R.id.btnUob);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == btnDbs){
            bankSelected = "DBS";
        }
        else if(v == btnOcbc){
            bankSelected = "OCBC";
        }
        else if(v == btnUob){
            bankSelected = "UOB";
        }
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Phone");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String bankWebsite = "";
        String bankPhone = "";
        if(bankSelected.equalsIgnoreCase("DBS")){
            bankWebsite = getString(R.string.dbsURL);
            bankPhone = getString(R.string.dbsTel);
        }
        else if(bankSelected.equalsIgnoreCase("OCBC")){
            bankWebsite = getString(R.string.ocbcURL);
            bankPhone = getString(R.string.ocbcTel);
        }
        else if(bankSelected.equalsIgnoreCase("UOB")){
            bankWebsite = getString(R.string.uobURL);
            bankPhone = getString(R.string.uobTel);
        }

        if(item.getItemId()==0){
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(bankWebsite));
            startActivity(intentWeb);
        }
        else if(item.getItemId()==1){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(bankPhone));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.EnglishSelection){
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
        }
        else if(id == R.id.ChineseSelection){
            tvDBS.setText(getString(R.string.dbsChi));
            tvOCBC.setText(getString(R.string.ocbcChi));
            tvUOB.setText(getString(R.string.uobChi));
        }
        return super.onOptionsItemSelected(item);
    }
}