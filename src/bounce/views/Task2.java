package bounce.views;

import bounce.*;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

/*
 * TODO Complete this class to have a functioning Bounce application
 */
public class Task2 extends Task1 implements ShapeModelListener {

    private ShapeModel adaptee2;

    private List<ShapeModelListener> listeners;



    public Task2(ShapeModel model) {
        super(model);
        this.adaptee2 = model;
        this.listeners = new ArrayList<>();
    }

    @Override
    public void update(ShapeModelEvent event) {
        int[] childIndices = new int[1];
        childIndices[0] = event.index();

        TreeModelEvent treeModelEvent = new TreeModelEvent(adaptee2, event.operand().path().toArray());

//        , childIndices, event.operand()

        for (TreeModelListener l : treeListeners) {
            if(event.eventType() == ShapeModelEvent.EventType.ShapeAdded ){
                l.treeNodesInserted(treeModelEvent);

            }else if(event.eventType() == ShapeModelEvent.EventType.ShapeRemoved){
                l.treeNodesRemoved(treeModelEvent);
            }




        }




    }



}
