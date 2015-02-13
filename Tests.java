package data1;


public class Tests {
    public static void main(String[] args){
        System.out.println("FiniteSet tests go here");
    }
    
    // FiniteSet example
    FiniteSet bot = new Leaf();
    FiniteSet f1 = new Branch(bot, 1, bot);
    FiniteSet f4 = new Branch(bot, 4, bot);
    FiniteSet f3 = new Branch(f1, 3, f4);
    FiniteSet f7 = new Branch(bot, 7, bot);
    FiniteSet f9 = new Branch(bot, 9, bot);
    FiniteSet f8 = new Branch(f7, 8, f9);
    FiniteSet f5 = new Branch(f3, 5, f8);
    
}