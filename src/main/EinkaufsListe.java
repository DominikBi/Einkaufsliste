package main;

import java.io.*;
import java.util.ArrayList;

public class EinkaufsListe {

    ArrayList<Item> list;

    public ArrayList<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }
    public EinkaufsListe(){
        list = new ArrayList<>();
    }
    public void saveList(){
        File file = new File("C:\\Users\\birke\\OneDrive\\Desktop\\EinkauftlisteData");
        try {
            DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
            assert (list != null);
            fos.writeInt(list.size());
                for (Item item : list){
                    fos.writeUTF(item.getName());
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updateList(){
        File file = new File("C:\\Users\\birke\\OneDrive\\Dokumente\\EinkauftlisteData");
        list.clear();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            for(int i = 0; i<dis.readInt();i++){
                list.add(new Item(dis.readUTF()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
