/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geotagger;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 *
 * @author kamil
 */
public class MapPanel extends JPanel implements JMapViewerEventListener {    

    private static final long serialVersionUID = 1L;
    
    private final JMapViewerTree treeMap = new JMapViewerTree("Zones");

    
    public MapPanel() {
        super();
        customizePanel();
        initComponents();
    }
    
    private void customizePanel() {
        setMinimumSize(new Dimension(400, 400));
        setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(new GridLayout(0, 1));
    }
    
    private void initComponents() {
        add(treeMap);        
        
        map().setTileLoader(new OsmTileLoader(map()));
        map().setTileSource(new OsmTileSource.Mapnik());
    }

    private JMapViewer map() {
        return treeMap.getViewer();
    }

    private void updateZoomParameters() {
        //map().getZoom()
    }

    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            updateZoomParameters();
        }
    }
    
}
