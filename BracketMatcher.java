public class BracketMatcher {

    private char[] open = {'{','(','[','<'};
    public SinglyLinkedStack<Character> S = new SinglyLinkedStack<>();

    public boolean isOpeningBracket(char c){
        if(c == '('|| c == '['|| c == '{'|| c  == '<')
            return true;
        return false;
    }

    public boolean isClosingBracket(char c){
        if(c == ')'|| c == ']'|| c == '}'|| c  == '>')
            return true;
        return false;
    }
    public boolean corresponds(char open, char close){
        if(open == '(' && close == ')'|| open == '[' && close == ']'|| open == '{' && close == '}' || open == '<' && close == '>')
            return true;
        return false;
    }

    public boolean checkBrackets(String s){
        char[] chars = s.toCharArray();             // converts string to array of characters
        if (chars.length == 0) return false;        // if string is empty
        for (int i=0; i < chars.length; i++){
            if (isOpeningBracket(chars[i])) {
                S.push(chars[i]);
            }
            if (isClosingBracket(chars[i])) {
                if (S.size() == 0) return false;        // there is no opening bracket left in the stack
                else if (corresponds(S.top(), chars[i])) {
                    S.pop();
                }
            }
            //S.display();
        }
        if (S.size() != 0) return false;        // there is still opening brackets in the stack
        return true;
    }

    public static void main(String[] args){
        BracketMatcher check = new BracketMatcher();

        String randum1 = "(([])";
        String randum2 = "}";
        String randum3 = "{(())}[()]";
        System.out.println(check.checkBrackets(randum3));
        System.out.println(check.checkBrackets(randum2));
        System.out.println(check.checkBrackets(randum1));

    }
}
