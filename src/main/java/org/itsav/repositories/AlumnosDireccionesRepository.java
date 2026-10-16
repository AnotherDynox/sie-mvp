package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.AlumnoDireccion;
import org.itsav.domain.entities.AlumnoDireccionId;

@ApplicationScoped
public class AlumnosDireccionesRepository implements PanacheRepositoryBase<AlumnoDireccion, AlumnoDireccionId> {
}
