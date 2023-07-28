package com.dtstep.test.ice.PrinterServer.local.server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

/**
 * 本地模式运行模式 -- Server端
 */
public class PrinterServer {

    public static void main(String[] args) {
        Communicator ic = null;
        try {
            ic = Util.initialize();
            ObjectAdapter adapter = ic.
                    createObjectAdapterWithEndpoints("PrinterServiceAdapter", "default -p 10000");
            LocalPrinterServiceImpl servant = new LocalPrinterServiceImpl();
            adapter.add(servant, Util.stringToIdentity("PrinterService"));
            adapter.activate();
            System.out.println("The server starts listening ...");
            ic.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
    }
}
