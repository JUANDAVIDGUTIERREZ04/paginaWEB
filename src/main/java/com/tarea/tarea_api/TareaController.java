package com.tarea.tarea_api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    TareaService tareaService;

    // Obtener todas las tareas
    @GetMapping("/todas")
    public ArrayList<TareaModel> obtenerTareas() {
        return tareaService.ObtenerTareas();
    }

    // Guardar una tarea
    @PostMapping()
    public TareaModel guardarTarea(@RequestBody TareaModel tarea) {
        return tareaService.guardarTarea(tarea);
    }

    // Obtener una tarea por ID
    @GetMapping(path = "/{id}")
    public Optional<TareaModel> obtenerTareaPorId(@PathVariable("id") Long id) {
        return this.tareaService.obtenerTareaPorId(id);
    }
    
    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public String eliminarTareaId(@PathVariable("id") Long id) {
        boolean ok = this.tareaService.eliminarTarea(id);
        if (ok) {
            return " se elimino el usuario con el Id:"+id;
            
        } else {
            return "no se pudo eliminar el usuario con el Id:"+ id;
        }
    }
}
