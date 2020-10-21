import com.SecondP.SecondProgram.dao.BookDao;

public class BookMain {

	public static void main(String[] args) {
		BookDao.AddBook(01, "AWS");
		BookDao.ShowBook(01);
	}
}
