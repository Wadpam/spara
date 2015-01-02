package com.wadpam.spara.api;

import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by sosandstrom on 2015-01-02.
 */
public class SparaResourceTest {

    @Test
    public void testFindTicketIds() {
        assertEquals(ImmutableSortedSet.of("ABC-123", "D-2"), SparaResource.findTicketIds("D-2 ABC-123 def-456 ABC-ABC this is my first commit."));
    }
}
