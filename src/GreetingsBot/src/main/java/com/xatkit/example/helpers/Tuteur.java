package com.xatkit.example.helpers;

import java.util.*;
import com.xatkit.example.helpers.Tuteur;

public class Tuteur {

    private static final String WOMAN = "👩🏻‍🎓";
    private static final String MEN   = "🙋🏻‍♂️";

    public char sex;
    public String name;
    public String omnivox;
    public String outlook;

    public Tuteur ( String name, String omnivox, String outlook, char sex )
    {
        this.omnivox = omnivox;
        this.outlook = outlook;
        this.sex     = sex;
        this.name    = name;
    }

    public Tuteur ( String name )
    {
        this ( name, "", "" , ' ' );
    }

    // give the name
    public String output() { return sex == 'm' ? this.name + MEN : this.name + WOMAN; }

    public static Tuteur fromSet ( List<Tuteur> tuteurs, String name )
    {
        Tuteur tt;         
        for ( Tuteur tuteur : tuteurs )
        {
            if ( tuteur.output().equals ( name ) ) return tuteur;
            else                              continue;
        }

        return null;
    }

    public static List<String> static_cast ( List<Tuteur> tt )
    {
        List<String> ret = new ArrayList<String>(tt.size());
        for ( Tuteur t : tt )
        { ret.add ( t.output() ); }

        return ret;
    }

    @Override
    public String toString()
    { return "⋆˚✿˖° " + this.omnivox + "\n" + "📧" + this.outlook; }

}