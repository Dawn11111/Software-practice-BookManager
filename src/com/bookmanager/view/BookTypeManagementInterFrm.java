package com.bookmanager.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DbUtil;
import com.bookmanager.util.StringUtil;

public class BookTypeManagementInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	private JTextArea bookTypeDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private BookDao bookDao=new BookDao();
    private JTextField s_bookTypeNameTxt;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagementInterFrm frame = new BookTypeManagementInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeManagementInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 953, 579);
		
		JScrollPane scrollPane = new JScrollPane();
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(41);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(93);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(93);
		scrollPane.setViewportView(bookTypeTable);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {//图书类别管理“查询”按钮
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeManagementInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(276, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnNewButton)
							.addGap(17))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
					.addGap(261))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {//图书类别管理的“修改”按键
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManagementInterFrm.class.getResource("/images/polish.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {//图书类别管理的“删除”按键
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookTypeManagementInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(3)
									.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(87)
							.addComponent(btnNewButton_2)
							.addGap(84))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookType());
		

	}
	
	/**
	 * 图书类别删除事件处理
	 * @param e
	 */
	private void bookTypeDeleteActionEvent(ActionEvent e) {
		String id=idTxt.getText();//获取id
		if(StringUtil.isEmpty(id)) {//id为空
			JOptionPane.showMessageDialog(null,"请选择要删除的记录");
			return ;
		}
		//为防止用户误点，要进行一个确认设置
		int n=JOptionPane.showConfirmDialog(null,"确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;//开始连接
			try {
				con=dbUtil.getCon();
				boolean flag=bookDao.existBookByBookTypeId(con,id);
				if(flag) {
					JOptionPane.showMessageDialog(null,"当前图书下类别有图书，不能删除此类别");
					return ;
				}
				int deleteNum=bookTypeDao.delete(con,id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null,"删除成功");
		            this.resetValue();
		            this.fillTable(new BookType());
				}else {
					JOptionPane.showConfirmDialog(null,"删除失败");	
				}
			}catch(Exception m) {
				m.printStackTrace(); 
				JOptionPane.showMessageDialog(null,"删除失败");
			}finally {
				try {
					dbUtil.closeCon(con);	//关闭数据库		
				}catch(Exception s) {
					s.printStackTrace();
				}		
				
			}		
			
		}
		
		
		
	}

	/**
	 * 图书类别修改事件处理
	 * @param evt
	 */
	private void bookTypeUpdateActionEvent(ActionEvent evt) {
		//获取三个数据
		String id=idTxt.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		//对id进行判断，如果id是空的，则不能进行修改
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return ;
		}
		//判断bookTypeName
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null,"图书类别名称不能为空");
			return ;
		}
		//实例化
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc); 
		//功能实现
		Connection con=null;//开始连接
		try {
			con=dbUtil.getCon();
			int modifyNum=bookTypeDao.Update(con,bookType);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null,"修改成功");
				this.resetValue();//重置
				this.fillTable(new BookType());//重现显示一个实例
			}else {
				JOptionPane.showMessageDialog(null,"修改失败");	
			}
		}catch(Exception e) {
			e.printStackTrace(); 
			JOptionPane.showMessageDialog(null,"修改失败");
		}finally {
			try {
				dbUtil.closeCon(con);	//关闭数据库		
			}catch(Exception e) {
				e.printStackTrace();
			}		
			
		}		
		
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookTypeMousePressed(MouseEvent evt) {
		int row=bookTypeTable.getSelectedRow();//获取选中行,返回行号
		idTxt.setText((String)bookTypeTable.getValueAt(row,0));
		bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row,1));
		bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row,2));
	}
 
	/**
	 * 图书类别搜索事件处理
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		
		String s_bookTypeName=this.s_bookTypeNameTxt.getText();//获取用户输入的图书类别
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);//把图书类别设置进去
		this.fillTable(bookType);
		
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行，即把表格清空
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con,bookType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);	//关闭数据库		
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");	
	}
}
