/**
 *      Copyright 2013 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package org.lesie.loader.connection.impl;

import org.lesie.client.message.Message;
import org.lesie.loader.connection.Connector;
import org.lesie.loader.util.LesieLogger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class ConnectorImpl implements Connector {

    private SocketChannel socketChannel;

    private int serverPort;

    private String serverAddr;

    private LesieLogger log;

    public ConnectorImpl(int serverPort,String serverAddr,Logger log){
        this.serverPort = serverPort;
        this.serverAddr = serverAddr;
        this.log = new LesieLogger(log);
    }


    @Override
    public void connect() {
        try{
            socketChannel = SocketChannel.open();

            if(socketChannel.isOpen()){
                socketChannel = configureSocketChannel(socketChannel);

                socketChannel.connect(new InetSocketAddress(serverAddr,serverPort));




                if(socketChannel.isConnected()){
                    ByteBuffer helloBuffer = ByteBuffer.wrap("Hello !".getBytes());

                    socketChannel.write(helloBuffer);
                    log.info("Connection established to -" + serverAddr +":" + serverPort);
                }else{
                    log.info("Connection could not be established to -" + serverAddr +":" + serverPort);
                }
            } else{
                log.info("Socket channel could not be opened");
            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    @Override
    public void sendMessage(Message msg) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isConnected() {
        if(socketChannel == null){
            return false;
        }
        return socketChannel.isConnected();
    }


    private SocketChannel configureSocketChannel(SocketChannel sChannel) throws IOException {

        //set the blocking mode
        sChannel.configureBlocking(true);
//set some options
        sChannel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
        sChannel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
        sChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
        sChannel.setOption(StandardSocketOptions.SO_LINGER, 5);


        return sChannel;
    }
}
