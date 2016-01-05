package com.tw.wsztest;
import java.util.*;
import java.util.Random;
/**
 * Created by Administrator on 2015/12/26.
 */
public class NumGenetator {
    public String generater(){
        List list = new ArrayList();
        for(int j = 0; j <= 9 ; j++){
            list.add(j);
        }
        Collections.shuffle(list);
        String randomnum="";
        for(int i=0;i<4;i++){
            randomnum+=list.get(i)+"";
        }
        return randomnum;
    }
    public String result(String randomnum , String youresult){
        int numofa=0,numofb=0;
        for(int nums=0;nums<4;nums++){
            int position=randomnum.indexOf(youresult.charAt(nums));
            if( position >= 0){
                numofb+=1;
                if(position == nums){
                    numofa+=1;
                    numofb-=1;
                }
            }
        }
        return numofa+"A"+numofb+"B";
    }
    public static void main(String []args){
        NumGenetator numGen=new NumGenetator();
        String numbers = numGen.generater();
        Scanner scanner = new Scanner(System.in);
        System.out.println("game begin:"+numbers);
        for(int times=0;times<6;times++){
            String line = scanner.nextLine();
            String resultofgame=numGen.result(numbers,line);
            if(resultofgame.equals("4A0B")){
                System.out.println("you win");
                return;
            }
            else{
                System.out.println("the result of round"+times+":"+resultofgame);
            }
        }
        System.out.println("run out of times……");
    }
}
