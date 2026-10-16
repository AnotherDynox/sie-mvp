package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ctl_paises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Long idPais;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "prefijo", nullable = false, length = 5)
    private String prefijo;
}