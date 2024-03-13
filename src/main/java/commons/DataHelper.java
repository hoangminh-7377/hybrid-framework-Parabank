package commons;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static DataHelper getDataHelper() {
        return new DataHelper();
    }

    public String getFirstName(){
        return faker.address().firstName();
    }

    public String getLastName(){
        return faker.address().lastName();
    }

    public String getFullName(){
        return faker.name().fullName();
    }

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getCity(){
        return faker.address().city();
    }

    public String getCityName(){
        return faker.address().cityName();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public String getCompanyName(){
        return faker.company().name();
    }

    public String getAddress(){
        return faker.address().streetAddress();
    }

    public String getPassword(){
        return faker.internet().password(8,12,true,true,true);
    }

    public String getSSN(){
        String[] urlList = {
                "https://www.facebook.com/",
                "https://www.twitter.com/",
                "https://www.instagram.com/",
                "https://www.linkedin.com/",
                "https://www.youtube.com/"
        };
        String randomlySelectedUrl = getRandomUrl(urlList);
        return randomlySelectedUrl;
    }

    public static String getRandomUrl(String[] list) {
        Random random = new Random();
        int selectedIndex = random.nextInt(list.length);
        return list[selectedIndex];
    }

    public String getState() {
        return faker.address().state();
    }

    public String getZipcode() {
        return faker.address().zipCode();
    }

    public String getUserName() {
        return getFirstName()+getFirstName()+ "_" + getRandomNumber();
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}