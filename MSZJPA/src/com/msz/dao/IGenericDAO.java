package com.msz.dao;

import java.io.Serializable;

public interface IGenericDAO<T, PK extends Serializable> {
    T create(T t);
    T findByID(PK id);
    T update(T t);
    boolean delete(T t);
}