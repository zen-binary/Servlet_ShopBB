package com.example.servlet_shopbb.repositories;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T getById(Integer id);
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(T entity);

}
