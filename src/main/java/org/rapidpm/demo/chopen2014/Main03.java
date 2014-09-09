package org.rapidpm.demo.chopen2014;

import com.tinkerforge.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */
public class Main03 {

  private static final String HOST = "localhost";
  private static final int PORT = 4223;

  public static void main(String[] args) throws AlreadyConnectedException, IOException, NotConnectedException {
    IPConnection ipConnection = new IPConnection();
    ipConnection.connect(HOST, PORT);

    final BrickletReader brickletReader = new BrickletReader();
    final List<DeviceIdentity> localhost = brickletReader.findBricklets(HOST);

    //it is a hack
    final Map<String, Device> deviceMap = new HashMap<>();

    BrickletAmbientLight ambientLight = null;
    BrickletLCD20x4 lcd20x4 = null;

    deviceMap.put("ambientLight", ambientLight);
    deviceMap.put("lcd", lcd20x4);


    for (final DeviceIdentity deviceIdentity : localhost) {
      System.out.println("deviceIdentity = " + deviceIdentity);

      final int di = deviceIdentity.getDeviceIdentifier();
      if (di == BrickletAmbientLight.DEVICE_IDENTIFIER) {
        //mache was mit Ambient Light
        ambientLight = new BrickletAmbientLight(deviceIdentity.getUid(), ipConnection);
      } else if(di == BrickletLCD20x4.DEVICE_IDENTIFIER) {
        lcd20x4 = new BrickletLCD20x4(deviceIdentity.getUid(), ipConnection);
      }
    }
    if(ambientLight != null && lcd20x4 != null){
      ambientLight.addIlluminanceListener(new BrickletAmbientLight.IlluminanceListener() {
        @Override
        public void illuminance(int i) {
          final BrickletLCD20x4 lcd = (BrickletLCD20x4) deviceMap.get("lcd");
          try {
            lcd.writeLine((short)0, (short)0, "LUX : " + i+"");
          } catch (TimeoutException | NotConnectedException e) {
            e.printStackTrace();
          }
        }
      });
    }
  }


}
