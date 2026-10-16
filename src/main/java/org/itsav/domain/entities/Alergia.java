package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ctl_alergias")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia")
    private Integer idAlergia;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    public Alergia(Integer idAlergia, String descripcion, String nombre) {
        this.idAlergia = idAlergia;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alergia() {


    }
}