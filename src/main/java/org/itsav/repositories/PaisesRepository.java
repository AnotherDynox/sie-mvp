package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.Pais;


@ApplicationScoped
public class PaisesRepository implements PanacheRepositoryBase<Pais, Long> {
}
