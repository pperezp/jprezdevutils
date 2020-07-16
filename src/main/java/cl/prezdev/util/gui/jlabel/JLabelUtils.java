package cl.prezdev.util.gui.jlabel;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

public class JLabelUtils {
    public static void applyStrikeThrough(JLabel jLabel){
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
    
    public static void takeOutStrikeThrough(JLabel jLabel) {
        jLabel.setFont(new Font("Dialog", 1, 12));
    }
}
