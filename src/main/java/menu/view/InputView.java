package menu.view;

import menu.converter.Converter;
import menu.domain.Coaches;
import menu.io.reader.Reader;
import menu.io.writer.Writer;

import java.util.List;

import static menu.view.constants.PrintMessage.INPUT_COACHES_NAME_MSG;
import static menu.view.constants.PrintMessage.INPUT_START;

public class InputView {
    private final Writer writer;
    private final Reader reader;
    private final RetryHandler retryHandler;

    public InputView(Writer writer, Reader reader, RetryHandler retryHandler) {
        this.writer = writer;
        this.reader = reader;
        this.retryHandler = retryHandler;
    }

    public void readAll() {
        writer.writeln(INPUT_START.getMessage());
        Coaches coaches = retryHandler.retryUntilSuccess(this::getCoachesName);
        reader.close();
//        return aaa;
    }

    private Coaches getCoachesName() {
        writer.writeln(INPUT_COACHES_NAME_MSG.getMessage());
        List<String> names = Converter.convertStrToList(reader.readLine());
        return new Coaches(names);
    }
}
