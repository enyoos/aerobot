package com.xatkit.example.helpers;

public class Customap {
  public String[] sentences;
  public String   resp; // @Incomplete , make it more than one
  
  public Customap( String[] sentences, String resp ) {
    this.sentences = sentences;
    this.resp = resp;
  }

  @Override
  public String toString () {
    return "@CustomMap( sentences_l = " + this.sentences.length + ", resp = " + resp;
  }

}
