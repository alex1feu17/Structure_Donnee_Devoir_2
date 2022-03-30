import java.io.*;
import java.text.DecimalFormat;

public class PostfixApp {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input, transResult;
        String parseResult;

        while(true)
        {
            System.out.print("Entrez une expression : ");
            input = br.readLine().replace(" ", "");
            if(input.isBlank())
                break;

            InToPost theTrans = new InToPost(input);
            try {
                transResult = theTrans.doTrans();

                ParsePost aParser = new ParsePost(transResult);
                try {
                    double result = aParser.doParse();
                    parseResult = "" + result;
                } catch (Exception e) {
                    parseResult = e.getMessage();
                }
            } catch (Exception e){
                transResult = e.getMessage();
                parseResult = e.getMessage();
            }

            System.out.printf("%s\t;\t%s\t;\t%s%n", input, transResult, parseResult);
        }
    }
}
