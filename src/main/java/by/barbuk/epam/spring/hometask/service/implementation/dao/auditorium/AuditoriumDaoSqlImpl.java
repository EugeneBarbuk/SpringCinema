package by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium;

import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class AuditoriumDaoSqlImpl  implements AuditoriumService {

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return null;
    }

    @Override
    public Auditorium save(@Nonnull Auditorium object) {
        return null;
    }

    @Override
    public void remove(@Nonnull Auditorium auditorium) {

    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Auditorium> getAll() {
        return null;
    }
}
