package benjaminc.chef_leveldesigner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import benjaminc.chef_simulator.rooms.Room;
import benjaminc.chef_textures.dialog.AreYouSureDialog;
import benjaminc.chef_textures.dialog.AreYouSureDialogRunnable;
import benjaminc.chef_textures.dialog.MessageDialog;

/**
 * @author Benjamin-C
 *
 */
public class LevelDesignerMenuBar extends JMenuBar {

	/** */ private static final long serialVersionUID = 7732631958665016458L;
	
	public Room room;
	
	public LevelDesignerMenuBar(Room r) {
		super();
		
		room = r;
		
		JFileChooser fc = new JFileChooser();
		
		JMenu fileMenu = new JMenu("File"); fileMenu.setMnemonic('f'); this.add(fileMenu);
		JMenuItem loadMenuItem = new JMenuItem("Open", KeyEvent.VK_D);
		loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		loadMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {
				new AreYouSureDialog("Open file?", "Are you sure you want to open a new file?\nThis will delte any unsaved work", new AreYouSureDialogRunnable() {
					@Override public void yes() {
						//Handle open button action.
						fc.setApproveButtonText("Load");
						int returnVal = fc.showOpenDialog(null);

				        if (returnVal == JFileChooser.APPROVE_OPTION) {
				        	@SuppressWarnings("unused")
							File file = fc.getSelectedFile();
				        	System.out.println("Sorry, I do not know how to read files yet");
				        	// TODO load file
				        } else {
				        	System.out.println("Open command cancelled by user.");
				        }
					}
					@Override public void no() { } });
		}});
		fileMenu.add(loadMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_D);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {
				fc.setApproveButtonText("Save");
		        int returnVal = fc.showOpenDialog(null);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            System.out.println("Saving to: " + file.getName() + ".");
		            try {
		            	PrintWriter pr = new PrintWriter(file);
		            	// TODO save file to String
		            	
		            	pr.println(room.asJSON());
						pr.flush();
						pr.close();
						System.out.println("Done");
						new MessageDialog("Save texture", "Saving complete to " + file.getPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        } else {
		        	System.out.println("Saving command cancelled by user.");
		        } }});
		fileMenu.add(saveMenuItem);
	}

}
