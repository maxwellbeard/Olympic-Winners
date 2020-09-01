/*******************************************************************************
 * ProjectName
 * Max Beard
 * 
 * ProjectExplanation
 ******************************************************************************/
package olympicwinners;

import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import static java.io.ObjectStreamConstants.STREAM_MAGIC;
import static java.io.ObjectStreamConstants.STREAM_VERSION;

public class AddEventGui
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JTextField eventBox;
    private JRadioButton scoredRB;
    private JRadioButton timedRB;
    private JTextField compNameBox1;
    private JTextField compNameBox2;
    private JTextField compNameBox3;
    private JTextField compNameBox4;
    private JTextField compNameBox5;
    private JTextField compScoreBox1;
    private JTextField compScoreBox2;
    private JTextField compScoreBox3;
    private JTextField compScoreBox4;
    private JTextField compScoreBox5;
    JFrame frame = new JFrame();
    
    public AddEventGui()
    {
        frame.setTitle("Add Event");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createContents();
        frame.setVisible(true);
    } // end constructor
    
    private void createContents()
    {
        JPanel eventPane = new JPanel();
        JPanel typePane = new JPanel();
        JPanel compPane1 = new JPanel();
        JPanel compPane2 = new JPanel();
        JPanel compPane3 = new JPanel();
        JPanel compPane4 = new JPanel();
        JPanel compPane5 = new JPanel();
        JPanel btnPane = new JPanel();
        JPanel a = new JPanel();
        a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
        
        // adding to event panel
        JLabel eventLab = new JLabel("Event name: ");
        eventBox = new JTextField(10);
        eventPane.add(eventLab);
        eventPane.add(eventBox);
        
        // adding to type panel
        scoredRB = new JRadioButton("Scored");
        timedRB = new JRadioButton("Timed");
        ButtonGroup eventType = new ButtonGroup();
        eventType.add(scoredRB);
        eventType.add(timedRB);
        typePane.add(scoredRB);
        typePane.add(timedRB);
        
        // adding message for adding 5 competitors
        JLabel msgLab = new JLabel("Add 5 competitors");
        msgLab.setAlignmentX(CENTER_ALIGNMENT);
        
        // adding to comp panel 1
        JLabel compNameLab1 = new JLabel("Competitor name: ");
        compNameBox1 = new JTextField(10);
        JLabel compScoreLab1 = new JLabel("Score or time: ");
        compScoreBox1 = new JTextField(5);
        compPane1.add(compNameLab1);
        compPane1.add(compNameBox1);
        compPane1.add(compScoreLab1);
        compPane1.add(compScoreBox1);
        
        // adding to comp panel 2
        JLabel compNameLab2 = new JLabel("Competitor name: ");
        compNameBox2 = new JTextField(10);
        JLabel compScoreLab2 = new JLabel("Score or time: ");
        compScoreBox2 = new JTextField(5);
        compPane1.add(compNameLab2);
        compPane1.add(compNameBox2);
        compPane1.add(compScoreLab2);
        compPane1.add(compScoreBox2);
        
        // adding to comp panel 3
        JLabel compNameLab3 = new JLabel("Competitor name: ");
        compNameBox3 = new JTextField(10);
        JLabel compScoreLab3 = new JLabel("Score or time: ");
        compScoreBox3 = new JTextField(5);
        compPane1.add(compNameLab3);
        compPane1.add(compNameBox3);
        compPane1.add(compScoreLab3);
        compPane1.add(compScoreBox3);
        
        // adding to comp panel 4
        JLabel compNameLab4 = new JLabel("Competitor name: ");
        compNameBox4 = new JTextField(10);
        JLabel compScoreLab4 = new JLabel("Score or time: ");
        compScoreBox4 = new JTextField(5);
        compPane1.add(compNameLab4);
        compPane1.add(compNameBox4);
        compPane1.add(compScoreLab4);
        compPane1.add(compScoreBox4);
        
        // adding to comp panel 5
        JLabel compNameLab5 = new JLabel("Competitor name: ");
        compNameBox5 = new JTextField(10);
        JLabel compScoreLab5 = new JLabel("Score or time: ");
        compScoreBox5 = new JTextField(5);
        compPane1.add(compNameLab5);
        compPane1.add(compNameBox5);
        compPane1.add(compScoreLab5);
        compPane1.add(compScoreBox5);
        
        // adding to button panel
        JButton btn = new JButton("Done");
        JButton cancelBtn = new JButton("Cancel");
        btnPane.add(btn);
        btnPane.add(cancelBtn);
        
        // adding to a panel
        a.add(compPane1);
        a.add(compPane2);
        a.add(compPane3);
        a.add(compPane4);
        a.add(compPane5);
        
        // adding panels to window
        frame.add(eventPane);
        frame.add(typePane);
        frame.add(msgLab);
        frame.add(a);
        frame.add(btnPane);
        frame.pack();
        
        // adding listeners to buttons
        Listener listener = new Listener();
        btn.addActionListener(listener);
        cancelBtn.addActionListener(listener);
        
    } // end createContents
    
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equals("Done")){
                Event event;
                String name = eventBox.getText();
                OlympicWinners ow = new OlympicWinners();
                ow.addItem(name);
                String type;
                if(scoredRB.isSelected()){
                    type = "scored";
                } else {
                    type = "timed";
                }

                String compName1 = compNameBox1.getText();
                double compScore1 = Double.parseDouble(compScoreBox1.getText());

                String compName2 = compNameBox2.getText();
                double compScore2 = Double.parseDouble(compScoreBox2.getText());

                String compName3 = compNameBox3.getText();
                double compScore3 = Double.parseDouble(compScoreBox3.getText());

                String compName4 = compNameBox4.getText();
                double compScore4 = Double.parseDouble(compScoreBox4.getText());

                String compName5 = compNameBox5.getText();
                double compScore5 = Double.parseDouble(compScoreBox5.getText());

                event = new Event(name, type);
                event.addCompetitors(new Competitor(compName1, compScore1));
                event.addCompetitors(new Competitor(compName2, compScore2));
                event.addCompetitors(new Competitor(compName3, compScore3));
                event.addCompetitors(new Competitor(compName4, compScore4));
                event.addCompetitors(new Competitor(compName5, compScore5));

                try(ObjectOutputStream fileOut = new AppendableObjectOutputStream(
                    new FileOutputStream("info.txt", true), true))
                {
                    fileOut.writeObject(event);
                }
                catch(Exception ex){
                    System.out.println(ex.getClass());
                    System.out.println(ex.getMessage());
                }
                frame.dispose();
            } else {
                new OlympicWinners();
                frame.dispose();
            }
        } // end actionPerformed
    } // end Listener
    
    //*******************************************************************************************************************************
    
    // inner class for appending to file
    public class AppendableObjectOutputStream extends ObjectOutputStream 
    {
        private boolean append;
        private boolean initialized;
        private DataOutputStream dout;

        protected AppendableObjectOutputStream(boolean append) throws IOException, SecurityException {
            super();
            this.append = append;
            this.initialized = true;
        }

        public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
            super(out);
            this.append = append;
            this.initialized = true;
            this.dout = new DataOutputStream(out);
            this.writeStreamHeader();
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            if (!this.initialized || this.append) return;
            if (dout != null) {
                dout.writeShort(STREAM_MAGIC);
                dout.writeShort(STREAM_VERSION);
            }
        }
    } // end AppendableObjectOutputStream
} // end AddEventGui
