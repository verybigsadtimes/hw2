import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main extends JFrame implements ActionListener {
    JLabel question = new JLabel("What would you like to order?");
    Font bigFont = new Font("Arial", Font.BOLD, 15);
    JButton small = new JButton("Small ($5)");
    JButton medium = new JButton("Medium ($10)");
    JButton large = new JButton("Large ($15)");
    JButton supr = new JButton("Super ($20)");
    JCheckBox a = new JCheckBox("Pepperoni",false);
    JCheckBox b = new JCheckBox("Mushrooms",false);
    JCheckBox c = new JCheckBox("Pineapple",false);
    JCheckBox d = new JCheckBox("Extra cheese",false);
    JButton totl = new JButton("Total");
    JButton eat = new JButton("Eat pizza!");
    JLabel amnt = new JLabel("");
    JLabel full = new JLabel("");
    DecimalFormat df = new DecimalFormat("0.00");
    final int WIDTH = 400;
    final int HEIGHT = 300;
    private double total = 00.00;
    private int fcount = 0;
    private int fvalue = 0;
    private int bites = 0;
    public Main(){
        super("BigY Sandwiches");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());
        question.setFont(bigFont);
        amnt.setFont(bigFont);
        add(question);
        add(small);
        add(medium);
        add(large);
        add(supr);
        add(amnt);
        add(totl);
        add(eat);
        add(full);
        add(a);
        add(b);
        add(c);
        add(d);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        supr.addActionListener(this);
        totl.addActionListener(this);
        eat.addActionListener(this);
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isPepperoni = a.isSelected();
        boolean isMushrooms = b.isSelected();
        boolean isPineapple = c.isSelected();
        if(e.getSource() == totl) {
            if(isPepperoni && (!isMushrooms) && (!isPineapple)) {
                total = total + 0.50;
                fvalue = fvalue + 1;
            }
            if(isPepperoni && isMushrooms && (!isPineapple)) {
                total = total + 1.00;
                fvalue = fvalue + 2;
            }
            if(isPineapple && (!isMushrooms) && (!isPepperoni)) {
                total = total + 0.50;
                fvalue = fvalue + 1;
            }
            if(isPineapple && isMushrooms && (!isPepperoni)) {
                total = total + 1.00;
                fvalue = fvalue + 2;
            }
            if(isPineapple && isMushrooms && isPepperoni) {
                total = total + 1.25;
                fvalue = fvalue + 3;
            }
            String am = "Your total is $" + df.format(total);
            amnt.setText(am);
            fcount = fcount + fvalue;
        }
        if(e.getSource() == eat) {
            if (bites == 0) {
                String am = "You have no pizza!";
                fvalue = 0;
                full.setText(am);
            }
            if (fcount <= 15 && fcount >= 1 && bites != 0) {
                String am = "Yummy!";
                full.setText(am);
                fcount = fcount + fvalue;
                bites = bites - 1;
            }
            if (fcount <= 30 && fcount >= 16 && bites != 0) {
                String am = "You are getting full...";
                full.setText(am);
                fcount = fcount + fvalue;
                bites = bites - 1;
            }
            if (fcount >= 31) {
                String am = "You're stuffed!";
                full.setText(am);
            }
        }
        if(e.getSource() == small){
            total = total + 5.00;
            fvalue = fvalue + 1;
            bites = bites + 2;
        }
        if(e.getSource() == medium){
            total = total + 10.00;
            fvalue = fvalue + 2;
            bites = bites + 3;
        }
        if(e.getSource() == large){
            total = total + 15.00;
            fvalue = fvalue + 3;
            bites = bites + 4;
        }
        if(e.getSource() == supr){
            total = total + 20.00;
            fvalue = fvalue + 4;
            bites = bites + 5;
        }
    }

    public static void main(String[] args) {
        Main ex = new Main();
        ex.setVisible(true);
    }
}
