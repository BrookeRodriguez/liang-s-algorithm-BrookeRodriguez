package com.company;

public class Node
{
    int liangNum;
    char character;
    Node[] nextCharArr;
    boolean isEndOfWord;
    char[] letters = {'.', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //looked at before for trie so it does not print it out again
    boolean lookedAt;

    Node (char character, boolean isEndOfWord)
    {
        this.character = character;
        this.isEndOfWord = isEndOfWord;
        nextCharArr = new Node[27];
        lookedAt = false;
    }

    public void addNextChar (Node nextChar)
    {
        for (int i = 0; i < letters.length; i++)
            if (nextChar.character == letters[i])
            {
                nextCharArr[i] = nextChar;
                return;
            }
    }

    public void removeNextChar (char removeChar)
    {
        for (int i = 0; i < letters.length; i++)
            if (removeChar == letters[i])
            {
                nextCharArr[i] = null;
                return;
            }
    }

    public Node getNextChar (char nextChar)
    {
        for (int i = 0; i < letters.length; i++)
            if (nextChar == letters[i])
                return nextCharArr[i];
        return null;
    }

    public Node getNextChar (int charNum)
    {
        return nextCharArr[charNum];
    }
}
