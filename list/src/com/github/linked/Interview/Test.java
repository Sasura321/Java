package com.github.linked.Interview;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        LinkedInterview linkedInterview = new LinkedInterview();
//        linkedInterview.addFirst(1);
//        linkedInterview.addFirst(1);
//        linkedInterview.addFirst(2);
//        linkedInterview.addFirst(3);
//        linkedInterview.addFirst(3);
//        linkedInterview.addFirst(4);
//        linkedInterview.addFirst(5);
//        linkedInterview.addFirst(5);
        LinkedInterview linkedInterview = new LinkedInterview();
        linkedInterview.addFirst(1);
        linkedInterview.addFirst(2);
        linkedInterview.addFirst(3);
        linkedInterview.addFirst(4);
        linkedInterview.addFirst(5);
        linkedInterview.addFirst(6);
        linkedInterview.addFirst(7);
        linkedInterview.display();

        LinkedInterview.Node cur = linkedInterview.deleteDuplication();
        linkedInterview.show(cur);

        boolean flg = linkedInterview.chkPalindrome();
        System.out.println(flg);

        LinkedInterview interview = new LinkedInterview();
        interview.addFirst(1);
        interview.addFirst(2);
        interview.addFirst(3);
        interview.addFirst(5);
        interview.addFirst(6);
        interview.addFirst(7);

    }

}
