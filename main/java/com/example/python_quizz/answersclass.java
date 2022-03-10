package com.example.python_quizz;

public class answersclass {
  private int optionA,optionB,optionC,optionD,questionId,answerId;
    public answersclass(int questionIde, int optiona, int optionb, int optionc, int
                        optiond,int answerIde)
    {
        questionId=questionIde;
        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;
        answerId=answerIde;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getAnswerId() {
        return answerId;
    }
}

