package busReservation;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class BusMain {
	public static void main(String[] args){
		
        Scanner s=new Scanner(System.in);
       
        BusDAO busdao = new BusDAO();
        try {
        busdao.displayInfo();
        
        int user=1;
        while(user==1){
            System.out.println("Enter '1' to Book tickets. Enter '2' to exit");
            user=s.nextInt();
            if(user==1){
                Booking booking=new Booking();   //To collect the details of the user booking tickets
                if(booking.isAvailable()){  //To check the availability of the bus
                    BookingDAO bookingdao=new BookingDAO();
                    bookingdao.addBooking(booking);1
                    System.out.println("Your ticket is confirmed.");
                }
                else {
                    System.out.println("Sorry.The Bus is Already full.Try for another date.");
                }
            }
        }
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
}
