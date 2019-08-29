package ru.stqa.ln.mantis.tests;

import org.testng.SkipException;
import org.testng.annotations.Test;
import ru.stqa.ln.mantis.model.Issue;
import ru.stqa.ln.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase{

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        try {
            skipIfNotFixed(0000001);
        } catch (SkipException e) {
            e.printStackTrace();
        }
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        try {
            skipIfNotFixed(0000002);
        } catch (SkipException e) {
            e.printStackTrace();
        }
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());

    }
}
