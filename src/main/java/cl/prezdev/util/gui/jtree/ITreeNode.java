package cl.prezdev.util.gui.jtree;

import javax.swing.tree.TreeNode;

public interface ITreeNode<T> extends TreeNode {

    T addChild(T t);

    T removeChild(T t);

    T removeMyself();
}
