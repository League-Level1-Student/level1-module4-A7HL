package _99_extra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdvancedBinaryConverter implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField hexResult;
    JTextField decimalResult;
    JTextField asciiResult;
    JTextField inputTextField;
    JButton convertButton;

    public static void main(String[] args) {
        new AdvancedBinaryConverter().start();
    }

    public void start() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        hexResult = new JTextField(12);
        decimalResult = new JTextField(12);
        asciiResult = new JTextField(12);
        inputTextField = new JTextField(20);
        convertButton = new JButton();

        // 1. Make the frame show up

        // 2. Give your frame a title

        // 3. Add your panel to the frame

        // 4. Call the addObjectToPanel() method to add inputTextField to row 0, column 0
        //    of the panel and span 2 columns, addObjectToPanel(inputTextField, 0, 0, 2);

        // 5. Set the convertButton text to "convert"

        // 6. Add an action listener to convertButton

        // 7. Call the addObjectToPanel() method to add convertButton to row 1, column 0
        //    of the panel with a cellWidth of 2

        // 8. Create a new JLabel with the text "ASCII:"

        // 9. Call the addObjectToPanel() method to add the new label to row 2, column 0
        //    of the panel with a cellWidth of 1

        // 10. Add asciiResult to the panel next to JLabel from step 8.

        // 11. Create a new JLabel with the text "Decimal:"

        // 12. Add the label from step 11. to row 3, column 0 of the panel

        // 13. Add the decimalResult JTextField to the panel next to label from step 11.

        // 14. Create a new JLabel with the text "Hexidecimal:"

        // 15. Add the label from step 14. to row 4, column 0 of the panel

        // 16. Add the hexResult JTextField to the panel next to the label from step 14.

        // 17. Pack the frame
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        // 18. If convertButton was pressed...

        // 19. Get the text from inputTextField and save it to a new String variable

        // 20. Call binaryToAscii() with the text from step 19 and save the result in a new String variable

        // 21. Set the text of asciiResult to the new String

        // 22. Call binaryToInt() with the text from step 19 and save the result in a new String variable

        // 23. Set the text of decimalResult to the new String

        // 24. Call binaryToHex() with the text from step 19 and save the result in a new String variable

        // 25. Set the text of hexResult to the new String

        // OPTIONAL: Create your own methods to convert binary to decimal (base 10) and
        //           binary to hexidecimal (base 16) without using the Integer.parseInt() method!
    }

    void addObjectToPanel(JComponent component, int row, int column, int cellWidth) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;       // This expands the JComponent to fill gridwidth
        constraints.gridx = column;             // This is the column the JComponent is placed
        constraints.gridy = row;                // This is the row the JComponent is placed
        constraints.gridwidth = cellWidth;      // This is how many horizontal cells to span across
        constraints.gridheight = 1;             // This is how many vertical cells to span across
        this.panel.add(component, constraints);
    }

    String binaryToInt(String binaryStr) {
        try {
            int binaryInt = Integer.parseInt(binaryStr, 2);
            return "" + binaryInt;
        } catch (Exception e) {
            return "-";
        }
    }

    String binaryToHex(String binaryStr) {
        try {
            int binaryInt = Integer.parseInt(binaryStr, 2);
            return "0x" + Integer.toHexString(binaryInt).toUpperCase();
        } catch (Exception e) {
            return "-";
        }
    }

    String binaryToAscii(String binaryStr) {
        if (binaryStr.length() != 8) {
            return "-";
        }

        try {
            int asciiValue = Integer.parseInt(binaryStr, 2);
            char theLetter = (char) asciiValue;
            return "" + theLetter;
        } catch (Exception e) {
            return "-";
        }
    }
}
