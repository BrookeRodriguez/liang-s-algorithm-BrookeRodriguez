package com.company;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        Connection doc = null;

        doc = Jsoup.connect("https://gist.githubusercontent.com/cosmologicon/1e7291714094d71a0e25678316141586/raw/006f7e9093dc7ad72b12ff9f1da649822e56d39d/tex-hyphenation-patterns.txt");
        try {
            System.out.println(doc.get().title());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Breadth-first search to show structure of the trie (each level should output on to a new line)

        String typed = "";
        String word = "." + typed + ".";
    }
}