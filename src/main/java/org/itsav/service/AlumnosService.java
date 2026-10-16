package org.itsav.service;

import org.itsav.domain.entities.Alumno;
import org.itsav.domain.records.AlumnoResumenDTO;
import org.itsav.domain.records.InfoUsuarioDTO;

import java.util.List;

public interface AlumnosService {

    public Alumno guardar(Alumno alumno);
    public List<Alumno> guardarVarios(List<Alumno> alumnos);
    public List<AlumnoResumenDTO> findAll();
    public List<InfoUsuarioDTO> buscar(String texto);
    public InfoUsuarioDTO findByNumControl(String numControl);
    public Alumno actualizarApellidos(String numControl, String apellidoPaterno, String apellidoMaterno);
    public boolean eliminar(String numControl);
}
