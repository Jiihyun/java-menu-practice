package menu.validator;

import menu.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator {
    private static final int NAME_MINIMUM_LENGTH = 2;
    private static final int NAME_MAXIMUM_LENGTH = 4;
    private static final int COACH_MINIMUM_COUNT = 2;
    private static final int COACH_MAXIMUM_COUNT = 5;

    private NameValidator() {
        throw new AssertionError();
    }

    public static void validateName(List<String> coachesName) {
        validateDuplicatedName(coachesName);
        validateNameLength(coachesName);
        validateCoachNameCount(coachesName);
    }

    private static void validateDuplicatedName(List<String> coachesName) {
        Set<String> names = new HashSet<>();
        for (String coachName : coachesName) {
            if (!names.add(coachName)) {
                throw ExceptionMessage.DUPLICATED_NAME.getException();
            }
        }
    }

    private static void validateNameLength(List<String> coachesName) {
        for (String name : coachesName) {
            checkLengthOf(name);
        }
    }

    private static void checkLengthOf(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH || name.length() > NAME_MAXIMUM_LENGTH) {
            throw ExceptionMessage.NAME_LENGTH.getException();
        }
    }

    private static void validateCoachNameCount(List<String> coachesName) {
        if (coachesName.size() < COACH_MINIMUM_COUNT || coachesName.size() > COACH_MAXIMUM_COUNT) {
            throw ExceptionMessage.COACH_COUNT.getException();
        }
    }
}

