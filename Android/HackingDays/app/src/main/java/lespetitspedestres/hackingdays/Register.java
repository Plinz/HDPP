package lespetitspedestres.hackingdays;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {
	private Socket socket;

	private static final int SERVERPORT = 4242;
	private static final String SERVER_IP = "176.31.118.118";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new Thread(new ClientThread()).start();
		setContentView(R.layout.activity_register);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_register, menu);
		return true;
	}

	@Override
	public void onPause() {
		super.onPause();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doRegister(View view) {
		try {
			String str = "RGTR:";

			TextView adresse = null;
			adresse = (TextView) findViewById(R.id.adresse);

			str += adresse.getText() + "" + ",";

			TextView ville = null;
			ville = (TextView) findViewById(R.id.ville);
			str += ville.getText() + "" + ",";

			TextView pays = null;
			pays = (TextView) findViewById(R.id.pays);
			str += pays.getText() + "" + ",";

			TextView code_postal = null;
			code_postal = (TextView) findViewById(R.id.code_postal);
			str += code_postal.getText() + "" + "|";
			TextView email = null;
			email = (TextView) findViewById(R.id.email);
			str += email.getText() + "" + "|";
			TextView nom = null;
			nom = (TextView) findViewById(R.id.nom);
			str += nom.getText() + "" + "|";
			TextView prenom = null;
			prenom = (TextView) findViewById(R.id.prenom);
			str += prenom.getText() + "" + "|";
			TextView age = null;
			age = (TextView) findViewById(R.id.age);
			str += age.getText() + "" + "|";
			TextView pass = null;
			pass = (TextView) findViewById(R.id.pass);
			str += pass.getText() + "";
			
			
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			out.println(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.ll
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	class ClientThread implements Runnable {

		@Override
		public void run() {
			try {
				InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
				socket = new Socket(serverAddr, SERVERPORT);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
 
}
