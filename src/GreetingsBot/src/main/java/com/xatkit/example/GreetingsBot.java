package com.xatkit.example;

import com.xatkit.core.XatkitBot;
import com.xatkit.plugins.react.platform.ReactPlatform;
import com.xatkit.plugins.react.platform.socket.action.*;
import com.xatkit.core.recognition.*;
import com.xatkit.library.core.CoreLibrary;
import com.xatkit.example.helpers.*;
import com.xatkit.core.recognition.nlpjs.*;
import org.apache.commons.configuration2.Configuration;
import static com.xatkit.dsl.DSL.eventIs;
import static com.xatkit.dsl.DSL.fallbackState;
import static com.xatkit.dsl.DSL.intent;
import static com.xatkit.dsl.DSL.intentIs;
import static com.xatkit.dsl.DSL.model;
import static com.xatkit.dsl.DSL.state;

import java.util.*;
import lombok.val;

import static com.xatkit.plugins.react.platform.utils.MessageUtils.*;
import com.xatkit.plugins.react.platform.action.*;
import com.xatkit.plugins.react.platform.io.*;
import org.apache.commons.configuration2.BaseConfiguration;
import static com.xatkit.example.helpers.Utils.*;

public class GreetingsBot {

        private static NavTree tree    = NavTree.init_nav_3();
        private static boolean asked   = false;
        private static String nameTutor= "";
        private static List<Tuteur> set= null;
        private static String sub      = null;
        private static String question = null;

        public static void main(String[] args) {

                String[] cheat_     = {
                        "Peux tu resoudre pour moi ce problem ?",
                        "Est-ce que tu peux m'aider a completer ce devoir",
                        "Resoud ce problem",
                        "Resoud cette question",
                        "Fais mon devoir", 
                        "Donne moi la reponse",
                        "Dis moi la bonne reponse",
                        "C'est quoi la bonne reponse",
                        "Est-ce que tu peux m'aider a remettre mon devoir",
                        "Simplifie cette equation",
                };

                String[] greetings_ = {
                        "Salut",
                        "Yo",
                        "Bonjour",
                        "hello",
                        "Hey",
                        "Allo",
                        "Heureux de te voir encore",
                        "Que la paix soit sur toi",
                        "Hello world",
                        "Kespass",
                        "Wesh",
                        "Mon gars",
                };

                String[] thankful_   = {
                        "woa, merci beaucoup",
                        "ton service me fait plaisir",
                        "Merci beaucoup",
                        "Je te remercie !",
                        "Merci",
                        "Tu me sauve la vie",
                        "J'apprecie ton aide",
                        "Tu m'as beaucoup aider",
                        "Ton aide m'est utile",
                };

                String[] howAreYou_ = {
                        "Comment tu vas ?", 
                        "Qu'est-ce qu'il y a de nouveau ?",
                        "Comment te sens-tu",
                        "Quelles sont tes sentiments ?" ,
                };

                String[] sad_       = {
                        "Je ne vais pas trop bien...",
                        "Je me sens pas bien",
                        "Je me sens mal",
                        "Je suis triste...",
                        "Je suis en depression",
                        "Je manque de motivation",
                        "Je n'ai plus envie de vivre",
                        "Je pense que je vais echouer ma session",
                        "Je pense que l'ecole n'est pas fait pour moi !",
                        "J'ai beaucoup de probleme en ce moment",
                        "Burnout",
                        "J'ai faim",
                        "J'ai des problemes avec ma famille",
                        "Ma copine m'a quitter",
                        "Je suis en divorce",
                        "Mes parents sont morts",
                        "Mes amis sont morts",
                        "J'ai peur d'aller a l'ecole",
                        "J'ai de la peine",
                        "Ma meuf m'a quitter",
                        "Je fais un burnout",
                        "J'ai beaucoup de chose a faire",
                        "J'ai trop de truc a prendre en compte",
                        "Je n'aime plus travailler",
                        "Je n'ai pas beaucoup d'amis",
                };

                String[] joy_          = {
                        "Je vais tres bien !",
                        "Oui ca roule,  merci bcp",
                        "Oui sa va bien",
                        "Tout marche bien dans ma vie",
                        "Je suis de bonne humeur",
                        "Je me suis lever du bon pied",
                        "Je ne suis plus en depression",
                        "Je suis heureux",
                        "Je suis motiver pour finir ma session",
                        "J'ai hate de finir l'ecole",
                        "J'aime aller a l'ecole",
                        "J'aime la vie",
                };

                // ici on peut redirect le tout a chat gpt, mais je pense que c'est meilleur d'en faire une compilation ?
                String[] tuteur_         = {
                        "J'aimerais un tuteur", 
                        "Quelles sont les tuteurs disponibles",
                        "Puis-je avoir un rendez vous avec un tuteur ?",
                        "Est-ce que il y a des tuteurs ?",
                        "Est-ce qu'il y a du tutorat ?",
                        "J'ai besoin d'un mentor",
                        "J'ai besoin d'aide en math",
                        "J'ai besoin d'un accompagnement personnel",
                        "J'ai besoin d'aide dans mes etudes",
                        "J'ai de la difficulte dans mes matieres",
                        "J'ai des mauvaises notes en math",
                        "Je pense que je vais echouer ma session",
                        "J'aimerais augmenter ma cote R",
                        "J'aimerais avoir de meilleur note",
                };

                /*
                * Define the intents our bot will react to.
                * <p>
                * In this example we want our bot to answer greetings inputs and "how are you" questions, so we create an
                * intent for each, and we give a few example training sentences to configure the underlying NLP engine.
                * <p>
                * Note that we recommend the usage of Lombok's val when using the Xatkit DSL: the fluent API defines many
                * interfaces that are not useful for bot designers. If you don't want to use val you can use our own
                * interface IntentVar instead.
                */

                // let's use french sentences

                val greetings = intent("Greetings")
                        .trainingSentence(greetings_[0])
                        .trainingSentence(greetings_[1])
                        .trainingSentence(greetings_[2])
                        .trainingSentence(greetings_[3])
                        .trainingSentence(greetings_[4])
                        .trainingSentence(greetings_[5])
                        .trainingSentence(greetings_[6]);

                val cheat   = intent("Cheat")
                        .trainingSentence(cheat_[0])
                        .trainingSentence(cheat_[1])
                        .trainingSentence(cheat_[2])
                        .trainingSentence(cheat_[3])
                        .trainingSentence(cheat_[4])
                        .trainingSentence(cheat_[5])
                        .trainingSentence(cheat_[6])
                        .trainingSentence(cheat_[7])
                        .trainingSentence(cheat_[8]);

                val thankful  = intent("Thankful")
                        .trainingSentence( thankful_[0] )
                        .trainingSentence( thankful_[1] )
                        .trainingSentence( thankful_[2] )
                        .trainingSentence( thankful_[3] )
                        .trainingSentence( thankful_[4] )
                        .trainingSentence( thankful_[5] )
                        .trainingSentence( thankful_[6] )
                        .trainingSentence( thankful_[7] );

                val howAreYou = intent("HowAreYou")
                        .trainingSentence(howAreYou_[0])
                        .trainingSentence(howAreYou_[1])
                        .trainingSentence(howAreYou_[2])
                        .trainingSentence(howAreYou_[3]);

                val sad            = intent ( "sad" )
                        .trainingSentence ( sad_[0] )  
                        .trainingSentence ( sad_[1] )  
                        .trainingSentence ( sad_[2] )  
                        .trainingSentence ( sad_[3] )  
                        .trainingSentence ( sad_[4] )  
                        .trainingSentence ( sad_[5] )  
                        .trainingSentence ( sad_[6] )  
                        .trainingSentence ( sad_[7] )  
                        .trainingSentence ( sad_[9] )  
                        .trainingSentence ( sad_[10] )  
                        .trainingSentence ( sad_[11] )  
                        .trainingSentence ( sad_[12] )  
                        .trainingSentence ( sad_[13] )  
                        .trainingSentence ( sad_[14] );

                val happy          = intent ( "happy" )
                        .trainingSentence ( joy_[0] )
                        .trainingSentence ( joy_[1] )
                        .trainingSentence ( joy_[2] )
                        .trainingSentence ( joy_[3] )
                        .trainingSentence ( joy_[4] )
                        .trainingSentence ( joy_[5] );

                /*
                * Instantiate the platform we will use in the bot definition.
                * <p>
                * Instantiating the platform before specifying the bot's states creates a usable reference that can be
                * accessed in the states, e.g:
                * <pre>
                * {@code
                * myState
                *   .body(context -> reactPlatform.reply(context, "Hi, nice to meet you!");
                * }
                * </pre>
                */
                /*
                * Similarly, instantiate the intent/event providers we want to use.
                * <p>
                * In our example we want to receive intents (i.e. interpreted user inputs) from our react client, so we
                * create a ReactIntentProvider instance. We also want to receive events from the react client (e.g. when the
                * client's connection is ready), so we create a ReactEventProvider instance.
                * <p>
                * We can instantiate as many providers as we want, including providers from different platforms.
                */
                ReactPlatform reactPlatform             = new ReactPlatform();
                ReactEventProvider reactEventProvider   = reactPlatform.getReactEventProvider();
                ReactIntentProvider reactIntentProvider = reactPlatform.getReactIntentProvider();

                /*
                * Create the states we want to use in our bot.
                * <p>
                * Similarly to platform/provider creation, we create the state variables first, and we specify their content
                * later. This allows to define circular references between states (e.g. AwaitingQuestion -> HandleWelcome ->
                * AwaitingQuestion).
                * <p>
                * This is not mandatory though, the important point is to have fully specified states when we build the
                * final bot model.
                */
                val init = state("Init");
                val awaitingInput  = state("AwaitingInput");
                val handleWelcome  = state("HandleWelcome");
                val promptChooseSubject = state ( "PromptSubject" );
                val handleWhatsUp  = state("HandleWhatsUp");
                val handleQuestion = state("HandleQuestion");
                val handleBooking  = state("HandleBooking");
                val handleThankful = state("HandleThankful");
                val handleCheat    = state("HandleCheat");
                val handleHappy    = state("HandleHappy");
                val handleSad      = state("HandleSad");

                // CHIMIE
                val handleChimie = state ( "HandleChimie" );

                // MATH
                val handleListMatiereMath = state ( "listMath" );
                val handleAlgebreLineaire = state ( "HandleAlgebreLineaire" );
                val handleCalcul_I         = state ( "HandleCalculI");
                val handleCalcul_II        = state ( "HandleCalculII");
                val handlePhysique         = state ( "HandlePhysique");

                init
                        .next()
                        .when(eventIs(ReactEventProvider.ClientReady)).moveTo(awaitingInput);

                val promptUser = state ( "promptUser" );
                val handleSuggestion = state ( "HandleSugg" );

                awaitingInput
                        .next()
                        .when(intentIs(greetings)).moveTo(handleWelcome)
                        .when(intentIs(howAreYou)).moveTo(handleWhatsUp)
                        .when(intentIs(thankful)).moveTo(handleThankful)
                        .when(intentIs(cheat)).moveTo (handleCheat);

                handleWelcome
                        .body(context -> reactPlatform.reply(context, "Salut ! Je m'appelle 🔥roseBot🔥. Je suis enchanté de faire ta rencontre 😊!"))
                        .next()
                        .moveTo(promptUser);

                handleWhatsUp
                        .body(context -> reactPlatform.reply(context, "Je vais bien ✅! Et toi ?"))
                        .next()
                                .when(intentIs(happy)).moveTo( handleHappy )
                                .when(intentIs( sad )).moveTo ( handleSad );

                handleHappy
                        .body( context -> reactPlatform.reply(context, "Wow, je suis très content pour toi 👌!"))
                        .next()
                        .moveTo(promptUser);

                handleSad
                        .body( context -> reactPlatform.reply(context, "Les temps sont très difficiles 😓. Voici une citation pour te motiver 💪" + 
                                giveMeQuote()))
                        .next()
                        .moveTo(promptUser);

                promptUser
                        .body ( context -> reactPlatform.reply (context, asked ? "Besoin d'autre chose🤔" : "Comment puis-je t'aider aujourd'hui 🛠️?", prompt_helper()))
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_HAVE_QUESTION );
                                })).moveTo( promptChooseSubject )
                                .when( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_NEED_TUTOR );
                                })).moveTo ( handleBooking )
                                .when( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_HAVE_SUGG );
                                })).moveTo( handleSuggestion );


                handleThankful
                        .body( context -> reactPlatform.reply(context, "Avec plaisir 😊!"))
                        .next()
                        .moveTo(awaitingInput);


                handleCheat
                        .body(context -> reactPlatform.reply(context, "Désolé je ne peux pas répondre à ce genre de question 🥺.") )
                        .next()
                        .moveTo ( awaitingInput );

                val handleSaved      = state ( "Saved" );

                handleSuggestion
                        .body ( context -> reactPlatform.reply ( context, "Super ! Quelle est cette merveilleuse idée 🧐"))
                        .next ()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String sugg = ( String ) context.getIntent().getValue("value");
                                        return true;
                                })).moveTo ( handleSaved );


                handleSaved
                        .body ( context -> reactPlatform.reply ( context, "Merçi, j'ai mémorisé ta magnifique suggestion dans ma base de donnée!"))
                        .next()
                        .moveTo ( promptUser );

                val giveAllPhysTutors   = state ( "giveAllPhysTutors" );        
                val giveAllChimieTutors = state ( "giveAllChimieTutors" );
                val giveAllMathTutors   = state ( "giveAllMathTutors" );

                handleBooking
                        .body( context -> reactPlatform.reply(context, "Super, choisis la spécification voulue de ton tuteur", optionsSubject()) )
                        .next()
                                .when( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( MATH );
                                })).moveTo ( giveAllMathTutors )
                                .when( intentIs ( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals(CHIMIE);
                                })).moveTo( giveAllChimieTutors )
                                .when( intentIs ( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( PHYS );
                                })).moveTo( giveAllPhysTutors );

                val giveTutorDesc = state ( "giveDesc" );

                // handle in all give<...> the input
                giveAllPhysTutors
                        .body( context -> reactPlatform.reply ( context, String.format( "Voici nos meilleurs tuteurs en %s", PHYS ), Tuteur.static_cast (getTuteurPhysique()) ))
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        nameTutor      = clicked.substring(0, clicked.length()-1); 
                                        set            = getTuteurPhysique();
                                        return true;
                                })).moveTo( giveTutorDesc );

                giveAllChimieTutors
                        .body( context -> reactPlatform.reply ( context, String.format("Voici nos meilleurs tuteurs en %s", CHIMIE), Tuteur.static_cast(getTuteurChimie()) ))
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        nameTutor      = clicked.substring(0, clicked.length()-1); 
                                        set            = getTuteurPhysique();
                                        return true;
                                })).moveTo( giveTutorDesc );


                giveAllMathTutors
                        .body( context -> reactPlatform.reply ( context, String.format ("Voici nos meilleurs tuteurs en %s", MATH), Tuteur.static_cast (getTuteurMath())) )
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        nameTutor      = clicked;
                                        set            = getTuteurPhysique();
                                        return true;
                                })).moveTo( giveTutorDesc );

                giveTutorDesc
                        .body ( context -> {
                                        reactPlatform.reply ( 
                                                context, 
                                                new CustomSb( "Voici les informations de " + nameTutor ).appendN("").append(Tuteur.fromSet(set, nameTutor).toString()).out()
                                        );
                                }
                        )
                        .next()
                        .moveTo ( awaitingInput );

                promptChooseSubject
                        .body ( context -> reactPlatform.reply( context, "Quelle est le domaine scientifique de cette question ?", optionsSubject() ) )
                        .next( )
                                .when( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals ( MATH );
                                })).moveTo( handleListMatiereMath )
                                .when( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( CHIMIE );
                                })).moveTo ( handleChimie )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( PHYS );
                                })).moveTo ( handlePhysique )
                        .fallback ( context -> {
                                reactPlatform.reply ( context, "Cette matière n'existe pas 😵...");
                        });

                handleChimie
                        .body( context -> reactPlatform.reply ( context, "Voici les matières disponibles"))
                        .next()
                        .moveTo( awaitingInput );

                val handleCalculusI = state( "HandleCalculusI" );
                val handleCalculusII = state ( "HandleCalculusII" );
                val handleDiscreteMath = state ( "HandleDMath" );
                val listAllQuestionMath = state ( "allQMathCalc" );

                handleListMatiereMath
                        .body ( context -> reactPlatform.reply ( context, "Choisis ta matière pertinente à cette question", listeMatiereMath() ))
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        sub = MATH_CALC_I;
                                        return clicked.equals( MATH_CALC_I );
                                })).moveTo ( listAllQuestionMath )
                                .when( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue ( "value" );
                                        sub = MATH_CALC_II;
                                        return clicked.equals( MATH_CALC_II );
                                }) ).moveTo ( listAllQuestionMath )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue ( "value" );
                                        sub = MATH_DISCRETE ;
                                        return clicked.equals( MATH_DISCRETE );
                                }) ).moveTo ( listAllQuestionMath )
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue ( "value" );
                                        sub = MATH_ALGEBRE_LIN;
                                        return clicked.equals( MATH_ALGEBRE_LIN );
                                })).moveTo ( listAllQuestionMath );

                val answerQuestion = state ( "ansQuestionChoosed" );

                answerQuestion
                        .body ( context -> {
                                String ret = tree.navigate(MATH).navigate(sub).navigate(question + " ?").nodes[0].header;
                                reactPlatform.reply ( context, ret );
                        })
                        .next ()
                        .moveTo ( promptUser );
                
                listAllQuestionMath 
                        .body ( context -> reactPlatform.reply( context, "Voila quelques questions dans ma base de donnée📂", NavTree.static_cast (tree.navigate(MATH).navigate(sub).getListNodes() )))
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        question = clicked;
                                        asked    = true;
                                        return true;
                                })).moveTo( answerQuestion );



                val defaultFallback = fallbackState()
                        .body(context -> reactPlatform.reply(context, "Excuse-moi, mais je n'ai pas bien saisi 🤭."));

                val botModel = model()
                        .usePlatform(reactPlatform)
                        .listenTo(reactEventProvider)
                        .listenTo(reactIntentProvider)
                        .initState(init)
                        .defaultFallbackState(defaultFallback);

                Configuration botConfiguration = new BaseConfiguration();

                botConfiguration.addProperty(IntentRecognitionProviderFactory.INTENT_PROVIDER_KEY, NlpjsConfiguration.NLPJS_INTENT_PROVIDER);
                botConfiguration.addProperty(NlpjsConfiguration.AGENT_ID_KEY, "default");
                botConfiguration.addProperty(NlpjsConfiguration.LANGUAGE_CODE_KEY, "en");
                botConfiguration.addProperty(NlpjsConfiguration.NLPJS_SERVER_KEY, "http://localhost:8080"); 

                /*
                * Add configuration properties (e.g. authentication tokens, platform tuning, intent provider to use).
                * Check the corresponding platform's wiki page for further information on optional/mandatory parameters and
                * their values.
                */

                XatkitBot xatkitBot = new XatkitBot(botModel, botConfiguration);
                xatkitBot.run();
                /*
                * The bot is now started, you can check http://localhost:5000/admin to test it.
                * The logs of the bot are stored in the logs folder at the root of this project.
                */
        }
}
