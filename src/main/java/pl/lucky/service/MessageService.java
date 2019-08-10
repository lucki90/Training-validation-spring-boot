package pl.lucky.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lucky.model.Message;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class MessageService {

    private Validator validator;

    @Autowired
    public MessageService(Validator validator) {
        this.validator = validator;
    }

    public boolean verifyMessage(Message msg) {
        Set<ConstraintViolation<Message>> errors = validator.validate(msg);

        if (!errors.isEmpty()) {
            for (ConstraintViolation<Message> error : errors) {
                System.out.println(error.getMessage());
            }
            return false;
        } else {
            return true;
        }
    }

}
