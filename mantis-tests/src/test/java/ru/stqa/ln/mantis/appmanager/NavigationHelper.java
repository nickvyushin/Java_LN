package ru.stqa.ln.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.ln.mantis.model.UserData;

public class NavigationHelper extends HelperBase{
    public ApplicationManager app;

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }
    public void control() {
        click(By.xpath("//li[7]/a/i"));
    }

    public void controlUsers() {
        click(By.linkText("Управление пользователями"));
    }
}
