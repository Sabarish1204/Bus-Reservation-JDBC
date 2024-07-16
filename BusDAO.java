package busReservation;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class BusDAO {
	public void displayInfo() throws SQLException{
		String query="Select * from bus";
		Connection con=DBconnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println("Bus No : "+rs.getInt(1));
			if(rs.getInt(2)==0) {
				System.out.println("AC : No");
			}
			else System.out.println("AC : Yes");
			
			System.out.println("Capacity : "+ rs.getInt(3));
			System.out.println("x--------x");
		}
		System.out.println(" - - - - - - - - - - - - ");
	}
	
	public int getCapacity(int id) throws SQLException{
		String query = "Select Capacity from bus where id=" +id;
		Connection con=DBconnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
