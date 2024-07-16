package busReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;
import java.sql.SQLException;

public class Booking {
	String passengerName;
    int busNo;
    Date date;   //Date is class which is in the library of the util package (IMPORTANT)

    Booking(){  //collecting information of the user through the constructor
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Name : ");
        passengerName=s.next();
        System.out.println("Enter Bus No : ");
        busNo=s.nextInt();
        System.out.println("Enter Date (dd-mm-yyyy) : ");
        String dateinput=s.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");  //Date can not be directly assigned conversion must be done through this "SimpleDateFormat" class
        try {    //Exception handling to avoid any errors while entering the date
            date=dateFormat.parse(dateinput);   //Assigning the input date String to Date variable
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAvailable()throws SQLException{
    	
    	BusDAO busdao=new BusDAO();
        int capacity=busdao.getCapacity(busNo);
        
        BookingDAO bookingdao=new BookingDAO();
        
        int booked=bookingdao.getCount(busNo,date);
        
        return booked < capacity;
    }
}
