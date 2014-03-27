package com.msz.dao;

import java.io.Serializable;

public interface IGenericDAO<T, PK extends Serializable> {
    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
}