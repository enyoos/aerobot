#  AreoBot

# Requirements
- jdk 8
- mvn ( preferrably the latest )
- node, npm ( latest LTS )

## Building the xatkit lib
how to build the xatkit lib (follow the instructions ) : https://github.com/xatkit-bot-platform/xatkit/wiki/Build-Xatkit 

# Installation  
```console
git clone https://github.com/enyoos/aerobot.git
```

```console
cd areobot
```

```console
npm i
```

```console
cd src/GreetingsBot
```

```console
mvn clean install
```

```console
cd nlp.js-server
```

```console
npm i
```

navigate to the root directory using :
```console
cd .. && cd.. && cd ..
```

# Execution

## Running react Server
```console
npm start
```

## Running Chat Bot server
```console
cd src/GreetingsBot && mvn clean compile && mvn exec:java -Dexec.mainClass="com.xatkit.example.GreetingsBot"
```

## Running the nlp-js.server
```console
cd src/GreetingsBot/nlp-js.server && npm start
```
print ( "hello world" );
