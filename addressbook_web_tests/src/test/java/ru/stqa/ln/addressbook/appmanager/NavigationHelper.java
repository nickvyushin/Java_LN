package ru.stqa.ln.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoAddNew() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoHome() {
        click(By.linkText("home"));
    }
}
