import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
  private JFrame frame;

  // Text Fields and Labels
  private JTextField field1;
  private JTextField field2;
  private JLabel value1;
  private JLabel value2;
  private JLabel resLabel;

  // Panels
  private JPanel panel1;
  private JPanel panel2;
  private JPanel btns;
  private JPanel res;

  // Buttons
  private JButton add;
  private JButton sub;
  private JButton mul;
  private JButton div;

  public Calculator() {
    createWindow();
  }

  public static void main(String[] args) {
    new Calculator();
  }

  public void createWindow() {
    // New window
    frame = new JFrame("Calculator");
    frame.setLayout(null);
    frame.setResizable(false);

    // Panels for label, buttons, fields
    panel1 = new JPanel(new BorderLayout());
    panel1.setBounds(5, 5, 470, 35);

    panel2 = new JPanel(new BorderLayout());
    panel2.setBounds(5, 45, 470, 35);

    btns = new JPanel();
    btns.setBounds(5, 85, 470, 35);

    res = new JPanel();
    res.setBounds(5, 125, 470, 35);
    res.setBackground(Color.gray);

    // Text fields and labels
    field1 = new JTextField();
    value1 = new JLabel("Value 1: ");

    field2 = new JTextField();
    value2 = new JLabel("Value 2: ");

    resLabel = new JLabel("Result Shown Here");

    // Buttons
    add = new JButton("Add");
    add.addActionListener(this);
    sub = new JButton("Subtract");
    sub.addActionListener(this);
    mul = new JButton("Multiply");
    mul.addActionListener(this);
    div = new JButton("Divide");
    div.addActionListener(this);

    // Add fields and labels to the panels
    panel1.add(value1, BorderLayout.WEST);
    panel1.add(field1, BorderLayout.CENTER);
    panel2.add(value2, BorderLayout.WEST);
    panel2.add(field2, BorderLayout.CENTER);
    res.add(resLabel, BorderLayout.CENTER);

    // Adding the buttons
    btns.add(add);
    btns.add(sub);
    btns.add(mul);
    btns.add(div);

    // Add the panels to the frame
    frame.add(panel1);
    frame.add(panel2);
    frame.add(btns);
    frame.add(res);

    // Finalize the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(480, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String val1 = (field1.getText());
    String val2 = (field2.getText());
    if (this.isNan(val1) || this.isNan(val2)) {
      resLabel.setText("Please provide a valid number!");
      return;
    }

    Integer num1 = Integer.parseInt(val1);
    Integer num2 = Integer.parseInt(val2);
    int ans;

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
    if (str == null) return true;
    try {
      Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return true;
    }
    return false;
  }
}
