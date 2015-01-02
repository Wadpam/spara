package com.wadpam.spara.api;

import com.google.common.collect.ImmutableSortedSet;
import com.wadpam.guja.util.Pair;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by sosandstrom on 2015-01-02.
 */
public class SparaResourceTest {

    @Test
    public void testFindTicketIds() {
        assertEquals(ImmutableSortedSet.of(Pair.of("ABC", 123L), Pair.of("D", 2L)), SparaResource.findTicketIds("D-2 ABC-123 def-456 ABC-ABC this is my first commit."));
    }
}
