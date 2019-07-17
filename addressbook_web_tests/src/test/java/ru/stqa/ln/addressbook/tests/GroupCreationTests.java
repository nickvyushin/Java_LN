package ru.stqa.ln.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ln.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("New Test", "New Test 2", "New Test 3"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }


}
