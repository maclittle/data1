package data1;
import java.util.Random;

public class Branch implements FiniteSet {

    FiniteSet left;
    int key;
    FiniteSet right;

    Branch(FiniteSet left, int key, FiniteSet right) {
        this.left = left;
        this.key = key;
        this.right = right;
    }

    public String toString() {
        return "new Branch("
                + this.left + ", "
                + this.key + ", "
                + this.right + ")";
    }

    public FiniteSet empty() {
        return new Leaf();
    }

    public int cardinality() {
        return this.left.cardinality() + 1 + this.right.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public boolean member(int elt) {
        if (this.key == elt) {
            return true;
        } else if (this.key > elt) {
            return this.left.member(elt);
        } else {
            return this.right.member(elt);
        }
    }

    public FiniteSet add(int elt) {
        if (this.key == elt) {
            return this;
        } else if (this.key > elt) {
            return new Branch(this.left.add(elt), this.key, this.right);
        } else {
            return new Branch(this.left, this.key, this.right.add(elt));
        }
    }

    public FiniteSet remove(int elt) {
        if (this.key == elt) {
            return this.left.union(this.right);
        } else if (this.key > elt) {
            return new Branch(this.left.remove(elt), this.key, this.right);
        } else {
            return new Branch(this.left, this.key, this.right.remove(elt));
        }
    }

    public FiniteSet union(FiniteSet u) {
        return this.left.union(this.right).union(u).add(this.key);
    }

    public FiniteSet inter(FiniteSet u) {
        if (!(u.member(this.key))) {
            return remove(this.key).inter(u);
        } else {
            return new Branch(this.left.inter(u), this.key,
                    this.right.inter(u));
        }
    }

    public FiniteSet diff(FiniteSet u) {
        return (this.remove(this.key).diff(u.remove(this.key)));
    }

    public boolean equal(FiniteSet u) {
        return ((this.subset(u)) && (u.subset(this)));

    }

    public boolean subset(FiniteSet u) {
        if ((u.member(this.key)) == true) {
            return ((this.left.subset(u)) || (this.right.subset(u)));
        } else {
            return false;
        }
    }

 
    // Tests if y is a member of the FiniteSet with x added, if also either x=y
    // or y is a member of the FiniteSet without x
    // - This is a test of member and add
    public boolean memberTest(int x, int y){
       return ((this.add(x).member(y)) &&
                ((x ==y) || (this.member(y))));
    }
    
}
