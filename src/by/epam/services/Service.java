package by.epam.services;

import by.epam.dao.Dao;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Service <E extends Entity, KEY, DAO extends Dao<E>> {
    protected static Logger log = LogManager.getLogger();
    protected ArrayList <E> data;
    protected DAO dao;

    public  E getEntityByKey(KEY key){
        return getEntityByHash(key.hashCode());
    }

    public E getEntityByHash(int hash) throws  IllegalArgumentException{
        for(E obj : data) {
            if (obj.hashCode() == hash) return obj;
        }
        log.error("OBJECT NOT FOUND EXCEPTION");
        throw new IllegalArgumentException();
    }

    protected Integer getIndexByHash(int hash) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).hashCode() == hash) return i;
        }
        return -1;
    }

    protected Integer getIndexByKey(KEY key){
        return getIndexByHash(key.hashCode());
    }

    public boolean add(E ob){
        try{
            if(getIndexByHash(ob.hashCode()) != -1)return data.add(ob);
            else return false;
        }catch (NullPointerException e){
            log.error(e);
            return false;
        }finally {
            dao.save(data);
        }
    }

    public ArrayList<E> getAll(){
        return data;
    }

    public boolean update(E entity){
        int index = getIndexByHash(entity.hashCode());
        if(index != -1){
            data.set(index, entity);
            dao.save(data);
            return true;
        }
        return false;
    }

    public boolean delete(KEY key){
        int index = getIndexByKey(key);
        if(index != -1){
            data.remove(index);
            dao.save(data);
            return true;
        }
        return false;
    }
}
