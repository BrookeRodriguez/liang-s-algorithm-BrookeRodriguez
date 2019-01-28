package com.company;

public class Node
{
    int liangNum;
    char character;
    Node[] nextCharArr;
    boolean isEndOfWord;

    Node (char character, boolean isEndOfWord)
    {
        this.character = character;
        this.isEndOfWord = isEndOfWord;
        nextCharArr = new Node[26];
    }

    public void addNextChar (Node nextChar)
    {
        for (int i = 0; i < nextCharArr.length; i++)
        {
            if (nextCharArr[i] == null)
            {
                nextCharArr[i] = nextChar;
                return;
            }
        }
    }

    public void removeNextChar (char removeChar)
    {
        for (int i = 0; i < nextCharArr.length; i++)
        {
            if (nextCharArr[i].character == removeChar)
            {
                nextCharArr[i].isEndOfWord = false;

                if (nextCharArr[i].nextCharArr.length == 0)
                    nextCharArr[i] = null;

                return;
            }
        }
    }

    public Node getNextChar (char nextChar)
    {
        for (int i = 0; i < nextCharArr.length; i++)
            if (nextCharArr[i].character == nextChar)
                return nextCharArr[i];
        return null;
    }
}
