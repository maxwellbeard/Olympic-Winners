/*******************************************************************************
* Competitor.java
* Max Beard
* 
* simulates a competitor in an event
*******************************************************************************/
package olympicwinners;

import java.io.Serializable;
import java.util.Comparator;

public class Competitor implements Serializable, Comparator<Competitor>
{
    public String name;
    public double scoreTime;
    
    // empty constructor for sorting
    public Competitor()
    {
        scoreTime = 0;
    }
    
    public Competitor(String name, double scoreTime)
    {
        this.name = name;
        this.scoreTime = scoreTime;
    } // end constructor

    public String getName() {
        return name;
    } // end getName
    
    public double getScoreTime() {
        return scoreTime;
    } // end getScoreTime

    // overriding compare method from comparator
    @Override
    public int compare(Competitor o1, Competitor o2)
    {
        int highScoreOne = (int) o1.getScoreTime();
        int highScoreTwo = (int) o2.getScoreTime();
        
        return highScoreOne > highScoreTwo ? 1 :
               highScoreTwo > highScoreOne ? -1 :
               0;
    }
} // end Competitor
