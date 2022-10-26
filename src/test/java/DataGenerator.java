import com.github.javafaker.Faker;
import lombok.Value;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator(){}

    public static String dateGeneration(int shift){
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String cityGeneration(){
        var cities = new String[]{
                "Ярославль","Москва","Ростов-на-Дону","Казань","Иваново","Сызрань","Тула","Владимир",
                "Вологда","Астрахань","Махачкала","Рязань","Тверь","Кострома",
        };

        return cities[new Random().nextInt(cities.length)];
    }
    public static String nameGeneration(String locale){
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }


        public static String phoneGeneration(String locale){
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration{
        private Registration(){
        }

        public static UserInfo userGeneration(String locale){
            return new UserInfo(cityGeneration(), nameGeneration(locale), phoneGeneration(locale));
        }
    }
    @Value
    public static class UserInfo{
        String city;
        String name;
        String phone;
    }

}
