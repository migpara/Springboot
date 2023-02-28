package com.main.practicaSpring.DAO;

import com.main.practicaSpring.modelo.modeloDj;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DjDaoImp implements DJDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<modeloDj> getDj() {
        String query ="FROM modeloDj";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<modeloDj> buscar(String nombre) {
        String query="SELECT * FROM `db_dj` WHERE `nombre`LIKE "+nombre;
        return entityManager.createQuery(query).getResultList();
    }
    public void editar(String nombre){

    }




}
