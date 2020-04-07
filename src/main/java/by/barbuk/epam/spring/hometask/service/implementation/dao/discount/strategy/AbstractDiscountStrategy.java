package by.barbuk.epam.spring.hometask.service.implementation.dao.discount.strategy;

import by.barbuk.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;

public interface AbstractDiscountStrategy {
    int getDiscount(User user, LocalDateTime airDate, long numberOfTickets);
}
