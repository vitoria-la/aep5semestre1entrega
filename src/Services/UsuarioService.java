package Services;

import Entitys.Cidadao;

public class UsuarioService {

    public Cidadao realizarLoginCidadao(String cpf) {
        Cidadao cidadao = new Cidadao();
        cidadao.setCpf(cpf);

        cidadao.setId(Math.abs(cpf.hashCode()));

        return cidadao;
    }
}
