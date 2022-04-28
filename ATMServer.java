import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ATMServer {																		

	public ATMServer() {
		try {
			ServerSocket serverSK = new ServerSocket(8000);
			Socket skServer = serverSK.accept();
			//nhan du lieu
			while(true) {
				DataInputStream inputServer = new DataInputStream(skServer.getInputStream());
				String chuoiNhan = inputServer.readLine();
				System.out.println("client "+chuoiNhan);
				float money = Float.parseFloat(chuoiNhan.split(";")[0]);
				String option = chuoiNhan.split(";")[1];
				switch (option) {
				case "Deposit": {
						Business bs = new Business();
						//System.out.println("Update Account set Balance =Balance+"+money + "where AccountID=987321");
						bs.executeDB("Update Account set Balance =Balance+"+money + " where AccountID=987321");
						JOptionPane.showMessageDialog(null, "Success");
						break;
						}
				case "Withdraw":{
					
				}
				case "Balance":{
					String accountID="987321";
					Business bs = new Business();
					ResultSet rs= bs.queryDB("EXEC sp_CheckBalance '"+accountID+"'");
					while(rs.next()) System.out.println("Balance is"+rs.getFloat("Balance"));
				
				}
				default:
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ATMServer();
	}

}
