package com.example.quizapp;

public class QuestionAnswers {
    public static String question[] = {
            "Which method can be defined only once in a program?",
            "Which keyword is usedbymethod to referto thecurrent object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package‘pkg’?",
            "What is the return type of Constructors?"
    };

    public static String choices[][] = {
            {"finalize method","main method","static method","private method"},
            {"import","this","catch","abstract"},
            {"public","protected","private","All of the mentioned"},
            {"Importpkg.","importpkg.*","Importpkg.*","importpkg."},
            {"int","float","void","None of the mentioned"}
    };

    public static String correctAnswers[] = {
            "mainmethod",
            "this",
            "public",
            "importpkg.*",
            "None of the mentioned"
    };
}
