import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements  ActionListener {
    JLabel lb, lb1, lb2, lb3;
    Button b1, b2, b3, b4;
    Button b11, b12, b13, b14, b15, b16, b17, b18;
    JButton b5;
    boolean isAppetizerSelected = false;
    boolean isMainCourseSelected = false;
    boolean isDessertsSelected = false;
    boolean isDrinksSelected = false;
    JCheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8;
    JList<String> numberList;

     Menu() {
        setLayout(null);
        setTitle("Digital Restaurant Menu");
         Utils.setBackgroundColor(this, Color.DARK_GRAY);


         b1 = new Button("Appetizers");
        b1.setBounds(30, 100, 120, 30);
        add(b1);

        b2 = new Button("Main Course");
        b2.setBounds(30, 150, 120, 30);
        add(b2);

        b3 = new Button("Desserts");
        b3.setBounds(30, 200, 120, 30);
        add(b3);

        b4 = new Button("Drinks");
        b4.setBounds(30, 250, 120, 30);
        add(b4);

        b5 = new JButton("Confirm order");
        b5.setBounds(30, 600, 670, 70);
        add(b5);

        String[] tableNumbers = {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6", "Table 7", "Table 8", "Table 9"};

        // Create a JList with the array of table numbers
        numberList = new JList<>(tableNumbers);
        numberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add the JList to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(numberList);
        scrollPane.setBounds(30, 350, 120, 120);
        add(scrollPane);

        b5.addActionListener(this);

        lb = new JLabel();
        lb.setBounds(30, 300, 300, 30);
        add(lb);

        lb1 = new JLabel("        Select your orders");
        lb1.setBounds(30, 30, 350, 50);
        lb1.setFont(new Font("Arial", Font.BOLD, 22));
        lb1.setBackground(Color.orange);
        lb1.setOpaque(true);
        add(lb1);

        lb2 = new JLabel();
        lb2.setBounds(20, 40, 250, 500);
        lb2.setBackground(Color.BLUE);
        lb2.setOpaque(true);
        add(lb2);

         lb3 = new JLabel();
         lb3.setBounds(750, 40, 50, 700);
         lb3.setBackground(Color.CYAN);
         lb3.setOpaque(true);
         add(lb3);

        checkbox1 = new JCheckBox(" French Fries ");
        checkbox1.setBounds(300, 100, 200, 50);
        checkbox1.setVisible(false);
        add(checkbox1);

        checkbox2 = new JCheckBox(" Soup ");
        checkbox2.setBounds(500, 100, 200, 50);
        checkbox2.setVisible(false);
        add(checkbox2);

        checkbox3 = new JCheckBox(" Steak ");
        checkbox3.setBounds(300, 100, 200, 50);
        checkbox3.setVisible(false);
        add(checkbox3);

        checkbox4 = new JCheckBox(" Pasta ");
        checkbox4.setBounds(500, 100, 200, 50);
        checkbox4.setVisible(false);
        add(checkbox4);

        checkbox5 = new JCheckBox(" Cake ");
        checkbox5.setBounds(300, 100, 200, 50);
        checkbox5.setVisible(false);
        add(checkbox5);

        checkbox6 = new JCheckBox(" Icecream ");
        checkbox6.setBounds(500, 100, 200, 50);
        checkbox6.setVisible(false);
        add(checkbox6);

        checkbox7 = new JCheckBox(" Coffee ");
        checkbox7.setBounds(300, 100, 200, 50);
        checkbox7.setVisible(false);
        add(checkbox7);

        checkbox8 = new JCheckBox(" Tea ");
        checkbox8.setBounds(500, 100, 200, 50);
        checkbox8.setVisible(false);
        add(checkbox8);

         ActionListener al = new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String str = e.getActionCommand();

                 boolean isAppetizer = str.equals("Appetizers");
                 boolean isMainCourse = str.equals("Main Course");
                 boolean isDessert = str.equals("Desserts");
                 boolean isDrink = str.equals("Drinks");

                 checkbox1.setVisible(isAppetizer);
                 checkbox2.setVisible(isAppetizer);
                 checkbox3.setVisible(isMainCourse);
                 checkbox4.setVisible(isMainCourse);
                 checkbox5.setVisible(isDessert);
                 checkbox6.setVisible(isDessert);
                 checkbox7.setVisible(isDrink);
                 checkbox8.setVisible(isDrink);

                 lb.setText(str + " selected");
                 validate();
                 repaint();
            }
        };

        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        b4.addActionListener(al);

        this.add(checkbox1);
        this.add(checkbox2);
        this.add(checkbox3);
        this.add(checkbox4);
        this.add(b5);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent arg0) {
        float amount = 0;
        String msg = "";

        msg += "................Order Summary.................\n\n";

        String selectedTable = numberList.getSelectedValue();

        msg += "Table Number: " + selectedTable + "\n";

        if (checkbox1.isSelected()) {
            amount += 8.00;
            msg += "French Fries ............... RM8.00 \n";
        }

        if (checkbox2.isSelected()) {
            amount += 6.00;
            msg += "Soup         ............... RM6.00 \n";
        }

        if (checkbox3.isSelected()) {
            amount += 15.00;
            msg += "Steak       ............... RM15.00 \n";
        }

        if (checkbox4.isSelected()) {
            amount += 12.00;
            msg += "Pasta       ............... RM12.00 \n";
        }

        if (checkbox5.isSelected()) {
            amount += 4.90;
            msg += "Cake        ................ RM4.90 \n";
        }

        if (checkbox6.isSelected()) {
            amount += 3.90;
            msg += "Icecream   ................. RM3.90 \n";
        }

        if (checkbox7.isSelected()) {
            amount += 3.20;
            msg += "Coffee    ................. RM3.20 \n";
        }

        if (checkbox8.isSelected()) {
            amount += 2.50;
            msg += "Tea      .................. RM2.50 \n";
        }


        msg += "...................................................\n\n";

        String formattedTotal = String.format("%.2f", amount);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 250));

        JTextArea textArea = new JTextArea(msg + "Total : RM " + formattedTotal);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.NORTH);

        JOptionPane.showMessageDialog(b5, panel, "     CUSTOMER RECEIPT", JOptionPane.INFORMATION_MESSAGE);

    }

}