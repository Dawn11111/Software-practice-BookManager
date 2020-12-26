package com.bookmanager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1258, 734);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/shujuweihu.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/booktypemanager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {//图书类别添加事件
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/booktypeadd.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {//图书类别管理的事件
			public void actionPerformed(ActionEvent e) {
				BookTypeManagementInterFrm bookTypeManageInterFrm=new BookTypeManagementInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookmanager.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {//图书添加
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookadd.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {//图书维护
			public void actionPerformed(ActionEvent e) {
				BookManagementInterFrm bookManagementInterFrm=new BookManagementInterFrm();
				bookManagementInterFrm.setVisible(true);
				table.add(bookManagementInterFrm);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookedit.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {//安全退出按键
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"是否退出系统");
				if(result==0) {//退出
					dispose();
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/quit.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/guanyuwomen.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u7528\u6237");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//在点击"关于我们"的按钮时，出现新的界面
				UserInterFrm userInterFrm=new UserInterFrm();
				userInterFrm.setVisible(true);
				table.add(userInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ours.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.NORTH);
		table.setLayout(new BorderLayout(0, 0));
		
		//设置JFrame最大化
	    //this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

}
