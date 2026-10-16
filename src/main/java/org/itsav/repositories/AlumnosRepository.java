package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.Alumno;

import java.util.UUID;


@ApplicationScoped
public class AlumnosRepository implements PanacheRepositoryBase<Alumno, UUID> {

    public Alumno findByNumControl(String numControl) {
        return find("numControl = ?1 and activo = true", numControl).firstResult();
    }
}
