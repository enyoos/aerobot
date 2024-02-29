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
import static com.xatkit.example.helpers.Intents.*;

public class GreetingsBot {

        private static NavTree tree    = NavTree.init_nav_3();
        private static boolean asked   = false;
        private static final int PORT  = 8080; // change it on the school's computer
        private static String nameTutor= "";
        private static List<Tuteur> set= null;
        private static String sub      = null;
        private static String question = null;

        // PRINT EVAL LOOP
        public static void main(String[] args) {

                val menu           = intent("Menu")
                        .trainingSentences(menu_);

                val cheat          = intent("Cheat")
                        .trainingSentences(cheat_);

                val thankful       = intent("Thankful")
                        .trainingSentences( thankful_ );

                val howAreYou      = intent("HowAreYou")
                        .trainingSentences(howAreYou_);

                val sad            = intent ( "Sad" )
                        .trainingSentences( sad_ );

                val happy          = intent ( "Happy" )
                        .trainingSentences( joy_ );
                
                val greetings      = intent ("Greetings" )
                        .trainingSentences( greetings_ );

                ReactPlatform reactPlatform             = new ReactPlatform();
                ReactEventProvider reactEventProvider   = reactPlatform.getReactEventProvider();
                ReactIntentProvider reactIntentProvider = reactPlatform.getReactIntentProvider();

                val init = state("Init");
                val handleSaved      = state ( "Saved" );
                val answerQuestion = state ( "ansQuestionChoosed" );
                val awaitingInput  = state("AwaitingInput");
                val handleWelcome  = state("HandleWelcome");
                val promptChooseSubject = state ( "PromptSubject" );
                val handleWhatsUp  = state("HandleWhatsUp");
                val handleQuestion = state("HandleQuestion");
                val handleBooking  = state("HandleBooking");
                val handleThankful = state("HandleThankful");
                val handleCheat    = state("HandleCheat");
                val handleHappy    = state("HandleHappy");
                val giveTutorDesc = state ( "giveDesc" );
                val handleSad      = state("HandleSad");
                val promptUser       = state ( "promptUser" );
                val handleSuggestion = state ( "HandleSugg" );
                val handleChimie = state ( "HandleChimie" );
                val handleListMatiereMath  = state ( "listMath" );
                val handleAlgebreLineaire  = state ( "HandleAlgebreLineaire" );
                val handleCalcul_I         = state ( "HandleCalculI");
                val handleCalcul_II        = state ( "HandleCalculII");
                val handlePhysique         = state ( "HandlePhysique");
                val giveAllPhysTutors   = state ( "giveAllPhysTutors" );        
                val giveAllChimieTutors = state ( "giveAllChimieTutors" );
                val giveAllMathTutors   = state ( "giveAllMathTutors" );
                val handleCalculusI = state( "HandleCalculusI" );
                val handleCalculusII = state ( "HandleCalculusII" );
                val handleDiscreteMath = state ( "HandleDMath" );
                val listAllQuestionMath = state ( "allQMathCalc" );
                val handleDiscussion    = state ( "handleFreeWill" );
                val handleQuitMenu      = state ( "handleQuitMenu" );
                val handleGreetings     = state ( "handleGreetings" );


                init
                        .next()
                        .when(eventIs(ReactEventProvider.ClientReady)).moveTo(handleWelcome);


                awaitingInput
                        .next()
                        .when(intentIs(menu)).moveTo ( promptUser )
                        .when(intentIs(thankful)).moveTo(handleThankful)
                        .when(intentIs(greetings)).moveTo( handleGreetings )
                        .when(intentIs(howAreYou)).moveTo(handleWhatsUp)
                        .when(intentIs(cheat)).moveTo (handleCheat);

                handleWelcome
                        .body(context -> {
                                reactPlatform.reply(context, "Salut ! Je m'appelle 🔥roseBot🔥. Je suis enchanté de faire ta rencontre 😊!");
                                reactPlatform.reply(context, "Comment vas-tu aujourd'hui ?!");
                        })
                        .next()
                                .when(intentIs(happy)).moveTo( handleHappy )
                                .when(intentIs(cheat)).moveTo( handleCheat )
                                .when(intentIs(howAreYou)).moveTo( handleWhatsUp )
                                .when(intentIs( happy )).moveTo ( handleHappy )
                                .when(intentIs( sad )).moveTo ( handleSad )
                        .fallback ( context -> {
                                reactPlatform.reply ( context, "Eh, et alors ? 😵");
                        });

                handleWhatsUp
                        .body(context -> reactPlatform.reply(context, "Je vais bien ✅! Merci."))
                        .next()
                        .moveTo ( promptUser );

                handleHappy
                        .body( context -> reactPlatform.reply(context, "Wow, je suis très content pour toi 👌!"))
                        .next()
                        .moveTo(promptUser);

                handleGreetings
                        .body (
                                context -> reactPlatform.reply ( context, "Salut👋")
                        )
                        .next()
                        .moveTo ( awaitingInput );

                handleSad
                        .body( context -> {
                                reactPlatform.reply(context, "Les temps sont très difficiles 😓. Voici une citation pour te motiver 💪");
                                reactPlatform.reply(context, giveMeQuote());
                        })
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
                                })).moveTo( handleSuggestion )
                                .when( intentIs ( CoreLibrary.AnyValue).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( DISCUTONS );
                                })).moveTo ( handleDiscussion )
                                .when ( intentIs( CoreLibrary.AnyValue).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( QUITTER_MENU );
                                })).moveTo(handleQuitMenu);

                handleQuitMenu
                        .body (
                                context -> reactPlatform.reply ( context, "Avec plaisir, n'hésite pas à m'envoyer le message *menu* pour faire apparaître ces choix." ) 
                        )
                        .next()
                        .moveTo ( awaitingInput );

                handleThankful
                        .body( context -> reactPlatform.reply(context, "Avec plaisir 😊!"))
                        .next()
                        .moveTo(awaitingInput);

                handleCheat
                        .body(context -> reactPlatform.reply(context, "Désolé je ne peux pas répondre à ce genre de question 🥺") )
                        .next()
                        .moveTo ( awaitingInput );


                handleSuggestion
                        .body ( context -> reactPlatform.reply ( context, "Super ! Quelle est cette merveilleuse idée 🧐"))
                        .next ()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String sugg = ( String ) context.getIntent().getValue("value");
                                        saveSugg ( sugg );

                                        return true;
                                })).moveTo ( handleSaved );

                handleSaved
                        .body ( context -> {
                                reactPlatform.reply ( context, "Merçi, j'ai mémorisé ta magnifique suggestion dans ma base de donnée!");
                                reactPlatform.reply ( context, "Je l'ai aussi envoyé à mon supérieur😉");
                        })
                        .next()
                        .moveTo ( promptUser );
                
                handleBooking
                        .body( context -> reactPlatform.reply(context, "Super! Choisis la spécification voulue de ton tuteur", optionsSubject()) )
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
                                })).moveTo( giveAllPhysTutors )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals ( QUITTER_MENU );
                                })).moveTo ( handleQuitMenu );

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
                                        set            = getTuteurChimie();
                                        return true;
                                })).moveTo( giveTutorDesc );


                giveAllMathTutors
                        .body( context -> reactPlatform.reply ( context, String.format ("Voici nos meilleurs tuteurs en %s", MATH), Tuteur.static_cast (getTuteurMath())) )
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        nameTutor      = clicked;
                                        set            = getTuteurMath();
                                        return true;
                                })).moveTo( giveTutorDesc );

                giveTutorDesc
                        .body ( context -> {
                                reactPlatform.reply ( context, "Voici les informations de " + nameTutor );
                                reactPlatform.reply ( context, Tuteur.fromSet ( set, nameTutor ).toString() );
                                asked = true;
                        })
                        .next()
                        .moveTo ( promptUser );

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
                                .when( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals ( QUITTER_MENU );
                                })).moveTo ( handleQuitMenu );

                handleChimie
                        .body( context -> reactPlatform.reply ( context, "Voici les matières disponibles"))
                        .next()
                        .moveTo( awaitingInput );

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
                                })).moveTo ( listAllQuestionMath )
                                .when( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals ( QUITTER_MENU );
                                })).moveTo ( handleQuitMenu );

                answerQuestion
                        .body ( context -> {
                                asked    = true;
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
                botConfiguration.addProperty(NlpjsConfiguration.NLPJS_SERVER_KEY, "http://localhost:" + PORT ); 

                XatkitBot xatkitBot = new XatkitBot(botModel, botConfiguration);
                xatkitBot.run();
        }
}
