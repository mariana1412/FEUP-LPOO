package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private List<Integer> list;

    @Before
    public void setUpList(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }


    @Test
    public void deduplicate() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class StubListSorter implements IListSorter{
            public List<Integer> sort(){
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(2);
                unique.add(4);
                return unique;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubListSorter());

        assertEquals(expected, distinct);
    }
}