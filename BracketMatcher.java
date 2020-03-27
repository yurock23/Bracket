public class BracketMatcher{
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
        if((open == '(' && close == ')')||(open == '[' && close == ']')|| (open == '{' && close == '}' || open == '<' && close == '>'))
            return true;
        return false;
    }

    public boolean checkBrackets(String s){
        char[] chars = s.toCharArray();             // converts string to array of characters
        char[] brackets = new char[s.length()];
        int j = 0;
        for(char c : chars){
            if(c == '('|| c == '['|| c == '{'|| c  == '<'||c == ')'|| c == ']'|| c == '}'|| c  == '>')
                brackets[j] = c;
                j++;
        }

        
        if (chars.length == 0) return false;        // if string is empty
        for (int i=0; i < brackets.length; i++){
            if (isOpeningBracket(brackets[i])) {
                S.push(brackets[i]);
            }
            if (isClosingBracket(brackets[i])) {
                if (S.size() == 0) return false;        // there is no opening bracket left in the stack
                else if (corresponds(S.top(), brackets[i])) {
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

        String randum1 = "(([s])";
        String randum2 = "s}";
        String randum3 = "{((d)e)}[()]";
        System.out.println(check.checkBrackets(randum3));
        System.out.println(check.checkBrackets(randum2));
        System.out.println(check.checkBrackets(randum1));

    }
}