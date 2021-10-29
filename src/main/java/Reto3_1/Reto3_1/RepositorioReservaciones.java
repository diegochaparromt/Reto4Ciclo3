
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;

    public List<ModeloReservaciones> getAll(){
        return (List<ModeloReservaciones>) crud4.findAll();
    }
    public Optional<ModeloReservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public ModeloReservaciones save(ModeloReservaciones reservation){
        return crud4.save(reservation);
    }   
    public void delete(ModeloReservaciones reservation){
        crud4.delete(reservation);
    } 
}
