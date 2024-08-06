package Task_4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Quiz q=new Quiz();
        q.logic();
    }
}
class Quiz{
    Scanner sc=new Scanner(System.in);
    int correctAnsCount=0;
    int wrongAnsCount=0;
    private Timer tm;
    public void logic(){
    Questions q1=new Questions(" In what year did the Great October Socialist Revolution take place?","A. 1917","B. 1920","C. 1914","D. 1923");
    Questions q2=new Questions("What is the largest lake in the world?","A. Caspian Sea","B. Baikal Lake","C. Lake Superior","D. Ontario");
    Questions q3=new Questions(" Which planet in the solar system is known as the “Red Planet”?","A. Venus","B. Earth","C. Mars","D. Jupiter");
    Questions q4=new Questions(" What animal is the national symbol of Australia?","A. Kangaroo","B. Koala","C. Emu","D. Crocodile");
    Questions q5=new Questions(" What chemical element is designated as “Hg”?","A. Silver","B. Tin","C. Copper","D. Mercury");

        Map<Questions,Character>hmap=new HashMap<>();
        hmap.put(q1,'A');
        hmap.put(q2,'B');
        hmap.put(q3,'C');
        hmap.put(q4,'A');
        hmap.put(q5,'D');

        for (Map.Entry<Questions,Character>map:hmap.entrySet()){
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.println("Enter your Answer: ");
            Character ans=sc.next().charAt(0);
            int cans=Character.compare(ans,map.getValue());//cns=correct Answer
            if(cans==0){
                System.out.println("Correct");
                correctAnsCount++;
            }else{
                System.out.println("wrong");
                wrongAnsCount++;
            }

        }
        System.out.println();
        System.out.println("-----------------Result-----------------");
        System.out.println("Total no of Questions: "+hmap.size());
        System.out.println("Correct Answered: " + correctAnsCount);
        System.out.println("Wrong Answered: "+wrongAnsCount);
        System.out.println("Percentage: "+ (100*correctAnsCount)/hmap.size());
    }
}