
package uz.pdp.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.bot.handler.HandlerManager;

import static uz.pdp.bot.BotConfig.BOT_TOKEN;
import static uz.pdp.bot.BotConfig.BOT_USERNAME;

public class UniversalBot extends TelegramLongPollingBot {

    public UniversalBot() {
        super(BOT_TOKEN);
    }

    @Override
    public void onUpdateReceived(Update update) {

        HandlerManager.handle(update,this);

    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }
}
