package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

 /*
        .properties uzantili dosyaya erisebilmek icin Properties class'indan obje olusturmamiz gerekir
      bu olusturdugumu obje ile akisa aldigimiz dosya yolunu properties.load(fis) methodu ile propeties
      dosyasindaki bilgileri objemize yukler ve properties dosyasindaki key degerini return ederiz
      Bunu yapmak icin parametreli bir method olusturur girdigimiz key'in degerini bize dondurur
     */


        /*
            .properties uzantili dosyaya erişebilmek için Properties class'ından obje oluşturmamız gerekir.
         bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu properties.load(fis) methodu ile properties
         dosyasındaki bilgileri objemize yükler ve properties dosyasındaki key değerini return ederiz.
         Bunu yapmak için parametreli bir method oluşturur girdiğimiz key'in değerini bize döndürür
         */
        static Properties properties;
        static {
            try {
                FileInputStream fis = new FileInputStream("configuration.properties");
                properties = new Properties();
                properties.load(fis);//-->fis'in okuduğu bilgileri properties'e yükler
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static String getProperty(String key) {

            return properties.getProperty(key);//-->String olarak girdiğim key'in değerini return eder
        }

    }
