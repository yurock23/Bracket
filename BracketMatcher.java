public class BracketMatcher{

    public boolean isOpeningBracket(char c){
        if(c == '('|| c== "["|| c == '{'|| c  == '<')
            return true;
        return false;
    }

    public boolean isClosingBracket(char c){
        if(c == ')'|| c== "]"|| c == '}'|| c  == '>')
            return true;
        return false;
    }
    public boolean corresponds(char open, char close){
        if(open == '(' && close == ')'|| open == '[' && close == ']'|| open == '{' && close == '}' || open == '<' && close == '>')
            return true;
        return false;
    }

    public boolean checkBrackets(String s){


    }

    public static void main(String[] args){

        
    }