package com.company;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Connection liang = null;
        Connection words = null;
        String liangString = null;
        String wordsString = null;
        Scanner typed = new Scanner(System.in);

        words = Jsoup.connect("https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt");

        liang = Jsoup.connect("https://gist.githubusercontent.com/cosmologicon/1e7291714094d71a0e25678316141586/raw/006f7e9093dc7ad72b12ff9f1da649822e56d39d/tex-hyphenation-patterns.txt");

        try {
            liangString = liang.get().body().text();
            wordsString = words.get().body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] liangList = liangString.split(" ");
        String[] wordsList = wordsString.split(" ");

        Trie liangTrie = new Trie(liangList, true);
        Trie wordTrie = new Trie(wordsList);

        System.out.println("Please type a word below to be to be hyphenated:");

        String word = typed.nextLine().toLowerCase();

        while (wordTrie.getSuggestions(word))
            word = typed.nextLine().toLowerCase();

        word = "." + typed + ".";

        System.out.println(liangTrie.getLiang(word));
    }
}