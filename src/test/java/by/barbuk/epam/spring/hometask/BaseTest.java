package by.barbuk.epam.spring.hometask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BaseTest {
    protected ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    protected ApplicationContext testDataContext = new ClassPathXmlApplicationContext("classpath:beans/testData.xml");
}
