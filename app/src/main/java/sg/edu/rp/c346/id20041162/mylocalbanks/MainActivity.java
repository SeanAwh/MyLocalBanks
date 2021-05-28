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

public class MainActivity extends AppCompatActivity {

    Button btnDbs, btnOcbc, btnUob;

    String bankSelected = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.btnDbs);
        btnOcbc = findViewById(R.id.btnOcbc);
        btnUob = findViewById(R.id.btnUob);

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
            bankWebsite = "https://www.dbs.com.sg";
            bankPhone = "tel:18001111111";
        }
        else if(bankSelected.equalsIgnoreCase("OCBC")){
            bankWebsite = "https://www.ocbc.com";
            bankPhone = "tel:18003633333";
        }
        else if(bankSelected.equalsIgnoreCase("UOB")){
            bankWebsite = "https://www.uob.com.sg";
            bankPhone = "tel:18002222121";
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
            btnDbs.setText("DBS");
            btnOcbc.setText("OCBC");
            btnUob.setText("UOB");
        }
        else if(id == R.id.ChineseSelection){
            btnDbs.setText("星展银行");
            btnOcbc.setText("华侨银行");
            btnUob.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}