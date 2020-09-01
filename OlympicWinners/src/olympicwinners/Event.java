/*******************************************************************************
* Event.java
* Max Beard
* 
* simulates a sporting event in the Olympics
*******************************************************************************/
package olympicwinners;

import java.io.Serializable;
import java.util.Arrays;

public class Event implements Serializable
{
    public String eventName;
    public String type;
    public Competitor[] competitors;        // array of competitors in each event
    public int i;                           // index for array
    
    public Event(String name, String type)
    {
        eventName = name;
        this.type = type;
        competitors = new Competitor[5];        
    } // end constructor
    
    public String getEventName()
    {
        return eventName;
    } // end getEventName
    
    public void addCompetitors(Competitor comp)
    {
        competitors[i] = comp;
        i++;
    } // end addCompetitors
    
    // sorting method for getting winners
    public Competitor[] sortWinner()
    {
        Arrays.sort(competitors, new Competitor());
        if(type.equalsIgnoreCase("scored")){
            // returning highest 3 competitors for scored event
            return new Competitor[]{ competitors[4], competitors[3], competitors[2]};
        } else {
            // returning lowest 3 competitors for timed event
            return new Competitor[]{ competitors[0], competitors[1], competitors[2]};
        }
    } // end sortWinner;
} // end Event
