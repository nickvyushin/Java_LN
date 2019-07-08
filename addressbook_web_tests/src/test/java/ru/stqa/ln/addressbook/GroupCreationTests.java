package ru.stqa.ln.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test1", "test1"));
        submitGroupCreation();
        returnGroupPage();
    }


}
