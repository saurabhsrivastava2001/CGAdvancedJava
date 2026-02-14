package com.saurabh.HotelManagementSystem;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner= new Scanner(System.in);
	
	public static void addCustomer(Session session) {
		System.out.println("Enter the details of the booking:");

		System.out.println("Enter the custmer name:");
		scanner.nextLine();
		String nameString = scanner.nextLine();
		System.out.println("Room Type Selection");
		System.out.println("1: Standard");
		System.out.println("2: Deluxe");
		System.out.println("3: Suite");
		int type=scanner.nextInt();
		String roomType=type==1?"Standard":type==2?"Deluxe":"Suite";
		int pricePerDay=type==1?2000:type==2?3500:5000;
		
		System.out.println("Checking date: (yyyy-mm-dd)");
		String checkIn=scanner.next();
		System.out.println("Checkout date: (yyyy-mm-dd)");
		String checkout=scanner.next();
		
		int dayDiff= (int)getDateDifference(checkIn, checkout);
		double totalAmount=dayDiff*pricePerDay;
		Booking booking=new Booking( nameString, roomType, checkIn, checkout, totalAmount);
		session.persist(booking);
		System.out.println("Booking created successfully!");
		System.out.println("Your Booking ID is: " + booking.getBookingID()+ " for "+booking.getCustomerName());
		
	}
	public static void UpdateBookingDetails(Session s) {
		System.out.println("Enter the Booking Id");
		int id= scanner.nextInt();
		Booking booking= s.get(Booking.class, id);
		System.out.println("Want to update name press 1 any other number for quitting ");
		int res=0;
		res=scanner.nextInt();
		if(res==1) {
			scanner.nextLine();
			System.out.println("enter the new name ->");
			String nameString = scanner.nextLine();
			booking.setCustomerName(nameString);
			res=0;
		}
		System.out.println("Want to update roomType press 1 any other number for quitting the updation?");
		res=scanner.nextInt();
		if(res==1) {
			System.out.println("Room Type Selection");
			System.out.println("1: Standard");
			System.out.println("2: Deluxe");
			System.out.println("3: Suite");
			int type=scanner.nextInt();
			String roomType=type==1?"Standard":type==2?"Deluxe":"Suite";

			booking.setRoomType(roomType);
			int pricePerDay=type==1?2000:type==2?3500:5000;
			int dayDiff= (int)getDateDifference(booking.getCheckInDate(), booking.getCheckOutDate());
			double totalAmount=dayDiff*pricePerDay;
			booking.setTotalAmount(totalAmount);
			res=0;
		}
		System.out.println("Want to update checkIn date press 1 any other number for quitting the updation?");
		res=scanner.nextInt();
		if(res==1) {
			System.out.println("enter the new checkin date in (YYYY-MM-DD) format ->");
			String checkIn=scanner.next();
			booking.setCheckInDate(checkIn);
			String type=booking.getRoomType();
			int pricePerDay=type.equalsIgnoreCase("standard")?2000:type.equalsIgnoreCase("deluxe")?3500:5000;
			int dayDiff= (int)getDateDifference(booking.getCheckInDate(), booking.getCheckOutDate());
			double totalAmount=dayDiff*pricePerDay;
			booking.setTotalAmount(totalAmount);
			res=0;
		}
		System.out.println("Want to update checkOut date press 1 any other number for quitting the updation?");
		res=scanner.nextInt();
		if(res==1) {
			System.out.println("enter the new checkOut date in (YYYY-MM-DD) format ->");
			String checkOut=scanner.next();
			booking.setCheckInDate(checkOut);
			String type=booking.getRoomType();
			int pricePerDay=type.equalsIgnoreCase("standard")?2000:type.equalsIgnoreCase("deluxe")?3500:5000;
			int dayDiff= (int)getDateDifference(booking.getCheckInDate(), booking.getCheckOutDate());
			double totalAmount=dayDiff*pricePerDay;
			booking.setTotalAmount(totalAmount);
			res=0;
		}
		System.out.println("record/sUpdated successfully!");
		return;
	}
	
	public static void readBookingDetailsById(Session s) {
		System.out.println("enter the id of the booking : ");
		int id= scanner.nextInt();
		Booking booking= s.get(Booking.class, id);
		if(booking!=null) {
			System.out.println("Id: "+booking.getBookingID());
			System.out.println("Name: "+booking.getCustomerName());
			System.out.println("CheckIn date: "+booking.getCheckInDate());
			System.out.println("CheckOut date: "+booking.getCheckOutDate());
			System.out.println("Room type: "+booking.getRoomType());
			System.out.println("Total amount: "+booking.getTotalAmount());
		}
		else {
			System.out.println("Booking doesn't Exist");
		}
	}
	
	public static void deleteBookingById(Session s) {
		System.out.println("enter the id of the Booking: ");
		int id= scanner.nextInt();
		Booking booking=s.get(Booking.class, id);
		s.remove(booking);
		System.out.println("Booking deleted successfully");
	}
	 public static long getDateDifference(String date1, String date2) {

	        DateTimeFormatter formatter =
	                DateTimeFormatter.ofPattern("yyyy-M-d");

	        LocalDate d1 = LocalDate.parse(date1, formatter);
	        LocalDate d2 = LocalDate.parse(date2, formatter);

	        long daysBetween = ChronoUnit.DAYS.between(d1, d2);

	        return Math.abs(daysBetween);   // always positive
	    }
	
    public static void main( String[] args )
    {
    	Configuration cfg= new Configuration();
    	
    	SessionFactory sFactory= cfg.configure().buildSessionFactory();
    	
    	Session session= sFactory.openSession();
    	
    	System.out.println("Enter the admin password to proceed ");
        if( !"admin123".equals(scanner.next()))return;
    	
    	System.out.println("Welcome to the Hotel Management System Admin Portal");
    	
    	 while(true) {
         	System.out.println("Press: ");
         	System.out.println("1: add new customer booking");
         	System.out.println("2: view customer booking details");
         	System.out.println("3: update booking details");
         	System.out.println("4: delete booking");
         	System.out.println("any other key to exit the program! ");
         	
         	int input= scanner.nextInt();
         	switch (input) {
 			case 1:
 				Transaction transaction=session.beginTransaction();
 				try {
 					
 					addCustomer(session);
 					transaction.commit();
 					System.out.println("Employee added successfully");
 					break;
 				}
 				catch (Exception e) {
 					transaction.rollback();
 					e.printStackTrace();
 				}
 				
 				break;
 			case 2:
 				
 				Transaction transaction2=session.beginTransaction();
 				try {
 					
 					readBookingDetailsById(session);
 					transaction2.commit();
 					break;
 				}
 				catch (Exception e) {
 					transaction2.rollback();
 					e.printStackTrace();
 				}
 			case 3:
 				Transaction transaction3=session.beginTransaction();
 				try {
 					
 					UpdateBookingDetails(session);
 					transaction3.commit();
 					break;
 				}
 				catch (Exception e) {
 					transaction3.rollback();
 					e.printStackTrace();
 				}
 			case 4:
 				Transaction transaction4=session.beginTransaction();
 				try {
 					deleteBookingById(session);
 					transaction4.commit();
 					break;
 				}
 				catch (Exception e) {
 					transaction4.rollback();
 					e.printStackTrace();
 				}

 			default:
 				System.out.println("Thanks for using the software");
 				System.out.println(" ----saurabh!");
 				session.close();
 			    sFactory.close();
 				return;
 			}
         	
         }
    
    }
    	
    }

