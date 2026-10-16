package org.itsav.domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_alumno")
    private UUID idAlumno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "curp")
    private String curp;

    @Column(name = "num_telefono_fijo")
    private String numTelefonoFijo;

    @Column(name = "num_telefono_movil")
    private String numTelefonoMovil;

    @Column(name = "correo_personal")
    private String correoPersonal;

    @Column(name = "correo_institucional")
    private String correoInstitucional;

    @Column(name = "nombre_tutor")
    private String nombreTutor;

    @Column(name = "contacto_tutor")
    private String contactoTutor;

    @Column(name = "num_control")
    private String numControl;

    @Column(name = "activo")
    private Boolean activo = true;
}
