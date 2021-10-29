package Reto4.Reto4.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Se importa la clase Entity
 */
@Entity
/**
 * Se importa la Clase Table
 */
@Table(name = "boat")
/**
 * Author Antonio Palacio
 * Reto 3 del Ciclo 3 Desarrolo de Sofware
 * Se crea la Clase Principal Barcos
 */
public class Barcos implements Serializable{
    /**
     * Se importa la Clase Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Se crea el atributo id en la entidad boat
     */
    private Integer id;
    /**
     * Se crea el atributo name en la entidad boat
     */
    @Column(length = 45)
    private String name;
    /**
     * Se crea el atributo brand en la entidad boat
     */
    @Column(length = 45)
    private String brand;
    /**
     * Se crea el atributo year en la entidad boat
     */
    private Integer year;
    /**
     * Se crea el attributo description en la entidad boat
     */
    @Column(length = 250)
    private String description;
    /**
     * Se crea la relacion de entidades de muchos a uno entre las
     * entidades boat y category
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boat")
    private Categoria category;
    /**
     * Se crea la relacion de entidades de uno a muchos entre las
     * entidades boat y message
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Mensaje> messages;
    /**
     * Se crea la relacion de entidades de uno a muchos entre las
     * entidades boat y reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Reservaciones> reservations;

    /**
     * Se crea el getter del atributo id de la entidad boat
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Se crea el setter del atributo id de la entidad boat
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Se crea el getter del atributo name de la entidad boat
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Se crea el setter del atributo name de la entidad boat
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Se crea el getter del atributo brand de la entidad boat
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Se crea el setter del atributo brand de la entidad boat
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Se crea el getter del atributo year de la entidad boat
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Se crea el setter del atributo year de la entidad boat
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Se crea el getter del atributo description de la entidad boat
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Se crea el setter del atributo description de la entidad boat
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Se crea el getter del atributo category en la relacion
     * entre boat y category
     * @return
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Se crea el setter de la entidad category en la relacion
     * entre boat y category
     * @param category
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Se crea el getter de la entidad message en la relacion
     * entre boat y message
     * @return
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     * Se crea el setter de la entidad message en la relacion
     * entre boat y message
     * @param messages
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /**
     * Se crea el getter de la entidad reservations en la relacion
     * entre boat y reservations
     * @return
     */
    public List<Reservaciones> getReservations() {
        return reservations;
    }

    /**
     * Se crea el setter de la entidad reservations en la relacion
     * entre boat y reservations
     * @param reservations
     */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
