package busReservation;
import java.util.Date;
import java.sql.*;

public class BookingDAO {
	public int getCount(int busNo,Date date) throws SQLException{
		
		String query = "Select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con=DBconnection.getConnection();
		PreparedStatement pst= con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		pst.setInt(1,busNo);
		pst.setDate(2, sqldate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking) throws SQLException{
		String query = "insert into booking values(?,?,?)";
		Connection con=DBconnection.getConnection();
		
		PreparedStatement pst= con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		pst.setDate(3,sqldate);
		
		pst.executeUpdate();
	}
}
