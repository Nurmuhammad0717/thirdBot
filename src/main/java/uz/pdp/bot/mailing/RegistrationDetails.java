package uz.pdp.bot.mailing;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationDetails {

    private String userName;
    private String password;

    public RegistrationDetails(String userName) {
        this.userName = userName;
    }
}
