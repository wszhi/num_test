package com.tw.wsztest;

import org.junit.*;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2015/12/26.
 */
public class NumGenetatorTest {
    private NumGenetator numGenetator=new NumGenetator();
    @Test
    public void should_have_four_chasracters(){
        String numbers = numGenetator.generater();
        assertEquals(numbers.length(),4);
    }
    @Test
    public void should_be_digital(){
        String numbers = numGenetator.generater();
        assertTrue(numbers.matches("\\d{4}"));
    }
    @Test
    public void should_be_unique(){
        String numbers = new NumGenetator().generater();
        //assertTrue(!numbers.matches("^.*?(.+?)\\1.*?$"));// 正则表达式表示有重复的
        assertTrue(isunique(numbers));
    }
    public boolean isunique(String stri){
        char str[]=stri.toCharArray();
        for(int strx=0;strx<stri.length();strx++){
           if(stri.substring(strx+1,stri.length()).indexOf(stri.charAt(strx)) > 0)
               return false;
        }
        return true;
    }
    @Test
    public void should_be_random(){
        assertTrue(israndomEachOther(numGenetator.generater()));
    }
    public boolean israndomEachOther(String onenum){
        String twonum=numGenetator.generater();
        if(twonum.equals(onenum))
            return false;
        else
            return true;
    }
    @Test
    public void should_be_true_result_of0a0b(){
        assertEquals(numGenetator.result("1234","5678"),"0A0B");
    }
    @Test
    public void should_be_true_result_of4a0b(){
        assertEquals(numGenetator.result("1234","1234"),"4A0B");
    }
    @Test
    public void should_be_true_result_of0a4b(){
        assertEquals(numGenetator.result("1234","4321"),"0A4B");
    }
    @Test
    public void should_be_true_result_of2a2b(){
        assertEquals(numGenetator.result("1234","1324"),"2A2B");
    }
}


