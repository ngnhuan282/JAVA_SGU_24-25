package GUI;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class LoaiSanPhamGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblLoai;
    private DefaultTableModel modelLoai;
    private JTextField txtMaLoai, txtTenLoai;
    private JButton btnSuaLoai, btnXoaLoai;

    public LoaiSanPhamGUI() {
        setTitle("Quản lý loại sản phẩm");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ này nhưng không tắt app

        // Tiêu đề
        JLabel lbTitle = new JLabel("QUẢN LÝ LOẠI SẢN PHẨM", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lbTitle.setBounds(0, 10, 500, 30);
        getContentPane().add(lbTitle);

        // Bảng hiển thị danh sách loại sản phẩm
        modelLoai = new DefaultTableModel(new String[]{"Mã loại", "Tên loại"}, 0);
        tblLoai = new JTable(modelLoai);
        tblLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        tblLoai.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollLoai = new JScrollPane(tblLoai);
        scrollLoai.setBounds(10, 50, 480, 200);
        getContentPane().add(scrollLoai);

        // Form nhập liệu
        JLabel lbMaLoai = new JLabel("Mã loại:");
        lbMaLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbMaLoai.setBounds(10, 260, 80, 25);
        getContentPane().add(lbMaLoai);

        txtMaLoai = new JTextField();
        txtMaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtMaLoai.setBounds(90, 260, 100, 25);
        txtMaLoai.setEditable(false);
        getContentPane().add(txtMaLoai);

        JLabel lbTenLoai = new JLabel("Tên loại:");
        lbTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
        lbTenLoai.setBounds(210, 260, 71, 25);
        getContentPane().add(lbTenLoai);

        txtTenLoai = new JTextField();
        txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTenLoai.setBounds(280, 260, 200, 25);
        getContentPane().add(txtTenLoai);

        // Nút thêm loại
        ImageIcon addIcon = new ImageIcon(getClass().getResource("/image/add20.png"));
        btnSuaLoai = new JButton("Cập nhật", new ImageIcon(LoaiSanPhamGUI.class.getResource("/image/edit20.png")));
        btnSuaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSuaLoai.setBounds(199, 300, 120, 30);
        btnSuaLoai.setForeground(Color.WHITE);
        btnSuaLoai.setBackground(Color.decode("#7986CB"));
        getContentPane().add(btnSuaLoai);

        // Nút xóa loại
        ImageIcon removeIcon = new ImageIcon(getClass().getResource("/image/remove20.png"));
        btnXoaLoai = new JButton("Xóa", removeIcon);
        btnXoaLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnXoaLoai.setBounds(338, 300, 120, 30);
        btnXoaLoai.setForeground(Color.WHITE);
        btnXoaLoai.setBackground(Color.decode("#FF7043"));
        getContentPane().add(btnXoaLoai);
        
        JButton btnThemLoai = new JButton("Thêm", new ImageIcon(LoaiSanPhamGUI.class.getResource("/image/add20.png")));
        btnThemLoai.setForeground(Color.WHITE);
        btnThemLoai.setFont(new Font("Arial", Font.PLAIN, 13));
        btnThemLoai.setBounds(56, 300, 120, 30);
        btnThemLoai.setBackground(Color.decode("#4CAF50"));
        getContentPane().add(btnThemLoai);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    // Bạn có thể thêm getter để lấy component và xử lý ở class khác nếu cần
    public static void main(String[] args) {
		new LoaiSanPhamGUI();
	}
}
