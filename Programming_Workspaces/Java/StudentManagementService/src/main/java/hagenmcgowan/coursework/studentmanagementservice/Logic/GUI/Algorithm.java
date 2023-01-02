package hagenmcgowan.coursework.studentmanagementservice.Logic.GUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Algorithm implements Serializable{
    private String filename;
    public Algorithm(String pFilename) {
        this.filename = pFilename;
    }

    private String getFilename() {
        return filename;
    }

    public void serialise(String choice){
        DataHolder object = new DataHolder(choice);

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(getFilename());
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException e) {
            System.out.println("The IOException has been caught.");
        }
    }

    public String deserialise() {
        DataHolder object1 = null;

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(getFilename());
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (DataHolder)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            return object1.choice;
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            return "";
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            return "";
        }
    }

}
