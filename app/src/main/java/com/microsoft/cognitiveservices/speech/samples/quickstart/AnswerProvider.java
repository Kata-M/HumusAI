package com.microsoft.cognitiveservices.speech.samples.quickstart;

import java.util.Arrays;
import java.util.List;

public class AnswerProvider {

    DoctorContext context;
    enum questionTypes {
        CLOSED, OPEN;
    }

    public void setContext(DoctorContext context) {
        this.context = context;
    }

    List<String> wQuestions = Arrays.asList("what", "why", "when", "where", "who", "how");
    List<String> openQuestions = Arrays.asList(
            "are you",
            "should i",
            "have you",
            "do you",
            "shall we");

    // Returns if a sentence is a question

    // Parses a text in sentences

    public questionTypes getQuestionType(String question){

        // Check if a question is closed
        if (question.toLowerCase().startsWith("do you"))

            // Check if it is a "W" question
            for (String w : wQuestions) {
                if (question.toLowerCase().startsWith(w)) {
                    return questionTypes.OPEN;
                }
                if(question.toLowerCase().contains(w)){
                    return questionTypes.OPEN;
                }
            }
        return questionTypes.CLOSED;
    }

    public static String mockReply(String message) {
        return "Hej";
    }

}
