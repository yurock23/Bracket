public class BracketMatcher{
    
    private char[] openArray = {'{','(','[','<'};
    private char[] closeArray = {'}',')',']','>'};
    
    public SinglyLinkedStack<Character> S = new SinglyLinkedStack<>();

    /**
     * Checks if the character is a opening Bracket
     * @param c character
     * @return true if the character is an opening bracket false if not
     */
    public boolean isOpeningBracket(char c){
        for(char brackets : openArray)      //loops through the array 
            if(brackets == c)           // check if the bracket matches
                return true;
        return false;
    }
     /**
     * Checks if the character is a closing Bracket
     * @param c character
     * @return true if the character is an closing bracket false if not
     */
    public boolean isClosingBracket(char c){
        for(char brackets : closeArray)     //loops through the array 
            if(brackets == c)       // check if the bracket matches
                return true;
        return false;
    }
    /**
     * Finds the index of the value inside the array
     * @param array array full of characters
     * @param valueToFind the value that your trying to find the index of
     * @return it returns the index of the value
     */
    public int indexOf(char[] array, int valueToFind){
        int index = -1;              //inital index
        for(int i = 0; i<array.length; i++){
            if(array[i] == valueToFind){            //checks through the array and finds the value
                index = i;
                break;
            }
        }
        return index;
    }


    public boolean corresponds(char open, char close){
        int openIndex = indexOf(openArray,open);
        int closeIndex = indexOf(closeArray,close);
        if(openIndex == closeIndex)
            return true;
        return false;
    }
    /**
     * 
     * @param s
     * @return
     */
    public boolean checkBrackets(String s) {
        char[] chars = s.toCharArray();             // converts string to array of characters
        char[] brackets = new char[s.length()];
        int j = 0;
        for(char c : chars){
            if(isOpeningBracket(c)||isClosingBracket(c))
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
        System.out.println(check.isOpeningBracket('('));
        System.out.println(check.checkBrackets(randum3));
        System.out.println(check.checkBrackets(randum2));
        System.out.println(check.checkBrackets(randum1));

    }
}