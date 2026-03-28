import Entitys.Cidadao;
import Entitys.Gestor;
import Entitys.Usuario;

import java.util.Scanner;

/**
 * Responsavel pelos fluxos dos menus
 */
public class MenuManager {
    private Scanner leitor = new Scanner(System.in);
    private int opcao;

    public void limparConsole() {
        // gambiarra
        for (int x = 0; x < 50; x++) {
            System.out.println("\n");
        }
    }

    /**
     * Primeiro menu (escolher se é cidadao ou funcionario)
     */
    public void mostrarOpcaoDeUsuario() {
        // Menu para escolher morador ou funcionario
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("	    Para acessar a plataforma, digite o número de acordo com sua situação:       \n");
        System.out.println("                            1 - Morador de Maringá");
        System.out.println("                            2 - Funcionário público\n");
        System.out.print("                                Sua escolha: ");
    }

    /**
     * Menu do login do cidadao (via CPF)
     */
    public Cidadao mostrarLoginCidadao() {
        // Menu para realizar o login do cidadao
        System.out.println("\n");
        System.out.println("");
        System.out.print("                    Digite o seu CPF (sem o ponto entre os dígitos):                                   \n");
        System.out.println("      Ele será utilizado por você para acompanhar o progresso de suas ocorrências\n");
        System.out.print("                            CPF: ");
        String cpfCidadao = leitor.next();
        Cidadao cidadao = new Cidadao();
        cidadao.setCpf(cpfCidadao);
        return cidadao;
    }

    /**
     * Menu das opcoes do funcionario de login ou cadastro
     */
    public void mostrarOpcoesGestor() {
        // Menu para o funcionario fazer login ou cadastro
        System.out.println("\n");
        System.out.println("                            1 - Realizar Login");
        System.out.println("                            2 - Realizar cadastro\n");
        System.out.print("                              Opção: ");
    }

    /**
     * Menu do login do funcionario (email e senha)
     */
    public Usuario realizarLoginFuncionario() {
        System.out.println("\n");
        System.out.println("");
        System.out.println("                                Bem vindo de volta!");
        System.out.println("              Realize seu login com o seu e-mail e senha cadastrados\n");
        System.out.print("                              E-MAIL: ");
        String email = leitor.next();
        System.out.print("                              SENHA: ");
        String senha = leitor.next();

        // Verificar se o login está correto
        // Retornar o funcionario da lista de funcionarios

        // PROVISÓRIO
        Gestor funcionario = new Gestor();
        return funcionario;
    }

    /**
     * Menu do cadastro do funcionario
     */
    public Usuario realizarCadastroFuncionario() {
        System.out.println("\n");
        System.out.println("");
        System.out.println("                                      Bem vindo!");
        System.out.println("                                Realize seu cadastro:\n");
        System.out.print("                      Nome: ");
        String nome = leitor.next();
        System.out.print("                      CPF: ");
        String cpf = leitor.next();
        System.out.print("                      Cargo: ");
        String cargo = leitor.next();
        System.out.print("                      E-mail: ");
        String email = leitor.next();
        System.out.print("                      Senha: ");
        String senha = leitor.next();
        System.out.print("                      Digite novamente sua senha: ");
        String confSenha = leitor.next();

        // PROVISÓRIO
        Gestor funcionario = new Gestor();
        return funcionario;
    }

    /**
     * Gerenciador dos menus iniciais (antes do login do usuario)
     */
    public Usuario gerenciandoMenusIniciais() {
        mostrarOpcaoDeUsuario();
        Usuario usuario = new Usuario();
        do {
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    // Se for um cidadao
                    usuario = mostrarLoginCidadao();
                    break;
                case 2:
                    // Se for um funcionario
                    mostrarOpcoesGestor();
                    int opcaoFuncionario = leitor.nextInt();
                    switch (opcaoFuncionario) {
                        case 1:
                            // Se for realizar login
                            usuario = realizarLoginFuncionario();
                            break;
                        case 2:
                            // Se for realizar cadastro
                            usuario = realizarCadastroFuncionario();
                            break;
                    }
                    break;
                default:
                    System.out.println("Dígito inválido");
                    break;
            }
        } while (opcao != 1 && opcao != 2);

        return usuario;
    }

    /**
     * Menu simples que pergunta o número do protocolo. Usado por ambas as classes
     */
    public void mostrarBuscaProtocolo() {
        System.out.println("\n");
        System.out.print("                      Digite o número do protocolo:");
    }

    /**
     * Menu da lista das solicitações de um cidadão
     * @param cidadao
     */
    public void mostrarSolicitacoesCidadao(Cidadao cidadao) {
        limparConsole();
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpf());
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                    Solicitações:\n");
        // Esse é o modelo das solicitações, não será travado assim, apenas para demonstração
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("       N° 1234         Poste sem luz na Av. Teste                       12/01/2021");
        System.out.println("         Iluminação");
        System.out.println("         Endereço: Avenida Teste, 1234");
        System.out.println("         Status: Em Aberto");
        System.out.println("         Atualizado: 12/01/2026");
        System.out.println("         Assinatura: Fulano");
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.print("  Para voltar, digite 1:");
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 1);
    }

    /**
     * Mostra a solicitação buscada pelo cidadão
     * @param cidadao
     */
    public void mostrarSolicitacaoBuscada(Cidadao cidadao) {
        limparConsole();
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpf());
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("");
        // Esse é o modelo das solicitações, não será travado assim, apenas para demonstração
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("       N° 1234         Poste sem luz na Av. Teste                       12/01/2021");
        System.out.println("         Iluminação");
        System.out.println("         Endereço: Avenida Teste, 1234");
        System.out.println("         Status: Encaminhada ao setor");
        System.out.println("         Atualizado: 12/01/2026");
        System.out.println("         Justificativa: A sua solicitação foi enviada ao setor de iluminação;");
        System.out.println("         Assinatura: Fulano");
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.print("  Para voltar, digite 1:");
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 1);
    }

    /**
     * Menu para criar uma solicitação
     * @param cidadao
     */
    public void mostrarCriacaoSolicitacao(Cidadao cidadao) {
        limparConsole();
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpf());
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("                       Escolha a categoria da sua solicitação:\n");
        System.out.println("                          1 - Iluminação");
        System.out.println("                          2 - Asfalto");
        System.out.println("                          3 - Grama");
        System.out.println("                          4 - Pontos de ônibus");
        System.out.println("                          5 - Outro");
        System.out.print("                          Opção: ");
        int opcaoLoop;
        do {
            opcaoLoop = leitor.nextInt();
        } while (opcaoLoop > 5 || opcaoLoop < 1);
        System.out.println("");
        System.out.print("                       Título: ");
        String titulo = leitor.next();
        System.out.print("                       Descrição: ");
        String descricao = leitor.next();
        System.out.print("                       Localização: ");
        String local = leitor.next();

        System.out.println("\n");
        System.out.println("                             Solicitação criada com sucesso!");
        // Solicitação recem criada
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("       N° 1234         Poste sem luz na Av. Teste                       12/01/2021");
        System.out.println("         Iluminação");
        System.out.println("         Endereço: Avenida Teste, 1234");
        System.out.println("         Status: Em aberto");
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.print("  Para voltar, digite 1:");
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 1);
    }

    /**
     * Loop do menu do Entitys.Cidadao
     * @param cidadao
     */
    public int loopCidadao(Cidadao cidadao) {
        int opcaoLoop;
        do {
            limparConsole();
            System.out.println("\n");
            System.out.println("  =====================================================================================");
            System.out.println("  ObservAcao                                               Transformando Maringá juntos");
            // Mostrar o CPF com os pontos
            System.out.println("  CPF: " + cidadao.getCpf() + "                                    Para trocar de conta, digite 0");
            System.out.println("  -------------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("                        Escolha a opção que deseja realizar:\n");
            System.out.println("                          1 - Registrar uma ocorrência");
            System.out.println("                          2 - Listar suas ocorrências");
            System.out.println("                          3 - Buscar uma ocorrência sua");
            System.out.println("                          4 - Sair");
            System.out.print("                            Opção: ");
            do {
                opcaoLoop = leitor.nextInt();
            } while (opcaoLoop > 4 || opcaoLoop < 0);

            switch (opcaoLoop) {
                case 1:
                    mostrarCriacaoSolicitacao(cidadao);
                    break;
                case 2:
                    mostrarSolicitacoesCidadao(cidadao);
                    break;
                case 3:
                    mostrarBuscaProtocolo();
                    Long protocoloBusca = leitor.nextLong();
                    mostrarSolicitacaoBuscada(cidadao);
                    break;
                case 4:
                    System.out.println("\n                       Obrigado por utilizar o nosso sistema!");
                    break;
            }

        } while (opcaoLoop != 4 && opcaoLoop != 0);
        return opcaoLoop;
    }

    /**
     * Menu da lista das solicitações que aparecem para os funcionarios
     * @param gestor
     */
    public void mostrarSolicitacoesFuncionario(Gestor gestor) {
        limparConsole();
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  E-mail: " + gestor.getEmail());
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                    Solicitações:\n");
        // Esse é o modelo das solicitações, não será travado assim, apenas para demonstração
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("       N° 1234         Poste sem luz na Av. Teste                       12/01/2021");
        System.out.println("         Iluminação");
        System.out.println("         Endereço: Avenida Teste, 1234");
        System.out.println("         Status: Em Aberto");
        System.out.println("         Atualizado: 12/01/2026");
        System.out.println("         Assinatura: Fulano");
        System.out.println("     -------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.print("  Para voltar, digite 1:");
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 1);
    }

    /**
     * Menu da da atualização do status das solicitações
     * @param gestor
     */
    public void mostrarAtualizacaoStatus(Gestor gestor) {
        int opcaoLoop;
        limparConsole();
        System.out.println("\n");
        System.out.println("  =====================================================================================");
        System.out.println("  ObservAcao                                               Transformando Maringá juntos");
        System.out.println("  E-mail: " + gestor.getEmail());
        System.out.println("  -------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                    Atualização:\n");
        // Status provisórios
        System.out.println("                          1 - Em aberto");
        System.out.println("                          2 - Emcaminhado ao setor");
        System.out.println("                          3 - Aprovado");
        System.out.println("                          4 - Negado");
        System.out.println("                          5 - Realizado");
        System.out.println("                          6 - Sair");
        System.out.print("                            Opção: ");

        do {
                opcaoLoop = leitor.nextInt();
        } while (opcaoLoop > 6 || opcaoLoop < 1);


        System.out.print("\n   Justificativa ao solicitante:");
        String justificativa = leitor.next();
    }

    /**
     * Loop do menu do Funcionario
     */
    public int loopFuncionario(Gestor gestor) {
        int opcaoLoop;
        do {
            limparConsole();
            System.out.println("\n");
            System.out.println("  =====================================================================================");
            System.out.println("  ObservAcao                                               Transformando Maringá juntos");
            System.out.println("  E-mail: " + gestor.getEmail() + "                                        Para trocar de conta, digite 0");
            System.out.println("  -------------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("                        Escolha a opção que deseja realizar:\n");
            System.out.println("                          1 - Listar solicitações");
            System.out.println("                          2 - Atualizar solicitação");
            System.out.println("                          3 - Sair");
            System.out.print("                            Opção: ");

            do {
                opcaoLoop = leitor.nextInt();
            } while (opcaoLoop > 3 || opcaoLoop < 0);

            switch (opcaoLoop) {
                case 1:
                    mostrarSolicitacoesFuncionario(gestor);
                    break;
                case 2:
                    mostrarBuscaProtocolo();
                    Long protocoloBusca = leitor.nextLong();
                    // Validar existencia da solicitação
                    mostrarAtualizacaoStatus(gestor);
                    break;
                case 3:
                    System.out.println("\n                       Obrigado por utilizar o nosso sistema!");
                    break;
            }

        } while (opcaoLoop != 3 && opcaoLoop != 0);
        return opcaoLoop;
    }
}