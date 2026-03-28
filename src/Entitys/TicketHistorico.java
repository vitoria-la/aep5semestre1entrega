package Entitys;

import Enums.StatusTicket;

import java.time.LocalDateTime;

public class TicketHistorico {

    private int id;
    private LocalDateTime dataHora;
    private StatusTicket statusAnterior;
    private StatusTicket statusNovo;
    private String comentario;
    private Long protocolo;
    private int idGestor;

}
