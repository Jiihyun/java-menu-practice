package menu.domain;

import menu.validator.NameValidator;

import java.util.List;

public class Coaches {
    private final List<String> names;

    public Coaches(List<String> names) {
        NameValidator.validateName(names);
        this.names = names;
    }

    public int getCoachesCount() {
        return names.size();
    }

    public String getCoachName(int index) {
        return names.get(index);
    }
}
