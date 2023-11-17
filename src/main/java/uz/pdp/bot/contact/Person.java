package uz.pdp.bot.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String city;
    private String birthDate;

    @Override
    public String toString() {
        return "Person[" +
                "id=" + id +
                "\n firstName= " + firstName  +
                "\n lastName= " + lastName  +
                "\n gender= " + gender  +
                "\n phoneNumber= " + phoneNumber +
                "\n city= " + city  +
                "\n birthDate= " + birthDate  +
                "\n===================================";
    }
}
