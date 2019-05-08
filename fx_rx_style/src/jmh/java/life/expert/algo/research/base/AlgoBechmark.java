package life.expert.algo.research.base;//@Header@
//--------------------------------------------------------------------------------
//
//                          graph  life.expert.algo.research.base
//                           wilmer 2019/01/31
//
//--------------------------------------------------------------------------------









import io.vavr.CheckedFunction1;
import io.vavr.control.Option;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Optional;

import life.expert.common.async.ThreadUtils;

import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.*;
import static reactor.core.scheduler.Schedulers.*;
import static life.expert.common.async.LogUtils.*;

import static io.vavr.API.*;                            //switch
import static io.vavr.Predicates.*;                     //switch - case
import static io.vavr.Patterns.*;                       //switch - case - success/failure









/**
 * The type Algo bechmark.
 */
public class AlgoBechmark
	{
	
	
	
	/**
	 * Some method string.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the string
	 */
	public String someMethod_( final String string )
		{
		//throw new RuntimeException( " cause " );
		return "otvet+" + string;
		}
	
	
	
	/**
	 * Return optional optional.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the optional
	 */
	public Optional<String> returnOptional( final String string )
		{
		return Optional.ofNullable( string )
		               .filter( StringUtils::isNotBlank )
		               //.onEmpty( logAtWarningRunnable( "AlgoBechmark.tryOptional(empty argument)" ) )
		               .map( logAtDebugUnaryOperator( "debug" ) )
		               .map( CheckedFunction1.liftTry( this::someMethod_ ) )
		               .map( t -> t.onFailure( logAtErrorConsumer( "error" ) ) )
		               .flatMap( t -> Optional.ofNullable( t.getOrNull() ) );
		}
	
	
	
	public Option<String> returnOption( final String string )
		{
		return Option( string ).filter( StringUtils::isNotBlank )
		                       //.onEmpty( logAtWarningRunnable( "AlgoBechmark.(empty argument)" ) )
		                       .map( logAtDebugUnaryOperator( "debug" ) )
		                       .map( CheckedFunction1.liftTry( this::someMethod_ ) )
		                       .peek( t -> t.onFailure( logAtErrorConsumer( "error" ) ) )
		                       .flatMap( t -> Option( t.getOrNull() ) );
		}
	
	
	
	public Mono<String> returnMono( final String string )
		{
		return justOrEmpty( string ).filter( StringUtils::isNotBlank )
		                            .single()
		                            //.onErrorResume( logAtWarningFunction( "AlgoBechmark. returnMono(empty argument)" , never() ) )
		                            .map( logAtDebugUnaryOperator( "debug" ) )
		                            .map( this::someMethod_ )
		                            .onErrorContinue( logAtErrorBiConsumer( "error" ) );
		}
	
	
	
	/**
	 * Return string string.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the string
	 */
	public String returnString( final String string )
		{
		if( string == null || string.isBlank() )
			{
			//logAtWarning_( "string param must not ne null or empty" );
			return "";
			}
		
		logAtDebug_( "debug({})" , string );
		
		String rezult = "";
		try
			{
			rezult = someMethod_( string );
			}
		catch( Exception e )
			{
			logAtError_( "error:" + e + string );
			}
		
		return rezult;
		}
	
	
	
	/**
	 * Algo two.
	 *
	 * @param data
	 * 	the data
	 * @param hole
	 * 	the hole
	 */
	@Benchmark
	public void caseWithString( ExperimentData data ,
	                            Blackhole hole )
		{
		data.list.forEach( s -> hole.consume( returnString( s ) ) );
		}
	
	
	
	/**
	 * Case with optional.
	 *
	 * @param data
	 * 	the data
	 * @param hole
	 * 	the hole
	 */
	@Benchmark
	public void caseWithOptional( ExperimentData data ,
	                              Blackhole hole )
		{
		data.list.forEach( s -> hole.consume( returnOptional( s ).orElse("NO VALUE"  ) ) );
		}
	
	
	
	@Benchmark
	public void caseWithVavrOption( ExperimentData data ,
	                                Blackhole hole )
		{
		data.list.forEach( s -> hole.consume( returnOption( s ).getOrElse( "NO VALUE" ) ) );
		}
	
	
	@Benchmark
	public void caseWithReactorMono( ExperimentData data ,
	                                Blackhole hole )
		{
		data.list.forEach( s -> returnMono( s ).subscribe( hole::consume ) );
		}
		
	}
