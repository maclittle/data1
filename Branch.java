package data1;

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

    public int cardinality(FiniteSet t) {
        return cardinality(this.left) + 1 + cardinality(this.right);
    }

    public boolean isEmptyHuh(FiniteSet t) {
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
            return new Branch(this.left.add(elt), elt, this.right);
        } else {
            return new Branch(this.left, elt, this.right.add(elt));
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
}
