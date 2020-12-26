package com.bookmanager.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.bookmanager.dao.UserDao;
import com.bookmanager.model.User;
import com.bookmanager.util.DbUtil;
import com.bookmanager.util.StringUtil;

public class LogOnFrm extends JFrame {
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		//�ı�ϵͳĬ������
		Font font=new Font("Dialog",Font.PLAIN,12);
		java.util.Enumeration keys=UIManager.getDefaults().keys();
		while(keys.hasMoreElements()) {
			Object key=keys.nextElement();
			Object value=UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key,font);
			}
		}
		
		
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/logon.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/user.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//��ֱ���ã����¶���һ���¼�����¼�¼���
				loginActionPerformed(e);			
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/denglu.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/chongzhi.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//��ֱ��д�����¶���һ���¼��������¼���
				resetValueActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
					.addGap(128))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(btnNewButton)
					.addGap(91)
					.addComponent(btnNewButton_1)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//����JFrame������ʾ
		this.setLocationRelativeTo(null);
	}
	/**
	 * ��¼�¼�����
	 * @param e
	 */
    private void loginActionPerformed(ActionEvent e) {
    	String userName=this.userNameTxt.getText();//��ö�Ӧ���û���
    	String password=new String(this.passwordTxt.getPassword());//��ö�Ӧ������
    	//������û��������벻��Ϊ��
    	if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null,"�û�����Ϊ�գ�");
			return;					
		}
    	if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�");
			return;					
		}
    	//���ݿ�����
    	User user=new User(userName,password);//ʵ����
    	Connection con=null;
    	try {
    		con = dbUtil.getCon();//�������ݿ�
    		User currentUser=userDao.login(con,user);
    		if(currentUser!=null) {
    			dispose();//���ٵ�ǰ���壬����������
    			new MainFrm().setVisible(true);
    		}else {
    			JOptionPane.showMessageDialog(null,"�û����������");
    		}
    	}catch(Exception m) {
    		m.printStackTrace();
    	}		    	
	}

	/**
     * �����¼�������������������Ϊ��
     * @param e
     */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");		
	}
}
