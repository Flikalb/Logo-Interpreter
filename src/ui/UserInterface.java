package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserInterface extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelCode = new JPanel();
    private JPanel panelConsol = new JPanel();
    private JPanel panelDraw = new JPanel();

    private JScrollPane scrollPanelConsol;
    private JScrollPane scrollpanelDraw;
    private JScrollPane scrollPanelCode;
    private JLabel codeLabel = new JLabel("Code");
    private JLabel consoleLabel = new JLabel("Console");
    private JLabel drawLabel = new JLabel("Drawing zone");

    public static DrawingZone dw = new DrawingZone(800, 600);
    public static JTextArea console = new JTextArea();
    public static JTextArea code = new JTextArea();

    public UserInterface() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Logo Interpreter");

        console.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        code.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        code.setEditable(false);
        console.setEditable(false);
        console.setRows(5);
        scrollPanelConsol = new JScrollPane(console);
        scrollPanelCode = new JScrollPane(code);
        scrollpanelDraw = new JScrollPane(dw);

        panel.setLayout(new BorderLayout());
        panelCode.setLayout(new BorderLayout());
        panelConsol.setLayout(new BorderLayout());
        panelDraw.setLayout(new BorderLayout());

        panelCode.add(scrollPanelCode, BorderLayout.CENTER);
        panelCode.add(codeLabel, BorderLayout.NORTH);
        panelConsol.add(scrollPanelConsol, BorderLayout.CENTER);
        panelConsol.add(consoleLabel, BorderLayout.NORTH);
        panelDraw.add(scrollpanelDraw, BorderLayout.CENTER);
        panelDraw.add(drawLabel, BorderLayout.NORTH);

        panel.add(panelDraw, BorderLayout.CENTER);
        panel.add(panelConsol, BorderLayout.SOUTH);
        panel.add(panelCode, BorderLayout.EAST);

        this.setContentPane(panel);

    }

    public void displayOn() {
        this.setVisible(true);
    }

    public void displayOff() {
        this.setVisible(false);
    }

    public void setCodeText(String code) {
        this.code.setText(code);
    }

    public String getCodeText() {
        return this.code.getText();
    }

}
