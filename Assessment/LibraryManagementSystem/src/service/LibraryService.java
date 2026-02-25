package service;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private BookService bookService;
    private MemberService memberService;

    public LibraryService(BookService bookService,
                          MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void issueBook(Long memberId, Long bookId) {
        System.out.println("Book Issued Successfully");
    }

    public void returnBook(Long memberId, Long bookId) {
        System.out.println("Book Returned Successfully");
    }
    
}