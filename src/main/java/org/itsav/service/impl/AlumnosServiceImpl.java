package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.itsav.domain.entities.Alumno;
import org.itsav.domain.records.AlumnoResumenDTO;
import org.itsav.domain.records.InfoUsuarioDTO;
import org.itsav.repositories.AlumnosRepository;
import org.itsav.service.AlumnosService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AlumnosServiceImpl implements AlumnosService {

    @Inject
    AlumnosRepository alumnosRepository;

    @Override
    @Transactional
    public Alumno guardar(Alumno alumno) {
        alumno.setNumControl(generarNumControl());
        alumnosRepository.persist(alumno);
        alumnosRepository.flush();
        return alumno;
    }

    @Override
    @Transactional
    public List<Alumno> guardarVarios(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            alumno.setNumControl(generarNumControl());
            alumnosRepository.persist(alumno);
            alumnosRepository.flush();
        }
        return alumnos;
    }

    @Override
    public List<AlumnoResumenDTO> findAll() {
        List<AlumnoResumenDTO> lista = new ArrayList<>();
        for (Alumno alumno : alumnosRepository.list("activo", true)) {
            int edad = Period.between(alumno.getFechaNacimiento(), LocalDate.now()).getYears();
            lista.add(new AlumnoResumenDTO(alumno.getNombre(), edad, alumno.getNumControl()));
        }
        return lista;
    }

    // El número de control nuevo es el más alto que ya existe + 1
    private String generarNumControl() {
        int mayor = 0;
        for (Alumno alumno : alumnosRepository.listAll()) {
            try {
                int numero = Integer.parseInt(alumno.getNumControl());
                if (numero > mayor) {
                    mayor = numero;
                }
            } catch (NumberFormatException e) {
                // si el número de control no es solo dígitos, se ignora
            }
        }
        if (mayor == 0) {
            return "20260001";
        }
        return String.valueOf(mayor + 1);
    }

    // Busca por número de control o por nombre completo
    @Override
    public List<InfoUsuarioDTO> buscar(String texto) {
        List<InfoUsuarioDTO> lista = new ArrayList<>();
        String buscado = texto.trim().toLowerCase();
        for (Alumno alumno : alumnosRepository.list("activo", true)) {
            InfoUsuarioDTO info = aInfoUsuario(alumno);
            if (info.numControl().toLowerCase().contains(buscado)
                    || info.nombreCompleto().toLowerCase().contains(buscado)) {
                lista.add(info);
            }
        }
        return lista;
    }

    private InfoUsuarioDTO aInfoUsuario(Alumno alumno) {
        String nombreCompleto = alumno.getNombre() + " " + alumno.getApellidoPaterno();
        if (alumno.getApellidoMaterno() != null) {
            nombreCompleto = nombreCompleto + " " + alumno.getApellidoMaterno();
        }
        return new InfoUsuarioDTO(alumno.getNumControl(), nombreCompleto);
    }

    @Override
    public InfoUsuarioDTO findByNumControl(String numControl) {
        Alumno alumno = alumnosRepository.findByNumControl(numControl);
        if (alumno == null) {
            return null;
        }
        return aInfoUsuario(alumno);
    }

    @Override
    @Transactional
    public Alumno actualizarApellidos(String numControl, String apellidoPaterno, String apellidoMaterno) {
        Alumno alumno = alumnosRepository.findByNumControl(numControl);
        if (alumno == null) {
            return null;
        }
        alumno.setApellidoPaterno(apellidoPaterno);
        alumno.setApellidoMaterno(apellidoMaterno);
        return alumno;
    }

    @Override
    @Transactional
    public boolean eliminar(String numControl) {
        Alumno alumno = alumnosRepository.findByNumControl(numControl);
        if (alumno == null) {
            return false;
        }
        alumno.setActivo(false);
        return true;
    }
}
