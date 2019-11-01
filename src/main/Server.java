package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    EinkaufsListe einkaufsListe;

    public Server(){
        einkaufsListe = new EinkaufsListe();
        einkaufsListe.updateList();
        try {
            ServerSocket serverSocket = new ServerSocket(1335);
            while (true){
                Socket client = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeInt(einkaufsListe.getList().size());
                for(Item item : einkaufsListe.getList()){
                    dos.writeUTF(item.getName());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
