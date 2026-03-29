package Repositories.Interfaces;

import Entitys.Ticket;

import java.util.List;

public interface ITicketRepository {

    void salvar(Ticket ticket);
    List<Ticket> buscarPorIdUsuario(int idUsuario);
    Ticket buscarPorProtocolo(Long protocolo);
    Ticket buscarPorProtocoloEUsuario(Long protocolo, int idUsuario);
    List<Ticket> buscarTodos();
}
