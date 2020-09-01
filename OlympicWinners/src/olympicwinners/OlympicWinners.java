/*******************************************************************************
* Olympic Winners
* Max Beard
* 
* displays Winter Olympics event winners
*******************************************************************************/
package olympicwinners;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class OlympicWinners  extends JFrame
{
    private static final int WIDTH = 350;
    private static final int HEIGHT = 300;
    private JComboBox eventBox;                         // drop-down list of events
    private JLabel goldLabel;                           // label for displaying gold medal
    private JLabel silverLabel;                         // label for displaying silver medal
    private JLabel bronzeLabel;                         // label for displaying bronze medal
    private JLabel goldName;
    private JLabel goldScore;
    private JLabel silverName;
    private JLabel silverScore;
    private JLabel bronzeName;
    private JLabel bronzeScore;
    private JLabel nameLabel;
    private JLabel scoreLabel;
    private JButton btn;
    private static String[] events = new String[4];     // array of events
    
    public OlympicWinners()
    {
        setTitle("Winter Olympic Winners");
        setSize(WIDTH, HEIGHT);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    } // end constructor
    
    // creating contents for the window
    private void createContents()
    {
        Listener listener = new Listener();
        JPanel eventPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JPanel resultPanel = new JPanel(new GridLayout(4, 3));
        
        // adding to event panel
        JLabel eventLabel = new JLabel("Event");
        eventBox = new JComboBox(events);
        eventPanel.add(eventLabel);
        eventPanel.add(eventBox);
        
        // adding to button panel
        JButton resultsBtn = new JButton("View Winners");
        JButton addEventBtn = new JButton("Add New Event");
        btnPanel.add(resultsBtn);
        btnPanel.add(addEventBtn);
        
        // adding to result panel
        resultPanel.add(new JLabel());
        resultPanel.add(nameLabel = new JLabel(" "));
        resultPanel.add(scoreLabel = new JLabel(" "));
        resultPanel.add(goldLabel = new JLabel(" "));
        resultPanel.add(goldName = new JLabel(" "));
        resultPanel.add(goldScore = new JLabel(" "));
        resultPanel.add(silverLabel = new JLabel(" "));
        resultPanel.add(silverName = new JLabel(" "));
        resultPanel.add(silverScore = new JLabel(" "));
        resultPanel.add(bronzeLabel = new JLabel(" "));
        resultPanel.add(bronzeName = new JLabel(" "));
        resultPanel.add(bronzeScore = new JLabel(" "));
        resultPanel.setBorder(new EmptyBorder(0,20,10,0));
        
        // adding panels to window
        add(eventPanel);
        add(btnPanel);
        add(resultPanel);
        
        // adding event listeners
        resultsBtn.addActionListener(listener);
        addEventBtn.addActionListener(listener);
    } // end createContents
    
    //*****************************************************************************************************
    
    // inner class for event handling
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Event event;                        // Object holder for reading in file
            Competitor[] winners;               // array for winners
            // reading in from file
            if(e.getActionCommand().equals("View Winners")){
                try(ObjectInputStream fileIn = new ObjectInputStream(
                    new FileInputStream("info.txt")))
                {
                    while(true){
                        event = (Event) fileIn.readObject();
                        if(eventBox.getSelectedItem().equals(event.getEventName())){
                            winners = event.sortWinner();   // call sorting method to sort winners
                            break; // if selected item is equal to object being read, break from loop
                        }
                    }

                    // setting labels for winner output
                    nameLabel.setText("Name");
                    scoreLabel.setText("Score/Time");
                    goldLabel.setText("Gold medal: ");
                    goldName.setText(winners[0].getName());
                    goldScore.setText(Double.toString(winners[0].getScoreTime()));
                    silverLabel.setText("Silver medal: ");
                    silverName.setText(winners[1].getName());
                    silverScore.setText(Double.toString(winners[1].getScoreTime()));
                    bronzeLabel.setText("Bronze medal: ");
                    bronzeName.setText(winners[2].getName());
                    bronzeScore.setText(Double.toString(winners[2].getScoreTime()));
                }
                catch(EOFException eof){} // breaks out of loop
                catch(Exception ex){
                    System.out.println(ex.getClass());
                    System.out.println(ex.getMessage());
                }
            } else {
                new AddEventGui();
                dispose();
            }
        } // end actionPerformed
    } // end Listener
    
    //*******************************************************************************************************
    
    public static void main(String[] args) 
    {
        Event event;                // used for writing to file
        
        // writing events to file
        try(ObjectOutputStream fileOut = new ObjectOutputStream(
            new FileOutputStream("info.txt")))
        {
            // creating Skiing and adding competitors
            event = new Event("Skiing", "scored");
            events[0] = event.getEventName();
            event.addCompetitors(new Competitor("Max", 50));
            event.addCompetitors(new Competitor("Dylan", 14));
            event.addCompetitors(new Competitor("Bob", 45));
            event.addCompetitors(new Competitor("Elena", 72));
            event.addCompetitors(new Competitor("Tim", 15));
            fileOut.writeObject(event);
            
            // creating Figure Skating event and adding competitors
            event = new Event("Figure Skating", "scored");
            events[1] = event.getEventName();
            event.addCompetitors(new Competitor("Rose", 58));
            event.addCompetitors(new Competitor("Jim", 24));
            event.addCompetitors(new Competitor("Sally", 48));
            event.addCompetitors(new Competitor("Matthew", 96));
            event.addCompetitors(new Competitor("Terry", 3));
            fileOut.writeObject(event);
            
            // creating Speed Skating event and adding competitors
            event = new Event("Speed Skating", "timed");
            events[2] = event.getEventName();
            event.addCompetitors(new Competitor("Lloyd", 25.4));
            event.addCompetitors(new Competitor("Hope", 10.8));
            event.addCompetitors(new Competitor("Kelly", 75.62));
            event.addCompetitors(new Competitor("Sam", 4.25));
            event.addCompetitors(new Competitor("Corey", 62.5));
            fileOut.writeObject(event);
            
            // creating Bobsled event and adding competitors
            event = new Event("Bobsleding", "timed");
            events[3] = event.getEventName();
            event.addCompetitors(new Competitor("James", 15.45));
            event.addCompetitors(new Competitor("Luke", 10.9));
            event.addCompetitors(new Competitor("Cody", 2.85));
            event.addCompetitors(new Competitor("Jackson", 14));
            event.addCompetitors(new Competitor("Nick", 20.65));
            fileOut.writeObject(event);
        }
        catch(Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        
        // calling constructor to create window
        new OlympicWinners();
    } // end main
    
    public void addItem(String name)
    {
        eventBox.addItem(name);
    } // end addItem
} // end OlympicWinners
