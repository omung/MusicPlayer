package com.musicplayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class test {
	JSlider slider;
	 FloatControl  control;
	javax.sound.sampled.Mixer.Info[] mixers = AudioSystem.getMixerInfo();
JFrame j=new JFrame();
    Mixer.Info mixerInfo = mixers[4];
    Mixer mixer = AudioSystem.getMixer(mixerInfo);
    Line.Info[] lineinfos = mixer.getTargetLineInfo();{

        try {
            Line line = mixer.getLine(lineinfos[0]);
            line.open();
            if(line.isControlSupported(FloatControl.Type.VOLUME)){
              control = (FloatControl) line.getControl(FloatControl.Type.VOLUME);

                control.setValue((float) 0.7);
                int value = (int) (control.getValue()*100);                          

              slider = new JSlider((int)control.getMinimum()*100,(int)control.getMaximum()*100, value);
                slider.setMajorTickSpacing(10);
                slider.setPaintLabels(true);
                System.out.println("Volume:"+control.getValue());                     

                j.add(slider);
                j.pack();
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent arg0) {
                control.setValue(slider.getValue()/100f);

            }

			
			});
        
    }

}
