package finitesets;

public interface FiniteSet {
    
    //Returns a fresh empty FiniteSet
    FiniteSet empty();
    
    //Returns the number of elements in FiniteSet t
    int cardinality(FiniteSet t);
    
    //Determines if the FiniteSet t is empty
    boolean isEmptyHuh(FiniteSet t);
    
    //Determines if elt is in FiniteSet t
    boolean member(FiniteSet t, int elt);
    
    //Returns a FiniteSet containing elt and everything in t
    FiniteSet add(FiniteSet t, int elt);
    
    //Returns a FiniteSet containing everything in t except elt
    FiniteSet remove(FiniteSet t, int elt);
    
    //Returns a FiniteSet containing everything in t and u
    FiniteSet union(FiniteSet t, FiniteSet u);
    
    //Returns a FiniteSet containing everything in both t and u
    FiniteSet inter(FiniteSet t, FiniteSet u);
    
    //Returns a FiniteSet containing everything in u except those in t
    FiniteSet diff(FiniteSet t, FiniteSet u);
    
    //Determines if FiniteSets t and u contain the same elements
    boolean equal(FiniteSet t, FiniteSet u);
    
    //Determines if t is a subset of u
    boolean subset(FiniteSet t, FiniteSet u);
    
}
