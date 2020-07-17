package cl.prezdev.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IO {
    public static void writeObject(Object object, File file) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        
        objectOutputStream.close();
        fileOutputStream.close();
    }
    
    public static <T> T readObject(File file, Class<T> _class) throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T t = (T) objectInputStream.readObject();
        
        objectInputStream.close();
        fileInputStream.close();
        
        return t;
    }
}
