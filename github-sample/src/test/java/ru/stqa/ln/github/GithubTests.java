package ru.stqa.ln.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("ca6cf401a1614501d97ea9b2eb89b82fec4b4f28");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("nickvyushin", "Java_LN")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
