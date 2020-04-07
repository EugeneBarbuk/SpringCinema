package by.barbuk.epam.spring.hometask.service.implementation.dao.ticket;

import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.service.TicketService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketRepositoryImpl implements TicketService {

    @Override
    public Ticket save(@Nonnull Ticket ticket) {
        TicketStorage.tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public void remove(@Nonnull Ticket ticket) {
        TicketStorage.tickets.remove(ticket.getId());
    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        Optional<Ticket> exist = TicketStorage.tickets.values().stream().filter(ticket -> ticket.getId().equals(id)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Collection getAll() {
        return new HashSet<>(TicketStorage.tickets.values());
    }


    @Nullable
    public Set<Ticket> getTicketsByEmail(String email) {
        return TicketStorage.tickets.values().stream()
                .filter(ticket -> ticket.getUser().getEmail().equals(email))
                .collect(Collectors.toSet());
    }

    @Nullable
    public Set<Ticket> getTicketsByEvent(Event event, LocalDateTime dateTime) {
        return TicketStorage.tickets.values().stream()
                .filter(ticket ->
                        ticket.getEvent().getId().equals(event.getId())
                                && ticket.getDateTime().equals(dateTime))
                .collect(Collectors.toSet());
    }

}
