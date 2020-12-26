package com.bookmanager.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.Book;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DbUtil;
import com.bookmanager.util.StringUtil;

public class BookManagementInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_authorTxt;
	private JTextField s_bookNameTxt;
	private JComboBox s_bookTypeJcb;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagementInterFrm frame = new BookManagementInterFrm();
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
	public BookManagementInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u9986\u91CC");
		setBounds(100, 100, 950, 651);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_9 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {//ͼ������޸ġ���ť
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {//ͼ�����ɾ������ť
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerformed(evt);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt)))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_7))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookNameTxt)
								.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(femaleJrb))
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookDescTxt)))
					.addGap(90))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(244)
					.addComponent(btnNewButton_1)
					.addGap(135)
					.addComponent(btnNewButton_2)
					.addContainerGap(270, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(manJrb)
								.addComponent(femaleJrb))
							.addGap(18))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addGap(24))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {//��ѯ�¼�
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnNewButton)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1)
							.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {//����е��
				bookTableMousePressed(me);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(56);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillBookType("search");//����	
		this.fillBookType("modify");
		this.fillTable(new Book());//����	  

	}
	
	
	/**
	 * ͼ��ɾ���¼�����
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();//��ȡid
		if(StringUtil.isEmpty(id)) {//idΪ��
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼");
			return ;
		}
		//Ϊ��ֹ�û���㣬Ҫ����һ��ȷ������
		int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ���ü�¼��");
		if(n==0) {
			Connection con=null;//��ʼ����
			try {
				con=dbUtil.getCon();	
				int deleteNum=bookDao.delete(con,id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
		            this.resetValue();
		            this.fillTable(new Book());
				}else {
					JOptionPane.showConfirmDialog(null,"ɾ��ʧ��");	
				}
			}catch(Exception m) {
				m.printStackTrace(); 
				JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
			}finally {
				try {
					dbUtil.closeCon(con);	//�ر����ݿ�		
				}catch(Exception s) {
					s.printStackTrace();
				}		
				
			}		
			
		}
		
	}

	
	/**
	 * ͼ���޸��¼�����
	 * @param evt
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		//����û�һ��һ����¼��ûѡ��
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼");
			return ;
		}
		//��ȡ����(���������ߡ��۸�)
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		//�ж��Ƿ�Ϊ��
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null,"ͼ�����Ʋ���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null,"ͼ�����߲���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null,"ͼ��۸���Ϊ�գ�");
			return;
		}
		//��ȡ����(�Ա�)
		String sex="";
		if(manJrb.isSelected()) {
			sex="��";
		}else if(femaleJrb.isSelected()) {
			sex="Ů";
		}
		//��ȡ����(ͼ�����)
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		//��װ
		Book book=new Book(Integer.parseInt(id),bookName,author,sex,Float.parseFloat(price),bookTypeId,bookDesc);
		//�޸Ĳ���
		Connection con=null;
		try {
			con=dbUtil.getCon();	
			int addNum=bookDao.update(con,book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null,"ͼ���޸ĳɹ�");
				resetValue();
				this.fillTable(new Book());//û����һ�����޸Ĺ���������ڱ���ϲ�����
			}else {
				JOptionPane.showMessageDialog(null,"ͼ���޸�ʧ��");
			}
		}catch(Exception m) {
			m.printStackTrace(); 
			JOptionPane.showMessageDialog(null,"ͼ���޸�ʧ��");
		}finally {
			try {
				dbUtil.closeCon(con);	//�ر����ݿ�		
			}catch(Exception s) {
				s.printStackTrace();
			}		
			
		}	
	}

	
	
	/**
	 * ���ñ�
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {//����ͼ�����Ϊ��
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
	

	/**
	 * ����е���¼�����
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		int row=this.bookTable.getSelectedRow();//��ȡ����
		this.idTxt.setText((String)bookTable.getValueAt(row,0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row,1));
		this.authorTxt.setText((String)bookTable.getValueAt(row,2));
		String sex=(String)bookTable.getValueAt(row,3);
		if("��".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if("Ů".equals(sex)) {
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row,4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row,5));
		String bookTypeName=(String)this.bookTable.getValueAt(row,6);
		int n=this.bookTypeJcb.getItemCount();
		for(int i=0;i<n;i++) {
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * ͼ���ѯ�¼�����
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		//��ȡ��ѯ����
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		//����ʵ��
		Book book=new Book(bookName,author,bookTypeId);//��װ
		this.fillTable(book);
		
	}

	/**
	 * ��ʼ��������
	 * @param type ����������
	 */
	private void fillBookType(String type) {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();//��ʼ��
			ResultSet rs=bookTypeDao.list(con,new BookType());//Ū�����ݣ�������һ�������
			//�����ж�
			if("search".equals(type)) {//���ʼ��û�е���������ʱ�����ʾ
				bookType=new BookType();
				bookType.setBookTypeName("��ѡ��...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);				
			}
			while(rs.next()) {
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				}else if("modify".equals(type)){
					this.bookTypeJcb.addItem(bookType);
				}
			}
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			try {
				dbUtil.closeCon(con);	//�ر����ݿ�		
			}catch(Exception e) {
				e.printStackTrace();
			}		
			
		}	
	}
	
	
	/**
	 * ��ʼ���������
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//���ó�0�У����ѱ�����
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con,book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);	//�ر����ݿ�		
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		
	}
}
