import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
   //Liste des question reponses

    String q1 = "What is hardware?\n"
          + "(a)virtual machine\n(b)the physical machine\n(c)applications such as browsers\n(d)part of the processor\n";

    String q2 = "What does counter++; do?\n"
          + "(a)Adds 1 to counter\n(b)Adds 2 to counter\n(c)Gets the sum\n(d)Multiplies the numbers\n";

    String q3 = "What is a loop that never stops?\n"
          + "(a)For Loop\n(b)Infinite Loop\n(c)Do-While Loop\n(d)Full Loop\n";

    String q4 = "In a while loop, if the boolean expression is true, what will the loop do?\n"
          + "(a)Break\n(b)Program will exit\n(c)Repeat\n(d)Continue through program\n";

    String q5 = "What special value is designated for controlling a loop?\n"
          + "(a)Control value\n(b)Mutator Method\n(c)Accessor Method\n(d)Sentinel Value\n";

    String q6 = "What is a method?\n"
          + "(a)A collection of statements grouped together to perform an operation\n(b)A value returned from a method using the return statement\n(c)The portion of the program where the variable can be accessed.\n(d)The combination of the name of a method and the list of its parameters\n";

    String q7 = "What is an object?\n"
          + "(a)Representation of an entity in the real world that can be distinctly identified\n(b)A static method can be called without creating an instance of the class\n(c)Instance variable/instance mthod\n(d)A template, blueprint or contract that defines what an object's data fields and methods will be.\n";

    String q8 = "What is an array?\n"
          + "(a)Numbers of items ArrayList can store without increasing its size\n(b)Number used as an index to pinpoint a specfic element within an array\n(c)Object that can store a group of values, all of the same type\n(d)Method of locating a specific item in a larger collection of data\n";

    String q9 = "You use this statement to throw an exception manually.\n"
          + "(a)Throw\n(b)call stack\n(c)try block\n(d)thrown\n";

    String qF = "When an exception is generated, it is said to have been what?\n";

    private final List<String> prompt;
    private final List<String> answer;
    
    Scanner scanner = null;
    public Question() {

        scanner = new Scanner(System.in);
    //ajout des questions a la liste prompt
        prompt = new ArrayList<>() ;
        prompt.add(q1);
        prompt.add(q2);
        prompt.add(q3);
        prompt.add(q4);
        prompt.add(q5);
        prompt.add(q6);
        prompt.add(q7);
        prompt.add(q8);
        prompt.add(q9);
        prompt.add(qF);

    //ajouts des reponses a la liste answer
        answer = new ArrayList<>();
        answer.add("b");
        answer.add("a");
        answer.add("b");
        answer.add("c");
        answer.add("d");
        answer.add("a");
        answer.add("a");
        answer.add("c");
        answer.add("d");
        answer.add("c");


    }

    public void play() {
        //creation d'une liste de reponse utilisateur
        List<String> responseUserList = new ArrayList<>();

        System.out.println("A questionnaire will be proposed to you, " +
                "please enter the letter corresponding to the correct answer");
    //parcourt la liste des questions auxquelles a chaque question on demande a l'utilisateur de repondes aux questions
    //la reponse est stocker dans la liste de reponse utilisateur
    //el le contenu des questions
            for (String el : prompt) {
                System.out.print("\n" + el);
                        String response = "";
                        do {
                            response = scanner.nextLine();
                            if (response.trim().length() != 1)  {
                                System.out.println("Invalid entry, please enter a letter only!");
                            }
                        } while (response.trim().length() != 1);

                        responseUserList.add(response);
                
            }

        // prompt.forEach(question -> {
        //     System.out.print("\n" + question);
        //     String response = "";
        //     do {
        //         response = scanner.nextLine();
        //         if (response.trim().length() != 1)  {
        //             System.out.println("Invalid entry, please enter a letter only!");
        //         }
        //     } while (response.trim().length() != 1);

        //     responseUserList.add(response);

        // });

        //Calcul du score
        int trueResponseNumber = 0;
        int falseResponseNumber = 0;

        System.out.println("\n\n************ RECAPITULATIF ***************");
        // on parcourt la liste de reponse utilisateur reponseUserList qu'on compare par la suite a la liste de reponse exact answer
        // on affiche le contenu des deux listes et par la suite si les resultats concordent alors on incremente la variable trueResponseNumber 
        // qui represente le compteur de bonne reponse sinon on incremente falseResponseNumber;

        for (int compteur = 0; compteur < responseUserList.size(); compteur++) {
            String anwserData = answer.get(compteur);
            String UserReponse = responseUserList.get(compteur);
            System.out.print(prompt.get(compteur));
            System.out.println("\tYour Response: " + UserReponse);
            System.out.println("\tCorrect Answer: " + anwserData);
            System.out.println();

            if (responseUserList.get(compteur).equalsIgnoreCase(anwserData)) {
                trueResponseNumber++;
            } else {
                falseResponseNumber++;
            }
        }

        System.out.println("\n============ YOUR SCORE =============");
        System.out.println("True responses: " + trueResponseNumber);
        System.out.println("False responses: " + falseResponseNumber);
        // voulez vous continuer le jeux ou pas
        repeatTheGame();
    }

    private void repeatTheGame() {
        String response = "";
        do {
            System.out.println("\n\nWould you like to try again? (Y/N)");
            response = scanner.nextLine();
        } while (!response.trim().equalsIgnoreCase("y") && !response.trim().equalsIgnoreCase("n"));

        if (response.trim().equalsIgnoreCase("y")) {
            play();
        } else {
            System.out.println("Thank you for participating in this questionnaire!!!");
        }
    }
}