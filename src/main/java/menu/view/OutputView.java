package menu.view;

import menu.domain.constants.MenuCategories;
import menu.io.writer.Writer;

import java.util.List;
import java.util.Map;

import static menu.view.constants.PrintFormat.RESULT_FORMAT;
import static menu.view.constants.PrintMessage.OUTPUT_END;

public class OutputView {
    private static final String DELIMETER = " | ";
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printResult(Map<String, List<String>> weeklyMenu, List<MenuCategories> weeklyMenuCategories) {
        writer.writef(RESULT_FORMAT.getFormat());
        List<String> categories = weeklyMenuCategories
                .stream().map(MenuCategories::getCategoryName)
                .toList();

        writer.writef("[ 카테고리 | %s ]" + System.lineSeparator(), String.join(DELIMETER, categories));

        for (Map.Entry<String, List<String>> resultEntry : weeklyMenu.entrySet()) {
            writer.writef("[ %s | %s ]" + System.lineSeparator(), resultEntry.getKey(), String.join(DELIMETER, resultEntry.getValue()));
        }
        writer.writeln(OUTPUT_END.getMessage());
    }
}
