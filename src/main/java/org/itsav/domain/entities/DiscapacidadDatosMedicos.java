package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rel_discapacidades_datos_medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscapacidadDatosMedicos extends PanacheEntityBase {

    @EmbeddedId
    private DiscapacidadDatosMedicosId id;
}
