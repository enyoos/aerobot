package com.xatkit.example.helpers;


import java.net.*;
import java.util.*;
import com.xatkit.example.helpers.Tuteur;

public final class Utils
{

    private static final Random random = new Random();

    // en rajouter
    // source : https://www.selection.ca/reportages/39-faits-insolites-qui-vous-sont-probablement-inconnus/
    private static final String[] facts = {
        "les montagnes russes ont été inventées pour éloigner les Américains de leurs péchés.",
        "les glaces sur bâtonnet (popsicles) ont été inventées par accident par un gamin de 11 ans.",
        "une femme a été élue au Congrès américain avant d’avoir le droit de vote.",
        "les pieuvres possèdent trois cœurs.",
        "aux Philippines, on sert du spaghetti dans les restaurants McDonald’s.",
        "adolf Hitler a été nommé pour recevoir un prix Nobel.",
        "les rondelles de Froot Loops ont toutes le même goût.",
        "les homards goûtent avec leurs pattes.",
        "la guerre la plus courte de l’histoire n’a duré que 38 minutes.",
        "au départ, la tour Eiffel devait être installée à Barcelone",
        "le Trésor américain a déjà imprimé des billets de 100 000💲",
        "avant l’invention du papier hygiénique, les Américains utilisaient des épis de maïs.",
    };

    // https://emplois.ca.indeed.com/conseils-carriere/developpement-carriere/citations-encouragement-inspirantes-travail
    // 
    private static final String[] quotes = {
        "« Le succès n'est pas final, l'échec n'est pas fatal. C'est le courage de continuer qui compte. » - Winston Churchill.",
        "« Je ne perds jamais. Soit je gagne, soit j'apprends. » - Nelson Mandela.",
        "« En suivant le chemin qui s'appelle plus tard, nous arrivons sur la place qui s'appelle jamais. » - Sénèque.",
        "« Croyez en vos rêves et ils se réaliseront peut-être. Croyez en vous et ils se réaliseront sûrement. » - Martin Luther King.",
        "« Le but de la vie, ce n'est pas l'espoir de devenir parfait, c'est la volonté d'être toujours meilleur. » - Ralph Waldo Emerson.",
        "« Il n'y a qu'une façon d'échouer, c'est d'abandonner avant d'avoir réussi. » - Georges Clemenceau.",
        "« Ce n'est pas grave si vous avancez lentement, du moment que vous ne vous arrêtez pas. » - Confucius.",
        "« Il y a plus de courage que de talent dans la plupart des réussites. » - Félix Leclerc.",
        "« La chance : plus vous la travaillez, plus elle vous sourit » - Stephen Leacock",
        "« Les faibles ont des problèmes, les forts ont des solutions » - Louis Pauwel",
        "« Un pessimiste fait de ses occasions des difficultés, un optimiste fait de ses difficultés des occasions » - Antoine de Saint-Exupéry",
        "« Le meilleur moyen de prédire le futur c’est de le créer » - Peter Drucker",
        "« Quand tout semble être contre vous, souvenez-vous que l'avion décolle face au vent, et non avec lui » - Henry Ford",
        "« Lorsqu’on regarde dans la bonne direction, il ne reste plus qu'à avancer. » - Bouddha",
        "« La réussite appartient à tout le monde. C'est au travail d'équipe qu'en revient le mérite. » - Franck Piccard.",
        "« Apprends les règles comme un professionnel afin de pouvoir les briser comme un artiste » - Pablo Picasso",
        "« Croyez que vous pouvez le faire et vous serez à la moitié du chemin » - Théodore Roosevelt",
        "« Ne comptez pas les jours. Faites que chaque jour compte. » -Muhammad Ali",
        "« Le pessimiste se plaint du vent. L'optimiste espère qu'il va changer. Le leader ajuste les voiles. » - John Maxwell",
        "« L'optimisme est la foi qui mène au succès, rien ne peut être fait sans espoir et sans confiance » - Helen Keller",
        "« Se réunir est un début, rester ensemble est un progrès, travailler ensemble est la réussite. » - Henry Ford",
        "« C'est incroyable ce que vous pouvez accomplir si vous ne vous souciez pas de qui en obtient le crédit. » - Harry S. Truman",
        "« La force ne vient pas de la capacité physique. Elle provient d'une volonté indomptable. » - Mahatma Ghandi",
        "« Je n'ai jamais rêvé du succès. J'ai travaillé pour l'obtenir. » Estée Lauder",
        "« L'échec n'est qu'une opportunité de recommencer la même chose plus intelligemment. » - Henry Ford",
        "« Se lamenter sur un malheur passé, voilà le plus sûr moyen d'en attirer un autre. » - William Shakespeare",
        "« Le succès est toujours un enfant de l'audace. » - Prosper de Crébillon",
        "« La persévérance, c'est ce qui rend l'impossible possible, le possible probable et le probable réalisé. » - Léon Trotsky",
        "« Il faut viser la lune, parce qu'au moins, si vous échouez, vous finirez dans les étoiles. » - Oscar Wilde",
        "« L'excellence ne résulte pas d'une impulsion isolée, mais d'une succession de petits éléments qui sont réunis. » - Vincent Van Gogh.",
    };

    public static void main ( String... args ) { }

    //mock
    public static List<Tuteur> getTuteurMath()
    {
        List<Tuteur> students = new ArrayList<>();

        students.add(
            new Tuteur("Sylvain", "x@crosemont.qc.ca", "x@outlook.fr", 'm')
                .setDescription( "le foot" )
        );
        students.add( 
            new Tuteur("Marie", "b@crosemont.qc.ca", "b@outlook.fr", 'w')
                .setDescription( "le basketball" )
        );
        students.add( 
            new Tuteur("Omar", "c@crosemont.qc.ca", "c@outlook.fr", 'm')
                .setDescription( "la musique" )
        );
        students.add( 
            new Tuteur("Syvlie", "y@crosemont.qc.ca", "y@outlook.fr", 'w')
                .setDescription( "le rugby" )
        );

        return students;
    }

    //mock
    public static List<Tuteur> getTuteurChimie()
    {
        List<Tuteur> students = new ArrayList<>();

        students.add( 
            new Tuteur("Dimitri", "u@crosemont.qc.ca", "u@outlook.fr", 'm')
                .setDescription( "manger" )
        );
        students.add ( 
            new Tuteur("Malik", "m@crosemont.qc.ca", "m@outlook.fr", 'm')
                .setDescription( "les friandises" )
        );
        students.add ( 
            new Tuteur("Nour", "n@crosemont.qc.ca", "n@outlook.fr", 'w')
                .setDescription( "discuter" )
        );
        students.add ( 
            new Tuteur("Yvan", "p@crosemont.qc.ca", "p@outlook.fr", 'm')
                .setDescription( "jouer aux jeux videos" )
        );

        return students;
    }

    // mock
    public static List<Tuteur> getTuteurPhysique( )
    {
        List<Tuteur> students = new ArrayList<>();

        students.add( 
            new Tuteur("Ryan", "m@crosemont.qc.ca", "m@outlook.fr", 'm') 
                .setDescription("les fraises" )
        );
        students.add ( 
            new Tuteur ( "Edgar", "e@crosemont.qc.ca", "c@outlook.fr", 'm')
                .setDescription( "les chiens" )
        );
        students.add ( 
            new Tuteur ( "Martin", "i@crosemont.qc.ca", "i@outlook.fr", 'm')
                .setDescription( "les animaux" )
        );
        students.add ( 
            new Tuteur ( "Yvick", "z@crosemont.qc.ca", "z@outlook.fr", 'm')
                .setDescription( "les chats" )
        );

        return students;
    }

    public static String giveMeFact ()
    {
        int length = facts.length;
        int rdmIdx = random.nextInt(length);

        return "**``" + facts[rdmIdx] + "``**";
    }

    public static String giveMeQuote ()
    {

        int length = quotes.length;
        int rdmIdx = random.nextInt ( length );

        return "**``" + quotes[rdmIdx] + "``**";
    }

    public static final String STOCH           = "Stoechiométrie💉"; 
    public static final String STRUCT_ATOMIQUE = "Atome💫";
    public static final String COMP_CHIMIQUE   = "Composer chimique🔗";
    public static final String REACT_CHIMIQUE  = "Reaction chimique💥";
    public static final String ATTRACTION_MOL  = "Attraction moleculaire🧲";


    public static List<String> listeMatiereChimie () {
      List<String> list = new ArrayList<String>();

      list.add ( STOCH );
      list.add ( STRUCT_ATOMIQUE );
      list.add ( COMP_CHIMIQUE );
      list.add ( REACT_CHIMIQUE);
      list.add ( ATTRACTION_MOL);
      list.add ( THROW_BACK );

      return list;
    }

    public static final String DESC_MOV = "Description du mouvement🛤️";
    public static final String FORCE    = "Les forces🦾";
    public static final String ENERGIE  = "L'energie💥";
    public static final String G_       = "La gravite🌌";

    public static List<String> listeMatierePhysique () {
      List<String> list = new ArrayList<String>();

      list.add ( DESC_MOV );
      list.add ( FORCE);
      list.add ( ENERGIE);
      list.add ( G_ );
      list.add ( THROW_BACK );

      return list; 
    }

    public static List<String> listeMatiereMath ( )
    {
        List<String> list = new ArrayList<String>();

        list.add ( MATH_CALC_I      );
        list.add ( MATH_CALC_II     );
        list.add ( MATH_ALGEBRE_LIN );
        list.add ( MATH_DISCRETE    );
        list.add ( THROW_BACK );

        return list;
    }

    // reponds a la questions : d'ou vient tu ?
    public static String[] fromAns ()
    {
      return new String[]{
        "Je suis un ``robot`` ; des 0 et des 1. Rien de plus ; je n'ai ni emotions ni opinions.",
        " Mon but est de repondre a vos questions et de vous guider dans votre cheminement scolaire."
      };
    }
    

    public static List<Node> cast_static( Node[] nodes )
    {
        int size       = nodes.length;
        List<Node> ret = new ArrayList<>(size);    

        for ( Node node : nodes ) { ret.add ( node ); }

        return ret;
    }

    // public static final String match ( String str )
    // {
    //     int length = str.length();
    //     switch ( length )
    //     {
    //         case MATH
    //     }
    // }


    public static final String MATH              = "Mathématiques📐";
    public static final String MATH_CALC_I       = "Calculus I🍎";
    public static final String MATH_ALGEBRE_LIN  = "Algèbre linéaire🕹️";
    public static final String MATH_CALC_II      = "Calculus II∫";
    public static final String MATH_DISCRETE     = "Mathématiques discrètes🤫";

    public static final String CHIMIE            = "Chimie🧪";
    public static final String PHYS              = "Mecanique🏃🏼‍♀️";

    public static final String I_HAVE_QUESTION   = "J'ai une question🧐";
    public static final String I_NEED_TUTOR      = "J'ai besoin d'un tuteur🧑‍🏫";
    public static final String I_HAVE_SUGG       = "J'ai une suggestion💡";

    // public static final String VIE_PROFESSIONELLE="Astuces de la vie🛤️";
    // public static final String PHILOSOPHIE       = "Quelques philosophies intéressantes📜";
    // public static final String MES_ORIGINES      = "Quelles sont mes origines🔎";

    public static final String QUITTER_MENU      = "Quitter le Menu✌️";
    public static final String NON_MERCI         = "Non Merci✌️";

    public static final String FAIT_INT          = "Un fait interessant🧐";
    public static final String THROW_BACK        = "Retourner🔙";

    public static List<String> prompt_helper ( boolean asked )
    {
        List<String> ret = new ArrayList<String>();

        ret.add ( I_HAVE_QUESTION );
        ret.add ( I_NEED_TUTOR    );
        ret.add ( I_HAVE_SUGG     );
        ret.add ( FAIT_INT        );

        if ( asked ) ret.add( NON_MERCI );
        else         ret.add( QUITTER_MENU );

        return ret;
    }

    public static List<String> optionsSubject()
    {
        List<String> ret = new ArrayList<String>();

        ret.add (MATH);
        ret.add (CHIMIE);
        ret.add (PHYS);
        ret.add( THROW_BACK );


        return ret;
    }


    public static String computePrompt ( boolean asked, boolean quit )
    {
        String default_ = "Comment puis-je t'aider aujourd'hui 🛠️?";
        String ifAsked = "Besoin d'autre chose🤔"; 
        String ifQuit  = "De retour ! ";

        if ( asked && quit ) return ifQuit + ifAsked;
        else if ( asked )    return ifAsked;
        else if ( quit )     return ifQuit + default_;
        else                 return default_;

    }

    // todo.
    // https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
    private static final String url = "https://github.com/enyoos/aerobot/issues";
    public static String TOKEN = ""; // to change after

    public static void saveSugg( String sugg ) {

    //     URL url                = new URL(url);
    //     URLConnection con      = url.openConnection();
    //     HttpURLConnection http = (HttpURLConnection)con;

    //     http.setRequestMethod("POST"); // PUT is another valid option
    //     http.setDoOutput(true);
        
    //     Map<String,String> arguments = new HashMap<>();

    //     arguments.put("username", "root");
    //     arguments.put("password", "sjh76HSn!"); // This is a fake password obviously

    //     StringJoiner sj = new StringJoiner("&");
    //     for(Map.Entry<String,String> entry : arguments.entrySet()){
    //         sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
    //             + URLEncoder.encode(entry.getValue(), "UTF-8"));
    //     }

    //     byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
    //     int length = out.length;

        return;
    }
    // todo

}
