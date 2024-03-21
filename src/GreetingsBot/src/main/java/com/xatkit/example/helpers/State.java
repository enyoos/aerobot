package com.xatkit.example.helpers;

import com.xatkit.example.helpers.Tuteur;
import java.util.List;

// stores the internal state of the chat bot.
public final class State {
    public boolean asked;// if he already asked a question
    public boolean quit; // if he quit the menu
    public String  nameTutor; // the name of teh tutor
    public String sub;   // sub ( sous-matiere )
    public String question; // la question choisit
    public List<Tuteur> set;// set des etudiants pertinents.
    public String curr;

    public State(){}
}
