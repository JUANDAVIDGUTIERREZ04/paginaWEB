package com.tarea.tarea_api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {

    @Autowired
    TareaRepository tareaRepository;

    // Obtener todas las tareas
    public ArrayList<TareaModel> ObtenerTareas() {
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    // Guardar o actualizar una tarea
    public TareaModel guardarTarea(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

    // Obtener una tarea por su ID
    public Optional<TareaModel> obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    

    // Eliminar una tarea por su ID
    public boolean eliminarTarea(Long id) {
        try {
            tareaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
            
        }
    }
}
