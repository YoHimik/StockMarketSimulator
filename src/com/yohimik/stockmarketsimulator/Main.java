package com.yohimik.stockmarketsimulator;

import com.yohimik.stockmarketsimulator.core.MainController;
import com.yohimik.stockmarketsimulator.core.OrderBook;
import com.yohimik.stockmarketsimulator.core.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        writeStartOut();
        MainController.startSimulator();
        writeEndOut();
    }

    private static void writeStartOut() {
        Logger.toLog("***Simulator started****", false);
        Logger.toLog("Welcome to stock market simulator. Use command \'help\' to get command description");
    }

    private static void writeEndOut() {
        Logger.toLog("***Simulator closed****", false);
    }

    public static HashMap<String, OrderBook> getOrderBooks() {
        HashMap<String, OrderBook> books = new HashMap<>();
        String line;
        try (Scanner reader = new Scanner(new File("books.txt"))) {
            line = reader.nextLine();
        } catch (IOException ex) {
            return null;
        }
        if (line == null)
            return null;
        String[] stringBooks = line.split(",");
        for (String book : stringBooks) {
            books.put(book, new OrderBook(book));
        }
        return books;
    }
}
