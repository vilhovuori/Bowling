import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaKeilaus {

        static int game;
        public static void main(String[] args) {

            int score = 0;
            int frame = 1;
            int firstScore=0;
            int secScore=0;
            int extraScore=0;
            int seconderyRoll=0;
            int XXX=0;
            List<Integer> saveFrame = new ArrayList<Integer>();
            List<Integer> secSaveFrame = new ArrayList<Integer>();
            String firstPlayer ="";
            String secPlayer="";
            List<Integer> resultList = new ArrayList<Integer>();
            List<Integer> secResultList = new ArrayList<Integer>();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to THE BEST BOWLING ALLEY, that was availible in this address! \n Do you dare to try your luck as a SOLO player or prefer to lose money to your playing PARTNER?");
            String playerMode= scanner.nextLine().toUpperCase();
            if (playerMode.equals("SOLO")){
                System.out.println("Good luck, hopefully this wasn't your only plan for Saturday evening...");
                game=2;
            } else if (playerMode.equals("PARTNER")){
                System.out.println("Add at least one more zero to that bet so nobody will fall asleep! What is name of the first player?");
                firstPlayer = scanner.nextLine();
                System.out.println("And the slow second?");
                secPlayer = scanner.nextLine();
                game=1;
            } else {
                System.out.println("Games are not for everyone, AT LEAST for those who are still learning to read");
                game=3;
            }

            while(game <3) {
                while (frame < 10) {
                    Random randomer = new Random();
                    int result = randomer.nextInt(11);
                    int spare = 11 - result;

                    System.out.println("\n" + frame + ". Frame");
                    System.out.println("Result of the first roll: " + result);
                    score = score + result;
                    resultList.add(result);
                    if (result < 10) {
                        Random spareRandom = new Random();
                        int secResult = spareRandom.nextInt(spare);
                        int secRoll = result + secResult;
                        score = score + secResult;
                        secResultList.add(secResult);
                        if (secRoll==10){
                            secSaveFrame.add(frame);
                            System.out.println("A save for extra score VVVVVVVVVVVVVVVVVVV");
                        }
                        System.out.println("Result of the second roll: " + secResult);
                    } if (result==10){
                        saveFrame.add(frame);
                        System.out.println("Extra score XXXXXXXXXXXXXXXXXXXX");
                    }
                    System.out.println("Overall score: " + score);
                    frame++;
                }
                // Last frame with all the possibilities
                while (frame == 10) {
                    Random randomer = new Random();
                    int result = randomer.nextInt(11);
                    int spare = 11 - result;

                    System.out.println("\n" + frame + " New frame");
                    System.out.println("Result of the first roll: " + result);
                    score = score + result;
                    resultList.add(result);
                    if (result < 10) {
                        Random spareRandom = new Random();
                        int secResult = spareRandom.nextInt(spare);
                        int secRoll = result + secResult;
                        score = score + secResult;
                        System.out.println("Result of the second roll: " + secResult);
                        secResultList.add(secResult);
                        if (secRoll == 10) {
                            Random randomerr = new Random();
                            int thirdResult = randomerr.nextInt(11);
                            System.out.println("Third roll result: " + thirdResult);
                            score = score + thirdResult;
                            secResultList.add(secResult);
                            break;
                        } else {
                            break;
                        }
                    } else if (result == 10) {
                        Random randomera = new Random();
                        int secResult = randomera.nextInt(11);
                        int secSpare = 11 - secResult;
                        System.out.println("Result of the second roll: " + secResult);
                        score = score + secResult;
                        resultList.add(result);
                        if (secResult < 10) {
                            Random spareRandom = new Random();
                            int thirdResult = spareRandom.nextInt(secSpare);
                            int thirdRoll = thirdResult + secResult;
                            score = score + thirdResult;
                            System.out.println("Result of the third roll: " + thirdResult);
                            secResultList.add(secResult);
                            break;
                        } else {
                            Random randomerru = new Random();
                            int thirdResult = randomerru.nextInt(11);
                            System.out.println("Third roll result: " + thirdResult);
                            score = score + thirdResult;
                            resultList.add(result);
                            break;
                        }
                    }
                }

                for (int i = 0; i < saveFrame.size(); i++) {
                    int gotAll = saveFrame.get(i);

                    seconderyRoll= secResultList.get(gotAll);
                    if (resultList.get(gotAll)==10){
                        XXX = gotAll+1;
                        seconderyRoll=resultList.get(XXX);
                    }
                    extraScore = extraScore + resultList.get(gotAll)+seconderyRoll;

                }
                for (int j = 0; j < secSaveFrame.size(); j++) {
                    int gotSecAll = secSaveFrame.get(j);

                    extraScore = extraScore + resultList.get(gotSecAll);

                }

                // Saving the scores of the different rounds.
                if (game == 1) {
                    System.out.println("Extra score: "+extraScore);
                    firstScore = (score+extraScore);
                }
                if (game == 2) {
                    System.out.println("Extra score: "+extraScore);
                    secScore = (score+extraScore);
                }
                System.out.println("\n" + "Game Over, your score was: " + (score+extraScore));
                game++;
                //Enabling two player mode.
                if (game < 3) {
                    frame = 1;
                    score = 0;
                }
                // Making sure that promises are upheld.
                if (playerMode.equals("PARTNER")&& game==3) {
                    System.out.println("\n" +firstPlayer + " score was: " + firstScore);
                    System.out.println(secPlayer+" score was: " + secScore);
                    if (firstScore>secScore){
                        System.out.println("\n"+"Time to pay up dear " + secPlayer);
                    } if (firstScore==secScore){
                        System.out.println("\n"+"Time to donate your bet for the maker of this MAGNIFICENT GAME!");
                    } if  (secScore>firstScore){
                        System.out.println("\n"+"Time to pay up dear " + firstPlayer);
                    }

                }
            }
        }
    }



