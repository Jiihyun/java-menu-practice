package menu.view;

import menu.converter.Converter;
import menu.domain.Coaches;
import menu.domain.CoachesNonEdibleMenus;
import menu.domain.NonEdibleMenus;
import menu.domain.NonEdibleMenusByCoach;
import menu.io.reader.Reader;
import menu.io.writer.Writer;

import java.util.ArrayList;
import java.util.List;

import static menu.view.constants.PrintMessage.*;

public class InputView {
    private final Writer writer;
    private final Reader reader;
    private final RetryHandler retryHandler;

    public InputView(Writer writer, Reader reader, RetryHandler retryHandler) {
        this.writer = writer;
        this.reader = reader;
        this.retryHandler = retryHandler;
    }

    public CoachesNonEdibleMenus readAll() {
        List<NonEdibleMenusByCoach> coachesNonEdibleMenus = new ArrayList<>();
        writer.writeln(INPUT_START.getMessage());

        Coaches coaches = retryHandler.retryUntilSuccess(this::getCoachesName);
        for (int index = 0; index < coaches.getCoachesCount(); index++) {
            putCoachesNonEdibleMenus(coachesNonEdibleMenus, coaches, index);
        }
        reader.close();

        return new CoachesNonEdibleMenus(coachesNonEdibleMenus);
    }

    private void putCoachesNonEdibleMenus(List<NonEdibleMenusByCoach> coachesNonEdibleMenus, Coaches coaches, int index) {
        String coachName = coaches.getCoachName(index);
        writer.writef(coachName + INPUT_NON_EDIBLE_MENU_MSG.getMessage());
        NonEdibleMenus nonEdibleMenus = retryHandler.retryUntilSuccess(this::getNonEdibleMenu);
        coachesNonEdibleMenus.add(new NonEdibleMenusByCoach(coachName, nonEdibleMenus));
    }

    private Coaches getCoachesName() {
        writer.writeln(INPUT_COACHES_NAME_MSG.getMessage());
        List<String> names = Converter.convertStrToList(reader.readLine());
        return new Coaches(names);
    }

    private NonEdibleMenus getNonEdibleMenu() {
        List<String> menus = Converter.convertStrToListWithoutValidateBlank(reader.readLine());
        return new NonEdibleMenus(menus);
    }
}
