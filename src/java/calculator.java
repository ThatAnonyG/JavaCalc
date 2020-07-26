import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
  // Text Fields and Labels
  private JTextField field1;
  private JTextField field2;
  private JLabel resLabel;

  public Calculator() {
    createWindow();
  }

  public static void main(String[] args) {
    new Calculator();
  }

  public void createWindow() {
    // New window
    JFrame frame = new JFrame("Calculator");
    frame.setLayout(null);
    frame.setResizable(false);

    // Panels for label, buttons, fields
    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.setBounds(5, 5, 470, 35);

    JPanel panel2 = new JPanel(new BorderLayout());
    panel2.setBounds(5, 45, 470, 35);

    JPanel buttons = new JPanel();
    buttons.setBounds(5, 85, 470, 35);

    JPanel res = new JPanel();
    res.setBounds(5, 125, 470, 35);
    res.setBackground(Color.gray);

    // Text fields and labels
    field1 = new JTextField();
    JLabel value1 = new JLabel("Value 1: ");

    field2 = new JTextField();
    JLabel value2 = new JLabel("Value 2: ");

    resLabel = new JLabel("Result Shown Here");

    // Buttons
    JButton add = new JButton("Add");
    add.addActionListener(this);
    JButton sub = new JButton("Subtract");
    sub.addActionListener(this);
    JButton mul = new JButton("Multiply");
    mul.addActionListener(this);
    JButton div = new JButton("Divide");
    div.addActionListener(this);

    // Add fields and labels to the panels
    panel1.add(value1, BorderLayout.WEST);
    panel1.add(field1, BorderLayout.CENTER);
    panel2.add(value2, BorderLayout.WEST);
    panel2.add(field2, BorderLayout.CENTER);
    res.add(resLabel, BorderLayout.CENTER);

    // Adding the buttons
    buttons.add(add);
    buttons.add(sub);
    buttons.add(mul);
    buttons.add(div);

    // Add the panels to the frame
    frame.add(panel1);
    frame.add(panel2);
    frame.add(buttons);
    frame.add(res);

    // Finalize the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(480, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Get the entries from the fields
    String val1 = field1.getText();
    String val2 = field2.getText();

    // Check if entered value is numeric
    if (this.isNan(val1) || this.isNan(val2)) {
      resLabel.setText("Please provide a valid number!");
      return;
    }

    // Parse into integer in above test passes
    Integer num1 = Integer.parseInt(val1);
    Integer num2 = Integer.parseInt(val2);
    int ans;

    // Determine which operator to use
    switch (((JButton) e.getSource()).getText()) {
      case "Add":
        ans = num1 + num2;
        resLabel.setText("Answer: " + num1 + " + " + num2 + " = " + ans);
        break;
      case "Subtract":
        ans = num1 - num2;
        resLabel.setText("Answer: " + num1 + " - " + num2 + " = " + ans);
        break;
      case "Multiply":
        ans = num1 * num2;
        resLabel.setText("Answer: " + num1 + " * " + num2 + " = " + ans);
        break;
      case "Divide":
        ans = num1 / num2;
        resLabel.setText("Answer: " + num1 + " / " + num2 + " = " + ans);
        break;
    }
  }

  public boolean isNan(String str) {
    // If input is null confirm as NaN
    if (str == null) return true;
    try {
      // Try to parse into a integer
      Integer.parseInt(str);
    } catch (NumberFormatException e) {
      // If there is error then confirm as NaN
      return true;
    }
    // If parsed successfully confirm as integer
    return false;
  }
}
