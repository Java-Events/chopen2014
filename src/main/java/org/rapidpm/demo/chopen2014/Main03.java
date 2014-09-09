package org.rapidpm.demo.chopen2014;

import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.IPConnection;
import com.tinkerforge.NotConnectedException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */
public class Main03 {

  private static final String HOST = "localhost";
  private static final int PORT = 4223;

  public static void main(String[] args) throws AlreadyConnectedException, IOException, NotConnectedException {

   final BrickletReader brickletReader = new BrickletReader();
    final List<DeviceIdentity> localhost = brickletReader.findBricklets("localhost");
    for (final DeviceIdentity deviceIdentity : localhost) {
      System.out.println("deviceIdentity = " + deviceIdentity);
    }


  }
}
