package com.company;

import java.util.ArrayList;

public class Trie
{
    Node root = new Node ('\u0000', false);
    private boolean isLiang = false;

    Trie (String[] wordList)
    {
        String temp;
        Node currNode = root;

        for (int i = 0; i < wordList.length; i++)
        {
            temp = wordList[i];

            for (int j = 0; j < temp.length(); j++)
                if (currNode.getNextChar(temp.charAt(j)) == null)
                {
                    if (temp.length() == j + 1)
                        root = new Node (temp.charAt(j), true);
                    else
                        root = new Node (temp.charAt(j), false);
                }

                else
                    currNode = currNode.getNextChar(temp.charAt(j));
        }
    }

    Trie (String[] wordList, boolean isLiang)
    {
        this.isLiang = isLiang;

        String temp;
        Node currNode = root;

        for (int i = 0; i < wordList.length; i++)
        {
            temp = wordList[i];

            for (int j = 0; j < temp.length(); j++)
                if (currNode.getNextChar(temp.charAt(j)) == null)
                {
                    if (temp.length() == j + 1)
                        root = new Node (temp.charAt(j), true);
                    else
                        root = new Node (temp.charAt(j), false);
                }

                else
                    currNode = currNode.getNextChar(temp.charAt(j));
        }
    }

    public boolean isWord (String word)
    {
        Node currNode = root;

        for (int i = 0; i < word.length(); i++)
        {
            if (currNode.getNextChar(word.charAt(i)) == null)
                return false;
            else if (currNode.getNextChar(word.charAt(i)).isEndOfWord && word.length() == i + 1)
                currNode = currNode.getNextChar(word.charAt(i));
        }

        return false;
    }

    public boolean getSuggestions (String word)
    {
        if (isWord(word))
            return false;

        System.out.println("This is not a word. Did you mean to type:");

        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            System.out.println("hello");
            currNode = currNode.getNextChar(word.charAt(i));

        }

        String temp;
        Node randomNode;
        int randomNum;
        for (int i = 0; i < 6; i++)
        {
            temp = new String(word);
            randomNode = currNode;
            while (randomNode.isEndOfWord == false)
            {
                randomNum = (int) (Math.random() * 26);
                while (randomNode.nextCharArr[randomNum] == null)
                    randomNum = (int) (Math.random() * 26);
                temp += randomNode.character;
            }
            System.out.println(i + ". " + temp);
        }

        return true;
    }

    public boolean removeWord (String word)
    {
        if (isWord(word) == false)
            return false;
        Node currNode = root;
        for (int i = 0; i < word.length() - 1; i++)
            currNode = currNode.getNextChar(word.charAt(i));
        currNode.removeNextChar(word.charAt(word.length() - 1));
        return true;
    }

    public String getLiang (String convertWord)
    {
        if (isLiang == false)
            return null;

        String liangWord = convertWord;
        String word = convertWord;

        for (int k = 0; k < convertWord.length() - 1; k++)
        {
            word = word.substring(k, convertWord.length());
            helper(root, word, 6, false);
            liangWord = liangWord.substring(0, k) + word.substring(k);
        }

        if (liangWord.indexOf(".") == 0)
            liangWord = liangWord.substring(1);
        if (liangWord.indexOf(".") == liangWord.length() - 1)
            liangWord = liangWord.substring(0, liangWord.length() - 1);

        return liangWord;
    }

    private void helper (Node currNode, String word, int dontUse, boolean lastWasNum)
    {
        boolean working = true;

        for (int i = 0; i < word.length() - 1 || working; i++)
            if (currNode.isEndOfWord)
            {
                currNode = root;
                working = false;
            }

            else if (currNode.getNextChar(word.charAt(i)) == null)
            {
                if (lastWasNum)
                {
                    dontUse = word.charAt(word.length() - 1) - 48;
                    word = word.substring(0, word.length() - 1);
                }

                helper2(currNode, word, dontUse);
            }

            else
            {
                word += word.charAt(i);
                currNode = currNode.getNextChar(word.charAt(i));
            }
    }

    private void helper2 (Node currNode, String temp, int dontUse)
    {
        boolean working = true;

        for (int i = dontUse - 1; i < 0 || working; i--)
            if (currNode.getNextChar((char) (i + 48)) != null)
            {
                temp += i;
                currNode = currNode.getNextChar((char) (i + 48));
                helper(currNode, temp, dontUse, true);
                working = false;
            }
    }
}