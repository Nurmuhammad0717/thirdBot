package uz.pdp;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.bot.UniversalBot;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws TelegramApiException, IOException {

        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);

        UniversalBot bot = new UniversalBot();

        api.registerBot(bot);




    }
}
