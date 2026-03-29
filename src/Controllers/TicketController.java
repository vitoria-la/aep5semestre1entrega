package Controllers;

import Entitys.Ticket;
import Repositories.Interfaces.ITicketRepository;
import Services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(ITicketRepository ticketRepository){
        ticketService = new TicketService(ticketRepository);
    }

    public Ticket criarTicket(Ticket ticket){

        Ticket novoTicket = ticketService.criarTicket(ticket);
        return novoTicket;
    }

    public Ticket buscarTicketCidadao(Long protocolo, int idUsuario) {
        return ticketService.buscarTicketCidadao(protocolo, idUsuario);
    }
}
