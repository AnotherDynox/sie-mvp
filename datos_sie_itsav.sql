
INSERT INTO ctl_paises (nombre, prefijo)
VALUES ('México', '+52');

SELECT * FROM ctl_paises;

INSERT INTO ctl_estados (nombre, pais)
SELECT 'Oaxaca', id_pais
FROM ctl_paises
WHERE nombre = 'México';

SELECT * FROM ctl_estados;

INSERT INTO ctl_ciudades (nombre, estado)
SELECT c.nombre, e.id_estado
FROM (VALUES ('Salina Cruz'),
             ('Juchitán de Zaragoza'),
             ('Oaxaca de Juárez')) AS c(nombre)
CROSS JOIN ctl_estados e
WHERE e.nombre = 'Oaxaca';

SELECT * FROM ctl_ciudades;

INSERT INTO tbl_alumnos (nombre,
                         apellido_paterno,
                         apellido_materno,
                         fecha_nacimiento,
                         curp,
                         num_telefono_fijo,
                         num_telefono_movil,
                         correo_personal,
                         correo_institucional,
                         nombre_tutor,
                         contacto_tutor,
                         num_control)
VALUES ('Diego', 'Ramirez', 'Soto', '2005-01-27', 'RASD050127HOCMTG08',
        NULL, '9711234567', 'diego.ramirez@example.com', '230300001@itsoax.edu.mx',
        'Laura Soto', '9717654321', '230300001'),
       ('Sofia', 'Mendoza', 'Cruz', '2004-06-03', 'MECS040603MOCNRF05',
        '9717001122', '9712345098', 'sofia.mendoza@example.com', '230300002@itsoax.edu.mx',
        'Pedro Mendoza', '9718765432', '230300002'),
       ('Javier', 'Ortiz', 'Luna', '2005-10-11', 'OILJ051011HOCRNV03',
        NULL, '9713456789', NULL, '230300003@itsoax.edu.mx',
        'Elena Luna', '9719876543', '230300003'),
       ('Camila', 'Herrera', 'Vazquez', '2004-12-30', 'HEVC041230MOCRZM07',
        NULL, '9714567890', 'camila.herrera@example.com', '230300004@itsoax.edu.mx',
        'Ricardo Herrera', '9710987654', '230300004'),
       ('Santiago', 'Perez', 'Aguilar', '2005-04-08', 'PEAS050408HOCRGN02',
        NULL, '9715678901', NULL, '230300005@itsoax.edu.mx',
        'Gabriela Aguilar', '9711122334', '230300005'),
       ('Fernanda', 'Gomez', 'Ruiz', '2004-09-14', 'GORF040914MOCMZR09',
        NULL, '9716789012', 'fernanda.gomez@example.com', '230300006@itsoax.edu.mx',
        'Hector Gomez', '9712233445', '230300006');

SELECT id_alumno, nombre, apellido_paterno, apellido_materno, num_control
FROM tbl_alumnos
ORDER BY num_control;

INSERT INTO tbl_direcciones (calle,
                             numero_ext,
                             numero_int,
                             colonia,
                             cp,
                             ciudad)
SELECT v.calle, v.numero_ext, v.numero_int, v.colonia, v.cp, c.id_ciudad
FROM (VALUES ('Avenida Tehuantepec', '210', NULL,  'Centro',          '70600', 'Salina Cruz'),
             ('Calle Allende',       '35',  'B',   'Cheguigo',        '70000', 'Juchitán de Zaragoza'),
             ('Calle Reforma',       '88',  NULL,  'Reforma',         '68050', 'Oaxaca de Juárez'),
             ('Calle Hidalgo',       '142', NULL,  'Playa Abierta',   '70610', 'Salina Cruz'),
             ('Calle 5 de Mayo',     '19',  '2',   'Centro',          '70000', 'Juchitán de Zaragoza'),
             ('Calle Morelos',       '301', NULL,  'Xochimilco',      '68040', 'Oaxaca de Juárez')
     ) AS v(calle, numero_ext, numero_int, colonia, cp, ciudad_nombre)
JOIN ctl_ciudades c ON c.nombre = v.ciudad_nombre;

SELECT * FROM tbl_direcciones;

INSERT INTO rel_alumnos_direcciones (direccion, alumno)
SELECT d.id_direccion, a.id_alumno
FROM (VALUES ('Avenida Tehuantepec', '210', '230300001'),
             ('Calle Allende',       '35',  '230300002'),
             ('Calle Reforma',       '88',  '230300003'),
             ('Calle Hidalgo',       '142', '230300004'),
             ('Calle 5 de Mayo',     '19',  '230300005'),
             ('Calle Morelos',       '301', '230300006')
     ) AS v(calle, numero_ext, num_control)
JOIN tbl_direcciones d ON d.calle = v.calle AND d.numero_ext = v.numero_ext
JOIN tbl_alumnos a     ON a.num_control = v.num_control;

SELECT * FROM rel_alumnos_direcciones;

INSERT INTO tbl_datos_medicos (tipo_sangre, alumno)
SELECT v.tipo_sangre, a.id_alumno
FROM (VALUES ('A+',  '230300001'),
             ('O-',  '230300002'),
             ('B+',  '230300003'),
             ('AB+', '230300004'),
             ('O+',  '230300005'),
             ('A-',  '230300006')
     ) AS v(tipo_sangre, num_control)
JOIN tbl_alumnos a ON a.num_control = v.num_control;

SELECT * FROM tbl_datos_medicos;


INSERT INTO ctl_alergias (nombre, descripcion)
VALUES ('Latex', 'Reacción alérgica al contacto con productos que contienen látex'),
       ('Lactosa', 'Reacción adversa al consumo de lácteos'),
       ('Gluten', 'Reacción alérgica al consumo de productos con gluten'),
       ('Picadura de abeja', 'Reacción alérgica severa a picaduras de abeja o avispa');

SELECT * FROM ctl_alergias;


INSERT INTO ctl_discapacidades_medicas (nombre, descripcion)
VALUES ('Del habla', 'Discapacidad que afecta la producción o fluidez del habla'),
       ('Psicosocial', 'Discapacidad derivada de condiciones que afectan la interacción social'),
       ('Visual parcial', 'Discapacidad que reduce parcialmente la agudeza visual'),
       ('Motriz de extremidades', 'Discapacidad que limita el movimiento de brazos o piernas');

SELECT * FROM ctl_discapacidades_medicas;

INSERT INTO rel_alergias_datos_medicos (alergia, dato_medico)
SELECT al.id_alergia, dm.id_dato_medico
FROM (VALUES ('Latex',             '230300001'),
             ('Lactosa',           '230300002'),
             ('Gluten',            '230300004'),
             ('Picadura de abeja', '230300005'),
             ('Lactosa',           '230300005')
     ) AS v(alergia, num_control)
JOIN ctl_alergias al    ON al.nombre = v.alergia
JOIN tbl_alumnos a      ON a.num_control = v.num_control
JOIN tbl_datos_medicos dm ON dm.alumno = a.id_alumno;

SELECT * FROM rel_alergias_datos_medicos;

INSERT INTO rel_discapacidades_datos_medicos (discapacidad, dato_medico)
SELECT dis.id_discapacidad, dm.id_dato_medico
FROM (VALUES ('Visual parcial', '230300003'),
             ('Del habla',      '230300006')
     ) AS v(discapacidad, num_control)
JOIN ctl_discapacidades_medicas dis ON dis.nombre = v.discapacidad
JOIN tbl_alumnos a                  ON a.num_control = v.num_control
JOIN tbl_datos_medicos dm           ON dm.alumno = a.id_alumno;

SELECT * FROM rel_discapacidades_datos_medicos;

SELECT a.nombre,
       a.apellido_paterno,
       a.apellido_materno,
       a.num_control,
       dm.tipo_sangre,
       al.nombre AS alergia
FROM tbl_alumnos a
INNER JOIN tbl_datos_medicos dm ON a.id_alumno = dm.alumno
INNER JOIN rel_alergias_datos_medicos radm ON dm.id_dato_medico = radm.dato_medico
INNER JOIN ctl_alergias al ON radm.alergia = al.id_alergia
ORDER BY a.num_control;

SELECT a.num_control,
       a.nombre,
       a.apellido_paterno,
       a.apellido_materno,
       a.num_telefono_movil,
       a.correo_institucional,
       d.calle,
       d.numero_ext,
       d.numero_int,
       d.colonia,
       d.cp,
       c.nombre AS ciudad,
       e.nombre AS estado,
       p.nombre AS pais,
       dm.tipo_sangre,
       al.nombre AS alergia,
       dis.nombre AS discapacidad
FROM tbl_alumnos a
LEFT JOIN rel_alumnos_direcciones rad ON a.id_alumno = rad.alumno
LEFT JOIN tbl_direcciones d ON rad.direccion = d.id_direccion
LEFT JOIN ctl_ciudades c ON d.ciudad = c.id_ciudad
LEFT JOIN ctl_estados e ON c.estado = e.id_estado
LEFT JOIN ctl_paises p ON e.pais = p.id_pais
LEFT JOIN tbl_datos_medicos dm ON a.id_alumno = dm.alumno
LEFT JOIN rel_alergias_datos_medicos ralm ON dm.id_dato_medico = ralm.dato_medico
LEFT JOIN ctl_alergias al ON ralm.alergia = al.id_alergia
LEFT JOIN rel_discapacidades_datos_medicos rdm ON dm.id_dato_medico = rdm.dato_medico
LEFT JOIN ctl_discapacidades_medicas dis ON rdm.discapacidad = dis.id_discapacidad
ORDER BY a.num_control;

SELECT 'ctl_paises' AS tabla, COUNT(*) AS registros FROM ctl_paises
UNION ALL SELECT 'ctl_estados', COUNT(*) FROM ctl_estados
UNION ALL SELECT 'ctl_ciudades', COUNT(*) FROM ctl_ciudades
UNION ALL SELECT 'ctl_alergias', COUNT(*) FROM ctl_alergias
UNION ALL SELECT 'ctl_discapacidades_medicas', COUNT(*) FROM ctl_discapacidades_medicas
UNION ALL SELECT 'tbl_alumnos', COUNT(*) FROM tbl_alumnos
UNION ALL SELECT 'tbl_direcciones', COUNT(*) FROM tbl_direcciones
UNION ALL SELECT 'tbl_datos_medicos', COUNT(*) FROM tbl_datos_medicos
UNION ALL SELECT 'rel_alumnos_direcciones', COUNT(*) FROM rel_alumnos_direcciones
UNION ALL SELECT 'rel_alergias_datos_medicos', COUNT(*) FROM rel_alergias_datos_medicos
UNION ALL SELECT 'rel_discapacidades_datos_medicos', COUNT(*) FROM rel_discapacidades_datos_medicos;

SELECT a.num_control,
       a.nombre,
       a.apellido_paterno,
       a.apellido_materno,
       cd.nombre AS discapacidad
FROM tbl_alumnos a
INNER JOIN tbl_datos_medicos dm ON a.id_alumno = dm.alumno
INNER JOIN rel_discapacidades_datos_medicos rddm ON dm.id_dato_medico = rddm.dato_medico
INNER JOIN ctl_discapacidades_medicas cd ON rddm.discapacidad = cd.id_discapacidad
ORDER BY a.num_control;
