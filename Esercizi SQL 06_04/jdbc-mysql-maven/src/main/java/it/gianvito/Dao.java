package it.gianvito;

import java.util.List;

public interface Dao<T> {
    public int count();
    public List<T> getData();
    public T getOne(Integer id);
    public boolean insert(T model);
    public boolean update(Integer id, T model);
    public boolean delete(Integer id);
}
