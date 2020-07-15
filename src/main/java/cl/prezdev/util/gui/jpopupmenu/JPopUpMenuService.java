package cl.prezdev.util.gui.jpopupmenu;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.SwingUtilities;

public class JPopUpMenuService {

    private JPopupMenu jPopupMenu;
    private JComponent jComponent;

    public JPopUpMenuService(JComponent component) {
        this.jPopupMenu = new JPopupMenu();
        this.jComponent = component;

        this.jComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                    Point locationOnScreen = mouseEvent.getPoint();

                    jPopupMenu.setLocation(mouseEvent.getPoint());

                    jPopupMenu.show(
                            jComponent,
                            locationOnScreen.x,
                            locationOnScreen.y
                    );
                }
            }
        });
    }

    public void addOption(String optionText, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(optionText);
        jMenuItem.addActionListener(actionListener);

        this.jPopupMenu.add(jMenuItem);
    }

    public void addSeparator() {
        this.jPopupMenu.add(new Separator());
    }
}
