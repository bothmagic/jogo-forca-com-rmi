package utils.fileChooser;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePreview extends JComponent implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private ImageIcon thumbnail;
	private File file;

	public ImagePreview(JFileChooser fc) {
		setPreferredSize(new Dimension(180, 100));
		fc.addPropertyChangeListener(this);
                fc.setFileFilter(new FileNameExtensionFilter("Imagem JPG", "jpg"));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public void loadImage() {
		if (file == null) {
			thumbnail = null;
			return;
		}
		ImageIcon tmpIcon = new ImageIcon(file.getPath());
		if (tmpIcon != null) {
			if (tmpIcon.getIconWidth() > 140) {
				thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(
						140, -1, Image.SCALE_SMOOTH));
			} else {
				thumbnail = tmpIcon;
			}
		}
	}

	public void propertyChange(PropertyChangeEvent e) {
		boolean update = false;
		String prop = e.getPropertyName();
		if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)) {
			file = null;
			update = true;
		} else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
			file = (File) e.getNewValue();
			update = true;
		}
		if (update) {
			thumbnail = null;
			if (isShowing()) {
				repaint();
			}
		}
	}

	protected void paintComponent(Graphics g) {
		if (thumbnail == null) {
			loadImage();
		}
		if (thumbnail != null) {
			int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
			int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;

			if (y < 0) {
				y = 0;
			}

			if (x < 5) {
				x = 5;
			}
			thumbnail.paintIcon(this, g, x, y);
		}
	}

}
