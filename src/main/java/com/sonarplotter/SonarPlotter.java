package com.sonarplotter;

import com.sonarplotter.ui.SonarFrame;

public class SonarPlotter {
    
    public static void main(String[] args){
        if(args.length>0){
            SonarFrame sonarFrame = new SonarFrame(args[0]);
        }
    }
}
