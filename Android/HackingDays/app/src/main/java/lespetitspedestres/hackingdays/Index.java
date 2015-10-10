package lespetitspedestres.hackingdays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.net.InetAddress;

public class Index extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
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

    public void doRegister(View view){
        Intent intentr = new Intent(Index.this,Register.class);
        startActivity(intentr);
    }

    public void doLogin(View view){
        try {
            Client test = new Client(InetAddress.getByName("176.31.118.118"), 4242);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intentl = new Intent(Index.this,Login.class);
        startActivity(intentl);
    }
}
