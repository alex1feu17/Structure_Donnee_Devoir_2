public class InToPost {

    private StackX<Character> theStack;
    private String input;
    private String output = "";

    public InToPost(String in)
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackX<>(stackSize);
    }

    public String doTrans() throws Exception {
        for(int j = 0; j < input.length(); j++)
        {
            char ch = input.charAt(j);
            switch(ch)
            {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    output += " ";
                    break;
                case '$':
                case '*':
                case '/':
                    gotOper(ch, 2);
                    output += " ";
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    output += ch;
                    break;
            }
        }

        while(!theStack.isEmpty())
            output += " " + theStack.pop();

        output = output.trim().replaceAll("\\s{2,}", " ") + " ";
        if(output.contains("(") || output.contains(")"))
            throw new Exception("Error");
        return output;
    }

    public void gotOper(char opThis, int prec1)
    {
        while( !theStack.isEmpty() )
        {
            char opTop = theStack.pop();
            if( opTop == '(' )
            {
                theStack.push(opTop);
                break;
            }
            else
            {
                int prec2;
                if(opTop=='+' || opTop=='-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec1)
                {
                    theStack.push(opTop);
                    break;
                }
                else
                    output += " " + opTop;
                }
        }
        theStack.push(opThis);
    }

    public void gotParen()
    {
        while( !theStack.isEmpty() )
        {
            char chx = theStack.pop();
            if( chx == '(' )
                break;
            else
                output += " " + chx;
        }
    }

}
