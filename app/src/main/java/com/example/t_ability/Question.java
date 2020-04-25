package com.example.t_ability;

public class Question {
    public String mQuestions[] = {
            "Which is the first planet in the Solar System?",
            "Which is the second planet in the Solar System?",
            "Which is the third planet in the Solar System?",
            "Which is the fourth planet in the Solar System",
            "Which is the fifth planet in the Solar System",
            "Which is the sixth planet in the Solar System",
            "Which is the seventh planet in the Solar System",
            "Which is the eight planet in the Solar System",
            "Which is the ninth planet in the Solar System"
    };
    private String mChoices[][] = {
            {"Mercury", "Venus", "Mars", "Saturn"},
            {"Jupiter", "Venus", "Earth", "Neptune"},
            {"Earth", "Jupiter", "Pluto", "Mars"},
            {"Jupiter", "Saturn", "Mars", "Earth"},
            {"Jupiter", "Pluto", "Mercury", "Earth"},
            {"Uranus", "Venus", "Mars", "Saturn"},
            {"Saturn", "Pluto", "Uranus", "Earth"},
            {"Mercury", "Neptune", "Pluto", "Mars"},
            {"Mercury", "Venus", "Mars", "Pluto"}
    };
    private String mCorrectAnswers[] = {"Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return  question;
    };
    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return  choice;
    };

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return  choice;
    };

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return  choice;
    };

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return  choice;
    };
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
