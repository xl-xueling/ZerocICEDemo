package com.dtstep.test.ice.PrinterServer.local.client;

import com.dtstep.test.ice.PrinterServer.PrinterPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

/**
 * 本地模式运行模式 -- Client端
 */
public class PrinterClient {

    public static void main(String[] args) {
        Communicator ic = null;
        try {
            ic = Util.initialize();
            ObjectPrx base = ic.stringToProxy("PrinterService:default -p 10000");
            PrinterPrx proxy = PrinterPrx.checkedCast(base);
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
