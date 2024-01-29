import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Task1 extends JFrame {

    private JTextField colorTextField;
    private JCheckBox checkBox;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup radioGroup;

    public Task1() {
        setTitle("Task1");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        checkBox = new JCheckBox("Checkbox");

        radio1 = new JRadioButton("Radio 1");
        radio2 = new JRadioButton("Radio 2");
        radio3 = new JRadioButton("Radio 3");

        radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);

        colorTextField = new JTextField(10);
        colorTextField.setEditable(false);

        // Set layouts
        setLayout(new FlowLayout());

        // Add components to the frame
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(checkBox);
        add(radio1);
        add(radio2);
        add(radio3);
        add(new JLabel("Color: "));
        add(colorTextField);

        // Add action listeners
        button1.addActionListener(new ButtonColorListener(Color.RED));
        button2.addActionListener(new ButtonColorListener(Color.BLUE));
        button3.addActionListener(new ButtonColorListener(Color.GREEN));
        button4.addActionListener(new ButtonColorListener(Color.YELLOW));

        checkBox.addItemListener(new CheckBoxListener());

        radio1.addActionListener(new RadioButtonListener("Radio 1"));
        radio2.addActionListener(new RadioButtonListener("Radio 2"));
        radio3.addActionListener(new RadioButtonListener("Radio 3"));
    }

    private class ButtonColorListener implements ActionListener {
        private Color color;

        public ButtonColorListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            colorTextField.setBackground(color);
            colorTextField.setText(getColorName(color));
        }
    }

    private class CheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(Task1.this, "Checkbox is selected");
            } else {
                JOptionPane.showMessageDialog(Task1.this, "Checkbox is deselected");
            }
        }
    }

    private class RadioButtonListener implements ActionListener {
        private String radioText;

        public RadioButtonListener(String radioText) {
            this.radioText = radioText;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(Task1.this, "Selected Radio Button: " + radioText);
        }
    }

    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Red";
        } else if (color.equals(Color.GREEN)) {
            return "Green";
        } else if (color.equals(Color.BLUE)) {
            return "Blue";
        } else if (color.equals(Color.YELLOW)) {
            return "Yellow";
        } else {
            return "Unknown";
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Task1 guiExample = new Task1();
            guiExample.setVisible(true);
        });
    }
}
