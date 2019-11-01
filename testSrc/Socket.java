import java.io.DataInputStream;
import java.io.IOException;

public class Socket {

    public static void main(String[] args){

    }
    private void start() throws IOException {
        java.net.Socket socket = new java.net.Socket("localhost",1335);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        for(int i = 0; i < dataInputStream.readInt(); i++){
            System.out.println(dataInputStream.readUTF());
        }


    }
}
