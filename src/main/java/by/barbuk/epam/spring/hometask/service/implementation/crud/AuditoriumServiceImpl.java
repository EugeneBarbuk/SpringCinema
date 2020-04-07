package by.barbuk.epam.spring.hometask.service.implementation.crud;

import by.barbuk.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
// TODO rework repository to DB and implement
public class AuditoriumServiceImpl {
    AuditoriumRepository auditoriumRepository;
    @Nullable
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumRepository.findByName(name);
    }
}
