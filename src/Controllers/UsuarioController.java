package Controllers;

import Entitys.Cidadao;
import Entitys.Gestor;
import Services.UsuarioService;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public Cidadao loginCidadao(String cpf) {
        return usuarioService.realizarLoginCidadao(cpf);
    }

    public Gestor cadastrarGestor(String nome, String cpf, String cargo, String email, String senha, String confirmacaoSenha) {
        return usuarioService.cadastrarGestor(nome, cpf, cargo, email, senha, confirmacaoSenha);
    }

    public Gestor loginGestor(String email, String senha) {
        return usuarioService.realizarLoginGestor(email, senha);
    }
}
