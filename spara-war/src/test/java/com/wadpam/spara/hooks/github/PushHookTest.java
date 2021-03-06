package com.wadpam.spara.hooks.github;

import com.wadpam.spara.hooks.GithubResource;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sosandstrom on 2014-12-30.
 */
public class PushHookTest {

    @Test
    public void testProcess() throws IOException {
        final String json = getResourceAsString("/push.json");
        PushHook hook = new PushHook(null);
        PushRequest event = hook.parseEvent(json);

        assertEquals(2, event.getCommits().size());

    }

    private String getResourceAsString(String path) throws IOException {
        InputStream in = getClass().getResourceAsStream(path);
        StringBuffer sb = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String s;
        while (null != (s = bufferedReader.readLine())) {
            if (0 < sb.length()) {
                sb.append('\n');
            }
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void testDateFormat() throws ParseException {
        assertEquals(PushHook.SDF.parse("2014-12-30T12:15:45+00:00"), PushHook.SDF.parse("2014-12-30T13:15:45+01:00"));
    }
}
