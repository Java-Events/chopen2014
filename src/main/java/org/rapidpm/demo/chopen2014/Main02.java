package org.rapidpm.demo.chopen2014;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */
public class Main02 {

  private static final String HOST = "localhost";
  private static final int PORT = 4223;
  private static final String UID = "ABC"; // Change to your UID

  // Note: To make the example code cleaner we do not handle exceptions. Exceptions you
  //       might normally want to catch are described in the documentation
  public static void main(String args[]) throws Exception {
    IPConnection ipcon = new IPConnection(); // Create IP connection
    BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); // Create device object

    ipcon.connect(HOST, PORT); // Connect to brickd
    // Don't use device before ipcon is connected

    // Add and implement listener for pressed and released events
    lcd.addButtonPressedListener(new BrickletLCD20x4.ButtonPressedListener() {
      public void buttonPressed(short button) {
        System.out.println("Pressed: " + button);
      }
    });
    lcd.addButtonReleasedListener(new BrickletLCD20x4.ButtonReleasedListener() {
      public void buttonReleased(short button) {
        System.out.println("Released: " + button);
      }
    });

    System.out.println("Press key to exit"); System.in.read();
    ipcon.disconnect();
  }
}
