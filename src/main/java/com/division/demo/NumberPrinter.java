package com.division.demo;

import org.springframework.stereotype.Service;

@Service
public class NumberPrinter {

    public StringBuilder printNumbers(int from, int to) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i <= to; i++) {
            if (i % 4 == 0) {
                sb.append(Words.foofuu).append("\n");
            } else if (i % 2 == 0) {
                sb.append(Words.foo).append("\n");
            } else {
                sb.append(i).append("\n");
            }
        }
        return sb;
    }
}
