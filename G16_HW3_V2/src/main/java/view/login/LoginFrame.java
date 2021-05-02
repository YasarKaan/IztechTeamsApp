package view.login;

import controller.datarecords.Data;
import controller.io.SignInHelper;
import model.user.User;
import view.mainpage.Homepage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.statistics.Statistics;

public class LoginFrame extends JFrame implements ActionListener {

    private final Container container = getContentPane();
    private final JLabel welcome = new JLabel("Welcome!");
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField userTextField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Enter");
    private final JButton resetButton = new JButton("Reset");
    private final JCheckBox showPassword = new JCheckBox("Show Password");

    public LoginFrame() {
        this.setTitle("Clothesragman");
        this.setBounds(10,10,370,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        welcome.setFont(new java.awt.Font("Tahoma", 0, 18));
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);

    }

    public void setLocationAndSize() {
        welcome.setBounds(150,50,100,30);

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 350, 100, 30);
        resetButton.setBounds(200, 350, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(welcome);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            User user = SignInHelper.signInHelp(Data.userList.getUserList(),userText,pwdText);
            if (user!=null) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                Homepage mainFrame = new Homepage(user);
                mainFrame.setVisible(true);
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}