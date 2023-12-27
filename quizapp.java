
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    class Question {
        private String questionText;
        private List<String> options;
        private int correctAnswer;

        public Question(String questionText, List<String> options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<String> getOptions() {
            return options;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }

    class Quiz {
        private List<Question> questions;

        public Quiz() {
            this.questions = new ArrayList<>();
        }

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public Question getQuestion(int index) {
            if (index >= 0 && index < questions.size()) {
                return questions.get(index);
            }
            return null;
        }

        public int getSize() {
            return questions.size();
        }
    }

    public class quizapp {
        public static void main(String[] args) {

            Quiz quiz = new Quiz();

            Question question1 = new Question("Which of the following is not a Java features?",
                    List.of("Use of pointers", "Dynamic", "Architecture Neutral", "Object-oriented"), 0);

            Question question2 = new Question("_____ is used to find and fix bugs in the Java programs.",
                    List.of("JVM", "JRE", "JDB", "JDK"), 2);

            Question question3 = new Question("What is the return type of the hashCode() method in the Object class?",
                    List.of("Object", "long", "void", "int"), 3);

            Question question4 = new Question("Which of the following is not an OOPS concept in Java?",
                    List.of("Polymorphism", "Inheritance", "Compilation", "Encapsulation"), 2);

            Question question5 = new Question("Which of the following is a type of polymorphism in Java Programming?",
                    List.of("Multiple polymorphism", "Compile time polymorphism", "Multilevel polymorphism",
                            "Execution time polymorphism"),
                    1);

            Question question6 = new Question("Which exception is thrown when java is out of memory?",
                    List.of("MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException"), 1);

            Question question7 = new Question(" Which of these are selection statements in Java?",
                    List.of("break", "continue", "for()", "if()"), 3);

            Question question8 = new Question(" Which of the following is a superclass of every class in Java?",
                    List.of("ArrayList", "Abstract class", "Object class", "String"), 2);

            Question question9 = new Question(
                    " Which of these keywords are used for the block to be examined for exceptions?",
                    List.of("check", "throw", "catch", "try"), 3);

            Question question10 = new Question("Which one of the following is not an access modifier?",
                    List.of("Protected", "Void", "Public", "Private"), 1);

            quiz.addQuestion(question1);
            quiz.addQuestion(question2);
            quiz.addQuestion(question3);
            quiz.addQuestion(question4);
            quiz.addQuestion(question5);
            quiz.addQuestion(question6);
            quiz.addQuestion(question7);
            quiz.addQuestion(question8);
            quiz.addQuestion(question9);
            quiz.addQuestion(question10);

            Scanner scanner = new Scanner(System.in);
            int score = 0;
            for (int i = 0; i < quiz.getSize(); i++) {
                Question currentQuestion = quiz.getQuestion(i);
                if (currentQuestion != null) {
                    System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
                    List<String> options = currentQuestion.getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        System.out.println((j + 1) + ". " + options.get(j));
                    }
                    System.out.print("Your answer (1-" + options.size() + "): ");
                    int userAnswer = scanner.nextInt();

                    if (userAnswer >= 1 && userAnswer <= options.size()) {
                        if (userAnswer - 1 == currentQuestion.getCorrectAnswer()) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Incorrect!");
                        }
                    } else {
                        System.out.println("Invalid input. Skipping this question.");
                    }
                }
            }

            System.out.println("Quiz completed! Your score is: " + score + "/" + quiz.getSize());
            scanner.close();
        }
    }


