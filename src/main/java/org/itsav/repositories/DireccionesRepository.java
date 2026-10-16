package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.Direccion;

import java.util.UUID;

@ApplicationScoped
public class DireccionesRepository implements PanacheRepositoryBase<Direccion, UUID> {
}
