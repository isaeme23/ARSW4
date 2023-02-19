package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.filters.FilterRedundancies;
import org.junit.Test;
import static org.junit.Assert.*;


public class FilterRedundanciesTest {

    @Test
    public void filterRedundancies(){

        FilterRedundancies ftr = new FilterRedundancies();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);

        Blueprint bp00 = ftr.filter(bp0);
        assertEquals(1, bp00.getPoints().size());
    }
}
