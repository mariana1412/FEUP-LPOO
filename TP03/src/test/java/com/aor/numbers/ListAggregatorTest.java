package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    private List<Integer> list;

    @Before
    public void setUpList() {
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);
        this.list.add(5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max2() { //alinea 4

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }


    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {


        class StubListDeduplicator implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter list){
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(4);
                unique.add(5);
                return unique;
            }
        }

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubListDeduplicator());

        assertEquals(4, distinct);

    }

    public void distinct2() {

        class StubListDeduplicator implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter list){
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(4);
                return unique;
            }
        }

        this.list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubListDeduplicator());

        assertEquals(3, distinct);

    }


}