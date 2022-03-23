package com.example;

import com.example.ParsePost;

import java.io.*;
public class PostfixApp {
    public static void main(String[] args) throws IOException
    {
        String input;
        int output;

        while(true)
        {
            System.out.print("Entrer une expression : ");
            System.out.flush();
            input = getString();

            if( input.equals("") )
                break;

            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();
            System.out.println("Sortie 1 : " );
            System.out.println("Sortie 2 : " + output);
        }
    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
