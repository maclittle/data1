package data1;

import java.util.Random;

public class Tests {

    public static FiniteSet randomFiniteSet(int size, int max) {
        FiniteSet randomSet = new Leaf();
        int r = (int) (size * Math.random());
        for (int i = 0; i < r; i++) {
            randomSet = randomSet.add((int) (max * (Math.random() - .5)));
        }
        return randomSet;
    }

    // Tests whether the size of the union of two FiniteSets is equal to the sum
    // of the sizes of each set minus the size of the intersection
    // - This is a test of union, inter, and cardinality
    public static boolean unionTest(FiniteSet t, FiniteSet u) {
        int unionSize = t.union(u).cardinality();
        return (unionSize == (t.cardinality() + u.cardinality()
                - t.inter(u).cardinality()));
    }

    // Tests whether the intersection of two FiniteSets is a subset of one of
    // the FiniteSets
    // - This is a test of inter and subset
    public static boolean interTest(FiniteSet t, FiniteSet u){
        return (t.inter(u).subset(t));
    }
    

    public static void main(String[] args) {
        // FiniteSet example
        FiniteSet bot = new Leaf();
        FiniteSet f1 = new Branch(bot, 1, bot);
        FiniteSet f4 = new Branch(bot, 4, bot);
        FiniteSet f3 = new Branch(f1, 3, f4);
        FiniteSet f7 = new Branch(bot, 7, bot);
        FiniteSet f9 = new Branch(bot, 9, bot);
        FiniteSet f8 = new Branch(f7, 8, f9);
        FiniteSet f5 = new Branch(f3, 5, f8);

        //Individual Tests
        System.out.println("The cardinality of f5 is: " + f5.cardinality()
                + ". This should have been 7.");
        System.out.println("The cardinality of bot is: " + bot.cardinality()
                + ". This should have been 0.");
        System.out.println("isEmptyHuh of f5: " + f5.isEmptyHuh()
                + ". This should have been false.");
        System.out.println("isEmptyHuh of bot: " + bot.isEmptyHuh()
                + ". This should have been true.");
        System.out.println("3 is a member of f5: " + f5.member(3)
                + ". This should have been true.");
        System.out.println("6 is a member of f4: " + f4.member(6)
                + ". This should have been false.");
        System.out.println("Adding 2 to f3: " + f3.add(2)
                + ". This should have been {1 2 3 4}.");
        System.out.println("Adding 8 to f8: " + f8.add(8)
                + ". This should have been {7 8 9}");

        int size = 10;
        int max = 25;

        // Random Tests
        
        //Runs unionTest 100 times with random sets
        for (int i = 0; i < 100; i++) {
            FiniteSet set1 = (randomFiniteSet(size, max));
            FiniteSet set2 = (randomFiniteSet(size, max));
            if (!unionTest(set1, set2)) {
                System.out.println("unionTest has failed on sets " + set1
                        + " , " + set2);
            }
        }
        
        //Runs unionTest 100 times with random sets
        for (int i = 0; i < 100; i++) {
            FiniteSet set1 = (randomFiniteSet(size, max));
            FiniteSet set2 = (randomFiniteSet(size, max));
            if (!unionTest(set1, set2)) {
                System.out.println("unionTest has failed on sets " + set1
                        + " , " + set2);
            }
        }
        
        //Runs interTest 100 times with random sets
        for (int i = 0; i < 100; i++) {
            FiniteSet set1 = (randomFiniteSet(size, max));
            FiniteSet set2 = (randomFiniteSet(size, max));
            if (!interTest(set1, set2)) {
                System.out.println("interTest has failed on sets " + set1
                        + " , " + set2);
            }
        }

        
    }