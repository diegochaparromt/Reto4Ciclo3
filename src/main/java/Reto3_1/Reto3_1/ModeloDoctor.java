
package Reto3_1.Reto3_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class ModeloDoctor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String department;
    private Integer year;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="idSpecialty")
    @JsonIgnoreProperties("doctors")
    private ModeloEspecialidad specialty;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<ModeloMensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<ModeloReservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModeloEspecialidad getSpecialty() {
        return specialty;
    }

    public void setSpecialty(ModeloEspecialidad specialty) {
        this.specialty = specialty;
    }

    public List<ModeloMensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<ModeloMensaje> messages) {
        this.messages = messages;
    }

    public List<ModeloReservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<ModeloReservaciones> reservations) {
        this.reservations = reservations;
    }
    
}
