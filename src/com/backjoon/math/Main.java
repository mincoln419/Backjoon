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
        
        //���Ĺ� �ߺ�üũ �迭
        int[] chk = new int[26];
        //�ܾ� ���� ����
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        //��Ģ���� �ʱ�ȭ - ������
        boolean rule_1 = false;
        boolean rule_2 = false;
        
        //��Ģ���� ������ �� ��Ģ�ܾ�
        char char_rule1 = ' ';
        char char_rule2 = ' ';
        
        
        for(int i = 0 ; i < sentence.length(); i++){
            char chr = sentence.charAt(i);
            if(rule_1 && rule_2){//��� ���� ����Ǿ��� ��
                
                if(isUpper(chr)){//�빮���ϰ��
                    word.append(chr);
                
                    //�빮�ڰ� �������ܾ��ϰ��
                    if(i  == sentence.length() - 1) return ivd;
                    //���� �ܾ �빮���ϰ�� - 2�� ����
                    else if(isUpper(sentence.charAt(i + 1))) return ivd;
                    //���� �ܾ 1�� �Ǵ� 2�� �ܾ �ƴ� ���
                    else if(char_rule1 != sentence.charAt(i + 1) && char_rule2 != sentence.charAt(i + 1)) return ivd;
                }
                else{//�ҹ����ϰ��
                    if(chr == char_rule2){//��Ģ 2�ܾ��϶�
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
                    
                    if(i == sentence.length() - 1)// ��Ģ2�� �������� �ƴѵ� �ҹ��ڷ� �������� ���
                        return ivd;
                    else if(isLower(sentence.charAt(i + 1))) // ��� ���� ����� ���¿��� �ҹ��ڰ� ���ӵǴ� ��� 
                        return ivd;                   // �ҹ��ڰ� ���ӵǱ� ���ؼ��� ��Ģ 1,2�� ������ ���ο� ��Ģ 2�� ���۵ɶ� ��
                }
            }
            else if(rule_1){//��Ģ 1�� ����ɶ�
                
                if(isUpper(chr)){//�빮���϶�
                    word.append(chr);
                    
                    if(i == sentence.length() - 1 || isUpper(sentence.charAt(i + 1)) || sentence.charAt(i + 1) != char_rule1){
                        //������ �ܾ��϶�//������ �ܾ �ƴѵ� ���� �ܾ �빮���϶�//���� �ܾ �ҹ����ε� ��Ģ1�ܾ �ƴҶ�
                        rule_1 = false;
                        chk[char_rule1 - 'a'] = 1;
                        char_rule1 = ' ';
                        words.add(word.toString());
                        word = new StringBuilder();
                    }
                }else{//�ҹ����϶�
                    if(i == sentence.length() - 1) return ivd;
                    else if(isLower(sentence.charAt(i + 1))) return ivd;
                }

            }
            else if(rule_2){//��Ģ 2�� ����ɶ� - ��Ģ 1�� ����� ���ɼ� ����ؾ���
                if(isUpper(chr)){
                    word.append(chr);
                    
                    if(i == sentence.length()) return ivd;
                    else if(isLower(sentence.charAt(i + 1)) && sentence.charAt(i + 1) != char_rule2){
                        // �����ܾ �ҹ��������� ��Ģ2�ܾ �ƴҰ��
                        if(sentence.charAt(i - 1) == char_rule2){//���� �ܾ ��Ģ2�ܾ� �ܾ���
                            if(chk[sentence.charAt(i + 1) - 'a'] == 1) return ivd;// ��Ģ1 ������ϸ� invalid��
                            //��Ģ 1����
                            rule_1 = true;
                            char_rule1 = sentence.charAt(i + 1);
                        }else return ivd;
                    }
                }else{//�ҹ����϶� -- ���࿡ �ռ� �빮���϶� ��Ģ 1�� ����Ǵ� üũ�߱� ������ ��Ģ2�� �ش��ϴ� �ܾ��ϼ��ۿ� ����
                    rule_2 = false;
                    chk[char_rule2 -'a'] = 1;
                    char_rule2 = ' ';
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            }
            else{//�ƹ��� ��Ģ ���� ������ ����
                if(isUpper(chr)){
                    word.append(chr);
                    rule_1 = true; // ��Ģ 1����
                    
                    if(i == sentence.length() - 1 || isUpper(sentence.charAt(i + 1))){//�������ܾ��ϰ��//�����ܾ �빮���ϰ��
                        rule_1 = false;//����
                        words.add(word.toString());
                        word = new StringBuilder();
                    }else if(isLower(sentence.charAt(i + 1))){//�����ܾ�� �ҹ����ϰ��
                        if(chk[sentence.charAt(i + 1) - 'a'] == 1) return ivd;
                        
                        char_rule1 = sentence.charAt(i + 1);
                        
                        List<Integer> rule1chk = new ArrayList<>();// ��Ģ1 ���밡�ɿ��� �̸� üũ
                        for(int j = i + 1 ; j < sentence.length(); j++){
                            if(sentence.charAt(j) == char_rule1)rule1chk.add(j);
                        }
                        if(rule1chk.size() == 1) continue;// 1��¥�� ��Ģ 1
                        else if(rule1chk.size() == 2){
                            //��Ģ2�������� ���� pass
                            rule_1 = false;
                            char_rule1 = ' ';
                            words.add(word.toString());
                            word = new StringBuilder();
                        }else{//2ĭ�� ����ִ��� Ȯ��
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
                }else{//�ҹ����϶� - ��Ģ 2���뿩�� üũ
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
