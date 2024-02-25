package com.xatkit.example.helpers;

public final class CustomSb
{
    String out = "";

    public CustomSb( String init ) { this.out = init; }

    public CustomSb append ( String arg )
    {
        out += arg;
        return this;
    }

    public CustomSb appendN (String arg)
    {
        out += arg + "<br/>";
        return this;
    }

    public String out () { return this.out;}
}