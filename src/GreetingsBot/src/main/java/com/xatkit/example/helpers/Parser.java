package com.xatkit.example.helpers;

import java.util.*;
import java.io.*;
import com.xatkit.dsl.intent.IntentMandatoryTrainingSentenceStep;
import com.xatkit.dsl.state.*;
import static com.xatkit.dsl.DSL.intent;
import com.xatkit.example.helpers.Customap;

public final class Parser {
  private Parser(){}

  public static final String FN        = ".areorc";
  public static final String COLUMN    = ":";
  public static final String SEPERATOR = "\\^";
  public static final String RESP      = ">>";

  public static void main ( String... args ) {

    //System.out.println("Hello world");
    HashMap<String, Customap> storage = new HashMap<>();
     File config = new File(FN);

     consumeF( config, storage );

     System.out.println(
         storage
     );
  }

  public static void consume ( String content, HashMap<String, Customap> storage ){

    // getting the intent and cleaning it.
    String[] splited = content.split( COLUMN );
    String intent    = splited[0].trim();

    String[] not_intent_splited  = splited[1].split(RESP);
    String[] trainingSentences   = not_intent_splited[0].split(SEPERATOR);
    
    // getting the resp
    String resp = not_intent_splited[1].trim();
    
    // cleaning the trainingSentences
    int length = trainingSentences.length;
    for ( int i = 0; i < length ; i ++ ) { trainingSentences[i] = trainingSentences[i].trim();
    }

    // debugging
    System.out.println("trainingSentences : " + Arrays.toString(trainingSentences) );
    System.out.println("Responding with : "   + resp );

    storage.put ( intent, new Customap( trainingSentences, resp ) );
  }

  // returns all the directives ( seperated by a line )
  public static void consumeF ( File file, HashMap<String, Customap> storage ) {

    ArrayList<String> ret = new ArrayList( 10 );

    try {
      Scanner sc = new Scanner ( file );
      while ( sc.hasNextLine() ){
        ret.add ( sc.nextLine ().trim() );
      }
    }catch ( FileNotFoundException e ) {
      System.out.println( "@rF @Parser File is not found Exception : " + file );
    }
      
    for ( String str : ret ) {
      consume ( str, storage );
    }
  }

  public static IntentMandatoryTrainingSentenceStep[] init_intents( HashMap<String, Customap> storage ) {
    Set<String> ignore = storage.keySet();
    int keys_length    = ignore.size();

    String[] keys = storage.keySet().toArray(new String[keys_length]);

    final IntentMandatoryTrainingSentenceStep[] ret = new IntentMandatoryTrainingSentenceStep[keys_length];

    for ( int i = 0; i < keys_length; i ++ ) {
      ret[i] = intent( keys[i] ).trainingSentences( 
        storage.get ( keys[i] ).sentences
      );
    }

    return ret;
  }

}
