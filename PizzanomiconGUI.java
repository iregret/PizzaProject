
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


class PizzanomiconGUI extends JFrame
{
// all the parts///////////////

     JTextField name = new JTextField(20);
     JTextField phone = new JTextField(10);
     JTextField address = new JTextField(20);

     JRadioButton small = new JRadioButton("Small");
     JRadioButton medium = new JRadioButton("Medium");
     JRadioButton large = new JRadioButton("Large");
     JRadioButton obnoxious = new JRadioButton("Obnoxious");

     JRadioButton thick = new JRadioButton("Thick");
     JRadioButton thin = new JRadioButton("Thin");
     JRadioButton evil = new JRadioButton("Evil");

     JCheckBox pepperoni = new JCheckBox("Pepperoni");
     JCheckBox mushrooms = new JCheckBox("Mushrooms");
     JCheckBox anchovies = new JCheckBox("Anchovies");
     JCheckBox extracheese = new JCheckBox("Extra Cheese");
     JCheckBox hemlock = new JCheckBox("Hemlock Root");
     JCheckBox olives = new JCheckBox("Black Olives");

     JRadioButton coke = new JRadioButton("Coke");
     JRadioButton dietcoke = new JRadioButton("Diet Coke");
     JRadioButton melloyello = new JRadioButton("Mello Yello");
     JRadioButton absinthe = new JRadioButton("Absinthe");

     JRadioButton sizeSmall = new JRadioButton("Tiny");
     JRadioButton sizeMedium = new JRadioButton("Average");
     JRadioButton sizeLarge = new JRadioButton("Large");

     JButton calcButton = new JButton("Calculate");
     JButton clearButton = new JButton("clear");

    public final double COKE = 2.25;
    public final double DCOKE = 2.25;
    public final double MYELLO = 2.25;
    public final double ABSINTHE = 2.25;

    public final double SIZESMALL = 2.00;
    public final double SIZEMEDIUM = 4.00;
    public final double SIZELARGE = 6.00;

    public final double SMALL = 8.00;
    public final double MEDIUM = 10.00;
    public final double LARGE = 14.00;
    public final double OBNOXIOUS = 22.00;

    public final double THICK = 2.00;
    public final double THIN = 2.00;
    public final double EVIL = 3.00;


    public final double PEP = 2.25;
    public final double MUSH = 2.25;
    public final double ANCH = 2.25;
    public final double EXCHEESE = 2.25;
    public final double HEMLOCK = 2.25;
    public final double BOLIVES = 2.25;


    public PizzanomiconGUI()
    {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon pizza = new ImageIcon(getClass().getResource("rsz_pizzanomicon.jpg"));
        JLabel p1 = new JLabel(pizza);

        setBackground (Color.red);

        Border border = BorderFactory.createLineBorder(Color.BLACK); // simple black border

        ImageIcon icon = new ImageIcon(PizzanomiconGUI.class.getResource("rsz_pizzanomicon_icon.jpg"));
        JLabel rName = new JLabel("Pizzanomicon", icon, JLabel.CENTER); // icon + name across the top
        rName.setBorder(border); //adds black border
        rName.setFont(new java.awt.Font("Century Gothic", Font.BOLD, 36)); // business name that displays across top part and remains there
        rName.setHorizontalAlignment(SwingConstants.CENTER); // centers the text


        //All the panels

        JPanel homePanel = new JPanel();
        homePanel.add(p1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calcButton);
        buttonPanel.add(clearButton);
        calcButton.addActionListener(new CalcButtonListener());

        //Infopanel
        JLabel totalLabel = new JLabel("Your Total: ");
        JTextArea totalArea = new JTextArea("Thank you for surviving Pizzanomicon");
        totalArea.setPreferredSize(new Dimension(300,400));

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.add(totalLabel, BorderLayout.NORTH);
        totalPanel.add(totalArea, BorderLayout.SOUTH);


        JPanel SizePanel = new JPanel();
        SizePanel.setLayout(new GridBagLayout());

        Box sizeBox = Box.createVerticalBox();
        ButtonGroup bg = new ButtonGroup();  //Button group for DRINK size
        bg.add(sizeSmall);
        bg.add(sizeMedium);
        bg.add(sizeLarge);
        sizeBox.add(sizeSmall);
        sizeBox.add(sizeMedium);
        sizeBox.add(sizeLarge);
        sizeBox.setBorder(BorderFactory.createTitledBorder("Size"));  //simple border
        addItem(SizePanel, sizeBox, 2, 3, 1, GridBagConstraints.NORTH);

        Box drinkBox = Box.createHorizontalBox();
        ButtonGroup drinkGroup = new ButtonGroup();
        drinkGroup.add(coke);
        drinkGroup.add(dietcoke);
        drinkGroup.add(melloyello);
        drinkGroup.add(absinthe);
        drinkBox.add(coke);
        drinkBox.add(dietcoke);
        drinkBox.add(melloyello);
        drinkBox.add(absinthe);
        drinkBox.setBorder(BorderFactory.createTitledBorder("Drinks"));
        addItem(SizePanel, drinkBox, 1, 4, 1, GridBagConstraints.NORTH);


        ///toppings panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        //Labels for text fields
        addItem(panel1, new JLabel("Name:"), 0, 0, 1, GridBagConstraints.EAST);
        addItem(panel1, new JLabel("Phone:"), 0, 1, 1, GridBagConstraints.EAST);
        addItem(panel1, new JLabel("Address:"), 0, 2, 1, GridBagConstraints.EAST);

        //Actual text fields
        addItem(panel1, name, 1, 0, 2, GridBagConstraints.WEST);
        addItem(panel1, phone, 1, 1, 1, GridBagConstraints.WEST);
        addItem(panel1, address, 1, 2, 2, GridBagConstraints.WEST);

        //Pizza size
        Box sizeBox2 = Box.createVerticalBox();
        ButtonGroup sizeGroup = new ButtonGroup();  //Button group for pizza size
        sizeGroup.add(small);
        sizeGroup.add(medium);
        sizeGroup.add(large);
        sizeGroup.add(obnoxious);
        sizeBox2.add(small);
        sizeBox2.add(medium);
        sizeBox2.add(large);
        sizeBox2.add(obnoxious);
        sizeBox2.setBorder(BorderFactory.createTitledBorder("Size"));  //simple border
        addItem(panel1, sizeBox2, 0, 3, 1, GridBagConstraints.NORTH);  //

        Box styleBox = Box.createVerticalBox();
        ButtonGroup styleGroup = new ButtonGroup();  //Button group for style
        styleGroup.add(thin);
        styleGroup.add(thick);
        styleGroup.add(evil);
        styleBox.add(thin);
        styleBox.add(thick);
        styleBox.add(evil);
        styleBox.setBorder(BorderFactory.createTitledBorder("Style"));
        addItem(panel1, styleBox, 1, 3, 1, GridBagConstraints.NORTH);

        Box topBox = Box.createVerticalBox();
        topBox.add(pepperoni);
        topBox.add(mushrooms);
        topBox.add(anchovies);
        topBox.add(extracheese);
        topBox.add(olives);
        topBox.add(hemlock);
        topBox.setBorder(BorderFactory.createTitledBorder("Toppings"));
        addItem(panel1, topBox, 2, 3, 1, GridBagConstraints.NORTH);

        JTabbedPane tp = new JTabbedPane();

        tp.addTab("Home", homePanel);
        tp.addTab("Guts", panel1);
        tp.addTab("SizePanel", SizePanel );

        con.add(tp, BorderLayout.CENTER);    //add tabs
        con.add(rName, BorderLayout.NORTH); //add pizzanomicon title
        con.add(totalPanel, BorderLayout.EAST); //add panel to the right
        con.add(buttonPanel, BorderLayout.SOUTH);   //add panel with buttons below

        pack();
        setVisible(true);
    }


        public void addItem(JPanel p, JComponent c, int x, int y, int width, int align)
        {
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = x;
            gc.gridy = y;
            gc.gridwidth = width;
            gc.gridheight = 1;
            gc.weightx = 100.0;
            gc.weighty = 100.0;
            gc.insets = new Insets(5, 5, 5, 5);
            gc.anchor = align;
            gc.fill = GridBagConstraints.NONE;
            p.add(c, gc);
        }


    //total cost
        public double getCost()
        {
            double Cost = 0.0;

            //if (obnoxious.isSelected() && evil.isSelected() && absinthe.isSelected() && hemlock.isSelected())
            //  Cost = 37.10;

            if (small.isSelected())
                Cost += SMALL;
            if (medium.isSelected())
                Cost += MEDIUM;
            if (large.isSelected())
                Cost += LARGE;
            if (obnoxious.isSelected())
                Cost += OBNOXIOUS;
            if (thick.isSelected())
                Cost += THICK;
            if (thin.isSelected())
                Cost += THIN;
            if (evil.isSelected())
                Cost += EVIL;
            if (pepperoni.isSelected())
                Cost += PEP;
            if (mushrooms.isSelected())
                Cost += MUSH;
            if (anchovies.isSelected())
                Cost += ANCH;
            if (extracheese.isSelected())
                Cost += EXCHEESE;
            if (hemlock.isSelected())
                Cost += HEMLOCK;
            if (olives.isSelected())
                Cost += BOLIVES;
            if (sizeSmall.isSelected())
                Cost += SIZESMALL;
            if (sizeMedium.isSelected())
                Cost += SIZEMEDIUM;
            if (sizeLarge.isSelected())
                Cost += SIZELARGE;
            if (coke.isSelected())
                Cost += COKE;
            if (dietcoke.isSelected())
                Cost += DCOKE;
            if (melloyello.isSelected())
                Cost += MYELLO;
            if (absinthe.isSelected())
                Cost += ABSINTHE;

            return Cost;
        }
    public class CalcButtonListener implements ActionListener
    {

        double subtotal = getCost();

        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat dollar = new DecimalFormat("0.00");

            JOptionPane.showMessageDialog(null, "Total: $" + dollar.format(subtotal));
        }
    }


}
