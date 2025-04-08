import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;

public class LinkStartGUI extends JFrame {

    private JButton myButton;
    private Clip clip;

    public LinkStartGUI() {
        // Set up the main window
        setTitle("Link Start GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel to hold the button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50)); // Center button with padding

        // Create the button
        myButton = new JButton("Click Me!");
        myButton.setPreferredSize(new Dimension(150, 50)); // Set button size
        myButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set font
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LinkStartGUI.this, "Button Clicked!");
            }
        });

        // Add the button to the panel
        panel.add(myButton);

        // Add the panel to the frame
        add(panel);

        // Play the "link start" sound
        playSound("link_start.wav"); // Replace with your sound file

        // Make the window visible
        setVisible(true);
    }

    private void playSound(String soundFileName) {
        try {
            // Load the sound file
            File soundFile = new File(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // Get a clip resource
            clip = AudioSystem.getClip();

            // Open the audio stream
            clip.open(audioIn);

            // Start playing the sound
            clip.start();

        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinkStartGUI();
            }
        });
    }
}
