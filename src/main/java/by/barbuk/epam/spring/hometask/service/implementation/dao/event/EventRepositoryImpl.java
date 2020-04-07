package by.barbuk.epam.spring.hometask.service.implementation.dao.event;

import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EventRepositoryImpl implements EventService {


    @Override
    public Event save(@Nonnull Event event) {
        EventStorage.events.put(event.getId(), event);
        return event;
    }

    @Override
    public void remove(@Nonnull Event event) {
        EventStorage.events.remove(event.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {
        Optional<Event> exist = EventStorage.events.values().stream().filter(event -> event.getId().equals(id)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return new HashSet<>(EventStorage.events.values());
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        Optional<Event> exist = EventStorage.events.values().stream().filter(event -> event.getName().equalsIgnoreCase(name)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return getAll().stream().filter(event -> event.airsOnDates(from.atStartOfDay(), to.atStartOfDay())).collect(Collectors.toSet());
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return getAll().stream().filter(event -> event.airsOnDates(LocalDateTime.now(), to)).collect(Collectors.toSet());
    }
}
