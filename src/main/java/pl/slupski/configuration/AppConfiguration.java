package pl.slupski.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.Configuration;
import pl.slupski.model.entiy.TProduct;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Configuration
@ComponentScan({"pl.slupski.model.dao", "pl.slupski.controller.services", "pl.slupski.model"})
public class AppConfiguration {

    private SessionFactory sessionFactory;

    @Bean
    public SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().addAnnotatedClass(TProduct.class);
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
    }
}
