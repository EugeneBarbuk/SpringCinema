package by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium;

import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;


public class AuditoriumRepositoryImpl implements AuditoriumService {

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        Optional<Auditorium> exist = AuditoriumStorage.auditoriums.values().stream().filter(user -> user.getName().equalsIgnoreCase(name)).findAny();
        return exist.orElse(null);
    }

    @Override
    public Auditorium save(@Nonnull Auditorium auditorium) {
        AuditoriumStorage.auditoriums.put(auditorium.getId(), auditorium);
        return auditorium;
    }

    @Override
    public void remove(@Nonnull Auditorium auditorium) {
        AuditoriumStorage.auditoriums.remove(auditorium.getId());
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        Optional<Auditorium> exist = AuditoriumStorage.auditoriums.values().stream().filter(user -> user.getId().equals(id)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Collection getAll() {
        return new HashSet<>(AuditoriumStorage.auditoriums.values());
    }
}

