import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class RegistrationForm {
    public RegistrationForm() {
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
        
        JButton createACCButton = createACCButton(panel);
        JButton haveACCButton = haveACCButton(panel);
        animation(panel, animatedGif);
        
        haveACCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frameX = frame.getX();
                Main.frameY = frame.getY();
                frame.dispose();
                new LoginForm();
            }
        });
        createACCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!username.getText().equals("Username") && !String.valueOf(password.getPassword()).equals("Password")) {
                    String[] credentials = credentials(username, password);
                    saveU_P(credentials);
                    JOptionPane.showMessageDialog(null, "Congratulations! \nYour account has been created successfully \nPress ok to Login", "Account Created", JOptionPane.PLAIN_MESSAGE);
                    Main.frameX = frame.getX();
                    Main.frameY = frame.getY();
                    frame.dispose();
                    new LoginForm();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please,\nEnter a valid username and password! \nAnd dont leave it empty", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    static JButton createACCButton(JPanel panel) {
        JButton createACCButton = new JButton();
        createACCButton.setBounds((panel.getWidth() / 2) - 60, 240, 100, 40);
        createACCButton.setMargin(new Insets(0, 0, 4, 0));
        createACCButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        createACCButton.setText("Register");
        createACCButton.setForeground(Color.white);
        
        panel.add(createACCButton);
        return createACCButton;
    }
    
    static JButton haveACCButton(JPanel panel) {
        JButton haveACCButton = new JButton();
        haveACCButton.setBounds((panel.getWidth() / 2) - 110, 195, 200, 20);
        haveACCButton.setMargin(new Insets(0, 0, 4, 0));
        haveACCButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        haveACCButton.setText("Already Have An Account?");
        haveACCButton.setOpaque(false);
        haveACCButton.setContentAreaFilled(false);
        haveACCButton.setBorderPainted(false);
        haveACCButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        haveACCButton.setForeground(Color.gray);
        haveACCButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                haveACCButton.setForeground(new Color(0x9900FF));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                haveACCButton.setForeground(Color.gray);
            }
        });
        
        panel.add(haveACCButton);
        return haveACCButton;
    }
    
    static String[] credentials(JTextField username, JPasswordField password) {
        String[] credentials = new String[2];
        
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
        //save the results
        credentials[0] = username.getText();
        credentials[1] = builder.toString();
        
        return credentials;
    }
    
    static void saveU_P(String[] username_Password) {
        File usernameAndPasswords = new File("UserAndPass/DoNotDelete!.txt");
        try {
            //Write the results in a file and separate each element by a $ sign
            FileWriter writer = new FileWriter(usernameAndPasswords, true);
            writer.write(username_Password[0] + "$" + username_Password[1] + "$");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
