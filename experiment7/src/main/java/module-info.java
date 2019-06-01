 import lombok.NonNull;//@NOTNULL

 



//import java.util.List;                                  //usual list
//import io.vavr.collection.List;                         //immutable List
//import com.google.common.collect.*;                     //ImmutableList

//@Header@
//--------------------------------------------------------------------------------
//
//                          graph
//                           wilmer 2019/05/30
//
//--------------------------------------------------------------------------------



 module life.expert.graph {
        exports life.expert.algo.research.base;
        
        
        requires java.logging;
	
//	requires himalaya;
 

	requires io.vavr;
	requires static lombok;
	requires io.vavr.match;
	requires com.google.common;
	requires org.apache.commons.lang3;

	requires cyclops;
	////requires cyclops.reactive.collections;

	//requires gson;

	//requires org.jetbrains.annotations;
	//requires error.prone.annotations;
	requires reactor.core;

requires org.slf4j;
 requires org.jetbrains.annotations;
 //requires manifold.all;

//requires org.junit.jupiter.api;
//requires org.junit.jupiter.engine;
//requires org.junit.platform.commons;
//requires org.junit.platform.engine;
//requires junit;
//requires org.junit.platform.engine;


}