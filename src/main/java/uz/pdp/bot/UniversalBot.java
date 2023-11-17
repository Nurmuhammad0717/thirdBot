
package uz.pdp.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.bot.handler.HandlerManager;

public class UniversalBot extends TelegramLongPollingBot {

    public UniversalBot() {
        super("6731491453:AAFgndc-G3I-sr72L5qDqPWPPTKv3TvoCFc");
    }

    @Override
    public void onUpdateReceived(Update update) {

        HandlerManager.handle(update,this);

    }

    @Override
    public String getBotUsername() {
        return "Uni_VersalBot_bot";
    }
}
