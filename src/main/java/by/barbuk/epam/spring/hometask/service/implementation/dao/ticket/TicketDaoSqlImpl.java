package by.barbuk.epam.spring.hometask.service.implementation.dao.ticket;

import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.service.AbstractDomainObjectService;
import by.barbuk.epam.spring.hometask.service.TicketService;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class TicketDaoSqlImpl implements TicketService {
    @Override
    public Ticket save(@Nonnull Ticket object) {
        return null;
    }

    @Override
    public void remove(@Nonnull Ticket object) {

    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Ticket> getAll() {
        return null;
    }

    @Override
    public Set<Ticket> getTicketsByEmail(String email) {
        return null;
    }

    @Override
    public Set<Ticket> getTicketsByEvent(Event event, LocalDateTime dateTime) {
        return null;
    }
}
