package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rel_alumnos_direcciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDireccion extends PanacheEntityBase {

    @EmbeddedId
    private AlumnoDireccionId id;
}
