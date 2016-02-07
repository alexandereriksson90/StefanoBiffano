package facade;

public class UnauthorizedMethodException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedMethodException()
	{
		super("Unauthorized Method");
	}
}
