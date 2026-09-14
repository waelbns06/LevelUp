package com.example.levelup.repository;

import java.util.List;

public interface RepositorioDAO<T> {

    void add(T objeto);

    void remove(int id);

    T findById(int id);

    List<T> getList();
}