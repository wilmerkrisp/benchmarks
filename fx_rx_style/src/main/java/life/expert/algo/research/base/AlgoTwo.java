package life.expert.algo.research.base;//@Header@
//--------------------------------------------------------------------------------
//
//                          graph  life.expert.algo.research.base
//                           wilmer 2019/02/04
//
//--------------------------------------------------------------------------------









import org.slf4j.Logger;
import org.slf4j.LoggerFactory;









public class AlgoTwo
	{
	
	private static final Logger logger_ = LoggerFactory.getLogger( App.class );
	
	private static final void log_( String message )
		{
		logger_.info(  message );
		}
	
	
	
	private static final void logAtError_( String message )
		{
		logger_.error(  message );
		}
	
	private AlgoTwo()
		{
		}
	
	
	
	public static AlgoTwo of()
		{
		return new AlgoTwo();
		}
	
	
	
	public void run()
		{
		try
			{
			Thread.sleep( 200 );
			}
		catch(final InterruptedException p_exception )
			{
			logAtError_("Sleep interrupted");
			}
		return;
		}
		
		
	}
