package bald.bible.automation.test.suite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class BaldHomePage {
    protected WebDriver driver;
    private final By homepageStatement = By.cssSelector("p[id='new-todo']");


    public BaldHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Format By for indexed todo item (label text)
    By getTodoLabelSelector(int index) {
        String todoLabelSelector = String.format(".todo-list li:nth-child(%d) label", index );
        By todoLabelSelectorBy;
        todoLabelSelectorBy = By.cssSelector(todoLabelSelector);
        return todoLabelSelectorBy;
    }

    public void takeScreenshot(String desiredPath) throws Exception {
        TakesScreenshot screenshot = ((TakesScreenshot)this.driver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }

    public void navigate() {
        driver.get("http://localhost:5173");
    }

//    public void addNewTodoItem(String todoValue) {
//        WebElement newTodoInput = driver.findElement(newTodoInputBy);
//        newTodoInput.sendKeys(todoValue);
//        newTodoInput.sendKeys(Keys.ENTER);
//    }

    public String getTodoText(int index) {
        WebElement todo = driver.findElement(getTodoLabelSelector(index));
        return todo.getText();
    }
}
