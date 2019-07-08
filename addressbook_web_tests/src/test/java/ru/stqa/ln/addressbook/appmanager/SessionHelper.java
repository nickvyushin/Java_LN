package ru.stqa.ln.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SessionHelper extends HelperBase {

    public SessionHelper(ChromeDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

}
