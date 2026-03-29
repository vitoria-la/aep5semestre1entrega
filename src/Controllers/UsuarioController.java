package Controllers;

import Entitys.Cidadao;
import Services.UsuarioService;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public Cidadao loginCidadao(String cpf) {
        return usuarioService.realizarLoginCidadao(cpf);
    }
}
