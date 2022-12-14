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


    public Task2(ShapeModel model) {
        super(model);

    }

    @Override
    public void update(ShapeModelEvent event) {
        if(event.eventType() == ShapeModelEvent.EventType.ShapeMoved){
            return;
        }


        int[] childIndices = new int[1];
        childIndices[0] = event.index();
        Object[] child = new Object[]{event.operand()};



        TreeModelEvent treeModelEvent = new TreeModelEvent(event.source(), event.parent().path().toArray(), childIndices, child);


        for (TreeModelListener l : treeListeners) {
            if(event.eventType() == ShapeModelEvent.EventType.ShapeAdded ){
                l.treeNodesInserted(treeModelEvent);

            }else if(event.eventType() == ShapeModelEvent.EventType.ShapeRemoved){
                l.treeNodesRemoved(treeModelEvent);
            }

        }




    }



}
