/**
 * @author Yurock Heo, Linh Nguyen
 * @since Mar 30, 2020
 * This class checks if brackets in a given string are matching or not
 */
public class BracketMatcher {

    // array of opening and closing brackets
    private char[] openArray = {'{','(','[','<'};
    private char[] closeArray = {'}',')',']','>'};
    public SinglyLinkedStack<Character> S = new SinglyLinkedStack<>();

    /**
     * Checks if the character is a opening Bracket
     * @param c character
     * @return true if the character is an opening bracket false if not
     */
    public boolean isOpeningBracket(char c){
        for(char brackets : openArray)          // go through the array of opening brackets
            if(brackets == c)
                return true;
        return false;
    }

    /**
     * Checks if the character is a closing Bracket
     * @param c character
     * @return true if the character is an closing bracket false if not
     */
    public boolean isClosingBracket(char c){
        for(char brackets : closeArray)         // go through the array of closing brackets
            if(brackets == c)
                return true;
        return false;
    }

    /**
     * Finds the index of the value inside the array
     * @param array array full of characters
     * @param valueToFind the value that your trying to find the index of
     * @return it returns the index of the value
     */
    public int indexOf(char[] array, int valueToFind) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToFind) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Check if input brackets are matching
     * @param open opening bracket
     * @param close closing bracket
     * @return true if they match, false otherwise
     */
    public boolean corresponds(char open, char close){
        int openIndex = indexOf(openArray, open);
        int closeIndex = indexOf(closeArray, close);
        if (openIndex == closeIndex)
            return true;
        return false;
    }

    /**
     * Check if brackets in given string are matching
     * @param s input string
     * @return true if brackets match, false otherwise
     */
    public boolean checkBrackets(String s){
        char[] chars = s.toCharArray();             // converts string to array of characters
        if (chars.length == 0) return false;        // if string is empty
        for (int i=0; i < chars.length; i++){
            if (isOpeningBracket(chars[i])) {
                S.push(chars[i]);               // push opening brackets into stack
            }
            if (isClosingBracket(chars[i])) {
                if (S.size() == 0) return false;        // there is no opening bracket left in the stack
                else if (corresponds(S.top(), chars[i])) {
                    S.pop();            // pop opening brackets if they match with next closing brackets
                }
            }
        }
        if (S.size() != 0) return false;        // there is still opening brackets in the stack
        return true;
    }

    public static void main(String[] args){
        BracketMatcher check = new BracketMatcher();

        String randum1 = "(([s])";
        String randum2 = "s}";
        String randum3 = "{((d))e}[()]";
        System.out.println(check.checkBrackets(randum3));
        System.out.println(check.checkBrackets(randum2));
        System.out.println(check.checkBrackets(randum1));

    }
}
