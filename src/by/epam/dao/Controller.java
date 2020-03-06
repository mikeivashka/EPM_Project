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
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ArrayList<E> data;

    public void save(){
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(getDir()));
            outputStream.writeObject(data);
            log.info(data.size() + "objects SAVED successfully");
            outputStream.close();
        }
        catch (IOException e){
            log.error(e);
        }
    }

    public void load(){
        try{
            inputStream = new ObjectInputStream(new FileInputStream(getDir()));
            log.info(inputStream);
            data = (ArrayList<E>)inputStream.readObject();
            log.info(data.size()+ "\n" + data.size() + " objects LOADED successfully");
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
        for(int i=0;i<data.size()-1; i++){
            if(data.get(i).hashCode() == entity.hashCode()){
                 data.set(i, entity);
                log.info(data.get(i) + "\nUPDATE SUCCESS" );
            }
        }
        log.error("UPDATE Failed, missing object to update");
        return entity;
    }

    public  E getEntityByKey(K key){
        try {
            for(E obj : data) {
                if (obj.hashCode() == key.hashCode()) return obj;
            }
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            log.error("OBJECT NOT FOUND EXCEPTION");
        }
        return data.get(0);
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

    public  void create(E entity){
        data.add(entity);
        log.info(entity + " added");
    }

    public ArrayList<E> getAll(){
        return data;
    }

    public abstract String getDir();
}
