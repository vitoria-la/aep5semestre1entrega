package Services;

import Entitys.Cidadao;
import Entitys.Gestor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Gestor> listaDeGestores = new ArrayList<>();

    public Cidadao realizarLoginCidadao(String cpf) {
        Cidadao cidadao = new Cidadao();
        cidadao.setCpf(cpf);

        cidadao.setId(Math.abs(cpf.hashCode()));

        return cidadao;
    }

    public Gestor cadastrarGestor(String nome, String cpf, String cargo, String email, String senha, String confirmacaoSenha) {

        if (!senha.equals(confirmacaoSenha)) {
            System.out.println("\n\u001B[91mErro: A senha e a confirmação de senha não coincidem.\u001B[0m");
            return null;
        }

        for (Gestor g : listaDeGestores) {
            if (g.getEmail().equalsIgnoreCase(email) || g.getCpf().equals(cpf)) {
                System.out.println("\n\u001B[91mErro: Já existe um funcionário cadastrado com este E-mail ou CPF.\u001B[0m");
                return null;
            }
        }

        Gestor novoGestor = new Gestor();
        novoGestor.setNome(nome);
        novoGestor.setCpf(cpf);
        novoGestor.setCargo(cargo);
        novoGestor.setEmail(email);
        novoGestor.setSenha(senha);
        novoGestor.setId(listaDeGestores.size() + 1);

        listaDeGestores.add(novoGestor);
        return novoGestor;
    }

    public Gestor realizarLoginGestor(String email, String senha) {
        for (Gestor g : listaDeGestores) {
            if (g.getEmail().equalsIgnoreCase(email)) {
                if (g.getSenha().equals(senha)) {
                    return g;
                } else {
                    System.out.println("\n\u001B[91mErro: Senha incorreta.\u001B[0m");
                    return null;
                }
            }
        }
        System.out.println("\n\u001B[91mErro: E-mail não encontrado no sistema.\u001B[0m");
        return null;
    }
}
