package pl.lucky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.lucky.model.Message;
import pl.lucky.service.MessageService;

import javax.validation.Validator;

@SpringBootApplication
public class TrainignValidationSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TrainignValidationSpringBootApplication.class, args);
        MessageService ms = ctx.getBean(MessageService.class);
        Message msg = new Message("Hello message", "cholera to brzydkie słowo");

        boolean verifyMsg = ms.verifyMessage(msg);
        System.out.println("Wiadomośc poprawna? " + verifyMsg);
        ctx.close();

    }

    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

}
