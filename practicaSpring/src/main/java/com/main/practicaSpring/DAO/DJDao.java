package com.main.practicaSpring.DAO;

import com.main.practicaSpring.modelo.modeloDj;

import java.util.List;

public interface DJDao {
    List<modeloDj> getDj();
    List<modeloDj> buscar(String nombre);
    void editar(String nombre);
}
