package uz.pdp.bot;

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
