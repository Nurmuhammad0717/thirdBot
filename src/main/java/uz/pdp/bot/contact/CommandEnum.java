package uz.pdp.bot.contact;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CommandEnum {

      ID("/id"),
      FIRST_NAME("/firstName"),
    LAST_NAME("/lastName"),
    PHONE_NUMBER("/phoneNumber"),
    BIRTH_DATE("/birthDate"),
    ANY_INFO("/anyInfo");


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
