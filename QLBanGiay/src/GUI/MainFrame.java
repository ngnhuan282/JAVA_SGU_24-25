package GUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Quản lý Chương trình Khuyến mãi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("CTKM", new CTKM());
        tabbedPane.addTab("CTKM Sản phẩm", new CTKMSP());
//        tabbedPane.addTab("CTKM Hóa đơn", new CTKMHDPanel());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
