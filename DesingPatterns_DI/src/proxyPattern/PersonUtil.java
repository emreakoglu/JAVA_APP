package proxyPattern;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PersonUtil {

    public static List<Person> mockPersons() {
        List<Person> persons = Arrays.asList(
                new Person("alican", "akkus", "male", 23, new Date().getTime() + new Random().nextInt()),
                new Person("mustafa", "demir", "male", 22, new Date().getTime() + new Random().nextInt()),
                new Person("enes", "dalkiran", "male", 25, new Date().getTime() + new Random().nextInt()),
                new Person("ilkay", "gunel", "male", 23, new Date().getTime() + new Random().nextInt()),
                new Person("hatun", "hatun", "female", 29, new Date().getTime() + new Random().nextInt()));
        return persons;
    }
}
