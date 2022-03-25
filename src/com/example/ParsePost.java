package com.example;

import java.beans.Expression;

public class ParsePost {
    private StackX theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public String doPost()
    {
        String expression = input;
        int compteur = 0;
        char ch[] = new char[expression.length()];
        for (int j=0; j<expression.length(); j++)
        {
            if(expression.charAt(j) =='+'|| expression.charAt(j) =='-'|| expression.charAt(j) =='*'
                    || expression.charAt(j) =='/' || expression.charAt(j) =='$')
            {
                ch[compteur] = expression.charAt(j);
                compteur++;
            }
        }
        char chFinal[] = new char[expression.length()];
        expression = expression.replaceAll("[^0-9]+", " ");


        compteur = 0;
        int compteur2 = 0;

        for(int i=0; i<expression.length(); i++) {

            if (expression.charAt(i) >= '0' && expression.charAt(i)  <= '9') {

                chFinal[compteur] = expression.charAt(i);
                compteur++;
            }

            if (input.charAt(i) != expression.charAt(i) && input.charAt(i) != ' ' && input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' ||
                    input.charAt(i) == '/' || input.charAt(i) == '$') {

                if(expression.charAt(i+2) >= '0' && expression.charAt(i+2)  <= '9')
                {
                    try
                    {
                        if(expression.charAt(i+4) >= '0' && expression.charAt(i+4)  <= '9')
                        {
                            chFinal[compteur+2] = ch[compteur2];
                        }
                    }
                    catch (Exception e)
                    {
                        chFinal[compteur+1] = ch[compteur2];
                    }


                }
                chFinal[compteur] = ch[compteur2];
                compteur2++;

            }
        }

        expression = String.valueOf(chFinal);
        expression = expression.trim();

        input = expression;

        return input;
    }
    public int doParse()
    {
        theStack = new StackX(20);
        char ch;
        int j;
        int num1, num2, interAns;

        for(j=0; j<input.length(); j++)
        {
            ch = input.charAt(j);

            if(ch >= '0')
                try
                {
                    if(input.charAt(j+1) >= '0')
                    {
                        if(input.charAt(j+2) >= '0') {
                            theStack.push(Integer. parseInt(ch+""+input.charAt(j+1)+input.charAt(j+2)));
                            j=j+2;
                        }
                        else
                        {
                            theStack.push(Integer. parseInt(ch+""+input.charAt(j+1)));
                            j++;
                        }
                    }
                }
                catch(Exception e)
                {
                    theStack.push( (int)(ch-'0') );
                }

            else
            {
                num2 = theStack.pop();
                num1 = theStack.pop();
                System.out.println("num1 : "+num1);
                System.out.println("num2 : "+num2);

                switch(ch)
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    case '$':
                        interAns = num2 * 1/2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}

