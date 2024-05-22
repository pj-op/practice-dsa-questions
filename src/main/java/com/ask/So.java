package com.ask;

import javax.xml.stream.events.EntityReference;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Pair {
    long dist;
    long node;

    Pair(long dist, long node) {
        this.dist = dist;
        this.node = node;
    }

    public long getDist() {
        return dist;
    }

    public long getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "{" +
                "dist=" + dist +
                ", node=" + node +
                '}';
    }
}

public class So {

    public static void main(String[] args) {
        /*int[] arr = new int[1000];
        Random random = new Random();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = random.nextInt(9000));
        System.out.println(Arrays.toString(arr));
//        qSrt(arr);
//        mSrt(arr);
//        iSrt(arr);
//        sSrt(arr);
//        cSrt(arr);
//        rSrt(arr);
        System.out.println(Arrays.toString(arr));*/

        /*int[] arr = {10, 11, 11, 20, 20, 30};
        System.out.println(Arrays.toString(removeInPlaceDuplicates(arr)));*/

        /*String s = "1011";
        System.out.println(minimumBeautifulSubstrings(s));*/

        /*StringBuilder sb = new StringBuilder();
        System.out.println(convertIntToBinStringRecursive(121, sb));*/

        /*String num = "101";
        System.out.println(convertBinToInt(num, num.length() - 1, 0));*/

        /*int[] arr = {8, 4, 2};
        System.out.println(triangleType(arr));*/

        /*String source = "abc";
        String target = "cba";
        System.out.println(minWindowOptimal(source, target));*/

        /*int n = 200;
        //7;
        int[][] roads = //{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
                //{{0, 1, 865326231}, {1, 4, 865326231}, {0, 2, 865326231}, {2, 4, 865326231}, {0, 3, 865326231}, {3, 4, 865326231}, {4, 5, 647618270}, {5, 9, 647618270}, {4, 6, 647618270}, {6, 9, 647618270}, {4, 7, 647618270}, {7, 9, 647618270}, {4, 8, 647618270}, {8, 9, 647618270}, {9, 10, 153310768}, {10, 15, 153310768}, {9, 11, 153310768}, {11, 15, 153310768}, {9, 12, 153310768}, {12, 15, 153310768}, {9, 13, 153310768}, {13, 15, 153310768}, {9, 14, 153310768}, {14, 15, 153310768}, {15, 16, 446216658}, {16, 21, 446216658}, {15, 17, 446216658}, {17, 21, 446216658}, {15, 18, 446216658}, {18, 21, 446216658}, {15, 19, 446216658}, {19, 21, 446216658}, {15, 20, 446216658}, {20, 21, 446216658}, {21, 22, 482432125}, {22, 27, 482432125}, {21, 23, 482432125}, {23, 27, 482432125}, {21, 24, 482432125}, {24, 27, 482432125}, {21, 25, 482432125}, {25, 27, 482432125}, {21, 26, 482432125}, {26, 27, 482432125}, {27, 28, 546917635}, {28, 32, 546917635}, {27, 29, 546917635}, {29, 32, 546917635}, {27, 30, 546917635}, {30, 32, 546917635}, {27, 31, 546917635}, {31, 32, 546917635}, {32, 33, 905837683}, {33, 37, 905837683}, {32, 34, 905837683}, {34, 37, 905837683}, {32, 35, 905837683}, {35, 37, 905837683}, {32, 36, 905837683}, {36, 37, 905837683}, {37, 38, 941383964}, {38, 41, 941383964}, {37, 39, 941383964}, {39, 41, 941383964}, {37, 40, 941383964}, {40, 41, 941383964}, {41, 42, 482278242}, {42, 44, 482278242}, {41, 43, 482278242}, {43, 44, 482278242}, {44, 45, 209029963}, {45, 49, 209029963}, {44, 46, 209029963}, {46, 49, 209029963}, {44, 47, 209029963}, {47, 49, 209029963}, {44, 48, 209029963}, {48, 49, 209029963}, {49, 50, 180362920}, {50, 53, 180362920}, {49, 51, 180362920}, {51, 53, 180362920}, {49, 52, 180362920}, {52, 53, 180362920}, {53, 54, 40040617}, {54, 58, 40040617}, {53, 55, 40040617}, {55, 58, 40040617}, {53, 56, 40040617}, {56, 58, 40040617}, {53, 57, 40040617}, {57, 58, 40040617}, {58, 59, 429647103}, {59, 62, 429647103}, {58, 60, 429647103}, {60, 62, 429647103}, {58, 61, 429647103}, {61, 62, 429647103}, {62, 63, 863858638}, {63, 64, 250353988}, {64, 66, 250353988}, {63, 65, 250353988}, {65, 66, 250353988}, {66, 67, 502785687}, {67, 68, 565934645}, {68, 69, 548158326}, {69, 74, 548158326}, {68, 70, 548158326}, {70, 74, 548158326}, {68, 71, 548158326}, {71, 74, 548158326}, {68, 72, 548158326}, {72, 74, 548158326}, {68, 73, 548158326}, {73, 74, 548158326}, {74, 75, 858926247}, {75, 79, 858926247}, {74, 76, 858926247}, {76, 79, 858926247}, {74, 77, 858926247}, {77, 79, 858926247}, {74, 78, 858926247}, {78, 79, 858926247}, {79, 80, 610164528}, {80, 82, 610164528}, {79, 81, 610164528}, {81, 82, 610164528}, {82, 83, 116910438}, {83, 84, 153203278}, {84, 88, 153203278}, {83, 85, 153203278}, {85, 88, 153203278}, {83, 86, 153203278}, {86, 88, 153203278}, {83, 87, 153203278}, {87, 88, 153203278}, {88, 89, 484666281}, {89, 93, 484666281}, {88, 90, 484666281}, {90, 93, 484666281}, {88, 91, 484666281}, {91, 93, 484666281}, {88, 92, 484666281}, {92, 93, 484666281}, {93, 94, 694001013}, {94, 95, 180373702}, {95, 96, 392438425}, {96, 97, 392438425}, {97, 98, 915720722}, {98, 99, 915720722}, {99, 100, 660886218}, {100, 101, 980566840}, {101, 103, 980566840}, {100, 102, 980566840}, {102, 103, 980566840}, {103, 104, 509703517}, {104, 105, 817920401}, {105, 106, 992341639}, {106, 107, 992341639}, {107, 108, 180854348}, {108, 111, 180854348}, {107, 109, 180854348}, {109, 111, 180854348}, {107, 110, 180854348}, {110, 111, 180854348}, {111, 112, 699029750}, {112, 115, 699029750}, {111, 113, 699029750}, {113, 115, 699029750}, {111, 114, 699029750}, {114, 115, 699029750}, {115, 116, 973634138}, {116, 120, 973634138}, {115, 117, 973634138}, {117, 120, 973634138}, {115, 118, 973634138}, {118, 120, 973634138}, {115, 119, 973634138}, {119, 120, 973634138}, {120, 121, 785570880}, {121, 125, 785570880}, {120, 122, 785570880}, {122, 125, 785570880}, {120, 123, 785570880}, {123, 125, 785570880}, {120, 124, 785570880}, {124, 125, 785570880}, {125, 126, 720521316}, {126, 130, 720521316}, {125, 127, 720521316}, {127, 130, 720521316}, {125, 128, 720521316}, {128, 130, 720521316}, {125, 129, 720521316}, {129, 130, 720521316}, {130, 131, 829375409}, {131, 132, 152165056}, {132, 133, 152165056}, {133, 134, 50370340}, {134, 137, 50370340}, {133, 135, 50370340}, {135, 137, 50370340}, {133, 136, 50370340}, {136, 137, 50370340}, {137, 138, 704034877}, {138, 139, 484468238}, {139, 143, 484468238}, {138, 140, 484468238}, {140, 143, 484468238}, {138, 141, 484468238}, {141, 143, 484468238}, {138, 142, 484468238}, {142, 143, 484468238}, {143, 144, 205433987}, {144, 145, 205433987}, {145, 146, 166956493}, {146, 149, 166956493}, {145, 147, 166956493}, {147, 149, 166956493}, {145, 148, 166956493}, {148, 149, 166956493}, {149, 150, 476307189}, {150, 151, 388217973}, {151, 152, 388217973}, {152, 153, 211490211}, {153, 155, 211490211}, {152, 154, 211490211}, {154, 155, 211490211}, {155, 156, 186981143}, {156, 160, 186981143}, {155, 157, 186981143}, {157, 160, 186981143}, {155, 158, 186981143}, {158, 160, 186981143}, {155, 159, 186981143}, {159, 160, 186981143}, {160, 161, 305206923}, {161, 166, 305206923}, {160, 162, 305206923}, {162, 166, 305206923}, {160, 163, 305206923}, {163, 166, 305206923}, {160, 164, 305206923}, {164, 166, 305206923}, {160, 165, 305206923}, {165, 166, 305206923}, {166, 167, 482432170}, {167, 171, 482432170}, {166, 168, 482432170}, {168, 171, 482432170}, {166, 169, 482432170}, {169, 171, 482432170}, {166, 170, 482432170}, {170, 171, 482432170}, {171, 172, 455923183}, {172, 177, 455923183}, {171, 173, 455923183}, {173, 177, 455923183}, {171, 174, 455923183}, {174, 177, 455923183}, {171, 175, 455923183}, {175, 177, 455923183}, {171, 176, 455923183}, {176, 177, 455923183}, {177, 178, 266584262}, {178, 179, 266584262}, {179, 180, 751579148}, {180, 185, 751579148}, {179, 181, 751579148}, {181, 185, 751579148}, {179, 182, 751579148}, {182, 185, 751579148}, {179, 183, 751579148}, {183, 185, 751579148}, {179, 184, 751579148}, {184, 185, 751579148}, {185, 186, 389984057}, {186, 188, 389984057}, {185, 187, 389984057}, {187, 188, 389984057}, {188, 189, 926312609}, {189, 192, 926312609}, {188, 190, 926312609}, {190, 192, 926312609}, {188, 191, 926312609}, {191, 192, 926312609}, {192, 193, 323360653}, {193, 196, 323360653}, {192, 194, 323360653}, {194, 196, 323360653}, {192, 195, 323360653}, {195, 196, 323360653}, {196, 197, 977934872}, {197, 198, 977934872}, {198, 199, 434009290}};
                {{0, 1, 865326231}, {1, 4, 865326231}, {0, 2, 865326231}, {2, 4, 865326231}, {0, 3, 865326231}, {3, 4, 865326231}, {4, 5, 647618270}, {5, 9, 647618270}, {4, 6, 647618270}, {6, 9, 647618270}, {4, 7, 647618270}, {7, 9, 647618270}, {4, 8, 647618270}, {8, 9, 647618270}, {9, 10, 153310768}, {10, 15, 153310768}, {9, 11, 153310768}, {11, 15, 153310768}, {9, 12, 153310768}, {12, 15, 153310768}, {9, 13, 153310768}, {13, 15, 153310768}, {9, 14, 153310768}, {14, 15, 153310768}, {15, 16, 446216658}, {16, 21, 446216658}, {15, 17, 446216658}, {17, 21, 446216658}, {15, 18, 446216658}, {18, 21, 446216658}, {15, 19, 446216658}, {19, 21, 446216658}, {15, 20, 446216658}, {20, 21, 446216658}, {21, 22, 482432125}, {22, 27, 482432125}, {21, 23, 482432125}, {23, 27, 482432125}, {21, 24, 482432125}, {24, 27, 482432125}, {21, 25, 482432125}, {25, 27, 482432125}, {21, 26, 482432125}, {26, 27, 482432125}, {27, 28, 546917635}, {28, 32, 546917635}, {27, 29, 546917635}, {29, 32, 546917635}, {27, 30, 546917635}, {30, 32, 546917635}, {27, 31, 546917635}, {31, 32, 546917635}, {32, 33, 905837683}, {33, 37, 905837683}, {32, 34, 905837683}, {34, 37, 905837683}, {32, 35, 905837683}, {35, 37, 905837683}, {32, 36, 905837683}, {36, 37, 905837683}, {37, 38, 941383964}, {38, 41, 941383964}, {37, 39, 941383964}, {39, 41, 941383964}, {37, 40, 941383964}, {40, 41, 941383964}, {41, 42, 482278242}, {42, 44, 482278242}, {41, 43, 482278242}, {43, 44, 482278242}, {44, 45, 209029963}, {45, 49, 209029963}, {44, 46, 209029963}, {46, 49, 209029963}, {44, 47, 209029963}, {47, 49, 209029963}, {44, 48, 209029963}, {48, 49, 209029963}, {49, 50, 180362920}, {50, 53, 180362920}, {49, 51, 180362920}, {51, 53, 180362920}, {49, 52, 180362920}, {52, 53, 180362920}, {53, 54, 40040617}, {54, 58, 40040617}, {53, 55, 40040617}, {55, 58, 40040617}, {53, 56, 40040617}, {56, 58, 40040617}, {53, 57, 40040617}, {57, 58, 40040617}, {58, 59, 429647103}, {59, 62, 429647103}, {58, 60, 429647103}, {60, 62, 429647103}, {58, 61, 429647103}, {61, 62, 429647103}, {62, 63, 863858638}, {63, 64, 250353988}, {64, 66, 250353988}, {63, 65, 250353988}, {65, 66, 250353988}, {66, 67, 502785687}, {67, 68, 565934645}, {68, 69, 548158326}, {69, 74, 548158326}, {68, 70, 548158326}, {70, 74, 548158326}, {68, 71, 548158326}, {71, 74, 548158326}, {68, 72, 548158326}, {72, 74, 548158326}, {68, 73, 548158326}, {73, 74, 548158326}, {74, 75, 858926247}, {75, 79, 858926247}, {74, 76, 858926247}, {76, 79, 858926247}, {74, 77, 858926247}, {77, 79, 858926247}, {74, 78, 858926247}, {78, 79, 858926247}, {79, 80, 610164528}, {80, 82, 610164528}, {79, 81, 610164528}, {81, 82, 610164528}, {82, 83, 116910438}, {83, 84, 153203278}, {84, 88, 153203278}, {83, 85, 153203278}, {85, 88, 153203278}, {83, 86, 153203278}, {86, 88, 153203278}, {83, 87, 153203278}, {87, 88, 153203278}, {88, 89, 484666281}, {89, 93, 484666281}, {88, 90, 484666281}, {90, 93, 484666281}, {88, 91, 484666281}, {91, 93, 484666281}, {88, 92, 484666281}, {92, 93, 484666281}, {93, 94, 694001013}, {94, 95, 180373702}, {95, 96, 392438425}, {96, 97, 392438425}, {97, 98, 915720722}, {98, 99, 915720722}, {99, 100, 660886218}, {100, 101, 980566840}, {101, 103, 980566840}, {100, 102, 980566840}, {102, 103, 980566840}, {103, 104, 509703517}, {104, 105, 817920401}, {105, 106, 992341639}, {106, 107, 992341639}, {107, 108, 180854348}, {108, 111, 180854348}, {107, 109, 180854348}, {109, 111, 180854348}, {107, 110, 180854348}, {110, 111, 180854348}, {111, 112, 699029750}, {112, 115, 699029750}, {111, 113, 699029750}, {113, 115, 699029750}, {111, 114, 699029750}, {114, 115, 699029750}, {115, 116, 973634138}, {116, 120, 973634138}, {115, 117, 973634138}, {117, 120, 973634138}, {115, 118, 973634138}, {118, 120, 973634138}, {115, 119, 973634138}, {119, 120, 973634138}, {120, 121, 785570880}, {121, 125, 785570880}, {120, 122, 785570880}, {122, 125, 785570880}, {120, 123, 785570880}, {123, 125, 785570880}, {120, 124, 785570880}, {124, 125, 785570880}, {125, 126, 720521316}, {126, 130, 720521316}, {125, 127, 720521316}, {127, 130, 720521316}, {125, 128, 720521316}, {128, 130, 720521316}, {125, 129, 720521316}, {129, 130, 720521316}, {130, 131, 829375409}, {131, 132, 152165056}, {132, 133, 152165056}, {133, 134, 50370340}, {134, 137, 50370340}, {133, 135, 50370340}, {135, 137, 50370340}, {133, 136, 50370340}, {136, 137, 50370340}, {137, 138, 704034877}, {138, 139, 484468238}, {139, 143, 484468238}, {138, 140, 484468238}, {140, 143, 484468238}, {138, 141, 484468238}, {141, 143, 484468238}, {138, 142, 484468238}, {142, 143, 484468238}, {143, 144, 205433987}, {144, 145, 205433987}, {145, 146, 166956493}, {146, 149, 166956493}, {145, 147, 166956493}, {147, 149, 166956493}, {145, 148, 166956493}, {148, 149, 166956493}, {149, 150, 476307189}, {150, 151, 388217973}, {151, 152, 388217973}, {152, 153, 211490211}, {153, 155, 211490211}, {152, 154, 211490211}, {154, 155, 211490211}, {155, 156, 186981143}, {156, 160, 186981143}, {155, 157, 186981143}, {157, 160, 186981143}, {155, 158, 186981143}, {158, 160, 186981143}, {155, 159, 186981143}, {159, 160, 186981143}, {160, 161, 305206923}, {161, 166, 305206923}, {160, 162, 305206923}, {162, 166, 305206923}, {160, 163, 305206923}, {163, 166, 305206923}, {160, 164, 305206923}, {164, 166, 305206923}, {160, 165, 305206923}, {165, 166, 305206923}, {166, 167, 482432170}, {167, 171, 482432170}, {166, 168, 482432170}, {168, 171, 482432170}, {166, 169, 482432170}, {169, 171, 482432170}, {166, 170, 482432170}, {170, 171, 482432170}, {171, 172, 455923183}, {172, 177, 455923183}, {171, 173, 455923183}, {173, 177, 455923183}, {171, 174, 455923183}, {174, 177, 455923183}, {171, 175, 455923183}, {175, 177, 455923183}, {171, 176, 455923183}, {176, 177, 455923183}, {177, 178, 266584262}, {178, 179, 266584262}, {179, 180, 751579148}, {180, 185, 751579148}, {179, 181, 751579148}, {181, 185, 751579148}, {179, 182, 751579148}, {182, 185, 751579148}, {179, 183, 751579148}, {183, 185, 751579148}, {179, 184, 751579148}, {184, 185, 751579148}, {185, 186, 389984057}, {186, 188, 389984057}, {185, 187, 389984057}, {187, 188, 389984057}, {188, 189, 926312609}, {189, 192, 926312609}, {188, 190, 926312609}, {190, 192, 926312609}, {188, 191, 926312609}, {191, 192, 926312609}, {192, 193, 323360653}, {193, 196, 323360653}, {192, 194, 323360653}, {194, 196, 323360653}, {192, 195, 323360653}, {195, 196, 323360653}, {196, 197, 977934872}, {197, 198, 977934872}, {198, 199, 434009290}};
//                {{0, 1, 1000000000},{0, 3, 1000000000},{1, 3, 1000000000},{1, 2, 1000000000},{1, 5, 1000000000},{3, 4, 1000000000},{4, 5, 1000000000},{2, 5, 1000000000}};
        System.out.println(countPaths(n, roads));*/

        /*Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(1);
        queue.add(13);
        queue.add(33);
        queue.add(90);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);*/

        /*int n = 10;
        System.out.println(generate(n));*/

        /*
        System.out.println(~1);
        */

        /*String s = "tree";
        System.out.println(frequencySort(s));*/

        /*
        IntStream.range(1, 20)
                .filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x))
                        .noneMatch(y -> x % y == 0))
                .forEach(System.out::println);
        */

        /* String s1 = "krishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishna";
        String s2 = "akrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishnakrishn";

        for (int i = 0; i < 10; i++) {
            long t1 = System.nanoTime();
            boolean res = isAnagram(s1, s2);
            long t2 = System.nanoTime();
            if (res) System.out.println("Iteration :" + i + " -- " + (t2 - t1));

            //Traditional
            long t3 = System.nanoTime();
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            res = String.valueOf(arr1).equals(String.valueOf(arr2));
            long t4 = System.nanoTime();
            if (res) System.out.print("Iteration :" + i + " -- " + (t4 - t3));
            System.out.println();
        }*/

        /*int[] nums = {8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290};
        System.out.println(mostFrequentEvenElement(nums));*/

        /*String inputString = "abcdefghijklmno";
        generateAllSubStrings(inputString).forEach(System.out::println);*/

        /*int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        generateAllSubArrays(arr).forEach(System.out::println);
         */

        /*
        int[] nums =
                {-1, -2, -3, 1, 2, 3};
//                {-1, 1};
        System.out.println(Arrays.toString(rearrangeArray(nums)));

         */

        /*int[][] sp = {
                {1, 2, 3, 12},
                {4, 5, 6, 45},
                {7, 8, 9, 67},
        };
        printSpiralMatrix(sp);*/

        /*
        //Bitwise AND of Numbers Range
        //int left = 1, right = 2147483647;
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));*/

        /*String str = "0123";
        System.out.println(prepareSubSet(str));*/

        TreeNode root = new TreeNode();
        printLevelOrderTraversal(root);
    }

    private static void printLevelOrderTraversal(TreeNode root) {
        if (root != null) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode currNode = queue.poll();
                System.out.println(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

        }
    }

    private static List<String> prepareSubSet(String str) {
        int index = 1;
        int n = str.length();
        while (index < n) {
            System.out.println(str.substring(0, index) + " == " + str.substring(index, n));
            index++;
        }
        return null;
    }

    private static int rangeBitwiseAnd(int left, int right) {
        /*int next = left + 1;
        while (next < right) {
            left = left & next;
            next++;
        }
        return left;*/
        for (int i = 0; i < (Math.log(right) / Math.log(2)) + 1; i++) {
            if (right <= left) {
                return right;
            }
            if ((right & (1 << i)) != 0) {
                right &= ~(1 << i);
            }
        }
        return right;
    }

    private static void printSpiralMatrix(int[][] sp) {


        int m = sp.length;
        int n = sp[0].length;
        int totalElements = m * n;
        int minCol = 0;
        int minRow = 0;
        int maxCol = n - 1;
        int maxRow = m - 1;

        while (totalElements > 0) {
            for (int i = minCol; i <= maxCol && totalElements > 0; i++) {
                System.out.print(sp[minRow][i] + " ");
                totalElements--;
            }
            minRow++;
            for (int i = minRow; i <= maxRow && totalElements > 0; i++) {
                System.out.print(sp[i][maxCol] + " ");
                totalElements--;
            }
            maxCol--;
            for (int i = maxCol; i >= minCol && totalElements > 0; i--) {
                System.out.print(sp[maxRow][i] + " ");
                totalElements--;
            }
            maxRow--;
            for (int i = maxRow; i >= minRow && totalElements > 0; i--) {
                System.out.print(sp[i][minCol] + " ");
                totalElements--;
            }
            minCol++;
        }


    }

    private static int[] rearrangeArray(int[] nums) {
        /*List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int ele : nums) {
            if (ele > 0) positive.add(ele);
            if (ele < 0) negative.add(ele);
        }

        int idx = 0;
        int idx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positive.get(idx);
                idx++;
            } else {
                nums[i] = negative.get(idx2);
                idx2++;
            }
        }

        return nums;*/
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0;
        int neg = 1;
        for (int ele : nums) {
            if (pos < n && ele > 0) {
                ans[pos] = ele;
                pos += 2;
            } else if (neg < n) {
                ans[neg] = ele;
                neg += 2;
            }
        }
        return ans;
    }

    private static List<List<Integer>> generateAllSubArrays(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> sublist = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    sublist.add(arr[k]);
                }
                ans.add(sublist);
            }
        }
        return ans;
    }

    private static List<String> generateAllSubStrings(String inputString) {
        List<String> ans = new ArrayList<>();
        int n = inputString.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                ans.add(inputString.substring(i, j));
            }
        }
        return ans;
    }

    private static int mostFrequentEvenElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            if (ele % 2 == 0) map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        var o = map.entrySet().stream().sorted((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) return a.getKey().compareTo(b.getKey());
            else return b.getValue().compareTo(a.getValue());
        }).collect(Collectors.toList());

        System.out.println(o);

        o.get(0).getValue();

        return 0;
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] freq = new int[26];
        int i = s1.length() - 1;
        while (i >= 0) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
            i--;
        }
        for (int ele : freq) {
            if (ele != 0) return false;
        }
        return true;
    }

    public int[] frequencySortAg(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        var output = freqMap.entrySet().stream().sorted((a, b) -> {
                    if (Objects.equals(a.getValue(), b.getValue())) return b.getValue() - a.getValue();
                    else return a.getValue() - b.getValue();
                })
                .toList();

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : output) {
            int val = entry.getValue();
            while (val > 0) {
                nums[i++] = entry.getKey();
                val--;
            }
        }

        return nums;
    }

    private static String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        var output = freqMap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).collect(Collectors.toList());

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : output) {
            int val = entry.getValue();
            while (val > 0) {
                ans.append(entry.getKey());
                val--;
            }
        }
        return ans.toString();
    }

    private int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] != val) return nums.length;
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (i < n && j < n) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
            i++;
        }
        return j;
    }

    private static ArrayList<String> generate(int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");
        for (int i = 1; i <= n; i++) {
            String topElement = queue.poll();
            ans.add(topElement);
            queue.add(topElement + "0");
            queue.add(topElement + "1");
        }
        return ans;
    }

    private static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int front = q.poll();
        reverseQueue(q);
        q.add(front);
    }

    private static int countPaths(int n, int[][] roads) {
        long MOD = (int) 1e9 + 7;
        long[] dist = new long[n];
        long[] ways = new long[n];
        //Bi-directional Adj-list
        List<List<Pair>> adjlist = prepareAdjList(roads, n);

        Pair startNode = new Pair(0, 0);
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(Pair::getDist));
        pq.add(startNode);

        //Initially distance array will have +Infinity as distance
        Arrays.fill(dist, Long.MAX_VALUE);
        //Distance from starting node is always zero
        dist[0] = 0;
        //Ways to arrive at zero node is 1;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            long currDist = currPair.getDist();
            long currNode = currPair.getNode();

            for (Pair neigh : adjlist.get((int) currNode)) {
                long neighDist = neigh.getDist();
                long neighNode = neigh.getNode();

                long newDist = (currDist + neighDist);
                if (newDist < dist[(int) neighNode]) {
                    dist[(int) neighNode] = newDist;
                    pq.add(new Pair(newDist, neighNode));
                    ways[(int) neighNode] = ways[(int) currNode];
                } else if (newDist == dist[(int) neighNode]) {
                    ways[(int) neighNode] = (ways[(int) neighNode] + ways[(int) currNode]) % MOD;
                }
            }
        }
        return (int) ways[n - 1];
    }

    private static List<List<Pair>> prepareAdjList(int[][] roads, int n) {
        List<List<Pair>> ans = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> ans.add(new ArrayList<>()));

        //Preparing AdjList
        for (int[] road : roads) {
            Pair pair = new Pair(road[2], road[1]);
            ans.get(road[0]).add(pair);
            Pair pair1 = new Pair(road[2], road[0]);
            ans.get(road[1]).add(pair1);
        }
        return ans;
    }

    private static String minWindowOptimal(String s, String t) {
        int[] map = new int[123];
        int left = 0, right = 0, count = t.length(), sub_len = Integer.MAX_VALUE, start = 0;

        for (char c : t.toCharArray()) map[c]++;

        char[] ch = s.toCharArray();
        while (right < s.length()) {
            if (map[ch[right++]]-- > 0) count--;
            while (count == 0) {
                if ((right - left) < sub_len) sub_len = right - (start = left);
                if (map[ch[left++]]++ == 0) count++;
            }
        }
        return sub_len == Integer.MAX_VALUE ? "" : s.substring(start, start + sub_len);
    }

    private static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        IntStream.range(0, n).forEach(i -> tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1));

        String ans = "";
        int matchCount = 0;
        int i = -1;
        int j = -1;
        Map<Character, Integer> sMap = new HashMap<>();

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;

            //Acquire
            while (i < m - 1 && matchCount < n) {
                i++;
                char c = s.charAt(i);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (sMap.getOrDefault(c, 0) <= tMap.getOrDefault(c, 0)) {
                    matchCount++;
                }
                flag1 = true;
            }
            //Collect & Release
            while (j < i && matchCount == n) {
                String pAns = s.substring(j + 1, i + 1);
                if (ans.isEmpty() || pAns.length() < ans.length()) {
                    ans = pAns;
                }
                j++;
                char jChar = s.charAt(j);
                if (sMap.containsKey(jChar)) {
                    if (sMap.get(jChar) == 1) sMap.remove(jChar);
                    else sMap.put(jChar, sMap.get(jChar) - 1);
                }

                if (sMap.getOrDefault(jChar, 0) < tMap.getOrDefault(jChar, 0)) {
                    matchCount--;
                }
                flag2 = true;
            }

            if (!flag1 && !flag2) break;
        }
        return ans;
    }

    private static boolean isContainsT(String incomingStr, String target, Map<Character, Integer> tFreq) {
        Map<Character, Integer> freqMap = new HashMap<>();
        IntStream.range(0, incomingStr.length()).forEach(i -> freqMap.put(incomingStr.charAt(i), freqMap.getOrDefault(incomingStr.charAt(i), 0) + 1));

        for (char c : target.toCharArray()) {
            if (!Objects.equals(freqMap.get(c), tFreq.get(c))) {
                return false;
            }
        }
        return true;
    }

    private static int convertBinToInt(String num, int index, int ans) {
        if (index < 0) {
            return ans;
        }
        int currChar = num.charAt(index) == '0' ? 0 : 1;
        ans += (int) (currChar * (Math.pow(2, (num.length() - 1 - index))));
        return convertBinToInt(num, index - 1, ans);
    }

    public static String triangleType(int[] nums) {

        Arrays.sort(nums);

        if (nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0]) {
            if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
            else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) return "isosceles";
            else return "scalene";
        } else {
            return "none";
        }
    }

    private static int minimumBeautifulSubstrings(String str) {
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String s = str.substring(i, j);
                if (!s.isBlank() && s.charAt(0) != 0) {
                    int k = convertBinToInt(s, s.length() - 1, 0);
                    if (isPowerOf5(k)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isPowerOf5(int k) {
        int curr = 1;
        while (curr <= k) {
            curr *= 5;
        }
        return curr == k;
    }

    private static String convertIntToBinStringIterative(int num, StringBuilder sb) {
        while (num != 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    private static String convertIntToBinStringRecursive(int num, StringBuilder sb) {
        if (num == 0) {
            return sb.reverse().toString();
        }
        sb.append(num % 2);
        return convertIntToBinStringRecursive(num / 2, sb);
    }

    private static int[] removeInPlaceDuplicates(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return arr;
    }

    private static void rSrt(int[] arr) {
        int maxEle = Integer.MIN_VALUE;
        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
        }
        int exponent = 1;

        while (exponent < maxEle) {
            countingSorting(arr, exponent);
            exponent *= 10;
        }

    }

    private static void countingSorting(int[] arr, int exponent) {
        int[] freq = new int[10];

        //FreqArray
        for (int ele : arr) {
            freq[ele / exponent % 10]++;
        }

        //Prefix sum
        IntStream.range(1, freq.length).forEach(i -> freq[i] = freq[i] + freq[i - 1]);

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freq[arr[i] / exponent % 10] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freq[arr[i] / exponent % 10]--;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    private static void cSrt(int[] arr) {
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;

        for (int ele : arr) {
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);
        }

        //FreqArray
        int[] freq = new int[maxEle - minEle + 1];
        for (int ele : arr) {
            freq[ele - minEle]++;
        }

        //Create prefix sum
        IntStream.range(1, freq.length).forEach(i -> freq[i] = freq[i] + freq[i - 1]);

        int[] ans = new int[arr.length];
        //Iterate from back to effectively sort elements
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = freq[arr[i] - minEle] - 1;
            if (index >= 0) {
                ans[index] = arr[i];
                freq[arr[i] - minEle]--;
            }
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);

    }

    private static void sSrt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                sp(i, minPos, arr);
            }
        }
    }

    private static void iSrt(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int minVal = arr[i];
            while (j >= 0 && arr[j] > minVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = minVal;
        }
    }

    private static void mSrt(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[arr.length - mid];

        IntStream.range(0, mid).forEach(i -> firstHalf[i] = arr[i]);
        IntStream.range(mid, arr.length).forEach(i -> secondHalf[i - mid] = arr[i]);

        mSrt(firstHalf);
        mSrt(secondHalf);

        mCh(firstHalf, secondHalf, arr);
    }

    private static void mCh(int[] firstHalf, int[] secondHalf, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] < secondHalf[j]) arr[k++] = firstHalf[i++];
            else arr[k++] = secondHalf[j++];
        }
        while (i < firstHalf.length) {
            arr[k++] = firstHalf[i++];
        }
        while (j < secondHalf.length) {
            arr[k++] = secondHalf[j++];
        }
    }

    private static void qSrt(int[] arr) {
        qSrt(arr, 0, arr.length - 1);
    }

    private static void qSrt(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && pivot > arr[leftPointer]) leftPointer++;
            while (leftPointer < rightPointer && pivot <= arr[rightPointer]) rightPointer--;
            sp(leftPointer, rightPointer, arr);
        }
        sp(leftPointer, highIndex, arr);

        qSrt(arr, lowIndex, leftPointer - 1);
        qSrt(arr, leftPointer + 1, highIndex);
    }

    private static void sp(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}