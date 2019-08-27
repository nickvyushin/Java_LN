package ru.stqa.ln.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase {

        public ChangePasswordHelper(ApplicationManager app) {
            super(app);
        }

        public void selectUserById(int id) {
            click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']"));
        }

        public void resetPassword() {
            click(By.xpath("//*[@id=\"manage-user-reset-form\"]"));
        }

        public void changePassword(String resetLink, String password) {
            wd.get(resetLink);
            type(By.name("password"), password);
            type(By.name("password_confirm"), password);
            click(By.cssSelector("button[type='submit']"));
        }

    }
