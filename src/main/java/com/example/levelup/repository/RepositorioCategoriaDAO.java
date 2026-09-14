package com.example.levelup.repository;

import com.example.levelup.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCategoriaDAO implements RepositorioDAO<Categoria> {

    @Override
    public void add(Categoria objeto) {
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public Categoria findById(int id) {
        return null;
    }

    @Override
    public List<Categoria> getList() {
        return new ArrayList<>();
    }
}