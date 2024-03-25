package com.xatkit.example.helpers;

import java.util.*;
import java.io.*;

public final class Parser {
  private Parser(){}

  public static final String FN        = ".areorc";
  public static final String COLUMN    = ":";
  public static final String SEPERATOR = "\\^";

  public static void main ( String... args ) {

    //System.out.println("Hello world");
    HashMap<String, String[]> storage = new HashMap<>();
     File config = new File(FN);

     consumeF( config, storage );

     System.out.println(
         storage
     );
  }

  // returns [<name of the intent>, <trainingSentences>]
  public static void consume ( String content, HashMap<String, String[]> storage ){

    String[] splited = content.split( COLUMN );
    String intent    = splited[0].trim();

    String[] trainingSentences = splited[1].split( SEPERATOR );
    
    // cleaning the trainingSentences
    int length = trainingSentences.length;
    for ( int i = 0; i < length ; i ++ ) { trainingSentences[i] = trainingSentences[i].trim();
    }

    System.out.println("trainingSentences : " + Arrays.toString(trainingSentences) );

    storage.put ( intent, trainingSentences );
  }

  // returns all the directives ( seperated by a line )
  public static void consumeF ( File file, HashMap<String, String[]> storage ) {

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

}
