
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class AutoComplete extends JFrame {
 private static final long serialVersionUID = 1L;
 private static String[] countryList = {"United States of America","Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burma","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","People's Republic of China","Republic of China","Colombia","Comoros","Democratic Republic of the Congo","Republic of the Congo","Costa Rica,","Croatia","Cuba","Cyprus","Czech Republic","Danzig","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gaza Strip","The Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Holy Roman Empire","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Republic of Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jonathanland","Jordan","Kazakhstan","Kenya","Kiribati","North Korea","South Korea","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mount Athos","Mozambique","Namibia","Nauru","Nepal","Newfoundland","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Ottoman Empire","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Prussia","Qatar","Romania","Rome","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the","Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"};
 private JPanel contentPane;
 private JTextField txtName;
 private JComboBox<String> comboBox;

 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     AutoComplete frame = new AutoComplete();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 public AutoComplete() {
  setUndecorated(true);
  setType(Type.UTILITY);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 318, 186);
  this.contentPane = new JPanel();
  contentPane.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent arg0) {
    System.exit(0);
   }
  });
  this.contentPane.setAutoscrolls(true);
  setContentPane(this.contentPane);
  this.contentPane.setLayout(null);

  this.txtName = new JTextField();
  txtName.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent arg0) {
    txtName.setText(null);
   }
  });
  txtName.addKeyListener(new KeyAdapter() {
   @Override
   public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == 38) {
     int x = comboBox.getSelectedIndex();
     if (x > 0) {
      comboBox.setSelectedIndex(x - 1);
     }
     getContentPane().add(comboBox);
     comboBox.showPopup();
    } else if (e.getKeyCode() == 40) {
     int x = comboBox.getSelectedIndex();
     int y = comboBox.getItemCount();
     if (x + 1 < y)
      comboBox.setSelectedIndex(x + 1);
     getContentPane().add(comboBox);
     comboBox.showPopup();
    }
   }
  });
  txtName.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    try {
     txtName.setText(comboBox.getSelectedItem().toString());
     comboBox.removeAllItems();
     comboBox.hidePopup();
     contentPane.remove(comboBox);
    } catch (Exception e) {
    }
   }
  });
  this.txtName.setHorizontalAlignment(SwingConstants.CENTER);
  this.txtName.addCaretListener(new TextFieldCaretListener());
  this.txtName.setBounds(24, 17, 269, 39);
  this.contentPane.add(this.txtName);
  this.txtName.setColumns(10);

  this.comboBox = new JComboBox<String>();
  this.comboBox.setFocusCycleRoot(true);
  this.comboBox.setFocusTraversalPolicyProvider(true);
  this.comboBox.setAutoscrolls(true);
  this.comboBox.setBorder(null);
  this.comboBox.setOpaque(false);
  this.comboBox.setBounds(25, 19, 268, 37);
  // this.contentPane.add(comboBox);
 }

 private class TextFieldCaretListener implements CaretListener {
  public void caretUpdate(CaretEvent e) {

   try {
    comboBox.removeAllItems();
    comboBox.hidePopup();
    contentPane.remove(comboBox);
    if (e.getMark() > 0) {
     for (String string : countryList) {
      if (string.toLowerCase().startsWith(txtName.getText().toLowerCase())) {
       contentPane.add(comboBox);
       comboBox.addItem(string);
       comboBox.showPopup();
      }
     }
    }
   } catch (Exception e1) {
   }
   if (e.getMark() < 2) {
    contentPane.remove(comboBox);
   }
  }
 }
}