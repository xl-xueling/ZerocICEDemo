package com.dtstep.test.ice.PrinterServer.cluster.server;

import com.dtstep.test.ice.PrinterServer.cluster.server.impl.ClusterPrinterServiceImpl;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import com.zeroc.IceBox.Service;

public class PrinterService implements Service  {

    @Override
    public void start(String s, Communicator communicator, String[] strings) {
        ObjectAdapter adapter = communicator.createObjectAdapter(s);
        communicator.getProperties().setProperty("Ice.MessageSizeMax", "1409600");
        ClusterPrinterServiceImpl servant = new ClusterPrinterServiceImpl();
        adapter.add(servant, Util.stringToIdentity("PrinterServiceIdentity"));
        adapter.activate();
        System.out.println("printer server start success!");
    }

    @Override
    public void stop() {

    }
}
