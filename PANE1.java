/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fk;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class PANE1 extends javax.swing.JFrame {
    
    private double totalLateMinsGlobal = 0;
    private double totalUTMinsGlobal = 0;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PANE1.class.getName());

    /**
     * Creates new form PANE1
     */
    public PANE1() {
        initComponents();
        // Prevents the window from being resized or maximized manually
        this.setResizable(false); 

        // Optional: Explicitly define the boundaries if pack() is too tight
        // Based on your Design Absolute Layout (940 width header + 230 width sidebar)
        this.setMinimumSize(new java.awt.Dimension(1170, 720));
        
        
        
// Paste this in your PANE1 constructor after initComponents();
rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {}, 
    new String [] {"Day", "Time In", "Time Out", "Absent", "Leave"} 
) {
    Class[] types = new Class [] {
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
        java.lang.Boolean.class, java.lang.Boolean.class
    };

    @Override
    public Class getColumnClass(int columnIndex) { return types [columnIndex]; }

    @Override
    public boolean isCellEditable(int row, int col) {
        // 1. Prevent editing if the row is a REST DAY
        if (getValueAt(row, 1).toString().equals("REST DAY")) return false;
        
        // 2. Disable Leave column (Index 4) for Part-timers/Contractual
        if (col == 4) {
            String type = jComboBox1.getSelectedItem().toString();
            return type.equalsIgnoreCase("Regular") || type.equalsIgnoreCase("Probationary");
        }
        return true; 
    }
});

rSTableMetro1.getModel().addTableModelListener(e -> {
    if (isUpdating || e.getType() != javax.swing.event.TableModelEvent.UPDATE) return;

    int row = e.getFirstRow();
    int col = e.getColumn();
    DefaultTableModel model = (DefaultTableModel) rSTableMetro1.getModel();

    // 1. TIME TRAVEL & FORMAT VALIDATION
    if (col == 1 || col == 2) {
        String inStr = model.getValueAt(row, 1).toString();
        String outStr = model.getValueAt(row, 2).toString();

        // Check format first
        String input = model.getValueAt(row, col).toString();
        if (!input.equals("REST DAY") && !input.equals("ABSENT") && !input.equals("LEAVE")) {
            if (!isValidTime(input)) {
                isUpdating = true;
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid Format! Use HH:mm (e.g. 08:00).");
                model.setValueAt(col == 1 ? "08:00" : "17:00", row, col);
                isUpdating = false;
                return;
            }
        }

        // Logical Check: Time Out cannot be before Time In
        if (isValidTime(inStr) && isValidTime(outStr)) {
            double inMins = timeToMinutes(inStr);
            double outMins = timeToMinutes(outStr);

            if (outMins < inMins) {
                isUpdating = true;
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Logical Error: Time Out cannot be earlier than Time In!", 
                    "Time Travel Detected", javax.swing.JOptionPane.ERROR_MESSAGE);
                
                // Reset the specific column that was just edited
                model.setValueAt(col == 1 ? "08:00" : "17:00", row, col);
                isUpdating = false;
                return;
            }
        }
    }

    // 2. PROCEED TO EXISTING MUTUAL EXCLUSION & CALCULATION LOGIC
    isUpdating = true;
    try {
        if (col == 3 || col == 4) {
             // ... [Existing Absent/Leave logic] ...
        }
        updateAttendanceLabels(); 
    } finally {
        isUpdating = false;
    }
});
        
        addPlaceholder(jTextField1, "Enter Your Full Name...");
        addPlaceholder(jTextField2, "(xxxx-xxxx-xx)");
        addPlaceholder(jTextField3, "0");
        addPlaceholder(jTextField4, "Enter Salary...");
        
        // Logic for Name Formatter Popup
jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        JTextField f = new JTextField();
        JTextField m = new JTextField();
        JTextField s = new JTextField();
        JTextField x = new JTextField();
        Object[] msg = {"First Name:", f, "M.I.:", m, "Surname:", s, "Suffix:", x};
        
        int result = JOptionPane.showConfirmDialog(null, msg, "NU Name Formatter", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String suffix = x.getText().isEmpty() ? "" : " " + x.getText() + ",";
            jTextField1.setText(s.getText() + ", " + f.getText() + "," + suffix + " " + m.getText());
        }
    }
});
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        Lay1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lay2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Lay3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(60, 70, 135));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(60, 70, 135));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("≡");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jButton1.setBackground(new java.awt.Color(60, 70, 135));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/fk/porrt.png"))); // NOI18N
        jButton1.setText("Employee Info");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jButton1.setOpaque(true);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/fk/hellllada.png"))); // NOI18N
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 203, 0), 3, true));

        jButton2.setBackground(new java.awt.Color(60, 70, 135));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/fk/coinsss.png"))); // NOI18N
        jButton2.setText("Payslip Summary");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jButton2.setOpaque(true);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setBackground(new java.awt.Color(60, 70, 135));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/fk/call.png"))); // NOI18N
        jButton3.setText("Time Table");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jButton3.setOpaque(true);
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2231, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 250, 2653);

        jPanel4.setBackground(new java.awt.Color(60, 70, 135));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(254, 203, 0)));

        jLabel3.setBackground(new java.awt.Color(60, 70, 135));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 203, 0));
        jLabel3.setText("WELCOME TO NU DASMARINAS PAYROLL SYSTEM !");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(60, 70, 135));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NATIONAL UNIVERSITY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(237, 237, 237))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(174, 174, 174))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(240, 0, 930, 120);

        Parent.setLayout(new java.awt.CardLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Employee Full Name:");

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Enter Your Full Name...");

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setText("(xxxx-xxxx-xx)");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(102, 102, 102));
        jTextField3.setText("0");

        jTextField4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jTextField4.setText("Enter Salary...");
        jTextField4.addActionListener(this::jTextField4ActionPerformed);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Monthly Salary Rate:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("Employee ID No.");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Loans");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Employee Type:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Cutoff Period:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Probationary", "Contractual", "Part-Timer" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel12.setBackground(new java.awt.Color(60, 70, 135));
        jLabel12.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 203, 0));
        jLabel12.setText("PLEASE FILL UP THE NECESSARY INFORMATION...");
        jLabel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel12.setOpaque(true);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st - 15th", "16th - 30th" }));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        jMonthChooser1.addPropertyChangeListener(this::jMonthChooser1PropertyChange);

        jLabel14.setBackground(new java.awt.Color(60, 70, 135));
        jLabel14.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Submit");
        jLabel14.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setText("Month of:");

        jLabel5.setBackground(new java.awt.Color(60, 70, 135));
        jLabel5.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 203, 0));
        jLabel5.setText("PROJECT BY: LACHICA, LABAO, SOLIS");
        jLabel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout Lay1Layout = new javax.swing.GroupLayout(Lay1);
        Lay1.setLayout(Lay1Layout);
        Lay1Layout.setHorizontalGroup(
            Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay1Layout.createSequentialGroup()
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Lay1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(Lay1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22))
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Lay1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        Lay1Layout.setVerticalGroup(
            Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Lay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addGap(61, 61, 61)
                .addComponent(jLabel14)
                .addGap(97, 97, 97)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Parent.add(Lay1, "card2");

        jLabel16.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel16.setText("Worked Hours");

        jLabel17.setBackground(new java.awt.Color(60, 70, 135));
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(254, 203, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("00:00");
        jLabel17.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel17.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel19.setText("Overtime");

        jLabel18.setBackground(new java.awt.Color(60, 70, 135));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(254, 203, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("00:00");
        jLabel18.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel18.setOpaque(true);

        rSTableMetro1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Day ", "Time in", "Time Out", "Absent", "Leave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(60, 70, 135));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(59, 107, 142));
        rSTableMetro1.setGridColor(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setGrosorBordeFilas(-1);
        rSTableMetro1.setShowGrid(true);
        jScrollPane1.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(130);
            rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(130);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(120);
            rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(120);
            rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(120);
            rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(120);
            rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(120);
            rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(120);
            rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(120);
            rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jButton4.setBackground(new java.awt.Color(60, 70, 135));
        jButton4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel21.setBackground(new java.awt.Color(60, 70, 135));
        jLabel21.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(254, 203, 0));
        jLabel21.setText("PLEASE FILL OUT THE TIME TABLE...");
        jLabel21.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jLabel21.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(60, 70, 135));
        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(254, 203, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("00");
        jLabel23.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(60, 70, 135));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(254, 203, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("00");
        jLabel24.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.black)));
        jLabel24.setOpaque(true);

        jLabel25.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel25.setText("Leaves");

        jLabel26.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel26.setText("Absences");

        javax.swing.GroupLayout Lay2Layout = new javax.swing.GroupLayout(Lay2);
        Lay2.setLayout(Lay2Layout);
        Lay2Layout.setHorizontalGroup(
            Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay2Layout.createSequentialGroup()
                .addGroup(Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Lay2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Lay2Layout.createSequentialGroup()
                                .addGap(484, 484, 484)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Lay2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel16)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel19)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel25)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel26))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Lay2Layout.setVerticalGroup(
            Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay2Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton4)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        Parent.add(Lay2, "card3");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel27.setBackground(new java.awt.Color(60, 70, 135));
        jLabel27.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(254, 203, 0));
        jLabel27.setText("HERE IS YOUR PAYSLIP SUMMARY...");
        jLabel27.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(254, 203, 0)), javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0))));
        jLabel27.setOpaque(true);

        javax.swing.GroupLayout Lay3Layout = new javax.swing.GroupLayout(Lay3);
        Lay3.setLayout(Lay3Layout);
        Lay3Layout.setHorizontalGroup(
            Lay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay3Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(Lay3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Lay3Layout.setVerticalGroup(
            Lay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay3Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Parent.add(Lay3, "card4");

        getContentPane().add(Parent);
        Parent.setBounds(250, 120, 920, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Lay1.setVisible(true); Lay2.setVisible(false); Lay3.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Lay1.setVisible(false); Lay2.setVisible(true); Lay3.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lay1.setVisible(false); Lay2.setVisible(false); Lay3.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
        // 1. GATHER EMPLOYEE INFO
        String id = jTextField2.getText().trim();
        String name = jTextField1.getText().trim();
        String type = jComboBox1.getSelectedItem().toString();
        double monthlyRate = Double.parseDouble(jTextField4.getText().replace(",", ""));
        double loans = Double.parseDouble(jTextField3.getText());

        // 2. DYNAMIC DAY COUNTING (EXCLUDING WEEKENDS)
        int activeWorkDays = 0;
        for (int i = 0; i < rSTableMetro1.getRowCount(); i++) {
            Object dayVal = rSTableMetro1.getValueAt(i, 0);
            if (dayVal != null && !dayVal.toString().trim().isEmpty()) {
                String dayText = dayVal.toString().toUpperCase();
                // Only count the day if it's a weekday
                if (!dayText.contains("(SAT)") && !dayText.contains("(SUN)")) {
                    activeWorkDays++;
                }
            }
        }

        // 3. DEFINE THE SEMI-MONTHLY BASE AND DYNAMIC RATE
        double semiMonthlyBase = monthlyRate / 2; // e.g., 20,000 for 40k
        double maxPeriodHrs = activeWorkDays * 8.0; // e.g., 80.0 or 88.0
        
        // This rate ensures Regular Pay = 20k if all hours are worked
        double dynamicHourlyRate = semiMonthlyBase / maxPeriodHrs; 

        // 4. ATTENDANCE CALCULATIONS
        double otHours = timeStringToDecimal(jLabel18.getText());
        int totalAbs = Integer.parseInt(jLabel24.getText());
        
        double lateHrs = totalLateMinsGlobal / 60.0;
        double utHrs = totalUTMinsGlobal / 60.0;
        double absHrs = totalAbs * 8.0;
        double actualWorkedHours = maxPeriodHrs - (lateHrs + utHrs + absHrs);

        // 5. EARNINGS
        double regularPay = actualWorkedHours * dynamicHourlyRate; 
        
        // OT uses the standard fixed rate to keep OT pay consistent
        double standardHourlyRate = (monthlyRate / 20) / 8; 
        double otPay = otHours * (standardHourlyRate * 1.25);
        double grossPay = regularPay + otPay;

        // 6. STATUTORY DEDUCTIONS (2025 RATES)
        double sss = PayrollCalculator.getSSSEmployeeShare(monthlyRate);
        double ph = PayrollCalculator.getPhilHealthShare(monthlyRate);
        double pi = PayrollCalculator.getPagIBIGShare();
        
        // Tax calculated on Gross minus mandatory contributions
        double taxableIncome = grossPay - (sss + ph + pi);
        double tax = PayrollCalculator.calculateTax(taxableIncome);
        
        double totalDeductions = sss + ph + pi + tax + loans;
        double netPay = grossPay - totalDeductions;

        // 7. GENERATE THE OFFICIAL PAYSLIP
        jTextArea1.setText(String.format(
            "       NATIONAL UNIVERSITY DASMARIÑAS\n" +
            "       Official Employee Payroll Slip\n" +
            "==============================================\n" +
            "NAME: %s\nID NO: %s\nSTATUS: %s\n" +
            "----------------------------------------------\n" +
            "ATTENDANCE DATA (HOURS):\n" +
            "  Max Period Hours:       %10.2f\n" +
            "  Less: Total Late:      -%10.2f\n" +
            "  Less: Total Undertime: -%10.2f\n" +
            "  Less: Total Absent:    -%10.2f\n" +
            "  TOTAL WORKED HOURS:     %10.2f\n" +
            "----------------------------------------------\n" +
            "EARNINGS:\n" +
            "  Regular Pay:            PHP %10.2f\n" +
            "  Overtime Pay:           PHP %10.2f\n" +
            "  GROSS PAY:              PHP %10.2f\n\n" +
            "STATUTORY DEDUCTIONS (2025 RATES):\n" +
            "  SSS Contribution:       PHP %10.2f\n" +
            "  PhilHealth Premium:     PHP %10.2f\n" +
            "  Pag-IBIG Fund:          PHP %10.2f\n" +
            "  Withholding Tax:        PHP %10.2f\n" +
            "  Personal Loans:         PHP %10.2f\n" +
            "----------------------------------------------\n" +
            "TOTAL DEDUCTIONS:         PHP %10.2f\n" +
            "NET PAY:                  PHP %10.2f\n" +
            "==============================================\n",
            name, id, type, maxPeriodHrs, lateHrs, utHrs, absHrs, actualWorkedHours,
            regularPay, otPay, grossPay, sss, ph, pi, tax, loans, 
            totalDeductions, netPay
        ));

        // 8. NAVIGATION
        Lay1.setVisible(false);
        Lay2.setVisible(false);
        Lay3.setVisible(true);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Submission Error: " + e.getMessage());
    }
}

private double parseMinutes(String in, String out) {
    try {
        String[] start = in.split(":");
        String[] end = out.split(":");
        double sM = Double.parseDouble(start[0]) * 60 + Double.parseDouble(start[1]);
        double eM = Double.parseDouble(end[0]) * 60 + Double.parseDouble(end[1]);
        return eM - sM;
    } catch (Exception e) { 
        return 0; 
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
        // TODO add your handling code here:
        refreshAttendanceTable();
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedType = jComboBox1.getSelectedItem().toString();
    // Use jLabel7 as identified in your PANE1.java file
    if (selectedType.equalsIgnoreCase("Part-timer")) {
        jLabel7.setText("Hourly Salary Rate:"); 
    } else {
        jLabel7.setText("Monthly Salary Rate:");
    }
// Refresh the table because Part-timers might have different work rules
refreshAttendanceTable();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        refreshAttendanceTable();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        // TODO add your handling code here:
        // 1. Validation Logic
    String id = jTextField2.getText().trim();
    String name = jTextField1.getText().trim();
    String rate = jTextField4.getText().trim();
    
    // Check if fields still have placeholders
    if (name.contains("Enter Your") || id.contains("(xxxx") || rate.contains("(xxx")) {
        JOptionPane.showMessageDialog(this, "Please fill out all required fields.");
        return;
    }

    // Regex Check for ID Format: XXXX-XXXX-XX
    if (!id.matches("\\d{4}-\\d{4}-\\d{2}")) {
        JOptionPane.showMessageDialog(this, "ID must follow the format: XXXX-XXXX-XX");
        return;
    }

    // Number Check for Rate
    try {
        Double.parseDouble(rate);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid numeric salary rate.");
        return;
    }

    // 2. Data Transfer (Updating UI Feedback)
    // Update the "Welcome" label in Step 2 or 3 to show the formatted name
    jLabel14.setText("Submit");
    
    // 3. Progressive Disclosure (Switching Panels)
    Lay1.setVisible(false);
    Lay2.setVisible(true);
    Lay3.setVisible(false);
    
    // Ensure the table is refreshed for the correct month/period
    refreshAttendanceTable();

    }//GEN-LAST:event_jLabel14MouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PANE1().setVisible(true));
    }
    
    private boolean isUpdating = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Lay1;
    private javax.swing.JPanel Lay2;
    private javax.swing.JPanel Lay3;
    private javax.swing.JPanel Parent;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private rojerusan.RSTableMetro rSTableMetro1;
    // End of variables declaration//GEN-END:variables

private void updateAttendanceLabels() {
    double totalRegHours = 0;
    double totalOTHours = 0;
    totalLateMinsGlobal = 0; 
    totalUTMinsGlobal = 0;   
    int leaves = 0, absences = 0;

    for (int i = 0; i < rSTableMetro1.getRowCount(); i++) {
        Object inObj = rSTableMetro1.getValueAt(i, 1);
        Object outObj = rSTableMetro1.getValueAt(i, 2);
        boolean isAbs = (boolean) rSTableMetro1.getValueAt(i, 3);
        boolean isLeave = (boolean) rSTableMetro1.getValueAt(i, 4);

        if (isAbs) { 
            absences++; 
        } else if (isLeave) { 
            leaves++; 
        } else if (inObj != null && outObj != null) {
            String inStr = inObj.toString();
            String outStr = outObj.toString();

            if (!inStr.equals("REST DAY") && isValidTime(inStr) && isValidTime(outStr)) {
                double inMins = timeToMinutes(inStr);
                double outMins = timeToMinutes(outStr);
                
                // Track Late (after 08:00) and Undertime (before 17:00)
                if (inMins > 480) totalLateMinsGlobal += (inMins - 480);
                if (outMins < 1020) totalUTMinsGlobal += (1020 - outMins);

                double rawWorkMins = outMins - inMins;
                if (rawWorkMins > 300) rawWorkMins -= 60; // 1hr Lunch Break
                
                double dayTotalHours = rawWorkMins / 60.0;

                if (dayTotalHours > 8.0) {
                    totalRegHours += 8.0;
                    totalOTHours += (dayTotalHours - 8.0);
                } else if (dayTotalHours > 0) {
                    totalRegHours += dayTotalHours;
                }
            }
        }
    }
    
    // Formatting these as HH:mm
    jLabel17.setText(formatDecimalToTime(totalRegHours)); 
    jLabel18.setText(formatDecimalToTime(totalOTHours));  
    jLabel23.setText(String.valueOf(leaves));               
    jLabel24.setText(String.valueOf(absences));             
}
 
      
    private void refreshAttendanceTable() {
    DefaultTableModel model = (DefaultTableModel) rSTableMetro1.getModel();
    model.setRowCount(0);
    
    // Determine if the current employee type is eligible for leaves
    String empType = jComboBox1.getSelectedItem().toString();
    boolean canHaveLeave = empType.equalsIgnoreCase("Regular") || empType.equalsIgnoreCase("Probationary");

    int year = 2026; 
    int month = jMonthChooser1.getMonth() + 1; 
    int startDay = (jComboBox2.getSelectedIndex() == 0) ? 1 : 16;
    int endDay = (jComboBox2.getSelectedIndex() == 0) ? 15 : 30;

    for (int i = startDay; i <= endDay; i++) {
        try {
            java.time.LocalDate date = java.time.LocalDate.of(year, month, i);
            java.time.DayOfWeek dow = date.getDayOfWeek();
            String dateLabel = i + " (" + dow.toString().substring(0, 3) + ")";
            
            if (dow == java.time.DayOfWeek.SATURDAY || dow == java.time.DayOfWeek.SUNDAY) {
                // Weekends: Date, In, Out, L, H, A
                model.addRow(new Object[]{dateLabel, "REST DAY", "REST DAY", false, false});
            } else {
                // Weekdays: Default to 8-5. Leave checkbox is only 'true' if eligible
                model.addRow(new Object[]{dateLabel, "08:00", "17:00", false, false});
            }
        } catch (java.time.DateTimeException e) {
            break; 
        }
        updateAttendanceLabels();
    }
}
    
    private void addPlaceholder(javax.swing.JTextField field, String placeholder) {
    field.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (field.getText().equals(placeholder)) {
                field.setText("");
                field.setForeground(java.awt.Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (field.getText().isEmpty()) {
                field.setForeground(new java.awt.Color(102, 102, 102));
                field.setText(placeholder);
            }
        }
    });
}   

    private boolean isValidTime(String time) {
        // Regex for HH:mm format (00:00 to 23:59)
        String timePattern = "([01]?[0-9]|2[0-9]):[0-5][0-9]";
        return time != null && time.matches(timePattern);
    }
    
    private String formatDecimalToTime(double decimalHours) {
    int h = (int) decimalHours;
    int m = (int) Math.round((decimalHours - h) * 60);
    return String.format("%02d:%02d", h, m);
}
    
    private double timeStringToDecimal(String timeStr) {
    try {
        String[] parts = timeStr.trim().split(":");
        return Double.parseDouble(parts[0]) + (Double.parseDouble(parts[1]) / 60.0);
    } catch (Exception e) { return 0.0; }
}
        // Helper to convert HH:mm to total minutes
    private double timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Double.parseDouble(parts[0]) * 60 + Double.parseDouble(parts[1]);
    } 
    
    
    
} // This is the very last closing brace of the file


