
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud3;
    
    public List<ModeloMensaje> getAll(){
        return (List<ModeloMensaje>) crud3.findAll();
    }
    public Optional<ModeloMensaje> getMessage(int id){
        return crud3.findById(id);
    }
    public ModeloMensaje save(ModeloMensaje message){
        return crud3.save(message);
    }
    public void delete(ModeloMensaje message){
        crud3.delete(message);
    }
    
}
