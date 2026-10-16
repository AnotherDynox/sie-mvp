package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tbl_direcciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_direccion")
    private UUID idDireccion;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero_ext")
    private String numeroExt;

    @Column(name = "numero_int")
    private String numeroInt;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "cp")
    private String cp;

    @Column(name = "ciudad")
    private Long ciudad;
}
