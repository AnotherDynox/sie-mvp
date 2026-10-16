package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.Ciudad;


@ApplicationScoped
public class CiudadesRepository implements PanacheRepositoryBase<Ciudad, Long> {
}
