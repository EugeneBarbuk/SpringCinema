package by.barbuk.epam.spring.hometask.service.implementation.dao.discount;


import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.DiscountService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.discount.strategy.AbstractDiscountStrategy;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Set;

public class DiscountServiceImpl implements DiscountService {

    private Set<AbstractDiscountStrategy> discounts;

    public void setDiscountStrategies(Set discountStrategies) {
        this.discounts = discountStrategies;
    }

    @Override
    public int getDiscount(
            User user,
            Event event,
            LocalDateTime airDateTime,
            long numberOfTickets) {
        int maxDiscount = 0;
        for (AbstractDiscountStrategy discountStrategy : discounts) {
            int discountValue = discountStrategy.getDiscount(user, airDateTime, numberOfTickets);
            if (discountValue > maxDiscount) {
                maxDiscount = discountValue;
            }
        }
        return maxDiscount;
    }
}
