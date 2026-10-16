package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ctl_estados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "pais", nullable = false)
    private Long pais;
}