package com.zakaria;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Help {
    InputValidation inputValidation = new InputValidation();
    List<String> createResultList(int i, String[] args) {
        List<String> list = new ArrayList<>();
        list.add(args[i]);
        int mid = args.length / 2;
        int res = 0;
        for (int j = 0; j < args.length; j++) {
            res = (int) Math.signum((i - j + mid + args.length) % args.length - mid);
            if (res == -1) {
                list.add("Win");
            } else if (res == 1) {
                list.add("Lose");
            } else {
                list.add("Draw");
            }
        }
        return list;
    }
    void printHelpTable(String[] args) {
        List<String> header = new ArrayList<>();
        header.add("Com\\User");
        header.addAll(Arrays.asList(args));
        int n = args.length;
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(header);
        asciiTable.addRule();

//        System.out.println("header " +header.size());

        for (int i = 0; i < n; i++) {
            List<String> res = createResultList(i, args);
            asciiTable.addRow(res);
            asciiTable.addRule();
        }

        asciiTable.setTextAlignment(TextAlignment.CENTER);
        String render = asciiTable.render();
        System.out.println(render);

    }
}
