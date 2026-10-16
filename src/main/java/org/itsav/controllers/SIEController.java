package org.itsav.controllers;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.itsav.domain.entities.AlergiaDatosMedicos;
import org.itsav.domain.entities.Alumno;
import org.itsav.domain.entities.AlumnoDireccion;
import org.itsav.domain.entities.Ciudad;
import org.itsav.domain.entities.DatosMedicos;
import org.itsav.domain.entities.Direccion;
import org.itsav.domain.entities.DiscapacidadDatosMedicos;
import org.itsav.domain.entities.DiscapacidadMedica;
import org.itsav.domain.entities.Estado;
import org.itsav.domain.entities.Pais;
import org.itsav.domain.records.AlumnoResumenDTO;
import org.itsav.service.AlergiasDatosMedicosService;
import org.itsav.service.AlergiasService;
import org.itsav.service.AlumnosDireccionesService;
import org.itsav.service.AlumnosService;
import org.itsav.service.CiudadesService;
import org.itsav.service.DatosMedicosService;
import org.itsav.service.DireccionesService;
import org.itsav.service.DiscapacidadesDatosMedicosService;
import org.itsav.service.DiscapacidadesMedicasService;
import org.itsav.service.EstadosService;
import org.itsav.service.PaisesService;
import org.itsav.service.UsuariosService;

@Path("/api")
public class SIEController {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/lista-tec")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listaNombres () {
        List<String> nombres = new ArrayList<>();
        nombres.add("Quarks");
        nombres.add("Angular");
        nombres.add("Spring");
        nombres.add("MySQL");
        return nombres;
    }

    @Inject
    UsuariosService usuariosService;

    @GET
    @Path("/lista-alumnos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaAlumnos(){
        var ListaUsuarios = usuariosService.getInfoUsuarios();
        return Response.ok(ListaUsuarios).build();
    }

    @Inject
    AlergiasService alergiasService;

    @GET
    @Path("/obtener_Alergias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerAlergias(){
        return Response.ok(alergiasService.findAll()).build();

    }

    @Inject
    EstadosService estadosService;

    @GET
    @Path("/estados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> getEstados() {
        return estadosService.findAll();
    }

    @Inject
    CiudadesService ciudadesService;

    @GET
    @Path("/ciudades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> getCiudades() {
        return ciudadesService.findAll();
    }

    @Inject
    PaisesService paisesService;

    @GET
    @Path("/paises")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> getPaises() {
        return paisesService.findAll();
    }

    @Inject
    DiscapacidadesMedicasService discapacidadesMedicasService;

    @GET
    @Path("/discapacidades-medicas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiscapacidadMedica> getDiscapacidadesMedicas() {
        return discapacidadesMedicasService.findAll();
    }

    @Inject
    AlergiasDatosMedicosService alergiasDatosMedicosService;

    @GET
    @Path("/alergias-datos-medicos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlergiaDatosMedicos> getAlergiasDatosMedicos() {
        return alergiasDatosMedicosService.findAll();
    }

    @Inject
    AlumnosDireccionesService alumnosDireccionesService;

    @GET
    @Path("/alumnos-direcciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlumnoDireccion> getAlumnosDirecciones() {
        return alumnosDireccionesService.findAll();
    }

    @Inject
    DatosMedicosService datosMedicosService;

    @GET
    @Path("/datos-medicos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatosMedicos> getDatosMedicos() {
        return datosMedicosService.findAll();
    }

    @Inject
    DireccionesService direccionesService;

    @GET
    @Path("/direcciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Direccion> getDirecciones() {
        return direccionesService.findAll();
    }

    @Inject
    DiscapacidadesDatosMedicosService discapacidadesDatosMedicosService;

    @GET
    @Path("/discapacidades-datos-medicos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiscapacidadDatosMedicos> getDiscapacidadesDatosMedicos() {
        return discapacidadesDatosMedicosService.findAll();
    }

    @Inject
    AlumnosService alumnosService;

    @GET
    @Path("/alumnos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlumnoResumenDTO> getAlumnos() {
        return alumnosService.findAll();
    }

    @GET
    @Path("/alumnos/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarAlumnos(@QueryParam("q") String q) {
        if (q == null || q.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Escribe un número de control o un nombre para buscar").build();
        }
        return Response.ok(alumnosService.buscar(q)).build();
    }

    @GET
    @Path("/alumnos/{numControl}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumno(@PathParam("numControl") String numControl) {
        var alumno = alumnosService.findByNumControl(numControl);
        if (alumno == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(alumno).build();
    }

    private String validarAlumno(Alumno alumno) {
        if (alumno.getCurp() == null || !alumno.getCurp().matches("[A-Z]{4}[0-9]{6}[HM][A-Z]{5}[A-Z0-9][0-9]")) {
            return "CURP inválida: deben ser 18 caracteres con el formato oficial";
        }
        if (alumno.getNumTelefonoMovil() == null || !alumno.getNumTelefonoMovil().matches("[0-9]{10}")) {
            return "Teléfono móvil inválido: deben ser 10 dígitos";
        }
        if (alumno.getContactoTutor() == null || !alumno.getContactoTutor().matches("[0-9]{10}")) {
            return "Contacto del tutor inválido: deben ser 10 dígitos";
        }
        return null;
    }

    @POST
    @Path("/alumnos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarAlumno(Alumno alumno) {
        String error = validarAlumno(alumno);
        if (error != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
        try {
            return Response.status(Response.Status.CREATED).entity(alumnosService.guardar(alumno)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("No se pudo guardar: revisa que no falten datos y que la CURP no esté repetida").build();
        }
    }

    @POST
    @Path("/alumnos/varios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            String error = validarAlumno(alumno);
            if (error != null) {
                return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
            }
        }
        try {
            return Response.status(Response.Status.CREATED).entity(alumnosService.guardarVarios(alumnos)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("No se pudo guardar: revisa que no falten datos y que la CURP no esté repetida").build();
        }
    }

    @PUT
    @Path("/alumnos/{numControl}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarApellidos(@PathParam("numControl") String numControl, Alumno apellidos) {
        if (apellidos.getApellidoPaterno() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El apellido paterno es obligatorio").build();
        }
        var alumno = alumnosService.actualizarApellidos(numControl, apellidos.getApellidoPaterno(), apellidos.getApellidoMaterno());
        if (alumno == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(alumno).build();
    }

    @DELETE
    @Path("/alumnos/{numControl}")
    public Response eliminarAlumno(@PathParam("numControl") String numControl) {
        if (!alumnosService.eliminar(numControl)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

}
