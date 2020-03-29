package by.epam.services;

import by.epam.dao.Dao;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Service <E extends Entity, KEY, DAO extends Dao<E>> {
    static Logger log = LogManager.getLogger();
    protected ArrayList <E> data;
    protected DAO dao;

    public Service(){
        this.data = dao.load();
    }

    public  E getEntityByKey(KEY key){
        return getEntityByHash(key.hashCode());
    }

    public E getEntityByHash(int hash){
        try {
            for(E obj : data) {
                if (obj.hashCode() == hash) return obj;
            }
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            log.error("OBJECT NOT FOUND EXCEPTION");
        }
        return data.get(0);
    }

    protected Integer getIndexByHash(int hash) {
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i).hashCode() == hash) return i;
        }
        return -1;
    }

    protected Integer getIndexByKey(KEY key){
        return getIndexByHash(key.hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dao.save(data);
    }

    public boolean add(E ob){
        return data.add(ob);
    }

    public ArrayList<E> getAll(){
        return data;
    }

    public boolean update(E entity){
        Integer index = getIndexByHash(entity.hashCode());
        if(index != -1){
            data.set(index, entity);
            return true;
        }
        return false;
    }

    public boolean delete(KEY key){
        Integer index = getIndexByKey(key);
        if(index != -1){
            data.remove(index);
            return true;
        }
        return false;
    }
}
