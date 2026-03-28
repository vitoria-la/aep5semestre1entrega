package Entitys;

import Enums.Categoria;
import Enums.Prioridade;
import Enums.StatusTicket;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private Long protocolo;
    private LocalDateTime dataCriacao;
    private Categoria categoria;
    private String descricao;
    private String localizacaoEndereco;
    private String bairro;
    private StatusTicket status;
    private Prioridade prioridade;
    private LocalDateTime prazoSLA;
    private int idUsuario;
    private List<TicketHistorico> listaDeHistoricos;


}
