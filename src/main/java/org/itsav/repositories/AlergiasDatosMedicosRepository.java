package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.AlergiaDatosMedicos;
import org.itsav.domain.entities.AlergiaDatosMedicosId;

@ApplicationScoped
public class AlergiasDatosMedicosRepository implements PanacheRepositoryBase<AlergiaDatosMedicos, AlergiaDatosMedicosId> {
}
