package com.sonarplotter.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.commons.geometry.euclidean.twod.PolarCoordinates;

public class SonarFrame extends JFrame{
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GREEN);

        g.drawLine(50, 300, 600-50, 300);
        
        g.drawArc(500/2-100/2+50, 300-100/2, 100, 100, 0, 180);
        g.drawArc(500/2-200/2+50, 300-200/2, 200, 200, 0, 180);
        g.drawArc(500/2-300/2+50, 300-300/2, 300, 300, 0, 180);
        g.drawArc(500/2-400/2+50, 300-400/2, 400, 400, 0, 180);
        g.drawArc(500/2-500/2+50, 300-500/2, 500, 500, 0, 180);
        
        g.drawLine(50+500/2, 300, 125, 125);
        g.drawLine(50+500/2, 300, 125+350, 125);
        
        PolarCoordinates pc1 = PolarCoordinates.of(200, Math.toRadians(90));
        PolarCoordinates pc2 = PolarCoordinates.of(100, Math.toRadians(90));
        PolarCoordinates pc3 = PolarCoordinates.of(230, Math.toRadians(70));
        PolarCoordinates pc4 = PolarCoordinates.of(140, Math.toRadians(123));
        
        g.setColor(Color.RED);
        g.fillOval((int) pc1.toCartesian().getX()+300-3, 300-(int) pc1.toCartesian().getY()-3, 6, 6);
        g.fillOval((int) pc2.toCartesian().getX()+300-3, 300-(int) pc2.toCartesian().getY()-3, 6, 6);
        g.fillOval((int) pc3.toCartesian().getX()+300-3, 300-(int) pc3.toCartesian().getY()-3, 6, 6);
        g.fillOval((int) pc4.toCartesian().getX()+300-3, 300-(int) pc4.toCartesian().getY()-3, 6, 6);
    }

    public SonarFrame(){
        super("Radar");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
