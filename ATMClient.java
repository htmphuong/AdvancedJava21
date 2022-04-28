import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ATMClient {

	private JFrame frame;
	private JTextField tfMoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATMClient window = new ATMClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATMClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("987321");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(284, 49, 178, 51);
		frame.getContentPane().add(lblNewLabel);
		
		tfMoney = new JTextField();
		tfMoney.setBounds(200, 110, 297, 60);
		frame.getContentPane().add(tfMoney);
		tfMoney.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket skClient = new Socket("localhost", 8000);
					PrintWriter outClient = new PrintWriter(skClient.getOutputStream());
					String chuoiGui = tfMoney.getText()+";"+"Deposit";
					outClient.println(chuoiGui);
					outClient.flush();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeposit.setBounds(48, 214, 165, 51);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnNewButton = new JButton("Check balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Business bs = new Business();
				ResultSet rs = bs.queryDB("select * from Account");
				try {
					while(rs.next()) {
						System.out.println(rs.getString("AccountID")+" has"+rs.getFloat("Balance"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				try {
					Socket skClient = new Socket("localhost", 8000);
					PrintWriter outClient = new PrintWriter(skClient.getOutputStream());
					String chuoiGui = tfMoney.getText()+";"+"Balance";
					outClient.println(chuoiGui);
					outClient.flush();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(464, 214, 170, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket skClient = new Socket("localhost", 8000);
					PrintWriter outClient = new PrintWriter(skClient.getOutputStream());
					String chuoiGui = tfMoney.getText()+";"+"Withdraw";
					outClient.println(chuoiGui);
					outClient.flush();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnWithdraw.setBounds(49, 320, 165, 51);
		frame.getContentPane().add(btnWithdraw);
	}
}
