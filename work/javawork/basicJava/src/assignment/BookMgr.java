package assignment;

public class BookMgr {
	
	private Book[] bookList;
	
	
	public BookMgr(Book[] bookList) {
		this.bookList = bookList;
	}
	
	public void printBooklist(){
		for (Book book : bookList) {
			System.out.println(book.getTitle());
		}
	}
	
	public void printTotalPrice(){
		int result = 0;
		for (Book book : bookList) {
			result += book.getPrice();
		}
		System.out.println("전체 책 가격의 합 : " + result);
	}
}
