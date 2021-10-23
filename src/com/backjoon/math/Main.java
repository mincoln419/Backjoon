package com.backjoon.math;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main ma = new Main();
		int n = 8;
		int k = 2;
		int[][] info = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		
		String a = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR";
		a = "AbAaAbAaCa";
		a ="aaA";
		a =  "Aaa";
		a = "HaEaLaLaOWaOaRaLaD";
		a= "aHELLOWORLDa";
		a =  "HaEaLaLObWORLDb";
		a = "HaEaLaLaObWORLDb";
		a =  "aHbEbLbLbOacWdOdRdLdDc";
		a= "abAba";
		a="xAaAbAaAx";
		a= "AbAaAbAaCa";
		a = "AbAaAbAaC";
		a = "baHELLOabWORLD";
		a = "TxTxTxbAb";
		a="AxAxAxA";
		a="a";
		a="AxAxAxACCCaDaBzBzBzB";
		a="AxAxAxABzBzB";
		a="aHbEbLbLbOacWdOdRdLdDceHgEgLgLgOefWbObRbLbDf";
		a="aHbEbLbLbOacWdOdRdLdDceHgEgLgLgOefWzOzRzLzDf";
		a="aHbEbLbLbOacWdOdRdLdDceHbEbLbLbOefWdOdRdLdDf";
		a="aCaCa";
		a="aGbWbFbDakGnWnLk";
		a="HaEaLaLaObWORLDbSpIpGpOpNpGJqOqAdGcWcFcDdeGfWfLeoBBoAAAAxAxAxAA";
		a="ABCD";
		a="AbAaAbAaC";
		a ="kABaCDk";
		a = "bTxTxTaTxTbkABaCDk";
		
		
		String s = "";
		
		
		StringBuilder sb = new StringBuilder();  

		System.out.println(ma.solution(a));
	}
	
    static final String ivd = "invalid";
    
    public String solution(String sentence) {
        String answer = "";
        
        //알파뱃 중복체크 배열
        int[] chk = new int[26];
        //단어 별로 넣음
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        //규칙적용 초기화 - 비적용
        boolean rule_1 = false;
        boolean rule_2 = false;
        
        //규칙적용 켜졌을 시 규칙단어
        char char_rule1 = ' ';
        char char_rule2 = ' ';
        
        
        for(int i = 0 ; i < sentence.length(); i++){
            char chr = sentence.charAt(i);
            if(rule_1 && rule_2){//모든 룰이 적용되었을 때
                
                if(isUpper(chr)){//대문자일경우
                    word.append(chr);
                
                    //대문자가 마지막단어일경우
                    if(i  == sentence.length() - 1) return ivd;
                    //다음 단어가 대문자일경우 - 2룰 위반
                    else if(isUpper(sentence.charAt(i + 1))) return ivd;
                    //다음 단어가 1룰 또는 2룰 단어가 아닐 경우
                    else if(char_rule1 != sentence.charAt(i + 1) && char_rule2 != sentence.charAt(i + 1)) return ivd;
                }
                else{//소문자일경우
                    if(chr == char_rule2){//규칙 2단어일때
                        rule_1 = false;
                        chk[char_rule1 - 'a'] = 1;
                        char_rule1 = ' ';
                        
                        rule_2 = false;
                        chk[char_rule2 - 'a'] = 1;
                        char_rule2 = ' ';
                        
                        words.add(word.toString());
                        word = new StringBuilder();
                        
                        continue;
                    }
                    
                    if(i == sentence.length() - 1)// 규칙2의 마무리가 아닌데 소문자로 마지막일 경우
                        return ivd;
                    else if(isLower(sentence.charAt(i + 1))) // 모든 룰이 적용된 상태에서 소문자가 연속되는 경우 
                        return ivd;                   // 소문자가 연속되기 위해서는 규칙 1,2가 끝나고 새로운 규칙 2가 시작될때 뿐
                }
            }
            else if(rule_1){//규칙 1만 적용될때
                
                if(isUpper(chr)){//대문자일때
                    word.append(chr);
                    
                    if(i == sentence.length() - 1 || isUpper(sentence.charAt(i + 1)) || sentence.charAt(i + 1) != char_rule1){
                        //마지막 단어일때//마지막 단어가 아닌데 다음 단어가 대문자일때//다음 단어가 소문자인데 규칙1단어가 아닐때
                        rule_1 = false;
                        chk[char_rule1 - 'a'] = 1;
                        char_rule1 = ' ';
                        words.add(word.toString());
                        word = new StringBuilder();
                    }
                }else{//소문자일때
                    if(i == sentence.length() - 1) return ivd;
                    else if(isLower(sentence.charAt(i + 1))) return ivd;
                }

            }
            else if(rule_2){//규칙 2만 적용될때 - 규칙 1이 적용될 가능성 고려해야함
                if(isUpper(chr)){
                    word.append(chr);
                    
                    if(i == sentence.length()) return ivd;
                    else if(isLower(sentence.charAt(i + 1)) && sentence.charAt(i + 1) != char_rule2){
                        // 다음단어가 소문자이지만 규칙2단어가 아닐경우
                        if(sentence.charAt(i - 1) == char_rule2){//이전 단어가 규칙2단어 단어라면
                            if(chk[sentence.charAt(i + 1) - 'a'] == 1) return ivd;// 규칙1 적용안하면 invalid임
                            //규칙 1적용
                            rule_1 = true;
                            char_rule1 = sentence.charAt(i + 1);
                        }else return ivd;
                    }
                }else{//소문자일때 -- 만약에 앞서 대문자일때 규칙 1이 적용되는 체크했기 때문에 규칙2에 해당하는 단어일수밖에 없음
                    rule_2 = false;
                    chk[char_rule2 -'a'] = 1;
                    char_rule2 = ' ';
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            }
            else{//아무런 규칙 없는 깨끗한 상태
                if(isUpper(chr)){
                    word.append(chr);
                    rule_1 = true; // 규칙 1시작
                    
                    if(i == sentence.length() - 1 || isUpper(sentence.charAt(i + 1))){//마지막단어일경우//다음단어도 대문자일경우
                        rule_1 = false;//종료
                        words.add(word.toString());
                        word = new StringBuilder();
                    }else if(isLower(sentence.charAt(i + 1))){//다음단어는 소문자일경우
                        if(chk[sentence.charAt(i + 1) - 'a'] == 1) return ivd;
                        
                        char_rule1 = sentence.charAt(i + 1);
                        
                        List<Integer> rule1chk = new ArrayList<>();// 규칙1 적용가능여부 미리 체크
                        for(int j = i + 1 ; j < sentence.length(); j++){
                            if(sentence.charAt(j) == char_rule1)rule1chk.add(j);
                        }
                        if(rule1chk.size() == 1) continue;// 1개짜리 규칙 1
                        else if(rule1chk.size() == 2){
                            //규칙2적용으로 보고 pass
                            rule_1 = false;
                            char_rule1 = ' ';
                            words.add(word.toString());
                            word = new StringBuilder();
                        }else{//2칸씩 띄어있는지 확인
                            boolean flag = true;
                            for(int j = 1 ; j < rule1chk.size() ; j++){
                                
                                if(rule1chk.get(j) - rule1chk.get(j -1) !=2){
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag)continue;
                        }
                    }
                }else{//소문자일때 - 규칙 2적용여부 체크
                    if(chk[chr - 'a'] == 1)return ivd;
                    else if(i == sentence.length() - 1)return ivd;
                    else if(isLower(sentence.charAt(i + 1))) return ivd;
                    
                    rule_2 = true;
                    char_rule2 = chr;
                }
                
            }

        }
    
        
    
        for(int i = 0 ; i < words.size(); i++){
            answer += words.get(i) + " ";
        }    
        answer.substring(0, answer.length() - 1);
        return answer;
    }
    
    
    boolean isLower(char a){
        
        if(a >= 'a' && a <= 'z')return true;
        else return false;
    }
    
    boolean isUpper(char a){
        
        if(a >= 'A' && a <= 'Z')return true;
        else return false;
    }
}
