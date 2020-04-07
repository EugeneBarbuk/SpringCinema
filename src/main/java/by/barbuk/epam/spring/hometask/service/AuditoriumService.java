package by.barbuk.epam.spring.hometask.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import by.barbuk.epam.spring.hometask.domain.Auditorium;

public interface AuditoriumService extends  AbstractDomainObjectService<Auditorium> {

    /**
     * Finding auditorium by name
     *
     * @param name Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    @Nullable
    Auditorium getByName(@Nonnull String name);

}
