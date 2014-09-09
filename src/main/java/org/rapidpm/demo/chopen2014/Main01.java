package org.rapidpm.demo.chopen2014;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.IPConnection;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */
public class Main01 {

  private static final String HOST = "localhost";
  private static final int PORT = 4223;
  private static final String UID = "jy2"; // Change to your UID

  public static void main(String args[]) throws Exception {
    final IPConnection ipcon = new IPConnection(); // Create IP connection
    final BrickletAmbientLight al = new BrickletAmbientLight(UID, ipcon); // Create device object

    ipcon.connect(HOST, PORT); // Connect to brickd
    al.setIlluminanceCallbackPeriod(1000);

    al.addIlluminanceListener(new BrickletAmbientLight.IlluminanceListener() {
      public void illuminance(int illuminance) {
        System.out.println("Illuminance: " + illuminance/10.0 + " Lux");
      }
    });

    System.out.println("Press key to exit"); System.in.read();
    ipcon.disconnect();
  }
}
