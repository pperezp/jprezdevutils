package cl.prezdev.util.gui.jtree;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.KeyAdapter;

public class JTreeService<T extends ITreeNode> {

    private JTree jtree;

    public JTreeService(JTree jtree) {
        this.jtree = jtree;
    }

    public void addNodeToSelectedNode(Object object) {
        T selectedNode = getSelectedNode();

        if (selectedNode != null) {
            selectedNode.addChild(object);
            expandSelectedNode();
            updateUI();
        }
    }

    public void removeSelectedNode() {
        T selectedNode = getSelectedNode();

        selectedNode.removeMyself();
        updateUI();
    }

    public T getSelectedNode() {
        return (T) jtree.getLastSelectedPathComponent();
    }

    public void expandSelectedNode() {
        expand(jtree.getSelectionPath());
    }

    private void expand(TreePath selectionPath) {
        jtree.expandPath(selectionPath);
    }

    public void updateUI() {
        jtree.updateUI();
    }
    
    public JTree getJtree(){
        return this.jtree;
    }
    
    public TreeModel getTreeModel(){
        return this.jtree.getModel();
    }

    public void expandAllNodes(){
        for (int i = 0; i < jtree.getRowCount(); i++) {
            jtree.expandRow(i);
        }
    }

    public void addKeyAdapter(KeyAdapter keyAdapter){
        this.jtree.addKeyListener(keyAdapter);
    }

    public boolean isSomeNodeSelected(){
        return getSelectedNode() != null;
    }
}
