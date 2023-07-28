package com.dtstep.test.ice.PrinterServer.cluster.client;

import com.dtstep.test.ice.PrinterServer.PrinterPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;
import java.util.UUID;

/**
 * 集群模式Client端
 */
public class ClientTest {

    public static void main(String[] args) {
        Communicator ic = null;
        try {
            String initParams = "--Ice.Default.Locator=PrinterIceGrid/Locator:tcp -h 10.206.6.37 -p 4061:tcp -h 10.206.6.39 -p 4061 -z";
            String [] params = new String[]{initParams};
            ic = Util.initialize(params);
            //注意该处配置与接口对应的replica-group的identity名称保持一致
            ObjectPrx objectPrx = ic.stringToProxy("PrinterServiceIdentity").ice_connectionId(UUID.randomUUID().toString()).ice_locatorCacheTimeout(1200);
            PrinterPrx proxy = PrinterPrx.checkedCast(objectPrx);
            for(int i=0;i<500;i++){
                String msg = "Hello World_" + i;
                proxy.printStr(msg);
                System.out.println("client send message,msg:" + msg);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
    }
}
