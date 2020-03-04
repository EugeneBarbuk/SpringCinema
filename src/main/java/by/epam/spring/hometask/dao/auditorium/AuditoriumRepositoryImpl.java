package by.epam.spring.hometask.dao.auditorium;

import by.epam.spring.hometask.domain.Auditorium;
import by.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuditoriumRepositoryImpl implements AuditoriumService {

    private static Set<Auditorium> auditoriums = new HashSet<>();

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        List<Auditorium> list = auditoriums.stream().filter(auditorium -> auditorium.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Auditorium save(@Nonnull Auditorium object) {
        auditoriums.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Auditorium object) {
        auditoriums.remove(object);
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        List<Auditorium> list = auditoriums.stream().filter(auditorium -> auditorium.getId().equals(id)).collect(Collectors.toList());
        return list.isEmpty() ? null : list.get(0);
    }

    @Nonnull
    @Override
    public Collection getAll() {
        return auditoriums;
    }
}

