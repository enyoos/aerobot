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
        private static boolean quit    = false;
        private static final int PORT  = 8080; // change it on the school's computer
        private static String nameTutor= "";
        private static State state     = new State();
        private static List<Tuteur> set= null;
        private static String sub      = null;
        private static String curr     = null; //MATH, CHIMIE , PHYS 
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

                val origins        = intent( "Origin" )
                        .trainingSentences( origins_ );

                val happy          = intent ( "Happy" )
                        .trainingSentences( joy_ );
                
                val greetings      = intent ("Greetings" )
                        .trainingSentences( greetings_ );

                val indecis        = intent ("Indecision")
                        .trainingSentences( indecis_ );

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
                val listAllQuestionChimie = state ( "allQChimie" );
                val handleQuitMenu      = state ( "handleQuitMenu" );
                val handleGreetings     = state ( "handleGreetings" );
                val handleOrigins       = state ( "handleOrigins" );
                val handleIndecis       = state ( "handleIndecis" );
                val handleFaitInt       = state ( "handleFaitInt ");


                init
                        .next()
                        .when(eventIs(ReactEventProvider.ClientReady)).moveTo(handleWelcome);


                awaitingInput
                        .next()
                        .when(intentIs(menu)).moveTo ( promptUser )
                        .when(intentIs(origins)).moveTo( handleOrigins )
                        .when(intentIs(thankful)).moveTo(handleThankful)
                        .when(intentIs(greetings)).moveTo( handleGreetings )
                        .when(intentIs(howAreYou)).moveTo(handleWhatsUp)
                        .when(intentIs(cheat)).moveTo (handleCheat);

                handleWelcome
                        .body(context -> {
                                reactPlatform.reply(context, "Salut ! Je m'appelle 🔥roseBot🔥");
                                reactPlatform.reply(context, "Je suis enchanté/e de faire ta rencontre🤗");
                                reactPlatform.reply(context, "Comment vas-tu aujourd'hui?");
                        })
                        .next()
                                .when(intentIs(happy)).moveTo( handleHappy )
                                .when(intentIs(cheat)).moveTo( handleCheat )
                                .when(intentIs(menu)).moveTo( promptUser )
                                .when(intentIs(howAreYou)).moveTo( handleWhatsUp )
                                .when(intentIs( sad )).moveTo ( handleSad )
                        .fallback ( context -> {
                                reactPlatform.reply ( context, "Eh, et alors ? 😵");
                        });

                handleWhatsUp
                        .body(context -> reactPlatform.reply(context, "Je vais bien💯 Merci."))
                        .next()
                        .moveTo ( promptUser );

                handleOrigins
                        .body ( context -> {
                          // do we really need some function for that ?
                          for ( String ans : fromAns() ) {
                            reactPlatform.reply ( context, ans );
                          }
                        })
                        .next ()
                        .moveTo(awaitingInput);

                handleIndecis
                        .body ( context -> {
                          reactPlatform.reply( context, "Ouf! Je vois que tu n'es pas sure pour ton future❓🤷‍♂️");
                          reactPlatform.reply( context, "Je te conseille fortement de prendre un rdv avec ton **API**👩🏻‍💻");
                        })
                        .next()
                        .moveTo ( awaitingInput);

                handleHappy
                        .body( context -> reactPlatform.reply(context, "Wow, je suis très content pour toi 👌") )
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
                                reactPlatform.reply(context, "Les temps sont très difficiles😓");
                                reactPlatform.reply(context, "Voici une citation pour te motiver💪");
                                reactPlatform.reply(context, giveMeQuote());
                        })
                        .next()
                        .moveTo(promptUser);

                promptUser
                        .body ( context -> reactPlatform.reply (context, computePrompt(state.asked, state.quit), prompt_helper(state.asked)))
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        state.asked = true;
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_HAVE_QUESTION );
                                })).moveTo( promptChooseSubject )
                                .when( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        state.asked = true;
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_NEED_TUTOR );
                                })).moveTo ( handleBooking )
                                .when( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        state.asked = true;
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( I_HAVE_SUGG );
                                })).moveTo( handleSuggestion )
                                .when(intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        state.asked = true;
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals ( FAIT_INT );
                                })).moveTo ( handleFaitInt )
                                .when ( intentIs( CoreLibrary.AnyValue).and ( context -> {
                                        // state.quit = true;
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        return clicked.equals( QUITTER_MENU ) || clicked.equals ( NON_MERCI);
                                })).moveTo(handleQuitMenu);

                handleFaitInt
                        .body( context -> {
                                reactPlatform.reply (context, "**``Savais-tu que``** " + giveMeFact() );
                        })
                        .next()
                        .moveTo ( promptUser );

                handleQuitMenu
                        .body (
                                context -> reactPlatform.reply ( context, "N'hésite pas à m'envoyer le message *menu* pour faire apparaître ces choix." ) 
                        )
                        .next()
                        .moveTo ( awaitingInput );

                handleThankful
                        .body( context -> reactPlatform.reply(context, "Avec plaisir 😊"))
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
                                        state.nameTutor= clicked;
                                        state.set      = getTuteurPhysique();

                                        return true;
                                })).moveTo( giveTutorDesc );

                giveAllChimieTutors
                        .body( context -> reactPlatform.reply ( context, String.format("Voici nos meilleurs tuteurs en %s", CHIMIE), Tuteur.static_cast(getTuteurChimie()) ))
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        state.nameTutor= clicked;
                                        state.set      = getTuteurChimie();

                                        return true;
                                })).moveTo( giveTutorDesc );


                giveAllMathTutors
                        .body( context -> reactPlatform.reply ( context, String.format ("Voici nos meilleurs tuteurs en %s", MATH), Tuteur.static_cast (getTuteurMath())) )
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        state.nameTutor= clicked;
                                        state.set      = getTuteurMath();

                                        return true;
                                })).moveTo( giveTutorDesc );

                giveTutorDesc
                        .body ( context -> {
                                state.asked = true;
                                reactPlatform.reply ( context, "Voici les informations de " + state.nameTutor );
                                reactPlatform.reply ( context, Tuteur.fromSet ( state.set, state.nameTutor ).toString() );
                        })
                        .next()
                        .moveTo ( promptUser );

                promptChooseSubject
                        .body ( context -> reactPlatform.reply( context, "Quelle est le domaine scientifique de cette question ?", optionsSubject() ))
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
                                .when( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        state.asked    = false;
                                        return clicked.equals(THROW_BACK);
                                })).moveTo( promptUser );


                handlePhysique
                  .body( context -> {
                    curr = PHYS;
                    reactPlatform.reply ( context, "Choisis ta matière pertinente à cette question", listeMatierePhysique() );
                  })
                  .next()
                    .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                            String clicked = ( String ) context.getIntent().getValue("value");
                            boolean ret    = clicked.equals(THROW_BACK);
                            
                            return ret;
                    })).moveTo ( promptChooseSubject );

                handleChimie
                        .body( context -> {
                          curr = CHIMIE;
                          reactPlatform.reply ( context, "Choisis ta matière pertinente à cette question", listeMatiereChimie() );
                        })
                        .next()
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals( STOCH  );
                                        if (ret)        { state.sub = STOCH ;  }

                                        return ret;
                                })).moveTo ( listAllQuestionChimie )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals ( STRUCT_ATOMIQUE  );
                                        if ( ret ) { state.sub = STRUCT_ATOMIQUE; }

                                        return ret;
                                })).moveTo( listAllQuestionChimie )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals(COMP_CHIMIQUE );
                                        if( ret ) { state.sub = COMP_CHIMIQUE; }

                                        return ret;
                                }) ).moveTo( listAllQuestionChimie)
                                .when ( intentIs ( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals(REACT_CHIMIQUE);
                                        if ( ret ) { state.sub = REACT_CHIMIQUE; }

                                        return ret;
                                }) ).moveTo ( listAllQuestionChimie)
                                .when ( intentIs ( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals(ATTRACTION_MOL);
                                        if ( ret ) { state.sub = ATTRACTION_MOL; }

                                        return ret;
                                }) ).moveTo ( listAllQuestionChimie )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret    = clicked.equals(THROW_BACK);
                                        
                                        return ret;
                                })).moveTo ( promptChooseSubject );

                listAllQuestionChimie
                  .body ( context -> {
                    reactPlatform.reply ( context, "Voila quelques questions dans ma base de donnée📂", NavTree.static_cast (tree.navigate(CHIMIE).navigate(state.sub).getListNodes() ));
                  })
                  .next ( )
                    .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                            String clicked = ( String ) context.getIntent().getValue("value");
                            state.question = clicked;

                            return true;
                    })).moveTo( answerQuestion );


                handleListMatiereMath
                        .body ( context -> {
                          curr = MATH;
                          reactPlatform.reply ( context, "Choisis ta matière pertinente à cette question", listeMatiereMath() );
                        })
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals( MATH_CALC_I );
                                        if (ret)        { state.sub = MATH_CALC_I;  }

                                        return ret;
                                })).moveTo ( listAllQuestionMath )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals ( MATH_CALC_II );
                                        if ( ret ) { state.sub = MATH_CALC_II; }

                                        return ret;
                                })).moveTo( listAllQuestionMath )
                                .when ( intentIs( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals(MATH_ALGEBRE_LIN);
                                        if( ret ) { state.sub = MATH_ALGEBRE_LIN; }

                                        return ret;
                                }) ).moveTo( listAllQuestionMath )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret = clicked.equals(MATH_DISCRETE);
                                        if ( ret ) { state.sub = MATH_DISCRETE; }

                                        return ret;
                                }) ).moveTo ( listAllQuestionMath )
                                .when ( intentIs ( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        boolean ret    = clicked.equals(THROW_BACK);
                                        
                                        return ret;
                                })).moveTo ( promptChooseSubject );

                answerQuestion
                        .body ( context -> {
                                state.asked = true;
                                System.out.println("the curr : " + curr );
                                System.out.println("the question : " + state.question );
                                System.out.println("the sub : " + state.sub );
                                Node rets[] = tree.navigate(curr).navigate(state.sub).navigate(state.question + " ?").nodes;

                                // response with batch_ans
                                for ( Node ret :  rets ) { reactPlatform.reply ( context, ret.header ); }
                        })
                        .next ()
                        .moveTo ( promptUser );
                
                listAllQuestionMath 
                        .body ( context -> reactPlatform.reply( context, "Voila quelques questions dans ma base de donnée📂", NavTree.static_cast (tree.navigate(MATH).navigate(state.sub).getListNodes() )))
                        .next ( )
                                .when ( intentIs( CoreLibrary.AnyValue ).and ( context -> {
                                        String clicked = ( String ) context.getIntent().getValue("value");
                                        state.question = clicked;
                                        return true;
                                })).moveTo( answerQuestion );

                val defaultFallback = fallbackState()
                        .body(context -> {
                                reactPlatform.reply(context, "Excuse-moi, mais je n'ai pas bien saisi🤭");
                        });

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
