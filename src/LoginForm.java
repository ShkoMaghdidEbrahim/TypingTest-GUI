import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginForm {
    public LoginForm() {
        FlatNightOwlContrastIJTheme.install(new FlatNightOwlContrastIJTheme());
        //Make Swing components Round
        UIManager.put("Button.arc", 10);
        UIManager.put("ProgressBar.arc", 5);
        UIManager.put("Component.arc", 10);
        UIManager.put("TextComponent.arc", 20);
        
        ImageIcon animatedGif = new ImageIcon("images/yousolveAnimated.gif");
        
        JFrame frame = frame();
        JPanel panel = panel(frame);
        
        JTextField username = username(panel);
        JPasswordField password = password(panel);
        
        JButton loginButton = loginButton(panel);
        JButton registerButton = registerButton(panel);
        JToggleButton showAndHide = showAndHide(panel);
        
        animation(panel, animatedGif);
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frameX = frame.getX();
                Main.frameY = frame.getY();
                frame.dispose();
                new RegistrationForm();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValid(username, password) && !username.getText().equals("Username") && !String.valueOf(password.getPassword()).equals("Password")) {
                    Main.frameX = frame.getX();
                    Main.frameY = frame.getY();
                    frame.dispose();
                    new TypingTest();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please,\nEnter a valid username and password! \nAnd dont leave it empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        showAndHide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showAndHide.isSelected()) {
                    password.setEchoChar((char) 0); //show the characters by changing the Echo char to null
                }
                else {
                    password.setEchoChar('•');
                }
            }
        });
        
        frame.setVisible(true);
    }
    
    static JFrame frame() {
        JFrame frame = new JFrame("Typing Test                                                                                                            OneAboveAll");
        frame.setLocation(Main.frameX, Main.frameY);
        frame.setSize(600, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(TypingTest.icon.getImage());
        
        return frame;
    }
    
    static JPanel panel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(600, 330));
        panel.setLocation(0, 0);
        /*
        Making the layout null
        So we can move the GUI components freely rather than pre-defined layouts
        */
        panel.setLayout(null);
        frame.add(panel);
        return panel;
    }
    
    static void animation(JPanel panel, ImageIcon animatedGif) {
        JLabel animation = new JLabel(animatedGif);
        animation.setBounds((panel.getWidth() / 2) - 110, 10, 200, 100);
        animation.setVisible(true);
        
        panel.add(animation);
    }
    
    static JTextField username(JPanel panel) {
        JTextField username = new JTextField();
        username.setBounds((panel.getWidth() / 2) - 135, 100, 250, 40);
        username.setMargin(new Insets(0, 15, 0, 0));
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (username.getText().equals("Username")) {
                    username.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().equals("")) {
                    username.setText("Username");
                }
            }
        });
        
        panel.add(username);
        return username;
    }
    
    static JPasswordField password(JPanel panel) {
        JPasswordField password = new JPasswordField("Password");
        password.setBounds((panel.getWidth() / 2) - 135, 150, 250, 40);
        password.setMargin(new Insets(0, 15, 0, 0));
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals("Password")) {
                    password.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (Arrays.toString(password.getPassword()).equals("[]")) {
                    password.setText("Password");
                }
            }
        });
        
        panel.add(password);
        return password;
    }
    
    static JButton loginButton(JPanel panel) {
        JButton loginButton = new JButton();
        loginButton.setBounds((panel.getWidth() / 2) - 60, 240, 100, 40);
        loginButton.setMargin(new Insets(0, 0, 4, 0));
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setText("Login");
        loginButton.setForeground(Color.white);
        
        panel.add(loginButton);
        return loginButton;
    }
    
    static JButton registerButton(JPanel panel) {
        JButton registerButton = new JButton();
        registerButton.setBounds((panel.getWidth() / 2) - 60, 195, 100, 20);
        registerButton.setMargin(new Insets(0, 0, 4, 0));
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        registerButton.setText("Create Account");
        registerButton.setOpaque(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setForeground(Color.gray);
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                registerButton.setForeground(new Color(0x9900FF));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                registerButton.setForeground(Color.gray);
            }
        });
        
        panel.add(registerButton);
        return registerButton;
    }
    
    static JToggleButton showAndHide(JPanel panel) {
        ImageIcon shown = new ImageIcon("images/shown.png");
        ImageIcon hidden = new ImageIcon("images/hidden.png");
        
        JToggleButton button = new JToggleButton(hidden);
        button.setBounds(420, 150, 30, 40);
        button.setSelectedIcon(shown);
        button.setFocusable(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        
        panel.add(button);
        return button;
    }
    
    static boolean isValid(JTextField username, JPasswordField password) {
        byte[] result = new byte[1];
        try {
            //Hash the input
            result = MessageDigest.getInstance("MD5").digest(String.valueOf(password.getPassword()).getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Convert it to hex
        StringBuilder builder = new StringBuilder();
        for (byte bytes : result) {
            builder.append(String.format("%02x", bytes));
        }
        
        //Initializing the file reader
        File usernameAndPasswords = new File("UserAndPass/DoNotDelete!.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(usernameAndPasswords);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //read the file and put it in a string char by char
        StringBuilder fileContents = new StringBuilder();
        int i = 0;
        while (true) {
            try {
                assert reader != null;
                if ((i = reader.read()) == -1) {
                    break;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            fileContents.append((char) i);
        }
        //Split the file contents on $ sign
        String[] separated = fileContents.toString().split("\\$");
        
        //Compare the entered and already stored credentials
        for (int j = 0; j < separated.length; j += 2) {
            if (username.getText().equals(separated[j]) && builder.toString().equals(separated[j + 1])) {
                Main.username = separated[j]; //update the username variable
                return true; //if there's a match return true
            }
        }
        return false; //if not return false
    }
    
}
