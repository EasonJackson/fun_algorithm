/**
 * Created by easonjackson on 1/15/18.
 */
public class SegmentTreeNodePrototype {

    public int start;
    public int end;
    public int value;
    public SegmentTreeNodePrototype leftNode;
    public SegmentTreeNodePrototype rightNode;

    public SegmentTreeNodePrototype(int start,
                                    int end,
                                    int value) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    @Override
    public String toString() {
        return "Interval: " + this.start + ":" + this.end + ", value: " + this.value;
    }

}
