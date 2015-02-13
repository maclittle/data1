package data1;

public interface FiniteSet {
    
    //Returns a fresh empty FiniteSet
    FiniteSet empty();
    
    //Returns the number of elements in FiniteSet t
    int cardinality(FiniteSet t);
    
    //Determines if the FiniteSet t is empty
    boolean isEmptyHuh(FiniteSet t);
    
    //Determines if elt is in FiniteSet t
    boolean member(int elt);
    
    //Returns a FiniteSet containing elt and everything in t
    FiniteSet add(int elt);
    
    //Returns a FiniteSet containing everything in t except elt
    FiniteSet remove(int elt);
    
    //Returns a FiniteSet containing everything in t and u
    FiniteSet union(FiniteSet u);
    
    //Returns a FiniteSet containing everything in both t and u
    FiniteSet inter(FiniteSet u);
    
    //Returns a FiniteSet containing everything in u except those in t
    FiniteSet diff(FiniteSet u);
    
    //Determines if FiniteSets t and u contain the same elements
    boolean equal(FiniteSet u);
    
    //Determines if t is a subset of u
    boolean subset(FiniteSet u);
    
}
