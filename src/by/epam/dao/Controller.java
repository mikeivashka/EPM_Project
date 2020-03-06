package by.epam.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Controller<E, K>{
    static Logger log = LogManager.getLogger();
    protected ObjectInputStream inputStream;
    protected ObjectOutputStream outputStream;
    protected List<E> data;



    public void save() throws IOException{
        outputStream.writeObject(data);
        log.info(data.size() + getClass().getName() + "objects saved successfully");
        outputStream.close();
    }

    public void load() throws ClassNotFoundException, IOException, ClassCastException{
        data = (ArrayList<E>) inputStream.readObject();
        log.info(data.size() + " " + getClass().getName() + "objects loaded successfully");
        inputStream.close();
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
                log.info(id + "object removed successfuly");
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
        try (FileOutputStream ostream = new FileOutputStream(dir);
             FileInputStream istream = new FileInputStream(dir)){
            inputStream = new ObjectInputStream(istream);
            outputStream = new ObjectOutputStream(ostream);
        }
        catch (FileNotFoundException e){
            log.error(e.getStackTrace());
        }
        catch (IOException e){
            log.error(e.getStackTrace());
        }
    }

    public List<E> getAll(){
        return data;
    }
}
