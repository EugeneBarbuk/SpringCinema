package by.epam.spring.hometask.service;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import by.epam.spring.hometask.domain.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yuriy_Tkach
 */
public interface AuditoriumService extends JpaRepository {

    /**
     * Finding auditorium by name
     * 
     * @param name
     *            Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    public @Nullable Auditorium getByName(@Nonnull String name);
    //aasdfasd
    ///lkajsd

}
