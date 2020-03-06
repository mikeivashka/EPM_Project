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
    }
    public void load() throws ClassNotFoundException, IOException, ClassCastException{
        data = (ArrayList<E>) inputStream.readObject();
        log.info(data.size() + " " + getClass().getName() + "objects loaded successfully");
    }

    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract void create(E entity);
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
}
