
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud;

    public List<ModeloCliente> getAll(){
        return (List<ModeloCliente>) crud.findAll();
    }
    public Optional<ModeloCliente> getCliente(int id){
        return crud.findById(id);
    }
    public ModeloCliente save(ModeloCliente client){
        return crud.save(client);
    }  
    public void delete(ModeloCliente client){
        crud.delete(client);
    }  
}
