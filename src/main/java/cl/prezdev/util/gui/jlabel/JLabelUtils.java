package cl.prezdev.util.gui.jlabel;

import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

// https://docs.oracle.com/javase/7/docs/api/java/awt/font/TextAttribute.html
public class JLabelUtils {
    public static void applyStrikeThrough(JLabel jLabel){
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, true);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
    
    public static void takeOutStrikeThrough(JLabel jLabel) {
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, false);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
    
    public static void changeFontSize(JLabel jLabel, Integer fontSize){
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.SIZE, fontSize);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
    
    public static void setItalic(JLabel jLabel) {
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
    
    public static void removeItalic(JLabel jLabel) {
        Map attributes = jLabel.getFont().getAttributes();
        attributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_REGULAR);
        jLabel.setFont(jLabel.getFont().deriveFont(attributes));
    }
}
