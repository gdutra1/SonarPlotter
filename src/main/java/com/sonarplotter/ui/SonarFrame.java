package com.sonarplotter.ui;

import com.sonarplotter.io.TxtReader;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.commons.geometry.euclidean.twod.PolarCoordinates;

public class SonarFrame extends JFrame{
    
    private String filePath = "";
    
    @Override
    public void paint(Graphics g){
        super.paint(g);

        //Define a cor do fundo do Frame
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        //Define a cor verde que será utilizada para desenhar a interface
        g.setColor(Color.GREEN);

        //Desenha a linha "base" da interface de sonar
        g.drawLine(50, 300, 600-50, 300);

        //Desenha os arcos
        g.drawArc(500/2-100/2+50, 300-100/2, 100, 100, 0, 180);
        g.drawArc(500/2-200/2+50, 300-200/2, 200, 200, 0, 180);
        g.drawArc(500/2-300/2+50, 300-300/2, 300, 300, 0, 180);
        g.drawArc(500/2-400/2+50, 300-400/2, 400, 400, 0, 180);
        g.drawArc(500/2-500/2+50, 300-500/2, 500, 500, 0, 180);

        //Desenha linhas que dividem os arcos
        g.drawLine(50+500/2, 300, 125, 125);
        g.drawLine(50+500/2, 300, 125+350, 125);
        
        //Define a cor como vermelho
        g.setColor(Color.RED);
        ArrayList<PolarCoordinates>  polarCoordinates = TxtReader.readPolarCoordinatesFromFile(filePath);
        for(PolarCoordinates pc: polarCoordinates){
            if(pc.getRadius()>250) pc = PolarCoordinates.of(250, pc.getAzimuth());
                
            int x = (int) pc.toCartesian().getX()+300-3;
            int y = 300-(int) pc.toCartesian().getY()-3;
            
            g.fillOval(x, y, 6, 6);
        }
    }

    public SonarFrame(String filePath){
        super("Sonar");
        //Define o caminho para o arquivo
        this.filePath = filePath;

        //Funções acessórias para a definição do comportamento do Frame
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
