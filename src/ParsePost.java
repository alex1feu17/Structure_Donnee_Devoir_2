public class ParsePost {

    private StackX<Double> theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public double doParse() throws Exception {
        theStack = new StackX<>(20);
        char ch;
        int j;
        double num1 = 0, num2, interAns;
        for(j = 0; j < input.length(); j++)
        {
            ch = input.charAt(j);
            if(ch >= '0' && ch <= '9')
            {
                String nb = "" + ch;
                for(int k = j + 1; k < input.length(); k++){
                    j = k;
                    char ch2 = input.charAt(k);
                    if(ch2 == '.' || (ch2 >= '0' && ch2 <= '9'))
                        nb += ch2;
                    else
                        break;
                }
                theStack.push(Double.parseDouble(nb));
            }
            else if (ch != ' ')
            {
                num2 = theStack.pop();
                if(ch != '$')
                    num1 = theStack.pop();
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
                        if(num2 == 0) throw new Exception("Error");
                        interAns = num1 / num2;
                        break;
                    case '$':
                        if(num2 < 0) throw new Exception("Error");
                        interAns = Math.sqrt(num2);
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        return theStack.pop();
    }
}

