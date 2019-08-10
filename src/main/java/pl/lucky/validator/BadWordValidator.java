package pl.lucky.validator;

import pl.lucky.common.Lang;
import pl.lucky.constraint.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {

    private Lang[] languages;

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.languages = constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        boolean valid = true;
        for (Lang lang : languages) {
            if (lang == Lang.PL) {
                valid &= plFilter(s);
            }
            if (lang == Lang.ENG) {
                valid &= endFilter(s);
            }
        }
        return valid;
    }


    private boolean plFilter(String text) {
        List<String> badWords = Arrays.asList("kurka", "cholera");
        return generalFilter(text, badWords);
    }

    private boolean endFilter(String text) {
        List<String> badWords = Arrays.asList("fak", "damn");
        return generalFilter(text, badWords);
    }

    private boolean generalFilter(String text, List<String> badWords) {
        List<String> found = badWords
                .stream()
                .filter(word -> text
                        .toLowerCase()
                        .contains(word))
                .collect(Collectors.toList());
        return found.isEmpty();
    }
}
