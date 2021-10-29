
package Reto3_1.Reto3_1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosDoctor {
    @Autowired
    private RepositorioDoctor metodosCrud;

    public List<ModeloDoctor> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModeloDoctor> getDoctor(int idDoctor) {
        return metodosCrud.getDoctor(idDoctor);
    }

    public ModeloDoctor save(ModeloDoctor doctor){
        if(doctor.getId()==null){
            return metodosCrud.save(doctor);
        }else{
            Optional<ModeloDoctor> e=metodosCrud.getDoctor(doctor.getId());
            if(e.isEmpty()){
                return metodosCrud.save(doctor);
            }else{
                return doctor;
            }
        }
    }

    public ModeloDoctor update(ModeloDoctor doctor){
        if(doctor.getId()!=null){
            Optional<ModeloDoctor> e=metodosCrud.getDoctor(doctor.getId());
            if(!e.isEmpty()){
                if(doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    e.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    e.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }

    public boolean deleteDoctor(int doctorId) {
        Boolean aBoolean = getDoctor(doctorId).map(doctor -> {
            metodosCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
