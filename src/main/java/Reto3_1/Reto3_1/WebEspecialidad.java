
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebEspecialidad {  
    @Autowired
    private ServiciosEspecialidad servicios;
    @GetMapping("/all")
    public List<ModeloEspecialidad> getSpecialty(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ModeloEspecialidad> getSpecialty(@PathVariable("id") int idSpecialty){
        return servicios.getSpecialty(idSpecialty);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloEspecialidad save (@RequestBody ModeloEspecialidad specialty){
        return servicios.save(specialty);
    }   
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloEspecialidad update(@RequestBody ModeloEspecialidad specialty) {
        return servicios.update(specialty);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int specialtyId) {
        return servicios.deletespecialty(specialtyId);
    }     
    
}
