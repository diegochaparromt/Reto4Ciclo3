
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository 
public class RepositorioEspecialidad {
    @Autowired
    private InterfaceEspecialidad crud;  
    
    public List<ModeloEspecialidad> getAll(){
        return (List<ModeloEspecialidad>) crud.findAll();
    } 
    public Optional<ModeloEspecialidad> getSpecialty(int id){
        return crud.findById(id);
    } 
    public ModeloEspecialidad save(ModeloEspecialidad specialty){
        return crud.save(specialty);
    }     
    public void delete(ModeloEspecialidad specialty){
        crud.delete(specialty);
    }
}
