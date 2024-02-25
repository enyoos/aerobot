@echo off
mvn compile && mvn exec:java -Dexec.mainClass="com.xatkit.example.GreetingsBot" 