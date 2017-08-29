import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ONP
{
    static class Expression
    {
        Expression initial;
        char operation;
        Expression second;
        
        char simplyChar;
        boolean isSimplyACharacter;
        
        public Expression()
        {
            isSimplyACharacter = false;
        }
        
        public Expression(char c)
        {
            setChar(c);
        }
        
        void setInitial(Expression e)
        {
            initial = e;
        }
        
        void setOperation(char o)
        {
            operation = o;
        }
        
        void setSecond(Expression e)
        {
            second = e;
        }
        
        void setChar(char c)
        {
            isSimplyACharacter = true;
            simplyChar = c;
        }
        
        public String toString()
        {
            if(isSimplyACharacter)
                return ""+simplyChar;
            return initial + "" + second + ""+operation;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numExpressions = Integer.parseInt(f.readLine());
        for(int i = 0; i < numExpressions; i++)
        {
            String input = f.readLine();
            output = ""+makeExpressionOfString(input);
            writer.println(output);
        }
        //out.println(makeExpressionOfString(input));
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static Expression makeExpressionOfString(String s)
    {
        //out.println(s);
        
        Expression ret = new Expression();
        if(!doesContainOperation(s))
        {
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(c >= 'a' && c <= 'z')
                    ret.setChar(c);
            }
            return ret;
        }
        int indexOfHighestPrecedenceOperationInString = getIndexOfHighestPrecedenceOperationInString(s);
        String initExpressionString = s.substring(0,indexOfHighestPrecedenceOperationInString);
        String secondExpressionString = s.substring(indexOfHighestPrecedenceOperationInString+1);
        Expression initExpression = makeExpressionOfString(initExpressionString);
        Expression secondExpression = makeExpressionOfString(secondExpressionString);
        char operation = s.charAt(indexOfHighestPrecedenceOperationInString);
        
        ret.setInitial(initExpression);
        ret.setSecond(secondExpression);
        //out.println(operation);
        ret.setOperation(operation);
        
        //out.println("RET"+ret);
        
        return ret;
    }
    
    public static boolean doesContainOperation(String s)
    {
        for(int i = 0; i < s.length(); i++)
            if(isOperation(s.charAt(i)))
                return true;
        return false;
    }
    
    public static int getIndexOfHighestPrecedenceOperationInString(String s)
    {
        int curLevel = 0;
        int index = 0;
        char resultOp = 'd';
        int resultLevel = 500;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                curLevel++;
            }
            else if(c==')')
            {
                curLevel--;
            }
            else if(isOperation(c))
            {
                if(curLevel < resultLevel)
                {
                    resultLevel = curLevel;
                    resultOp = c;
                    index = i;
                }
                else if(curLevel==resultLevel)
                {
                    if(isFirstOperationHigherPrecedenceThanSecondOperation(c,resultOp))
                    {
                        resultLevel = curLevel;
                        resultOp = c;
                        index = i;
                    }
                }
            }
        }
        return index;
    }
    
    public static boolean isFirstOperationHigherPrecedenceThanSecondOperation(char op1, char op2)
    {
        char[] ray = {'+','-','*','/','^'};
        int ind1 = -1;
        int ind2 = -1;
        int index = 0;
        for(char op : ray)
        {
            if(op1==op)
                ind1 = index;
            index++;
        }
        index = 0;
        for(char op : ray)
        {
            if(op2==op)
                ind2 = index;
            index++;
        }
        return ind1 > ind2;
    }
    
    public static boolean isOperation(char c)
    {
        char[] ray = {'+','-','/','*','^'};
        for(char op : ray)
            if(c==op)
                return true;
        return false;
    }
}