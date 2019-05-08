package life.expert.algo.research.base;//@Header@
//--------------------------------------------------------------------------------
//
//                          graph  life.expert.algo.research.base
//                           wilmer 2019/01/23
//
//--------------------------------------------------------------------------------









import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.ResourceBundle;
import java.util.logging.LogManager;


import static cyclops.control.Trampoline.more;
import static cyclops.control.Trampoline.done;

import cyclops.control.Trampoline;
import io.vavr.API;
import io.vavr.CheckedFunction0;
import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Lazy;
//import io.vavr.collection.List;
import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import life.expert.algo.research.values.Man;
import life.expert.common.async.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.Opt;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.internal.FastMoneyAmountFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



import javax.money.MonetaryException;

import static java.text.MessageFormat.format;           //format string

import java.util.ResourceBundle;

import static com.google.common.base.Preconditions.*;   //checkArgument
//import static life.expert.common.base.Preconditions.*;  //checkCollection
import static org.apache.commons.lang3.Validate.*;      //notEmpty(collection)
import static life.expert.common.base.Objects.*;        //deepCopyOfObject


import java.util.function.*;                            //producer supplier

import static java.util.stream.Collectors.*;            //toList streamAPI
import static java.util.function.Predicate.*;           //isEqual streamAPI

import java.util.Optional;


import static reactor.core.publisher.Mono.*;
import static reactor.core.scheduler.Schedulers.*;
import static life.expert.common.async.LogUtils.*;

import static io.vavr.API.*;                            //switch
import static io.vavr.Predicates.*;                     //switch - case
import static io.vavr.Patterns.*;                       //switch - case - success/failure

//import java.util.List;                                 //usual list
//import io.vavr.collection.List;                        //immutable List
//import com.google.common.collect.*;                   //ImmutableList



import static life.expert.algo.research.values.ManPatterns.*;









/**
 * The type App.
 */
@Slf4j
public class App
	{
	
	
	
	private static final ResourceBundle bundle_ = ResourceBundle.getBundle( "messages" );
	
	
	
	private static final String START_MESSAGE_ = bundle_.getString( "startProgram" );
	
	
	
	/**
	 * *    - пакет задать life.expert.algo.research.base
	 * *
	 * *    - change   rootProject.name  in settings.gradle
	 * project name in project settings
	 * *
	 * *
	 * *    - изменим gradle->use gradle wrapper task configuration
	 * ->use autoimport
	 * ->create dir for empty content root auto
	 * -> using qualified names
	 * ->delegate IDE build/run actions to gradle
	 * *
	 * *    - ./gradlew wrapper --gradle-version=5.4
	 * *
	 * *    - app run config, vm options
	 * *            -javaagent:/Users/wilmer/.flow/resources/javaagent.jar -Dflow.agent.autostart -Dflow.agent.include=life.expert.algo
	 * *
	 * *
	 * *    - создадим новый проект
	 * *               в настройках IDEA select code style = выберем мою схему
	 * *
	 * *    - добавим пакеты life.expert.mainpack и класс VV_main
	 * *
	 * *    - добавим поддержку мевена
	 * *               клик на project -> add framework support = maven
	 * *              ОБЯЗАТЕЛЬНО НАЖАТЬ В ПРАВОМ НИЖНЕМ УГЛУ В ВЫСКОЧИВШЕМ ОКНЕ enable auto import
	 * *              помести внутрь тегов в помке снипет maven
	 * *
	 * *    - добавим файл src/main/java/resources/logging.properties
	 * *
	 * *    - добавим metainf
	 * *               cmd+; -> artifacts -> jar -> from modules -> директорию выберем resources
	 * *               (или перетащить мышкой meta-inf в подпапку resources
	 * *
	 * *    - создать конфигурацию "Application" для запуска
	 * *               выбрать главный класс для запуска
	 * *
	 * *    - проверим: сбилдим цель и провери мавенBUILD
	 * *
	 * *
	 *
	 * @param p_i
	 * 	the p i
	 */
	public static void main( final String... p_i )
		{
		//System.out.println( "VV_main main " );
		log_( START_MESSAGE_ );
		
		
		
		
		
		//ThreadUtils.delay( 7 );
		log_( "END MESSAGE" );
		}
	
	//System.out.println( "TRAMPOLINE=" + new App().sum( List.of( 1L , 2L , 3L , 4L ) ) );
	
	
	
	public String sum( List<String> list )
		{
		return sum( "((" , list ).get();
		}
	
	
	
	public Trampoline<String> sum( String acc ,
	                               List<String> cnt )
		{
		return cnt.isEmpty() ? done( acc ) : more( () -> sum( acc + cnt.head() , cnt.tail() ) );
		}
	
	
	//	public Option<String> method1( final String string )
	//		{
	//		return Option( string ).filter( StringUtils::isNotBlank )
	//		                       .onEmpty( logAtWarningRunnable( "App.method1(empty argument)" ) )
	//		                       .map( logAtDebugUnaryOperator( "App.method1" ) )
	//		                       .map( CheckedFunction1.liftTry( this::method1_ ) )
	//		                       //.peek( o -> o.recover( logAtErrorFunction( "App.method1" ) ) )
	//		                       .peek( t -> t.onFailure( logAtErrorConsumer( "meth1" ) ) )
	//		                       .flatMap( t -> Option( t.getOrNull() ) );
	//		}
	
	
	
	/**
	 * Method 1 option.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the option
	 */
	public Optional<String> method1( final String string )
		{
		return Optional.ofNullable( string )
		               .filter( StringUtils::isNotBlank )
		               //.onEmpty( logAtWarningRunnable( "App.method1(empty argument)" ) )
		               .map( logAtDebugUnaryOperator( "App.method1" ) )
		               .map( CheckedFunction1.liftTry( this::method1_ ) )
		               //.peek( o -> o.recover( logAtErrorFunction( "App.method1" ) ) )
		               .map( t -> t.onFailure( logAtErrorConsumer( "meth1" ) ) )
		               .flatMap( t -> Optional.ofNullable( t.getOrNull() ) );
		}
	
	
	
	/**
	 * Method 1 string.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the string
	 */
	public String method1_( final String string )
		{
		throw new RuntimeException( " cause " );
		//return "otvet+" + string;
		}
	
	
	
	/**
	 * Method 2 mono.
	 *
	 * @return the mono
	 */
	public Mono<String> method2( final String string )
		{
		return Mono.justOrEmpty( string )
		           .filter( StringUtils::isNotBlank )
		           .single()
		           .onErrorResume( logAtWarningFunction( "App.method11(empty argument)" , never() ) )
		           .map( logAtDebugUnaryOperator( "App.method1" ) )
		           .flatMap( this::method2_ );
		}
	
	
	
	public Mono<String> method2_( final String string )
		{
		//throw new RuntimeException( " cause " );
		return Mono.justOrEmpty( "otvet+" + string );
		}
		
		
	}
