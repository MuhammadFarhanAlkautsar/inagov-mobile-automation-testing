package inadigital.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class Utils {
    public static Properties ELEMENTS;
    private static final Dotenv dotenv = Dotenv.load();

    public static void loadElementProperties(String directory) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        ELEMENTS = new Properties();

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].toString().contains(".properties")) {
                try {
                    ELEMENTS.load(new FileInputStream(directory + listOfFiles[i].getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String env(String key){
        return dotenv.get(key);
    }
    public static void waitABit(Integer seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
