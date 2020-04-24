package notebook.exception;

public class EmptyStockException extends Exception {

	public EmptyStockException() {
		super();
	}
	public EmptyStockException(String message) {
		super(message);
	}
}
