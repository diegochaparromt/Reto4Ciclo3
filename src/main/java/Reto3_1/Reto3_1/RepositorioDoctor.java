
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class RepositorioDoctor {    
    @Autowired
    private InterfaceDoctor crud;
  
    public List<ModeloDoctor> getAll(){
        return (List<ModeloDoctor>) crud.findAll();
    } 
    public Optional<ModeloDoctor> getDoctor(int id){
        return crud.findById(id);
    } 
    public ModeloDoctor save(ModeloDoctor doctor){
        return crud.save(doctor);
    }    
    public void delete(ModeloDoctor doctor){
        crud.delete(doctor);
    }
}
