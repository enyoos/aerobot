package com.xatkit.example.helpers;

import java.util.*;
import com.xatkit.example.helpers.Tuteur;

public final class Utils
{

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

    // link : https://fr.wikipedia.org/wiki/Matrice_(math%C3%A9matiques)
    private static final String def_matrix = "Les matrices sont des tableaux d'éléments (nombres, caractères). Par exemple, \n $$\\begin{matrix} 1 & 2 & 3\\ a & b & c \\end{matrix}";

    public static void main ( String... args )
    {

    }

    public static List<Tuteur> getTuteurMath()
    {
        List<Tuteur> students = new ArrayList<>();

        students.add( new Tuteur("Sylvain", "x@crosemont.qc.ca", "x@outlook.fr", 'm'));
        students.add( new Tuteur("Marie", "b@crosemont.qc.ca", "b@outlook.fr", 'w'));
        students.add( new Tuteur("Omar", "c@crosemont.qc.ca", "c@outlook.fr", 'm'));
        students.add( new Tuteur("Syvlie", "y@crosemont.qc.ca", "y@outlook.fr", 'w'));

        return students;
    }

    public static List<Tuteur> getTuteurChimie()
    {
        List<Tuteur> students = new ArrayList<>();

        students.add( new Tuteur("Dimitri", "u@crosemont.qc.ca", "u@outlook.fr", 'm'));
        students.add ( new Tuteur("Malik", "m@crosemont.qc.ca", "m@outlook.fr", 'm'));
        students.add ( new Tuteur("Nour", "n@crosemont.qc.ca", "n@outlook.fr", 'w'));
        students.add ( new Tuteur("Yvan", "p@crosemont.qc.ca", "p@outlook.fr", 'm'));

        return students;
    }

    public static List<Tuteur> getTuteurPhysique( )
    {
        List<Tuteur> students = new ArrayList<>();

        students.add( new Tuteur("Ryan", "m@crosemont.qc.ca", "m@outlook.fr", 'm') );
        students.add ( new Tuteur ( "Edgar", "e@crosemont.qc.ca", "c@outlook.fr", 'm'));
        students.add ( new Tuteur ( "Martin", "i@crosemont.qc.ca", "i@outlook.fr", 'm'));
        students.add ( new Tuteur ( "Yvick", "z@crosemont.qc.ca", "z@outlook.fr", 'm'));

        return students;
    }

    public static String giveMeQuote ()
    {

        int length = quotes.length;
        int rdmIdx = ( int ) Math.random() * length;

        return "``" + quotes[rdmIdx] + "``";
    }

    public static List<String> listeMatiereChimie ()
    {
        return null;
    }


    public static List<String> listeMatiereMath ( )
    {
        List<String> list = new ArrayList<String>();

        list.add ( MATH_CALC_I   );
        list.add ( MATH_CALC_II  );
        list.add ( MATH_DISCRETE );
        // list.add ( "C'est quoi une matrice ?" );
        // list.add ( "Comment multiplier deux matrice ?" );
        // list.add ( "Qu'est ce que la transposée d'une matrice ?" );
        // list.add ( "Comment diviser deux matrices ? " );
        // list.add ( "")

        return list;
    }

    public static String emoji ( int[] surr )
    {
        String ret = new String ( surr, 0, surr.length );
        ret.intern();
        return ret;
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


    public static final String MATH          = "Mathématiques📐";
    public static final String MATH_CALC_I   = "Calculus I🍎";
    public static final String MATH_ALGEBRE_LIN = "Algèbre linéaire🕹️";
    public static final String MATH_CALC_II  = "Calculus II∫";
    public static final String MATH_DISCRETE = "Mathématiques discrètes🤫";

    public static final String CHIMIE = "Chimie🧪";
    public static final String PHYS   = "Physique⚛️";

    public static final String I_HAVE_QUESTION = "J'ai une question🧐";
    public static final String I_NEED_TUTOR    = "J'ai besoin d'un tuteur🧑‍🏫";
    public static final String I_HAVE_SUGG     = "J'ai une suggestion💡";

    public static List<String> prompt_helper ()
    {
        List<String> ret = new ArrayList<String>();
        ret.add ( I_HAVE_QUESTION );
        ret.add ( I_NEED_TUTOR);
        ret.add ( I_HAVE_SUGG );
        return ret;
    }

    public static List<String> optionsSubject()
    {
        List<String> ret = new ArrayList<String>();

        ret.add (MATH);
        ret.add (CHIMIE);
        ret.add (PHYS);

        return ret;
    }

}