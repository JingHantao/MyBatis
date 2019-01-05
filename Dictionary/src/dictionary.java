import javax.swing.*;

/**
 * @auther: asuspc
 * @Date: 2019/1/5 20:32
 * @Description:
 */
public class dictionary {
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("dictionary");
        frame.setContentPane(new dictionary().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel1;
    private JButton button1;
    private JCheckBox checkBox1;
}
