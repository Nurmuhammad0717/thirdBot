package uz.pdp.bot.contact;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InfoManager {

    public static List<Person> getInfos() throws IOException {

        String data = Files.readString(Path.of("src/main/resources/MOCK_DATA.json"));

        Type type = new TypeToken<List<Person>>() {}.getType();

        List<Person> people = new GsonBuilder().create().fromJson(data, type);

        return people;
    }

}
