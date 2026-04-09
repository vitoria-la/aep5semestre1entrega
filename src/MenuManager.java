import Controllers.TicketController;
import Controllers.UsuarioController;
import Entitys.Cidadao;
import Entitys.Gestor;
import Entitys.Ticket;
import Entitys.Usuario;
import Enums.Categoria;
import Enums.Prioridade;
import Repositories.Interfaces.ITicketRepository;
import Repositories.TicketRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Responsavel pelos fluxos dos menus
 */
public class MenuManager {
    private final Scanner leitor = new Scanner(System.in);
    private int opcao;
    private ITicketRepository ticketRepository = new TicketRepository();
    private TicketController cidadaoController = new TicketController(ticketRepository);
    private UsuarioController usuarioController = new UsuarioController();

    // Constantes de cores
    public static final String AZUL = "\u001B[34m";
    public static final String VERMELHO = "\u001B[91m";
    public static final String VERDE = "\u001B[32m";

    // Constantes de estilo
    public static final String BOLD = "\u001B[1m";
    public static final String ITALICO = "\u001B[3m";
    public static final String RESET = "\u001B[0m";

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
        System.out.println(AZUL + "  =====================================================================================");
        System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
        System.out.println("  -------------------------------------------------------------------------------------" + RESET);
        System.out.println("\n");
        System.out.println(BOLD + "	    Para acessar a plataforma, digite o número de acordo com sua situação:       \n" + RESET);

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
        System.out.print(BOLD + "                    Digite o seu CPF (sem o ponto entre os dígitos):                                   \n" + RESET);
        System.out.println(ITALICO + "      Ele será utilizado por você para acompanhar o progresso de suas ocorrências" + RESET);
        System.out.println(ITALICO + "                     Caso queira voltar à tela anterior, digite 0" + RESET);
        System.out.print("                            CPF: ");
        String cpfCidadao = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(cpfCidadao)) {
            return null;
        }

        if (!VerificaCPF.verificarCPF(cpfCidadao)) {
            do {
                System.out.println(VERMELHO + "\n                          CPF inválido, digite novamente" + RESET);
                System.out.print("                      CPF: ");
                cpfCidadao = leitor.next();
            } while (!VerificaCPF.verificarCPF(cpfCidadao) && !VerificaInputVoltar.verificarStringIgualAZero(cpfCidadao));

            if (VerificaInputVoltar.verificarStringIgualAZero(cpfCidadao)) {
                return null;
            }

        }

        Cidadao cidadao = new Cidadao();
        return usuarioController.loginCidadao(cpfCidadao);
    }

    /**
     * Menu das opcoes do funcionario de login ou cadastro
     */
    public void mostrarOpcoesGestor() {
        // Menu para o funcionario fazer login ou cadastro
        System.out.println("\n");
        System.out.println("                            1 - Realizar Login");
        System.out.println("                            2 - Realizar cadastro");
        System.out.println("                            0 - Voltar a tela anterior\n");
        System.out.print("                              Opção: ");
    }

    /**
     * Menu do login do funcionario (email e senha)
     */
    public Usuario realizarLoginFuncionario() {
        System.out.println("\n");
        System.out.println("");
        System.out.println(BOLD + "                                Bem vindo de volta!" + RESET);
        System.out.println("              Realize seu login com o seu e-mail e senha cadastrados");
        System.out.println(ITALICO + "                      Para voltar a tela anterior, digite o\n" + RESET);
        System.out.print("                              E-MAIL: ");
        String email = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(email)) {
            return null;
        }

        System.out.print("                              SENHA: ");
        String senha = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(senha)) {
            return null;
        }

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
        System.out.println(BOLD + "                                      Bem vindo!" + RESET);
        System.out.println("                                Realize seu cadastro:\n");
        System.out.println(ITALICO + "                        Para voltar a tela anterior, digite o\n" + RESET);
        System.out.print("                      Nome: ");
        String nome = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(nome)) {
            return null;
        }

        System.out.print("                      CPF: ");
        String cpf = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(cpf)) {
            return null;
        }

        if (!VerificaCPF.verificarCPF(cpf)) {
            do {
                System.out.println(VERMELHO + "\n                          CPF inválido, digite novamente" + RESET);
                System.out.print("                      CPF: ");
                cpf = leitor.next();
            } while (!VerificaCPF.verificarCPF(cpf) && !VerificaInputVoltar.verificarStringIgualAZero(cpf));
        }
        System.out.print("                      Cargo: ");
        String cargo = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(cargo)) {
            return null;
        }

        System.out.print("                      E-mail: ");
        String email = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(email)) {
            return null;
        }

        System.out.print("                      Senha: ");
        String senha = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(senha)) {
            return null;
        }

        System.out.print("                      Digite novamente sua senha: ");
        String confSenha = leitor.next();

        if (VerificaInputVoltar.verificarStringIgualAZero(confSenha)) {
            return null;
        }

        // PROVISÓRIO
        Gestor funcionario = new Gestor();
        return funcionario;
    }

    /**
     * Gerenciador dos menus iniciais (antes do login do usuario)
     */
    public Usuario gerenciandoMenusIniciais() {
        boolean voltarTelaOpcaoUsuario = false;
        Usuario usuario = new Usuario();

        do {
            mostrarOpcaoDeUsuario();
            voltarTelaOpcaoUsuario = false;

            do {
                opcao = leitor.nextInt();
                switch (opcao) {
                    case 1:
                        // Se for um cidadao
                        usuario = mostrarLoginCidadao();

                        if (usuario == null) {
                            voltarTelaOpcaoUsuario = true;
                        }

                        break;
                    case 2:
                        // Se for um funcionario
                        boolean voltarTelaOpcaoGestor = false;

                        do {
                            mostrarOpcoesGestor();
                            voltarTelaOpcaoGestor = false;
                            int opcaoFuncionario = leitor.nextInt();

                            if (opcaoFuncionario == 0) {
                                voltarTelaOpcaoUsuario = true;
                            } else {
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
                                if (usuario == null) {
                                    voltarTelaOpcaoGestor = true;
                                }
                            }
                        } while (voltarTelaOpcaoGestor);

                        break;
                    default:
                        System.out.println(VERMELHO + "Dígito inválido" + RESET);
                        break;
                }
            } while (opcao != 1 && opcao != 2);
        } while (voltarTelaOpcaoUsuario);

        return usuario;

    }

    /**
     * Menu simples que pergunta o número do protocolo. Usado por ambas as classes
     */
    public void mostrarBuscaProtocolo() {
        System.out.println("\n");
        System.out.println("                      Digite o número do protocolo:");
        System.out.println(ITALICO + "                  Para voltar a tela anterior, digite 0" + RESET);
        System.out.print("                       ");
    }

    /**
     * Menu da lista das solicitações de um cidadão
     * @param cidadao
     */
    public void mostrarSolicitacoesCidadao(Cidadao cidadao) {
        limparConsole();
        System.out.println("\n");
        System.out.println(AZUL + "  =====================================================================================");
        System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpfFormatado());
        System.out.println("  -------------------------------------------------------------------------------------" + RESET);
        System.out.println("");
        System.out.println(BOLD + "                                    Suas Solicitações:\n" + RESET);

        List<Ticket> chamados = ticketRepository.buscarPorIdUsuario(cidadao.getId());

        if (chamados.isEmpty()) {
            System.out.println(VERMELHO + "                   Você ainda não possui nenhuma solicitação registrada." + RESET);
        } else {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (Ticket t : chamados) {
                System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
                System.out.println("       N° " + t.getProtocolo() + "         " + t.getTitulo() + "                       " + t.getDataCriacao().format(formatador));
                System.out.println("         Categoria: " + t.getCategoria());
                System.out.println("         Endereço: " + t.getLocalizacaoEndereco() + " - " + t.getBairro());
                System.out.println("         Status: " + t.getStatus());
                System.out.println("         Prazo de Resolução: " + t.getPrazoSLA().format(formatador));
                System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
            }
        }

        System.out.println("\n");
        System.out.print(ITALICO + "  Para voltar, digite 0" + RESET);
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 0);
    }

    /**
     * Mostra a solicitação buscada pelo cidadão
     * @param cidadao
     */
    public void mostrarSolicitacaoBuscada(Cidadao cidadao, Long protocolo) {
        limparConsole();
        System.out.println("\n");
        System.out.println(AZUL + "  =====================================================================================");
        System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpfFormatado());
        System.out.println("  -------------------------------------------------------------------------------------" + RESET);
        System.out.println("");

        Ticket ticketEncontrado = cidadaoController.buscarTicketCidadao(protocolo, cidadao.getId());

        if (ticketEncontrado == null) {
            System.out.println(VERMELHO + "         Nenhuma solicitação encontrada com este protocolo para o seu usuário.");
            System.out.println("         Verifique se o número foi digitado corretamente." + RESET);
        } else {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
            System.out.println("       N° " + ticketEncontrado.getProtocolo() + "         " + ticketEncontrado.getTitulo());
            System.out.println("         Data de Criação: " + ticketEncontrado.getDataCriacao().format(formatador));
            System.out.println("         Categoria: " + ticketEncontrado.getCategoria());
            System.out.println("         Prioridade: " + ticketEncontrado.getPrioridade());
            System.out.println("         Endereço: " + ticketEncontrado.getLocalizacaoEndereco() + " - " + ticketEncontrado.getBairro());
            System.out.println("         Status: " + ticketEncontrado.getStatus());
            System.out.println("         Prazo de Resolução (SLA): " + ticketEncontrado.getPrazoSLA().format(formatador));
            System.out.println("         Descrição: " + ticketEncontrado.getDescricao());
            System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
        }

        System.out.println("\n");
        System.out.print(ITALICO + "  Para voltar, digite 0" + RESET);
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 0);
    }

    /**
     * Menu para criar uma solicitação
     * @param cidadao
     */
    public void mostrarCriacaoSolicitacao(Cidadao cidadao) {
        limparConsole();
        System.out.println("\n");
        System.out.println(AZUL + "  =====================================================================================");
        System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
        System.out.println("  CPF: " + cidadao.getCpfFormatado());
        System.out.println("  -------------------------------------------------------------------------------------" + RESET);
        System.out.println("\n");
        System.out.println(BOLD + "                       Escolha a categoria da sua solicitação:" + RESET);
        System.out.println("                          1 - Iluminação");
        System.out.println("                          2 - Asfalto");
        System.out.println("                          3 - Grama");
        System.out.println("                          4 - Pontos de ônibus");
        System.out.println("                          5 - Outro");
        System.out.println("                          0 - Voltar a tela anterior");
        System.out.print("                          Opção: ");
        int opcaoCategoria;
        do {
            opcaoCategoria = leitor.nextInt();
        } while (opcaoCategoria > 5 || opcaoCategoria < 0);

        if (opcaoCategoria == 0) {
            return;
        }

        leitor.nextLine();

        System.out.println(BOLD + "\n                       Escolha a prioridade da sua solicitação:" + RESET);
        System.out.println("                          1 - Baixa");
        System.out.println("                          2 - Normal");
        System.out.println("                          3 - Alta");
        System.out.println("                          4 - Urgente");
        System.out.print("                          Opção: ");

        int opcaoPrioridade;
        do {
            opcaoPrioridade = leitor.nextInt();
        } while (opcaoPrioridade > 4 || opcaoPrioridade < 1);

        leitor.nextLine();

        System.out.println("");
        System.out.print("                       Título: ");
        String titulo = leitor.nextLine();
        System.out.print("                       Descrição: ");
        String descricao = leitor.nextLine();
        System.out.print("                       Localização: ");
        String local = leitor.nextLine();
        System.out.print("                       Bairro: ");
        String bairro = leitor.nextLine();

        Ticket novoTicket = new Ticket();
        novoTicket.setTitulo(titulo);
        novoTicket.setDescricao(descricao);
        novoTicket.setLocalizacaoEndereco(local);
        novoTicket.setBairro(bairro);
        novoTicket.setPrioridade(Prioridade.fromId(opcaoPrioridade));
        novoTicket.setCategoria(Categoria.fromId(opcaoCategoria));
        novoTicket.setIdUsuario(cidadao.getId());
        Ticket ticketCriado = cidadaoController.criarTicket(novoTicket);

        if (ticketCriado != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println(VERDE + "\n\n                             Solicitação criada com sucesso!" + RESET);
            System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
            System.out.println("       N° " + ticketCriado.getProtocolo() + "         " + ticketCriado.getTitulo());
            System.out.println("         Categoria: " + ticketCriado.getCategoria());
            System.out.println("         Prioridade: " + ticketCriado.getPrioridade());
            System.out.println("         Endereço: " + ticketCriado.getLocalizacaoEndereco() + " - " + ticketCriado.getBairro());
            System.out.println("         Prazo Limite (SLA): " + ticketCriado.getPrazoSLA().format(formatador));
            System.out.println("         Status: " + ticketCriado.getStatus());
            System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
        }

        System.out.println("\n");
        System.out.print(ITALICO + "  Para voltar, digite 0" + RESET);
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 0);
    }

    /**
     * Loop do menu do Entitys.Cidadao
     * @param cidadao
     */
    public int loopCidadao(Cidadao cidadao) {
        int opcaoLoop;
        boolean voltarLoopCidadao = false;
        do {
            voltarLoopCidadao = false;
            limparConsole();
            System.out.println("\n");
            System.out.println(AZUL + "  =====================================================================================");
            System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
            // Mostrar o CPF com os pontos
            System.out.println("  CPF: " + cidadao.getCpfFormatado() + "                                     Para trocar de conta, digite 0");
            System.out.println("  -------------------------------------------------------------------------------------" + RESET);
            System.out.println("\n");
            System.out.println(BOLD + "                        Escolha a opção que deseja realizar:\n" + RESET);
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

                    if (protocoloBusca == 0) {
                        voltarLoopCidadao = true;
                    } else {
                        mostrarSolicitacaoBuscada(cidadao, protocoloBusca);
                    }

                    break;
                case 4:
                    System.out.println(BOLD + "\n                       Obrigado por utilizar o nosso sistema!" + RESET);
                    break;
            }

        } while (opcaoLoop != 4 && opcaoLoop != 0 || voltarLoopCidadao);
        return opcaoLoop;
    }

    /**
     * Menu da lista das solicitações que aparecem para os funcionarios
     * @param gestor
     */
    public void mostrarSolicitacoesFuncionario(Gestor gestor) {
        limparConsole();
        System.out.println("\n");
        System.out.println(AZUL + "  =====================================================================================");
        System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
        System.out.println("  E-mail: " + gestor.getEmail());
        System.out.println("  -------------------------------------------------------------------------------------" + RESET);
        System.out.println("");
        System.out.println(BOLD + "                                    Solicitações:\n" + RESET);
        // Esse é o modelo das solicitações, não será travado assim, apenas para demonstração
        System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
        System.out.println("       N° 1234         Poste sem luz na Av. Teste                       12/01/2021");
        System.out.println("         Iluminação");
        System.out.println("         Endereço: Avenida Teste, 1234");
        System.out.println("         Status: Em Aberto");
        System.out.println("         Atualizado: 12/01/2026");
        System.out.println("         Assinatura: Fulano");
        System.out.println(AZUL + "     -------------------------------------------------------------------------------" + RESET);
        System.out.println("\n");
        System.out.print(ITALICO + "  Para voltar, digite 0" + RESET);
        int op;
        do {
            op = leitor.nextInt();
        } while (op != 0);
    }

    /**
     * Menu da da atualização do status das solicitações
     * @param gestor
     */
    public boolean mostrarAtualizacaoStatus(Gestor gestor) {
        boolean voltarMenuAtualizacaoStatus = false;

        do {
            voltarMenuAtualizacaoStatus = false;
            int opcaoLoop;
            limparConsole();
            System.out.println("\n");
            System.out.println(AZUL + "  =====================================================================================");
            System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
            System.out.println("  E-mail: " + gestor.getEmail());
            System.out.println("  -------------------------------------------------------------------------------------" + RESET);
            System.out.println("");
            System.out.println(BOLD + "                                    Atualização:\n" + RESET);
            // Status provisórios
            System.out.println("                          1 - Em aberto");
            System.out.println("                          2 - Emcaminhado ao setor");
            System.out.println("                          3 - Aprovado");
            System.out.println("                          4 - Negado");
            System.out.println("                          5 - Realizado");
            System.out.println("                          0 - Voltar");
            System.out.print("                            Opção: ");

            do {
                opcaoLoop = leitor.nextInt();
            } while (opcaoLoop > 5 || opcaoLoop < 0);

            if (opcaoLoop == 0) {
                return false;
            }

            System.out.print("\n   Justificativa ao solicitante (0 para voltar):");
            String justificativa = leitor.next();

            if (VerificaInputVoltar.verificarStringIgualAZero(justificativa)) {
                voltarMenuAtualizacaoStatus = true;
            }

        } while (voltarMenuAtualizacaoStatus);

        return true;
    }

    /**
     * Loop do menu do Funcionario
     */
    public int loopFuncionario(Gestor gestor) {
        int opcaoLoop;
        boolean voltarLoopFuncionario = false;
        do {
            limparConsole();
            voltarLoopFuncionario = false;

            System.out.println("\n");
            System.out.println(AZUL + "  =====================================================================================");
            System.out.println(BOLD + "  ObservaAção" + RESET + AZUL + "                                              Transformando Maringá juntos");
            System.out.println("  E-mail: " + gestor.getEmail() + "                                        Para trocar de conta, digite 0");
            System.out.println("  -------------------------------------------------------------------------------------" + RESET);
            System.out.println("\n");
            System.out.println(BOLD + "                        Escolha a opção que deseja realizar:\n" + RESET);
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
                    boolean voltarMenuBuscaProtocolo = false;

                    do {
                        voltarMenuBuscaProtocolo = false;
                        mostrarBuscaProtocolo();
                        Long protocoloBusca = leitor.nextLong();
                        
                        if (protocoloBusca == 0) {
                            voltarLoopFuncionario = true;
                        }  else {
                            // Validar existencia da solicitação
                            boolean resultadoAtualizacao = mostrarAtualizacaoStatus(gestor);

                            if (!resultadoAtualizacao) {
                                voltarMenuBuscaProtocolo = true;
                            }

                        }
                    } while (voltarMenuBuscaProtocolo);

                    break;
                case 3:
                    System.out.println(BOLD + "\n                       Obrigado por utilizar o nosso sistema!" + RESET);
                    break;
            }

        } while (opcaoLoop != 3 && opcaoLoop != 0 || voltarLoopFuncionario);
        return opcaoLoop;
    }
}