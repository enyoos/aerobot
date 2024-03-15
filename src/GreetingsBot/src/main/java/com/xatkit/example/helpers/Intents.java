package com.xatkit.example.helpers;

public final class Intents
{

    // des quantificateurs_ sont des adverbes.
    private static String[] quantificateurs_ = {
        "vraiment",
        "absolument",
        "trop",
        "magnifiquement",
        "superbement",
        "extra",
        "de plus en plus",
        "sincerement",
    };

    // on va les faire seulement pour les sentiments.
    public static String[] sad_       = {
        "Je ne vais pas trop bien...",
        "Je ne me sens pas bien",
        "Je me sens mal",
        "Je suis triste.",
        "Je suis en depression",
        "Je manque de motivation",
        "Je n'ai plus envie de vivre",
        "Je pense que je vais echouer ma session",
        "Je pense que l'ecole n'est pas fait pour moi !",
        "J'ai beaucoup de probleme en ce moment",
        "J'ai vécu une déception",
        "On m'a rejeté",
        "On m'a ignoré",
        "J'ai subi un échec",
        "J'ai perdu quelque chose de très important",
        "J'ai de la douleur derrière les yeux",
        "J'ai une boule dans la gorge",
        "J'ai envie de pleurer",
        "J'ai l'impression d'être petit",
        "J'ai un burnout",
        "Je n'ai plus envie de travailler",
        "J'ai envie de me mettre en boule",
        "Je suis en PLS",
        "Je suis dégouté",
        "J'ai les boules",
        "Je ne suis pas au top",
        "Je suis d'humeur morose",
        "Je me sens battu",
        "Je suis en proie à la désolation",
        "Je suis mélancolique",
        "J'ai de l'anxiete sociale",
        "J'ai peur des gens",
        "Je ne veux plus socialiser",
        "Je suis amer",
        "J'ai le cafard",
        "Je broie du noir",
        "Je ne suis pas dans mon assiette",
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

    public static String[] joy_          = {
        "Je vais tres bien !",
        "Je suis enchanté",
        "La vie me sourit",
        "Je suis extasié",
        "J'ai un bonheur exotique",
        "Je suis heureux comme un oiseau dans l'air",
        "Je suis au septième ciel",
        "Mon coeur saute de joie",
        "Je suis au comble de joie",
        "J'ai un large sourire sur mon visage",
        "Je pleure de joie",
        "Je saute de joie",
        "J'ai une émotions agréable",
        "je suis aux anges",
        "J'ai des larmes de joie",
        "Je baigne dans l'allégresse",
        "Je suis en liesse",
        "Oui ca roule,  merci bcp",
        "Oui sa va bien",
        "Tout marche bien dans ma vie",
        "Je suis de bonne humeur",
        "Je me suis lever du bon pied",
        "Je ne suis plus en depression",
        "Je vais vraiment trop bien.",
        "J'ai trop une belle vie",
        "Je suis heureux",
        "Je suis vraiment heureux",
        "Je suis motiver pour finir ma session",
        "J'ai hate de finir l'ecole",
        "J'aime aller a l'ecole",
        "J'aime la vie",
    };

    public static String[] tuteur_         = {
        "J'aimerais un tuteur", 
        "Quelles sont les tuteurs disponibles",
        "Puis-je avoir un rendez vous avec un tuteur ?",
        "Pourrais-tu m'aider dans mon parcours scolaire",
        "Pourrais-tu m'aider à réussir mes cours",
        "J'ai besoin d'aide",
        "Comment je suis sensé réussir mes cours",
        "Est-ce que il y a des tuteurs ?",
        "Est-ce qu'il y a du tutorat ?",
        "J'ai besoin d'un mentor",
        "J'ai besoin de conseil",
        "J'ai besoin d'un coup de main",
        "J'ai besoin que quelqu'un me pousse",
        "J'ai envie d'un guide",
        "J'ai besoin d'une troisième main",
        "J'ai besoin d'aide en *",
        "J'ai besoin d'un accompagnement personnel",
        "J'ai besoin d'aide dans mes etudes",
        "J'ai de la difficulte dans mes matieres",
        "J'ai des mauvaises notes en *",
        "J'ai des mauvaises notes en *",
        "J'ai des mauvaises notes en *",
        "Je pense que je vais echouer ma session",
        "J'aimerais augmenter ma cote R",
        "J'aimerais avoir de meilleur note",
    };

    public static String[] howAreYou_ = {
        "Comment tu vas ?",
        "Tout va bien ?",
        "Ça roule ?",
        "Bien ou bien ?",
        "Est-ce que tu vas bien ?",
        "Comment tu te portes",
        "Comment tu vas ?", 
        "Qu'est-ce qu'il y a de nouveau ?",
        "Comment te sens-tu",
        "Au top ?",
        "Alors quoi de neuf mon ami ?",
        "Quoi de neuf depuis la dernière fois où on s’est vu!",
        "Coucou toi que je ne te vois plus!",
        "Un pote qui pense à toi!",
        "Quelles sont tes sentiments ?" ,
    };

    public static String[] cheat_     = {
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
        "Combien font *",
        "Quelle est la réponse pour *",
    };

    public static String[] thankful_   = {
            "woa, merci beaucoup",
            "Un grand merci",
            "Merci bien",
            "Mille merci",
            "Merci du fond du coeur",
            "Merci infiniment",
            "Je ne sais pas comment te remercier",
            "C'est tres aimable a vous",
            "Je te suis tres reconnaissant",
            "Toute ma gratitude",
            "Je vous saurai gré",
            "tu m’ôte une épine du pied",
            "tu es un ange",
            "tu es mon ange gardien",
            "ton service me fait plaisir",
            "Merci beaucoup",
            "Je te remercie !",
            "Merci",
            "Tu me sauve la vie",
            "J'apprecie ton aide",
            "Tu m'as beaucoup aider",
            "Ton aide m'est utile",
    };

    public static String[] menu_ = {
        "J'aimerais le menu de retour",
        "Fait apparaitre le menu",
        "Donne moi le menu",
        "Affiche le menu encore",
        "J'aimerais avoir accés au menu",
        "J'ai besoin de quelque chose",
        "J'ai des questions sur quelques matieres scientifiques",
        "Affiche moi le menu",
        "Est-ce que tu peux m'afficher les choix",
        "Affiche moi les boutons de choix",
        "Menu",
    };

    public static String[] greetings_ = {
        "Salut",
        "Allo",
        "Hello world",
        "Hello",
        "Bonjour",
        "Bonne soiree",
        "Bonne journee",
        "Bon apres-midi",
        "Salam aleykoum",
        "Wesh",
        "Kesspass",
        "Whatsup",
        "Coucou",
        "Hé",
        "Hola",
        "Yo",
        "Bien le bonjour",
        "Rebonjour",
        "Salutation",
    };

  public static String[] origins_ = {
    "D'ou vient tu ?",
    "Qui t'a creer ?",
    "Quelle ta mission dans ta vie ?",
    "Quelle est ta cause ?",
    "Quelle est ton origine ?",
    "Quelles sont tes origines ?",
    "Tu es fais de quoi ?",
    "Pourquoi existe-tu ?",
    "Comment tu marche ?",
    "Quelle est ton fonctionnement interieur ?",
    "C'est quoi ton but dans ta vie ?",
    "Pourquoi existe tu ?",
    "Est-ce que tu es vivant ?",
    "Qui est ton createur ?",
    "Qui t'a donner la vie ?",
    "Qu'est-ce qui te motive dans la vie ?",
    "Est-ce que tu es un robot ?",
    "Est-ce que tu es un animal ?",
    "Peux-tu ressentir de la douleur ?",
    "Est-ce que tu as des sentiments ?",
    "Dans quelle endroit vis tu ?",
  };

  public static String[] indecis_ = {
    "Je ne sais ce que je vais faire plus tards.",
    "Je ne sais pas si je veux continuer l'ecole.",
    "A quoi sert l'ecole ?",
    "Pourquoi l'ecole est quelque chose d'obligatoire ?",
    "Quelle est mon metier du future ?",
    "Suis-je vraiment fais pour l'ecole ?",
    "Peux-tu me consiller un programme universitaire",
    "Je ne sais quel programme universitaire je vais aller ?",
    "Je n'arrive pas a trouver ma passion",
    "Quelle est ma passion ?",
    "Je ne sais pas ce qui m'attend dans mon future.",
    "Quelles sont mes chances de reussir ?",
    "Quelles cours je devrais choisir pour un bon salaire.",
  };



}
