package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rel_alergias_datos_medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlergiaDatosMedicos extends PanacheEntityBase {

    @EmbeddedId
    private AlergiaDatosMedicosId id;
}
