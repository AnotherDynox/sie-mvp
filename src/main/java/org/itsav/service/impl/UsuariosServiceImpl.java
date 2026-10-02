package org.itsav.service.impl;


import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.records.InfoUsuarioDTO;
import org.itsav.service.UsuariosService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuariosServiceImpl implements UsuariosService {
    @Override
    public void getInfoUsuario(String numControl) {
    }

    @Override
    public List<InfoUsuarioDTO> getInfoUsuarios() {
        List<InfoUsuarioDTO> InfoUsuarios = new ArrayList<>();
        InfoUsuarios.add(new InfoUsuarioDTO("1", "jose"));
        InfoUsuarios.add(new InfoUsuarioDTO("2", "Maria"));
        InfoUsuarios.add(new InfoUsuarioDTO("3", "Pedro"));
        InfoUsuarios.add(new InfoUsuarioDTO("4", "Juan"));
        InfoUsuarios.add(new InfoUsuarioDTO("5", "Emilio"));
        InfoUsuarios.add(new InfoUsuarioDTO("6", "Romina"));
        InfoUsuarios.add(new InfoUsuarioDTO("7", "Eduardo"));
        InfoUsuarios.add(new InfoUsuarioDTO("8", "Aldo"));
        InfoUsuarios.add(new InfoUsuarioDTO("9", "Alonso"));
        InfoUsuarios.add(new InfoUsuarioDTO("10", "Millie"));
        return InfoUsuarios;
    }
}
