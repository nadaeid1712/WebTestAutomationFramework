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
    @DataProvider
    public Object[][] getEmployeeBdAccount(){
        return new Object[][]{
                {"Adel1","Ibrahim","Talat" ,"F:\\WebTestAutomationFramework5\\Automation\\image\\employee image 1.png","hQPllyyy","adel123","adel123"}
        };
    }
    @DataProvider
    public Object[][] getFullFields(){
        return new Object[][]{

                {"Ahmed","Nagy","Shady","F:\\WebTestAutomationFramework5\\Automation\\image\\employee image 1.png","dadyyyy","shady123",
                        "shady123",985637,"2025-12-11",55,2,"1990-25-2",1,"AFC" }
        };
    }
    @DataProvider
    public Object[][] personalInfo(){
        return new Object[][]{
                {"ohood","a","s","55","gg444","2025-05-10"}
        };
    }



}