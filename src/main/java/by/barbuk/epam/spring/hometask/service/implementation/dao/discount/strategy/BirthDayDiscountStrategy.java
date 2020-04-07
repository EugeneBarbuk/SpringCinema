package by.barbuk.epam.spring.hometask.service.implementation.dao.discount.strategy;

import by.barbuk.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;

public class BirthDayDiscountStrategy implements AbstractDiscountStrategy {
    private static final int DISCOUNT_DAYS_INTERVAL = 5;
    private static final int BIRTHDAY_DISCOUNT = 5;

    @Override
    public int getDiscount(User user, LocalDateTime airDate, long numberOfTickets) {
        if (user.getBirthday() == null) {
            return 0;
        }
        if (Math.abs(airDate.getDayOfYear() - user.getBirthday().getDayOfYear()) <= DISCOUNT_DAYS_INTERVAL) {
            return BIRTHDAY_DISCOUNT;
        }
        return 0;
    }
}
