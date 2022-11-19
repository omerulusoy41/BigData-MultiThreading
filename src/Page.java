import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Page extends JFrame {

	private JPanel contentPane;
	private JTextArea txtAreaResponse1;
	private JTextArea txtAreaResponse3;
	private JTextArea txtAreaResponse2;
	private JTextArea txtAreaTimeResult;
	private JTextArea txtAreaTimeResult3;
	private JTextArea txtAreaTimeResult2;
	private int coloumn1;
	private int coloumn2;
	private int coloumn3;
	private ThreadProcessing process;
	private JTextField txtID;
	private JTextField txtThreadCount2;
	private JTextField txtSimilarityRate2;
	public Page() {
		Factory factory= new Factory();
		process = new ThreadProcessing(factory.getAllRows());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_50700467969500");
		
		JPanel s1_4 = new JPanel();
		tabbedPane.addTab("1 And 4 Senarious", null, s1_4, null);
		s1_4.setLayout(null);
		
		JPanel s2 = new JPanel();
		tabbedPane.addTab("2 Senario", null, s2, null);
		s2.setLayout(null);
		
		JPanel s3 = new JPanel();
		tabbedPane.addTab("3 Senario", null, s3, null);
		s3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select to Coloumn :");
		lblNewLabel.setBounds(31, 29, 167, 19);
		s1_4.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"Product", "Issue", "Company", "State", "ZipCode", "Complaint Id"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloumn1 = comboBox.getSelectedIndex();
			}
		});
		comboBox.setBounds(31, 71, 145, 20);
		s1_4.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Thread Count :");
		lblNewLabel_1.setBounds(316, 31, 101, 14);
		s1_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Similarity Rate (%40):");
		lblNewLabel_1_1.setBounds(563, 31, 125, 14);
		s1_4.add(lblNewLabel_1_1);
		
		JTextField txtThreadCount1 = new JTextField();
		txtThreadCount1.setBounds(316, 71, 86, 20);
		s1_4.add(txtThreadCount1);
		txtThreadCount1.setColumns(10);
		
		JTextField txtSimilarityRate1 = new JTextField();
		txtSimilarityRate1.setBounds(563, 71, 86, 20);
		s1_4.add(txtSimilarityRate1);
		txtSimilarityRate1.setColumns(10);
		
		JButton btncalculate1 = new JButton("find results");
		btncalculate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtThreadCount1.getText().isEmpty() || txtSimilarityRate1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"fill in all fields","",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				process.scenario1And4(Integer.parseInt(txtThreadCount1.getText()), coloumn1,Integer.parseInt(txtSimilarityRate1.getText()) );
				txtAreaResponse1.setText("");
				for(String s: process.getResult())
					txtAreaResponse1.setText(txtAreaResponse1.getText()+s+"\n");
				txtAreaTimeResult.setText("");
				int i = 0;
				for(Double d: process.getTimesResult())
					txtAreaTimeResult.setText(txtAreaTimeResult.getText()+(++i)+" : "+d+"\n");
				txtThreadCount1.setText("");
				txtSimilarityRate1.setText("");
			}
		});
		btncalculate1.setBounds(790, 48, 115, 23);
		s1_4.add(btncalculate1);
		
		txtAreaTimeResult = new JTextArea();
		txtAreaTimeResult.setBounds(905, 129, 194, 454);
		JScrollPane scrollTimeResult = new JScrollPane(txtAreaTimeResult,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTimeResult.setBounds(905, 129, 194, 454);
		s1_4.add(scrollTimeResult);
		
		JLabel lblNewLabel_2 = new JLabel("Thread Time");
		lblNewLabel_2.setBounds(905, 104, 159, 14);
		s1_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Response :");
		lblNewLabel_3.setBounds(31, 106, 94, 14);
		s1_4.add(lblNewLabel_3);
		
		txtAreaResponse1 = new JTextArea();
		txtAreaResponse1.setBounds(31, 129, 812, 454);
		JScrollPane scrollResponse = new JScrollPane(txtAreaResponse1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollResponse.setBounds(31, 129, 812, 454);
		s1_4.add(scrollResponse);
		
		
		JTextField txtThreadCount3 = new JTextField();
		txtThreadCount3.setColumns(10);
		txtThreadCount3.setBounds(430, 88, 86, 20);
		s3.add(txtThreadCount3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Thread Count :");
		lblNewLabel_1_2.setBounds(429, 48, 101, 14);
		s3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Similarity Rate (%40):");
		lblNewLabel_1_1_1.setBounds(615, 48, 125, 14);
		s3.add(lblNewLabel_1_1_1);
		
		JTextField txtSimilarityRate3 = new JTextField();
		txtSimilarityRate3.setColumns(10);
		txtSimilarityRate3.setBounds(615, 88, 86, 20);
		s3.add(txtSimilarityRate3);
		
		JButton btncalculate3 = new JButton("find results");
		btncalculate3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() || txtThreadCount3.getText().isEmpty() || txtSimilarityRate3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"fill in all fields","",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				String row = factory.getSelectedIDRow(Integer.parseInt(txtID.getText()));
				if(row == null) {
					JOptionPane.showMessageDialog(null,"ID not Found","",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				process.scenario3(Integer.parseInt(txtThreadCount3.getText()), 
						coloumn1,Integer.parseInt(txtSimilarityRate3.getText()),
						row);
				txtAreaResponse3.setText("");
				for(String s: process.getResult())
					txtAreaResponse3.setText(txtAreaResponse3.getText()+s+"\n");
				txtAreaTimeResult3.setText("");
				int i = 0;
				for(Double d: process.getTimesResult())
					txtAreaTimeResult3.setText(txtAreaTimeResult3.getText()+(++i)+" : "+d+"\n");
				txtThreadCount3.setText("");
				txtSimilarityRate3.setText("");
			}
		});
		btncalculate3.setBounds(842, 65, 115, 23);
		s3.add(btncalculate3);
		
		txtAreaResponse3 = new JTextArea();
		txtAreaResponse3.setBounds(31, 140, 812, 454);
		JScrollPane scrollResponse3 = new JScrollPane(txtAreaResponse3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollResponse3.setBounds(31, 129, 812, 454);
		s3.add(scrollResponse3);
		
		txtAreaTimeResult3 = new JTextArea();
		txtAreaTimeResult3.setBounds(905, 129, 194, 454);
		JScrollPane scrollTimeResult3 = new JScrollPane(txtAreaTimeResult3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTimeResult3.setBounds(905, 129, 194, 454);
		s3.add(scrollTimeResult3);
		
		JLabel lblNewLabel_4 = new JLabel("ID :");
		lblNewLabel_4.setBounds(49, 48, 125, 14);
		s3.add(lblNewLabel_4);
		
		txtID = new JTextField();
		txtID.setBounds(49, 88, 86, 20);
		s3.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Select to Coloumn :");
		lblNewLabel_5.setBounds(184, 48, 167, 19);
		s3.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox(new String[] {"Product", "Issue", "Company", "State", "ZipCode", "Complaint Id"});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloumn1 = comboBox_1.getSelectedIndex();
			}
		});
		comboBox_1.setBounds(184, 90, 145, 20);
		s3.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(new String[] {"Product", "Issue", "Company", "State", "ZipCode", "Complaint Id"});
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloumn2 = comboBox_2.getSelectedIndex();
			}
		});
		comboBox_2.setBounds(257, 89, 145, 20);
		s2.add(comboBox_2);
		
		JLabel lblNewLabel_6 = new JLabel("Select to Coloumn :");
		lblNewLabel_6.setBounds(257, 47, 167, 19);
		s2.add(lblNewLabel_6);
		
		txtThreadCount2 = new JTextField();
		txtThreadCount2.setColumns(10);
		txtThreadCount2.setBounds(473, 85, 86, 20);
		s2.add(txtThreadCount2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Thread Count :");
		lblNewLabel_1_3.setBounds(473, 45, 101, 14);
		s2.add(lblNewLabel_1_3);
		
		txtSimilarityRate2 = new JTextField();
		txtSimilarityRate2.setColumns(10);
		txtSimilarityRate2.setBounds(640, 83, 86, 20);
		s2.add(txtSimilarityRate2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Similarity Rate (%40):");
		lblNewLabel_1_1_2.setBounds(640, 43, 125, 14);
		s2.add(lblNewLabel_1_1_2);
		
		txtAreaResponse2 = new JTextArea();
		txtAreaResponse2.setBounds(31, 140, 812, 454);
		JScrollPane scrollResponse2 = new JScrollPane(txtAreaResponse2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollResponse2.setBounds(31, 129, 812, 454);
		s2.add(scrollResponse2);
		
		txtAreaTimeResult2 = new JTextArea();
		txtAreaTimeResult2.setBounds(905, 129, 194, 454);
		JScrollPane scrollTimeResult2 = new JScrollPane(txtAreaTimeResult2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTimeResult2.setBounds(905, 129, 194, 454);
		s2.add(scrollTimeResult2);
		
		JButton btncalculate2 = new JButton("find results");
		btncalculate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( txtThreadCount2.getText().isEmpty() || txtSimilarityRate2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"fill in all fields","",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				process.scenario2(Integer.parseInt(txtThreadCount2.getText()), 
						coloumn1,coloumn2,coloumn3,Integer.parseInt(txtSimilarityRate2.getText()));
				txtAreaResponse2.setText("");
				for(String s: process.getResult())
					txtAreaResponse2.setText(txtAreaResponse2.getText()+s+"\n");
				txtAreaTimeResult2.setText("");
				int i = 0;
				for(Double d: process.getTimesResult())
					txtAreaTimeResult2.setText(txtAreaTimeResult2.getText()+(++i)+" : "+d+"\n");
				txtThreadCount2.setText("");
				txtSimilarityRate2.setText("");
			}
		});
		btncalculate2.setBounds(1018, 63, 115, 23);
		s2.add(btncalculate2);
		
		JComboBox comboBox_2_1 = new JComboBox(new String[] {"Product", "Issue", "Company", "State", "ZipCode", "Complaint Id"});
		comboBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloumn1 = comboBox_2_1.getSelectedIndex();
			}
		});
		comboBox_2_1.setBounds(36, 90, 145, 20);
		s2.add(comboBox_2_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("the same coloumn");
		lblNewLabel_6_1.setBounds(36, 48, 167, 19);
		s2.add(lblNewLabel_6_1);
		
		JComboBox comboBox_2_2 = new JComboBox(new String[] {"Product", "Issue", "Company", "State", "ZipCode", "Complaint Id"});
		comboBox_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloumn3 = comboBox_2_2.getSelectedIndex();
			}
		});
		comboBox_2_2.setBounds(808, 85, 145, 20);
		s2.add(comboBox_2_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Response Coloumn :");
		lblNewLabel_6_2.setBounds(808, 43, 167, 19);
		s2.add(lblNewLabel_6_2);
	}
}
