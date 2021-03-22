package view;

import entity.BankAccount;
import service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserView extends JFrame {

    private JFrame frame = new JFrame();
    private JLabel FirstNameLabel = new JLabel();
    private JLabel LastNameLabel = new JLabel();
    private JLabel InsertFirstNameLabel = new JLabel();
    private JLabel InsertLastNameLabel = new JLabel();
    private JLabel EmailLabel = new JLabel();
    private JLabel InsertEmailLabel = new JLabel();
    private JLabel AmountLabel = new JLabel();
    private JLabel ReceiverLabel = new JLabel();
    private JLabel  AccountTranferLabel = new JLabel();
    private JLabel SelectAccountLabel = new JLabel();
    private JLabel AmountWithdrawPanel = new JLabel();
    private JLabel AccountWithdrawLabel = new JLabel();
    private JLabel pass = new JLabel();
    private JLabel AmountTransferLabel = new JLabel();
    private JPanel PricipalPanel = new JPanel();
    private JPanel DepositPanel  = new JPanel();
    private JPanel AccountsPanel = new JPanel();
    private JPanel TransferPanel = new JPanel();
    private JPanel WithdrawPanel = new JPanel();
    private JPanel TransactionsPanel = new JPanel();
    private JPanel ChangePassword = new JPanel();
    private JComboBox<String> SelectAccountComboBox = new JComboBox<>();
    private JComboBox<String> WithdrawComboBox = new JComboBox<>();
    private JComboBox<String> ReceiverNameComboBox = new JComboBox<>();
    private JComboBox<String> ReceiverAccountComboBox = new JComboBox<>();
    private JComboBox<String> SenderComboBox = new JComboBox<>();
    private JButton ConfirmButton = new JButton();
    private JButton Change = new JButton();
    private JButton AuxiliarButton = new JButton();
    private JButton WithdrawButton = new JButton();
    private JButton TransferButton = new JButton();
    private JButton TransactionsButton = new JButton();
    private JTextField AmountWithdrawTextField = new JTextField();
    private JTextField AmountTransfer = new JTextField();
    private JTextField newPassword = new JTextField();
    private JTextField AmountTextField = new JTextField();
    private JScrollPane AccountsScrollPanel = new JScrollPane();
    private JScrollPane TransactionsScrollPanel = new JScrollPane();
    private JDesktopPane DesktopPanel = new JDesktopPane();
    private JTabbedPane UserPanel = new JTabbedPane();
    private JTable TableAccounts = new JTable();
    private JTable TransactionsTable = new JTable();

    UserService us = new UserService();
    LoginView lv =  new LoginView();
    private String emailLogin;

    public UserView(String emailLogin) {
        initComponents();
        setVisible(true);
        this.emailLogin = emailLogin;
    }

    public String getEmailLogin(){
        return emailLogin;
    }
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        GridBagConstraints gridBagConstraints;

        DesktopPanel.setLayout(new GridBagLayout());
        PricipalPanel.setLayout(new GridBagLayout());
        DepositPanel.setLayout(new GridBagLayout());
        WithdrawPanel.setLayout(new GridBagLayout());
        TransferPanel.setLayout(new GridBagLayout());
        TransactionsPanel.setLayout(new GridBagLayout());
        ChangePassword.setLayout(new GridBagLayout());

        UserPanel.addTab("User", PricipalPanel);
        UserPanel.addTab("Deposit", DepositPanel);
        UserPanel.addTab("Withdraw", WithdrawPanel);
        UserPanel.addTab("Tranfer", TransferPanel);
        UserPanel.addTab("Transactions", TransactionsPanel);
        UserPanel.addTab("Accounts", AccountsPanel);
        UserPanel.addTab("Password", ChangePassword);

        //Principal Panel------------------------------------------------------------------
        FirstNameLabel.setText(" First Name:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(42, 54, 0, 0);
        PricipalPanel.add(FirstNameLabel, gridBagConstraints);

        FirstNameLabel.setMinimumSize(new java.awt.Dimension(100, 13));
        FirstNameLabel.setMaximumSize(new java.awt.Dimension(100, 13));

        LastNameLabel.setText(" Last Name:");
        LastNameLabel.setMaximumSize(new java.awt.Dimension(100, 13));
        LastNameLabel.setMinimumSize(new java.awt.Dimension(100, 13));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 54, 0, 0);
        PricipalPanel.add(LastNameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 384;
        gridBagConstraints.ipady = 58;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(42, 18, 0, 88);
        PricipalPanel.add(InsertFirstNameLabel, gridBagConstraints);

        InsertLastNameLabel.setText(" ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 381;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 18, 0, 88);
        PricipalPanel.add(InsertLastNameLabel, gridBagConstraints);

        EmailLabel.setText(" Email:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 53;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 54, 31, 0);
        PricipalPanel.add(EmailLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 386;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 16, 31, 88);
        PricipalPanel.add(InsertEmailLabel, gridBagConstraints);

        //Deposit panel--------------------------------------------------------------------------
        AmountLabel.setText("Amount:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 38, 0, 0);
        DepositPanel.add(AmountLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 221;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 4, 0, 188);
        DepositPanel.add(AmountTextField, gridBagConstraints);

        SelectAccountLabel.setText("Select account:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 38, 0, 0);
        DepositPanel.add(SelectAccountLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 173;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 4, 0, 188);
        DepositPanel.add(SelectAccountComboBox, gridBagConstraints);

        ConfirmButton.setText("Confirm deposit");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 123;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(27, 4, 65, 188);
        DepositPanel.add(ConfirmButton, gridBagConstraints);

        //Withdraw panel------------------------------------------------------------------
        AmountWithdrawPanel.setText("Amount:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 37, 0, 0);
        WithdrawPanel.add(AmountWithdrawPanel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 4, 0, 258);
        WithdrawPanel.add(AmountWithdrawTextField, gridBagConstraints);

        AccountWithdrawLabel.setText("Select account:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(29, 37, 0, 0);
        WithdrawPanel.add(AccountWithdrawLabel, gridBagConstraints);

        WithdrawComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 137;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(29, 4, 0, 258);
        WithdrawPanel.add(WithdrawComboBox, gridBagConstraints);

        WithdrawButton.setText("Confirm withdraw");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 4, 61, 258);
        WithdrawPanel.add(WithdrawButton, gridBagConstraints);

        //--Transfer panel--------------------------------------------------------------------
        ReceiverLabel.setText("Select receiver:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(36, 29, 0, 0);
        TransferPanel.add(ReceiverLabel, gridBagConstraints);

        AccountTranferLabel.setText("Select your account:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 29, 0, 0);
        TransferPanel.add(AccountTranferLabel, gridBagConstraints);

        createReceiverNameComboBox();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(36, 18, 0, 0);
        TransferPanel.add(ReceiverNameComboBox, gridBagConstraints);

        AuxiliarButton.setText("Confirm Receiver");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(36, 25, 0, 100);
        TransferPanel.add(AuxiliarButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(36, 46, 0, 100); //60
        TransferPanel.add(ReceiverAccountComboBox, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 18, 0, 0);
        TransferPanel.add(SenderComboBox, gridBagConstraints);

        AmountTransferLabel.setText("Amount:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 101;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 29, 0, 0);
        TransferPanel.add(AmountTransferLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 147;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 18, 0, 0);
        TransferPanel.add(AmountTransfer, gridBagConstraints);

        TransferButton.setText("Confirm Transfer");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 18, 35, 0);
        TransferPanel.add(TransferButton, gridBagConstraints);

        pass.setText("New password:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 38, 0, 0);
        ChangePassword.add(pass, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 221;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(54, 4, 0, 188);
        ChangePassword.add(newPassword, gridBagConstraints);

        Change.setText("Change password");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 123;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(27, 4, 65, 188);
        ChangePassword.add(Change, gridBagConstraints);

        //Transactions panel-----------------------------------------------------------------------------------
        ////////////////////////////////////////////
        TransactionsTable.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null}
                },
                new String [] {
                        "IBAN", "Date", "Amount", "Type"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TransactionsScrollPanel.setViewportView(TransactionsTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 578;
        gridBagConstraints.ipady = 204;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        TransactionsPanel.add(TransactionsScrollPanel, gridBagConstraints);

        TransactionsButton.setText("Transactions report");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(13, 175, 10, 0);
        TransactionsPanel.add(TransactionsButton, gridBagConstraints);

        //Desktop panel---------------------------------------------------------------------------------
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -429;
        gridBagConstraints.ipady = -399;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        DesktopPanel.add(UserPanel, gridBagConstraints);

        getContentPane().add(DesktopPanel);
        pack();
    }
    public double getAmountLabel (){
        String s = AmountTextField.getText();
        double q = 0;
        q = Double.parseDouble(s);
        return q;
    }

    public double getAmountTransferLabel (){
        String s = AmountTransfer.getText();
        double q = 0;
        q = Double.parseDouble(s);
        return q;
    }

    public double getAmountWithdrawLabel (){
        String s = AmountWithdrawTextField.getText();
        double q = 0;
        q = Double.parseDouble(s);
        return q;
    }

    public String getNewPassword (){
        String s = newPassword.getText();
        return s;
    }

    public void setInsertFirstNameLabel (String s){
        InsertFirstNameLabel.setText(s);
    }
    public void setInsertLastNameLabel (String s){
        InsertLastNameLabel.setText(s);
    }
    public void setInsertEmailLabel (String s){
        InsertEmailLabel.setText(s);
    }

    public void addConfirmButtonListener(ActionListener e) {
        ConfirmButton.addActionListener(e);
    }

    public void addChangePasswordListener(ActionListener e) {
        Change.addActionListener(e);
    }

    public void addAuxiliarButtonListener(ActionListener e) {
        AuxiliarButton.addActionListener(e);
    }

    public void addReportButtonListener(ActionListener e) {
        TransactionsButton.addActionListener(e);
    }

    public void addTransferButtonListener(ActionListener e) {
        TransferButton.addActionListener(e);
    }
    public void addWithdrawButtonListener(ActionListener e) {
        WithdrawButton.addActionListener(e);
    }

    public void createSelectAccountComboBox(String mail)
    {
        SelectAccountComboBox.removeAllItems();
        for(String item : us.getUserIDBankAccountwithMail(mail))
            SelectAccountComboBox.addItem(item);
    }

    public BankAccount getSelectAccountComboBox() {
        String id = (String)SelectAccountComboBox.getSelectedItem();
        BankAccount ba = us.getAccountfromId(id);
        return ba;
    }
    public void createWithdrawComboBox(String mail)
    {
        WithdrawComboBox.removeAllItems();
        for(String item : us.getUserIDBankAccountwithMail(mail))
            WithdrawComboBox.addItem(item);
    }

    public BankAccount getSelectWithdrawComboBox() {
        String id = (String)WithdrawComboBox.getSelectedItem();
        BankAccount ba = us.getAccountfromId(id);
        return ba;
    }

    public void createReceiverNameComboBox()
    {
        ReceiverNameComboBox.removeAllItems();
        for(String item : us.getAllUsersNameServ())
            ReceiverNameComboBox.addItem(item);
    }
    public String getReceiverComboBox() {
        String name = (String)ReceiverNameComboBox.getSelectedItem();
        return name;
    }

    public void createReceiverAccountComboBox(String name )
    {
        ReceiverAccountComboBox.removeAllItems();
        for(String item : us.getAccountsIDfromName(name))
           ReceiverAccountComboBox.addItem(item);
    }

    public BankAccount getReceiverAccComboBox() {
        String name = (String)ReceiverAccountComboBox.getSelectedItem();
        BankAccount ba = us.getAccountfromId(name);
        return ba;
    }

    public void createSenderComboBox(String mail)
    {
        SenderComboBox.removeAllItems();
        for(String item : us.getUserIDBankAccountwithMail(mail)) //"szabycsillag@gmail.com"
            SenderComboBox.addItem(item);
    }
    public BankAccount getSenderComboBox() {
        String name = (String)SenderComboBox.getSelectedItem();
        BankAccount ba = us.getAccountfromId(name);
        return ba;
    }


    public void createTable(ArrayList<BankAccount> bankAcc) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("IBAN");
        tableModel.addColumn("BALANCE");
        tableModel.addColumn("TYPE");

        for(BankAccount p : bankAcc) {
            String[] oneRow = new String[4];
            oneRow[0] = p.getIdAccount() + "";
            oneRow[1] = p.getBalance()+ "" ;
            oneRow[2] = p.getAccountType()+"";
            tableModel.addRow(oneRow);
        }

        TableAccounts = new JTable(tableModel);
        TableAccounts.getColumnModel().getColumn(0).setPreferredWidth(15);
        TableAccounts.getColumnModel().getColumn(1).setPreferredWidth(50);
        TableAccounts.getColumnModel().getColumn(2).setPreferredWidth(50);
        TableAccounts.setFillsViewportHeight(true);
        AccountsScrollPanel = new JScrollPane(TableAccounts);
        AccountsScrollPanel.setBounds(10, 10, 580, 220);
        add(AccountsScrollPanel);
        AccountsPanel.add(AccountsScrollPanel);
    }
}
