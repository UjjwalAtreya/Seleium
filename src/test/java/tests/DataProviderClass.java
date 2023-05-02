package tests;

import org.testng.annotations.DataProvider;

import static Utils.Helper.prop;

public class DataProviderClass {
    /* The data provider class will be responsible  to get the test data and provide it to the
    particular test.
    -- For now we are ignoring data provider, will be adding it soon
    * */

    @DataProvider(name = "data")
    public Object[][] getBaseUrl() {
        Object[][] data = new Object[1][1];
        data[0][0] = prop.getProperty("BaseUrl");
        return data;
    }
}
