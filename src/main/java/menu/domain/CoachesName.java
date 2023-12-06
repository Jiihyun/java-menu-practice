package menu.domain;

import menu.validator.NameValidator;

import java.util.List;

public class CoachesName {
    private final List<String> names;

    public CoachesName(List<String> names) {
        NameValidator.validateName(names);
        this.names = names;
    }
}
