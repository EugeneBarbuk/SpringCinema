package by.barbuk.epam.spring.hometask.service;

import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public interface TicketService extends  AbstractDomainObjectService<Ticket>{
    Set<Ticket> getTicketsByEmail(String email);
    Set<Ticket> getTicketsByEvent(Event event, LocalDateTime dateTime);
}
