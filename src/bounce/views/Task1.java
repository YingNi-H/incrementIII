package bounce.views;

import bounce.NestingShape;
import bounce.Shape;
import bounce.ShapeModel;
import bounce.ShapeModelListener;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 * TODO Complete this class to display a ShapeModel's shape composition on the JTree
 */
public class Task1 implements TreeModel {

    private ShapeModel treeAdaptee;
    NestingShape nestingShape;
    List<TreeModelListener> treeListeners;



    public Task1(ShapeModel shapeModel) {
        this.treeAdaptee = shapeModel;
        this.nestingShape = shapeModel.root();
        this.treeListeners = new ArrayList<>();

    }

    @Override
    public Object getRoot() {
        return nestingShape;
    }

    @Override
    public Object getChild(Object parent, int index) {

        if(parent instanceof NestingShape && (index >= 0 && index < ((NestingShape) parent).shapeCount()) ){
            return ((NestingShape) parent).shapeAt(index);
        }else{
            return null;
        }

    }

    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof NestingShape){
            return ((NestingShape) parent).shapeCount();
        }else{
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        if(node instanceof NestingShape){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof NestingShape ){
            return ((NestingShape)parent).indexOf((Shape)child);

        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        this.treeListeners.add(l);

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        this.treeListeners.remove(l);

    }
}


