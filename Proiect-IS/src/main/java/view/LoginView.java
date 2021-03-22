package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends javax.swing.JFrame {
    private JPanel panel = new JPanel();
    private JLabel emailLabel = new JLabel();
    private JTextField emailText = new JTextField();
    private JLabel passwordLabel = new JLabel();
    private JTextField passwordText = new JTextField();
    private JButton button = new JButton();
    private JButton buttonA = new JButton();

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.LINE_AXIS));
        panel.setLayout(new GridBagLayout());

        emailLabel.setText("Email:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(61, 62, 0, 0);
        panel.add(emailLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(58, 24, 0, 67);
        panel.add(emailText, gridBagConstraints);

        passwordLabel.setText("Password:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(26, 62, 0, 0);
        panel.add(passwordLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(23, 24, 0, 67);
        panel.add(passwordText, gridBagConstraints);

        button.setText("Login user");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0; //0
        gridBagConstraints.gridy = 4; //4
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(47, 62, 113, 0);
        panel.add(button, gridBagConstraints);

        buttonA.setText("Login admin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5; //0
        gridBagConstraints.gridy = 4; //4
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(47, 72, 113, 0);
        panel.add(buttonA, gridBagConstraints);

        getContentPane().add(panel);
        pack();
    }

    public void buttonListener(ActionListener mal) {
        button.addActionListener(mal);
    }

    public void buttonListenerAdmin(ActionListener malu) {
        buttonA.addActionListener(malu);
    }


    public String getEmailText() {
        return emailText.getText();
    }

    public String getPasswordText() {
        return passwordText.getText();
    }

    //public static void main(String args[]) {
    //    new LoginView().setVisible(true);
    //}
}

