package by.epam.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class Controller<E, K>{
    {
        data = new ArrayList<E>();
    }
    static Logger log = LogManager.getLogger();
    protected ObjectInputStream inputStream;
    protected ObjectOutputStream outputStream;
    protected ArrayList<E> data;

    public void save(){
        try{
            outputStream.writeObject(data);
            log.info(data.size() + "objects saved successfully");
            outputStream.close();
        }
        catch (IOException e){
            log.error(e);
        }
    }

    public void load(){
        try{
        log.info(inputStream);
        data = (ArrayList<E>)inputStream.readObject();
        log.info(data.size() + " " + getClass().getName() +" "+ data.size() + " objects loaded successfully");
        inputStream.close();
        }
        catch (IOException e){
            log.error(e);
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            log.error(e);
        }

    }

    public  E update(E entity){
        for(E obj: data){
            if(obj.hashCode() == entity.hashCode())obj = entity;
            log.info(entity + " successfully updated" );
            return obj;
        }
        return null;
    }

    public  E getEntityByKey(K key){
        for(E obj : data){
            if(obj.hashCode() == key.hashCode())return obj;
        }
        return null;
    }

    public  boolean delete(K id){
        for(int i=0;i<data.size();i++) {
            if (data.get(i).hashCode() == id.hashCode()) {
                data.remove(i);
                log.info(id + "object removed successfully");
                return true;
            }
        }
        return false;
    }

    public  void create(E entity) throws IllegalArgumentException{
        for(E obj : data){
            if(obj.hashCode() == entity.hashCode())throw new IllegalArgumentException();
        }
        data.add(entity);
        log.info(entity + " successfully added");

    }

    protected void initialize(String dir) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(dir));
            inputStream = new ObjectInputStream(new FileInputStream(dir));
        }
        catch (FileNotFoundException e){
            log.error(e);
            e.printStackTrace();
        }
        catch (IOException e){
            log.error(e);
            e.printStackTrace();
        }
    }

    public ArrayList<E> getAll(){
        return data;
    }
}
