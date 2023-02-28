package com.main.practicaSpring.Controlador;

import com.main.practicaSpring.DAO.DJDao;
import com.main.practicaSpring.modelo.modeloDj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DjControlador {
    @Autowired
    private DJDao djDAO;

    @GetMapping("/listar")
    public List<modeloDj> getDJ(){
        return djDAO.getDj();
    }
    @GetMapping("/buscar")
    public  modeloDj buscar(@PathVariable String nombre){
        for (modeloDj model2:djDAO.getDj()){
            if (model2.getNombre().equalsIgnoreCase(nombre)){
                return model2;
            }
        }
        return null;
    }
    @PutMapping("/editar")
    public void editar( modeloDj modelo2){
        for (modeloDj ejemplo: djDAO.getDj()){
            if (ejemplo.getNombre().equalsIgnoreCase(modelo2.getNombre())){
                ejemplo.setApellido(modelo2.getApellido());
                ejemplo.setGenero(modelo2.getGenero());
            }
        }
    }


}
