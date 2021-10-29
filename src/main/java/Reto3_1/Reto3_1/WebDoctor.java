
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
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebDoctor {
    @Autowired
    private ServiciosDoctor servicios;
    @GetMapping("/all")
    public List<ModeloDoctor> getDoctors(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ModeloDoctor> getDoctor(@PathVariable("id") int idDoctor){
        return servicios.getDoctor(idDoctor);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloDoctor save (@RequestBody ModeloDoctor doctor){
        return servicios.save(doctor);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloDoctor update(@RequestBody ModeloDoctor doctor) {
        return servicios.update(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId) {
        return servicios.deleteDoctor(doctorId);
    } 
    
}
