package by.epam.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class Dao<E>{

    static Logger log = LogManager.getLogger();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public void save(ArrayList<E> data){
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(getDir()));
            outputStream.writeObject(data);
            log.info(data.size() + " objects SAVED successfully");
        }
        catch (IOException e){
            log.error(e);
        }
        finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<E> load(){
        try{
            inputStream = new ObjectInputStream(new FileInputStream(getDir()));
            log.info(inputStream);
            ArrayList <E> data = (ArrayList<E>)inputStream.readObject();
            log.info( data.size() + " objects LOADED successfully");
            return  data;
        }
        catch (IOException e){
            log.error(e);
        }
        catch (ClassNotFoundException e){
            log.error(e);
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract String getDir();
}
