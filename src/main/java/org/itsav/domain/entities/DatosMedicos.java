package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tbl_datos_medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosMedicos extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_dato_medico")
    private UUID idDatoMedico;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Column(name = "alumno")
    private UUID alumno;
}
