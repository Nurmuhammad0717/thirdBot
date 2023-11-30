package uz.pdp.bot;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CommandEnum {

    START("/start"),
    HELP("/help"),
    SEND_MAIL("/send_mail"),
    ORDER("/order");


      private static Map<String,CommandEnum> map = Arrays.stream(CommandEnum.values())
              .collect(Collectors.toMap(c -> c.value, c -> c ));


    public final String value;

    CommandEnum(String value) {
        this.value = value;
    }

    public static CommandEnum of(String command){
        CommandEnum commandEnum = map.get(command);

        if(commandEnum != null){
            return commandEnum;
        }
           throw new IllegalArgumentException("Unsupported command");
    }


}
