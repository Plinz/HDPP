package lespetitspedestres.hackingdays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dowan on 10/10/15.
 */
public class Client {
    Socket socket;
    private PrintWriter envoi = null;
    private BufferedReader reception = null;

    public Client(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        envoi = new PrintWriter(socket.getOutputStream(), true);
        reception = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


    public void send() throws IOException {

        String message = "coucou";
        envoi.println(message);
    }
}
