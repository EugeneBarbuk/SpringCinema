package by.epam.spring.hometask.dao.event;

import by.epam.spring.hometask.domain.Event;
import by.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EventRepositoryImpl implements EventService {
    private Set<Event> events = new HashSet<>();

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return null;
    }

    @Override
    public Event save(@Nonnull Event object) {
        events.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Event object) {
        events.remove(object);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return null;
    }
}
