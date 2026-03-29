package Repositories;

import Entitys.Ticket;
import Repositories.Interfaces.ITicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository implements ITicketRepository {

    private List<Ticket> listaDeTicketsSalvos;

    public TicketRepository(){
        listaDeTicketsSalvos = new ArrayList<>();
    }

    @Override
    public void salvar(Ticket ticket) {
        listaDeTicketsSalvos.add(ticket);
    }

    @Override
    public List<Ticket> buscarPorIdUsuario(int idUsuario){
        List<Ticket> listaTickets = new ArrayList<>();
        for (Ticket ticket : listaDeTicketsSalvos){
            if (ticket.getIdUsuario() == idUsuario){
                listaTickets.add(ticket);
            }
        }
        return listaTickets;
    }

    @Override
    public Ticket buscarPorProtocoloEUsuario(Long protocolo, int idUsuario) {
        for (Ticket ticket : listaDeTicketsSalvos) {
            if (ticket.getProtocolo().equals(protocolo) && ticket.getIdUsuario() == idUsuario) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public Ticket buscarPorProtocolo(Long protocolo){
        for (Ticket ticket : listaDeTicketsSalvos){
            if (ticket.getProtocolo().equals(protocolo)){
                return ticket;
            }
        }
        return null;
    }

    @Override
    public List<Ticket> buscarTodos(){
        return listaDeTicketsSalvos;
    }
}
