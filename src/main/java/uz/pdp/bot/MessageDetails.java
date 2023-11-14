package uz.pdp.bot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDetails {
    private String recipient;
    private String subject;
    private String   text;

    public MessageDetails(String recipient) {
        this.recipient = recipient;
    }
}
