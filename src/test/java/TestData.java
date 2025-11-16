import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider
    public Object[][] getLoginData() {
        return new Object[][]{
                {"Admin", "admin123"}
        };

    }
    @DataProvider
    public Object[][] getUrl () {
        return new Object[][]{
                {"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"}
        };

    }
    @DataProvider
    public Object[][] getEmployeeBd(){
        return new Object[][]{
                {"Ali","Hassan","Allam"}

        };
    }

    @DataProvider
    public Object[][] getEmployeeBdId(){
        return new Object[][]{
                {"Shady","Saad","Ali",895742}

        };
    }
}