package com.example;

import com.example.ParsePost;

import java.io.*;
public class PostfixApp {
    public static void main(String[] args) throws IOException
    {
        String input;
        String outputPost;
        int output;

        while(true)
        {
            System.out.print("Entrer une expression : ");
            input = getString();

            if( input.equals("") )
                break;

            ParsePost aParser = new ParsePost(input);
            outputPost = aParser.doPost();
            output = aParser.doParse();

            System.out.println("Sortie 1 : " + outputPost);
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
