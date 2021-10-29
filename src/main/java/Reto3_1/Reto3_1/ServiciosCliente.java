
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;
     
    public List<ModeloCliente> getAll(){
        return metodosCrud.getAll();
    }
     
    public Optional<ModeloCliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public ModeloCliente save(ModeloCliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<ModeloCliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public ModeloCliente update(ModeloCliente client){
        if(client.getIdClient()!=null){
            Optional<ModeloCliente> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
