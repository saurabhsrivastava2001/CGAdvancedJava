package in.cg.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.resources.Config;
import service.BookService;
import service.LibraryService;
import service.MemberService;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        ApplicationContext context =
            new AnnotationConfigApplicationContext(Config.class);

        BookService bookService =
            context.getBean(BookService.class);

        MemberService memberService =
            context.getBean(MemberService.class);

        LibraryService libraryService =
            context.getBean(LibraryService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Register Member");
            System.out.println("2 Add Book");
            System.out.println("3 Issue Book");
            System.out.println("4 Return Book");
            System.out.println("5 View Members");
            System.out.println("6 View Books");
            System.out.println("7 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    memberService.registerMember(name, email);
                    break;

                case 2:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    bookService.addBook(title, author);
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    Long mid = sc.nextLong();

                    System.out.print("Enter Book ID: ");
                    Long bid = sc.nextLong();

                    libraryService.issueBook(mid, bid);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    Long mid2 = sc.nextLong();

                    System.out.print("Enter Book ID: ");
                    Long bid2 = sc.nextLong();

                    libraryService.returnBook(mid2, bid2);
                    break;

                case 5:
                    memberService.getAllMembers()
                                 .forEach(System.out::println);
                    break;

                case 6:
                    bookService.getAvailableBooks()
                               .forEach(System.out::println);
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}