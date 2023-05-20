package app.excercise.visualtree;// This class was created by PaintableToast

public interface DrawableTreeElement<T> {
    public DrawableTreeElement<T> getLeft();
    public DrawableTreeElement<T> getRight();
    public boolean isRed();
    public T getValue();
}
