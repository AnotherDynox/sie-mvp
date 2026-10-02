package org.itsav.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscapacidadDatosMedicosId implements Serializable {

    @Column(name = "discapacidad")
    private Integer discapacidad;

    @Column(name = "dato_medico")
    private UUID datoMedico;
}