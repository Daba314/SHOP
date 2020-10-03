package DAO.Interfaces;

import java.util.List;

public interface DAO<T> {

        int insert(T entity);

        T get(int id);

        List<T> getAll();

        int update(T entity);

        int delete(int id);

}
