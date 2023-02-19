package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.filters.FilterSubsampling;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilterSubsamplingTest {

    @Test
    public void filterSubsampling(){

        FilterSubsampling ftr = new FilterSubsampling();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(50, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);

        Blueprint bp00 = ftr.filter(bp0);
        assertEquals(1, bp00.getPoints().size());
    }

    @Test
    public void filterSubsamplingOnlyOnePoint(){

        FilterSubsampling ftr = new FilterSubsampling();

        Point[] pts0=new Point[]{new Point(40, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);

        Blueprint bp00 = ftr.filter(bp0);
        assertEquals(0, bp00.getPoints().size());
    }

    @Test
    public void filterSubsamplingQuantityOfPointsOdd(){

        FilterSubsampling ftr = new FilterSubsampling();

        Point[] pts0=new Point[]{new Point(40, 40), new Point(80, 40), new Point(40, 4)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);

        Blueprint bp00 = ftr.filter(bp0);
        assertEquals(1, bp00.getPoints().size());
    }
}
