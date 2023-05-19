package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserManagement {

    @FindBy(xpath = "(//div[@class='oxd-form-row']//input)[1]")
    public WebElement userSearchInputField;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class='oxd-table-card']//div[@class='oxd-table-cell oxd-padding-cell']/div)[2]")
    public WebElement searchedItem;

    public WebDriver driver;
    public WebDriverWait wait;
    public UserManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTextInSearchBox(String searchText){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userSearchInputField));
        userSearchInputField.sendKeys(searchText);
        searchButton.click();
    }

    public String getSearchedItem(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(searchedItem));
        return searchedItem.getText();
    }

}
