package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderReader {

    @DataProvider
    public static Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","icAnadolu","06"},
                              {"Zonguldak","karadeniz","67"},
                               {"Duzce","karadeniz","81"},
                                {"Diyarbakır","Dogu","21"}};
    }
}
