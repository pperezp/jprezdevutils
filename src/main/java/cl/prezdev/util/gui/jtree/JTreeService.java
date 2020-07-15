package cl.prezdev.util.gui.jtree;

import javax.swing.JTree;

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
        jtree.expandPath(jtree.getSelectionPath());
    }

    public void updateUI() {
        jtree.updateUI();
    }
}
