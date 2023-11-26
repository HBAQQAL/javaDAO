package DAO;

import java.util.List;

public interface DAO<T , ID>{
    public void create(T entity);
    public List<T> getAll( );
    public T getByID(ID id);
    public void updateByID(ID id, T entity);
    public void deleteByID(ID id);
    

}
